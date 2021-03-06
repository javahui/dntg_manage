package com.lingyu.dntg.action.gt;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 引导员禁言列表
 * @author donghui
 */
@Controller
@RequestMapping("guideJinyanList")
public class GuideJinyanListAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list",gameDaoTemplate.paging("gmUserState.index", paramMap));
		return DEFAULT_PATH;
	}
}