package com.lingyu.dntg.job;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.ServersIntegrationReport;
import com.lingyu.dntg.dao.base.AbstractDao;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;

@Component
public class ServersIntegrationReportJob extends AbstractDao{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public void run() {
		String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		this.batchUpdateServersIntegrationReport(date);
	}
	
	public void batchUpdateServersIntegrationReport(String date){
		StopWatch sw = new StopWatch();
		sw.start();
		log.error("开始全服关键信息整合报表 时间:{}", date);
		List<String> serverIdList = toolDaoTemplate.selectList("gameServer.getAllServerIdByLogDbUrlWithoutRepetition");
		//遍历所有服务器拉取相应数据
		for (String serverId : serverIdList) {
			serverId = StringUtils.substringBefore(serverId, ",");
			try {
				LookupContext.setCurrentServerId(serverId);
				Map roleLoginMap = logDaoTemplate.selectOne("roleLogin.loginGroupList", date);
				Map selectRechargeIntegrationDaysStatisticsExcelMap = gameDaoTemplate.selectOne("rechargeRecord.selectRecharge_ByDaysStatisticsExcel", date);
				Integer cnt  = gameDaoTemplate.selectOne("rechargeRecord.selectRecharge_ByNewStatisticsExcel", date);
				Integer createcount = gameDaoTemplate.selectOne("userRole.createCountList", date);
				Map onlineGroupMap = logDaoTemplate.selectOne("roleOnline.onlineGroupList",  date);
				Map ybincrGroupMap = logDaoTemplate.selectOne("gameFunctionMoney.getTodayRecord", date);
				insertToDb(roleLoginMap, selectRechargeIntegrationDaysStatisticsExcelMap, cnt, createcount, onlineGroupMap, ybincrGroupMap,serverId, date);
			} catch (Exception e) {
				log.error("serverId:["+ serverId +"] connection error", e);
			}
		}
		log.info("统计全服关键信息整合报表 时间:{} 用时:{}", date, sw.getTime());
	}
	
	/**
	 * 将List数据取出后入库
	 */
	private void insertToDb(Map roleLoginMap, Map selectRechargeIntegrationDaysStatisticsExcelMap, Integer cnt, Integer createcount, Map onlineGroupMap, Map ybincrGroupMap, String serverId, String today){	
		ServersIntegrationReport serversIntegrationReport = new ServersIntegrationReport();
		serversIntegrationReport.setServerId(serverId);
		serversIntegrationReport.setDate(today);
		serversIntegrationReport.setdCount(MapUtils.getIntValue(roleLoginMap, "dcount"));
		serversIntegrationReport.setLsDcount(MapUtils.getIntValue(roleLoginMap, "lsdcount"));
		//distCount 付费用户数 allRmb,当日总计充值RMB,
		serversIntegrationReport.setDistCount(MapUtils.getIntValue(selectRechargeIntegrationDaysStatisticsExcelMap, "distCount"));
		serversIntegrationReport.setAllRmb(MapUtils.getIntValue(selectRechargeIntegrationDaysStatisticsExcelMap, "allRmb"));
		//cnt 新增充值用户数
		serversIntegrationReport.setCnt(cnt);
		//createcount 新创建用户数
		serversIntegrationReport.setCreateCount(createcount);
		//accu 日均在线,puuc 日峰值在线数,timecount 当日数据包含小时数
		serversIntegrationReport.setAccu(MapUtils.getFloatValue(onlineGroupMap, "accu"));
		serversIntegrationReport.setPccu(MapUtils.getIntValue(onlineGroupMap, "pccu"));
		//ybincr 元宝增加,消耗
		serversIntegrationReport.setYbIncr(MapUtils.getLongValue(ybincrGroupMap, "gainYb"));
		serversIntegrationReport.setYbConsume(MapUtils.getLongValue(ybincrGroupMap, "consumeYb"));
		
		int num = toolDaoTemplate.update("serversIntegrationReport.updateByserverIdAndDate", serversIntegrationReport);
		if (num == 0) {
			toolDaoTemplate.insert("serversIntegrationReport.insert", serversIntegrationReport);
		}
	}
}