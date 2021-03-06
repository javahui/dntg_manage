package com.lingyu.dntg.action.glq;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;
import com.lingyu.dntg.dao.glq.GainYbDetailDao;

/**
 * 元宝获取日志
 * @author ln
 *
 */
@Controller
@RequestMapping("ybIncrLog")
public class YbIncrLogAction extends AbstractAction{
	@Resource private GainYbDetailDao gainYbDetailDao;
	@RequestMapping("index")
	public String index(String userName, String startTime,
			String endTime,String eventTypes, HttpServletRequest request, ModelMap modelMap){
		if (StringUtils.isNotBlank(userName)
				|| StringUtils.isNotBlank(startTime)
				|| StringUtils.isNotBlank(endTime)||StringUtils.isNotBlank(eventTypes)) {
		 Map paramMap = (Map) request.getAttribute("paramMap");
		    modelMap.put("list",logDaoTemplate.paging("ybIncr.index", paramMap));
		    modelMap.put("eventTypesList", paramMap.get("eventTypes"));
		 modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_YB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}
	
	/**
	 * 元宝获取详细日志
	 */
	@RequestMapping("indexDetail")
	public String indexDetail(String month, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(month)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list", gainYbDetailDao.selectByMonth(month, paramMap));
		    modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_YB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		return DEFAULT_PATH;
	}
}
