package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 玩家保有率统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("playerLostReport")
public class PlayerLostReportAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(String startTime,HttpServletRequest request, ModelMap modelMap) {
		
		if (StringUtils.isNotBlank(startTime)) {
			Map paramMap = (Map)request.getAttribute("paramMap");
			modelMap.put("list", gameDaoTemplate.selectList("userRole.playerLostReport", paramMap));
		}

		return DEFAULT_PATH;
	}
}