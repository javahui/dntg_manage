package com.lingyu.dntg.action.gds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;


/**
 * 关键信息整合报表
 * @author ln
 *
 */
@Controller
@RequestMapping("statisticsGroup")
public class StatisticsGroupAction extends AbstractAction {
	
	@RequestMapping("index")
	public String index(String startTime,String endTime, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
    	if(StringUtils.isNotBlank(startTime)||StringUtils.isNotBlank(endTime)){
    		//得到登陆信息（ducount 登录用户数,dcount 登陆次数,davg 人均登陆次数,lsducount 昨日登陆用户数）
            List<Map<String,Object>>list = logDaoTemplate.selectList("serversIntegrationReportlog.loginGroupList", paramMap);
    		if(CollectionUtils.isNotEmpty(list)){
	    		//得到充值（distCount 付费用户数 allRmb,当日总计充值RMB,arpu arpu）
	    		List<Map<String, Object>> selectRechargeIntegrationDaysStatistics= gameDaoTemplate.selectList("serversIntegrationReportgame.selectRecharge_ByDaysStatistics", paramMap);
	    		//得到新增充值用户数(cnt)
	    	    List<Map<String, Object>> selectRechargeIntegrationNewStatistics = gameDaoTemplate.selectList("serversIntegrationReportgame.selectRecharge_ByNewStatistics", paramMap);
	    		//得到新创建用户数（createcount）
	    	    List<Map<String, Object>> createCountList = gameDaoTemplate.selectList("serversIntegrationReportgame.createCountList", paramMap);
	    	    //得到日在线值 （accu 日均在线,puuc 日峰值在线数,timecount 当日数据包含小时数）
	    	    List<Map<String, Object>> onlineGroupList = logDaoTemplate.selectList("serversIntegrationReportlog.onlineGroupList", paramMap);
	    	    //元宝获取（ybIncr）
	    	    List<Map<String,Object>> ybincrGroupList = logDaoTemplate.selectList("serversIntegrationReportlog.ybincrGroupList", paramMap);
	    	    //元宝消耗(ybconsume)
	    	    List<Map<String,Object>> ybconsumeGroupList= logDaoTemplate.selectList("serversIntegrationReportlog.ybconsumeGroupList", paramMap);
	    	    
	    	    for(Map<String,Object> listObj:list){
					String date = MapUtils.getString(listObj, "date");
					for(Map<String,Object> map2:selectRechargeIntegrationDaysStatistics){
						//distCount 付费用户数 allRmb,当日总计充值RMB,arpu arpu
						String dtime = MapUtils.getString(map2, "dtime");
						if(date.equals(dtime)){
							listObj.put("distCount",map2.get("distCount"));
							listObj.put("allRmb",map2.get("allRmb"));
							listObj.put("arpu",map2.get("arpu"));
							break;
						}
					}
					
					for(Map<String,Object> map2:selectRechargeIntegrationNewStatistics){
						//cnt 新增充值用户数
						String dtime = MapUtils.getString(map2, "dtime");
						if(date.equals(dtime)){
							listObj.put("cnt",map2.get("cnt"));
							break;
						}
						}
					
					for(Map<String,Object> map2:createCountList){
						//createcount 新创建用户数
						String dtime = MapUtils.getString(map2, "date");
						if(date.equals(dtime)){
							listObj.put("createcount",map2.get("createcount"));
							break;
						}
					}
					
					for(Map<String,Object> map2:onlineGroupList){
						//accu 日均在线,puuc 日峰值在线数,timecount 当日数据包含小时数
						String dtime = MapUtils.getString(map2, "date");
						if(date.equals(dtime)){
							listObj.put("accu",map2.get("accu"));
							listObj.put("puuc",map2.get("puuc"));
							listObj.put("timecount",map2.get("timecount"));
							break;
						}
					 }
					
					for(Map<String,Object> map2:ybincrGroupList){
						String dtime = MapUtils.getString(map2, "date");
						if(date.equals(dtime)){
							listObj.put("ybincr", map2.get("ybincr"));
							break;
						}
					}
					
					for(Map<String,Object> map2:ybconsumeGroupList){
						//ybconsume 元宝消耗
						String dtime = MapUtils.getString(map2, "date");
						if(date.equals(dtime)){
							listObj.put("ybconsume",map2.get("ybconsume"));
							break;
						}
					}
					
					//流失率：[1-（当日登录数-当日新登录数）/昨日登录数] %  
					//(1-(ducount-createcount)/lsducount) lost
					
					double ducount = MapUtils.getDoubleValue(listObj, "ducount");
					if(null!=listObj.get("lsducount")){
						double createcount = MapUtils.getDoubleValue(listObj, "createcount");
						double lsducount = MapUtils.getDoubleValue(listObj, "lsducount");
						double lost=1-(ducount-createcount)/lsducount;
						listObj.put("lost",lost);
					}else{
						listObj.put("lost",0);
					}
					//DT（在线时长）：按分计算，公式＝ACCU*24*60/日登录 （若开服第一天只运行了12小时，则公式中24替换为12
					//(accu*timecount*60/ducount) dt
					if(listObj.get("accu")==null){
						listObj.put("dt", 0);
					}else{
						double accu = MapUtils.getDoubleValue(listObj, "accu");
						Integer timecount = MapUtils.getInteger(listObj, "timecount");
						double dt=(accu*timecount*60/ducount);
						listObj.put("dt",dt);
					}
					
					//付费率：付费用户数/登录 % 
					//distCount/ducount pl
					if(listObj.get("disCount")==null){
						listObj.put("pl", 0);
					}else{
						double distCount =MapUtils.getDoubleValue(listObj, "distCount");
						double pl=distCount/ducount;
						listObj.put("pl",pl);
					}
				
					//消耗比：元宝消耗/元宝新增 %
					//ybconsume/ybincr ybconlv	
					if(listObj.get("ybconsume")==null){
						listObj.put("ybconlv", 0);
					}else{
					    double ybconsume = MapUtils.getDoubleValue(listObj, "ybconsume");
						double ybincr=MapUtils.getDoubleValue(listObj, "ybincr");
					
						double ybconlv=ybconsume/ybincr;
						listObj.put("ybconlv",ybconlv);
					}
					
					List<Object> lostList = gameDaoTemplate.selectList("serversIntegrationReportgame.selectRecordsXLByPlayerLostReports", paramMap);
					if(lostList!=null&&lostList.size()>0){
						if(lostList.get(0)!=null){
							Map<String, Object> objMap=(HashMap<String, Object>)lostList.get(0);
							listObj.put("d1", objMap.get("d1")!=null?objMap.get("d1"):0);
						}else{
							listObj.put("d1",0);
						}
					}else{
						listObj.put("d1",0);
					}
	    	    }	
    		}
    		modelMap.put("list",list);
    	}
    	return DEFAULT_PATH;
	}
}
