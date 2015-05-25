package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 玩家在线时长每日统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("logoutStatisticsDay")
public class logoutStatisticsDayAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("logOutStatistics.logoutStatistics", paramMap));
		return DEFAULT_PATH;
	}
}