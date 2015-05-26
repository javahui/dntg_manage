package com.lingyu.dntg.action.glq;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;

/**
 * 游戏内活跃事件日志
 * @author ln
 *
 */
@Controller
@RequestMapping("gamePaticipateLog")
public class GamePaticipateLog extends AbstractAction {
	@RequestMapping("index")
	public String index(String userName, String startTime,
			String endTime, String eventTypes,HttpServletRequest request, ModelMap modelMap){
		if (StringUtils.isNotBlank(userName) || StringUtils.isNotBlank(startTime) || StringUtils.isNotBlank(endTime)||StringUtils.isNotBlank(eventTypes)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list",logDaoTemplate.paging("gamePaticipate.index", paramMap));
			modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAME_PARTICIPATE));
	 
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());


		return DEFAULT_PATH;
	}

}
