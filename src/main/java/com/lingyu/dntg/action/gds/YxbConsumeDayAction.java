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
 * 游戏币消耗每日统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("yxbConsumeDay")
public class YxbConsumeDayAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("yxbConsume.indexDay", paramMap));
		modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.CONSUME_YXB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("yxbConsume.excelIndex", paramMap);
		String[] titlesArray = new String[]{"事件","游戏币消耗总量","消耗次数","时间"};
		return super.exportXls(dataList, "游戏币消耗每日统计", titlesArray);
	}
}