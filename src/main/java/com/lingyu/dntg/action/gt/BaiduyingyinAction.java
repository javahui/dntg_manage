package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 百度影音人数
 * @author donghui
 */
@Controller
@RequestMapping("baiduyingyin")
public class BaiduyingyinAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		List serverIdlist = toolDaoTemplate.selectList("gameServer.getBaiduServerId", paramMap);
		Map map = gameDaoTemplate.selectMapByServerIdList(serverIdlist, "roleJiangliList.index", paramMap);
		modelMap.put("list", map);

		return DEFAULT_PATH;
	}
}