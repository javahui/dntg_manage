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
import com.lingyu.dntg.dao.glq.GainYxbDetailDao;

/**
 * 游戏币获取日志
 * @author ln
 *
 */

@Controller
@RequestMapping("yxbIncrLog")
public class YxbIncrLogAction extends AbstractAction {
	@Resource private GainYxbDetailDao gainYxbDetailDao;
	@RequestMapping("index")
	public String index(String userName, String startTime,
			String endTime,String eventTypes, HttpServletRequest request, ModelMap modelMap){
		if (StringUtils.isNotBlank(userName)
				|| StringUtils.isNotBlank(startTime)
				|| StringUtils.isNotBlank(endTime)||StringUtils.isNotBlank(eventTypes)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list",logDaoTemplate.paging("yxbIncr.index", paramMap));
			modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_YXB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		
		
		return DEFAULT_PATH;
	}
	
	/**
	 * 游戏币消耗详细日志
	 */
	@RequestMapping("indexDetail")
	public String indexDetail(String month, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(month)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list", gainYxbDetailDao.selectByMonth(month, paramMap));
		    modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_YXB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		return DEFAULT_PATH;
	}
}
