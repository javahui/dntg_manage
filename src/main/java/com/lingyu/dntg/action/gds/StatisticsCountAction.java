package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 分布统计
 * @author ln
 *
 */
@Controller
@RequestMapping("statisticsCount")
public class StatisticsCountAction extends AbstractAction {
	
	@RequestMapping("index")
	public String index(String type, String startTime, HttpServletRequest request, ModelMap modelMap) {
    	Map paramMap = (Map) request.getAttribute("paramMap");
    	if (StringUtils.isNotBlank(type)){
    		modelMap.put("list",toolDaoTemplate.paging("statisticsCount.index", paramMap));
    	}
	    return DEFAULT_PATH;
	}
	
	/**
	 *分布统计Excel
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = toolDaoTemplate.selectList("statisticsCount.excel", paramMap);
		Map eventTypeMap = this.getStatisticEventTypeMap();
		for (Map recordMap : dataList) {
			String type = MapUtils.getString(recordMap, "type");
			recordMap.put("type", MapUtils.getString(eventTypeMap, type));
		}
		String[] titlesArray = new String[]{"日期","等级","总数","类型"};
		return super.exportXls(dataList, "等级分布统计",titlesArray);
	}
	
	@ModelAttribute("typeMap")
	public Map getStatisticEventTypeMap(){
		return ConfigConstants.statisticEventTypeMap;
	}
}
