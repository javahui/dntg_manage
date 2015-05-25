package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;

/**
 * 游戏内活跃事件货币得失统计
 * @author Lian zhibin
 *
 */
@Controller
@RequestMapping("gameFunctionMoney")
public class GameFunctionMoneyAction extends AbstractAction {
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list",logDaoTemplate.paging("gameFunctionMoney.index", paramMap));
		
		modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAME_FUNCTION_MONEY_DISTRIBUTE));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("gameFunctionMoney.excelIndex", paramMap);
		String[] titlesArray = new String[]{"时间","总计事件进行次数","总计获取元宝","总计充值元宝","总计消耗元宝","总计获取绑定元宝","总计消耗绑定元宝","总计获取游戏币","总计消耗游戏币"};
		return super.exportXls(dataList, "游戏内活跃事件货币得失统计", titlesArray);
	}
}
