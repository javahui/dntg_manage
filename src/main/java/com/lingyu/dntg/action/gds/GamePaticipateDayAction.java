package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;

/**
 * 游戏内活跃事件每日统计
 * @author Lian zhibin
 *
 */
@Controller
@RequestMapping("gamePaticipateDay")
public class GamePaticipateDayAction extends AbstractAction {
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list",logDaoTemplate.paging("gamePaticipate.indexDay", paramMap));
		
		modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAME_PARTICIPATE));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}
}
