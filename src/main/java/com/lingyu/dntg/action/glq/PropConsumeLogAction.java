package com.lingyu.dntg.action.glq;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;
import com.lingyu.dntg.dao.glq.ConsumePropDetailDao;

/**
 * 道具消耗
 * @author ln
 *
 */
@Controller
@RequestMapping("propConsumeLog")
public class PropConsumeLogAction extends AbstractAction {
	@Resource private ConsumePropDetailDao consumePropDetailDao;
	@RequestMapping("index")
	public String index(String userName, String goodName,String startTime,
			String endTime,String eventTypes, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(userName)||StringUtils.isNotBlank(goodName)
				|| StringUtils.isNotBlank(startTime)
				|| StringUtils.isNotBlank(endTime)||StringUtils.isNotBlank(eventTypes)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
		    modelMap.put("list",logDaoTemplate.paging("propConsume.index", paramMap));
			modelMap.put("eventTypesList",paramMap.get("eventTypesList"));		
			}

		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.CONSUME_PROP));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}
	
	/**
	 * 道具消耗详细日志
	 */
	@RequestMapping("indexDetail")
	public String indexDetail(String month, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(month)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list", consumePropDetailDao.selectByMonth(month, paramMap));
		    modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.CONSUME_PROP));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("propConsume.excelIndex", paramMap);
		Map eventTypeMap = GameLogEventType.getEventTypeMap();
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		for(Map recordMap: dataList){
			String type = MapUtils.getString(recordMap, "eventType");
			recordMap.put("eventType", MapUtils.getString(eventTypeMap, type));
		}
		String[] titlesArray = new String[]{"角色名","事件","事件触发次数","消耗物品名称","消耗总数量","时间"};
		return super.exportXls(dataList, "道具消耗日志", titlesArray);
	}

}
