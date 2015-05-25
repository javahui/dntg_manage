package com.lingyu.dntg.action.cq;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 充值分布统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("rechargeDistributeStatistics")
public class RechargeDistributeStatisticsAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.selectList("rechargeRecord.indexDistribute", paramMap));

		return DEFAULT_PATH;
	}
}