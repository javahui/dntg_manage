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
import com.lingyu.dntg.dao.glq.GainBindybDetailDao;

/**
 * 绑定元宝获取
 * @author ln
 *
 */
@Controller
@RequestMapping("bindybGainLog")
public class BindybGainLogAction extends AbstractAction{
	@Resource private GainBindybDetailDao gainBindybDetailDao;
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
	    modelMap.put("list",logDaoTemplate.paging("bindybGain.index", paramMap));
	    modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_BINDYB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());

		return DEFAULT_PATH;
	}

	/**
	 * 绑定元宝获取详细日志
	 */
	@RequestMapping("indexDetail")
	public String indexDetail(String month, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(month)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list", gainBindybDetailDao.selectByMonth(month, paramMap));
			modelMap.put("eventTypesList",paramMap.get("eventTypesList"));
		}
		modelMap.put("eventTypeMap2",StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.GAIN_BINDYB));
		modelMap.put("eventTypeMap",GameLogEventType.getEventTypeMap());
		return DEFAULT_PATH;
	}
}
