package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.job.ServersIntegrationReportJob;

/**
 * 全服关键信息整合列表
 * @author Lian zhibin
 */
@Controller
@RequestMapping("statisticsGroupAllServer")
public class StatisticsGroupAllServerAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(String serverIds, String startTime,
			String endTime,  HttpServletRequest request, ModelMap modelMap) {
	    if(StringUtils.isNotBlank(serverIds)  ||StringUtils.isNotBlank(startTime) ||StringUtils.isNotBlank(endTime)){
			Map paramMap = (Map)request.getAttribute("paramMap");
			modelMap.put("list", toolDaoTemplate.selectList("serversIntegrationReport.index", paramMap));
	    }
	    
		return DEFAULT_PATH;
	}
	
	@Resource private ServersIntegrationReportJob serversIntegrationReportJob;

	@RequestMapping("recover")
	public String recover(String logDay) {
		serversIntegrationReportJob.batchUpdateServersIntegrationReport(logDay);
		return INDEX_PATH;
	}
	
	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = toolDaoTemplate.selectList("serversIntegrationReport.excelIndex", paramMap);
		String[] titlesArray = new String[]{"时间","新登录","登录","流失率%","ACCU","DT（分）","新付费用户","付费用户数","付费率%","充值","ARPU"};
		return super.exportXls(dataList, "全服关键信息整合报表", titlesArray);
	}
}