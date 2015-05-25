package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 宝石等级统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("roleBaoshiStatistics")
public class RoleBaoshiStatisticsAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.selectList("roleBaoshi.index", paramMap));
		modelMap.put("xlRoleBaoshiRoleCount", gameDaoTemplate.selectList("roleBaoshi.indexcount", paramMap));
		Object roleBaoshiTotalCount = modelMap.get("xlRoleBaoshiRoleCount");
		String totalCount = roleBaoshiTotalCount.toString();
		int allCount = Integer.parseInt(totalCount.substring(1, totalCount.length()-1));
		modelMap.put("allCount", allCount);

		return DEFAULT_PATH;
	}
}