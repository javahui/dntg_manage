package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 玩家每日在线数统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("roleOnlineDay")
public class RoleOnlineDayAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("roleOnline.indexList", paramMap));

		return DEFAULT_PATH;
	}
}