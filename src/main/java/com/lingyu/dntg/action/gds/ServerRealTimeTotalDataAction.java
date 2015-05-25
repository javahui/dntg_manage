package com.lingyu.dntg.action.gds;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.dao.gds.ServerRealTimeTotalDataDao;
import com.lingyu.dntg.service.gds.ServerRealTimeTotalDataService;

/**
 * 实时分服总数据
 * @author donghui
 */
@Controller
@RequestMapping("serverRealTimeTotalData")
public class ServerRealTimeTotalDataAction extends AbstractAction{
	@Resource private ServerRealTimeTotalDataDao serverRealTimeTotalDataDao;
	@Resource private ServerRealTimeTotalDataService serverRealTimeTotalDataService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		String logHour = MapUtils.getString(paramMap, "logHour");
		if (StringUtils.isBlank(logHour)) {
			paramMap.put("logHour", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH"));
		}
		modelMap.put("list", serverRealTimeTotalDataDao.selectByMonth(paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 恢复一天的数据
	 */
	@RequestMapping("recover")
	public String recover(@RequestParam String logDay, HttpServletRequest request, ModelMap modelMap) {
		serverRealTimeTotalDataService.batchUpdateByLogDay(logDay);
		return INDEX_PATH;
	}
	
	/**
	 * 实时分服总数据Excel
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]> xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> list = serverRealTimeTotalDataDao.selectXls(paramMap);
		String[] titlesArray = new String[]{"统计时间","平台","服务器ID","新角色","今日登陆","当前在线数","最高在线数","充值人数","充值总量（元）","付费率","Arpu"};
		return super.exportXls(list, "实时分服总数据",titlesArray);
	}
}
