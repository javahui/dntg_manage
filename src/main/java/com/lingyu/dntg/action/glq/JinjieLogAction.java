package com.lingyu.dntg.action.glq;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 进阶
 */
@Controller
@RequestMapping("jinjieLog")
public class JinjieLogAction extends AbstractAction {
	
	/**
	 * 坐骑进阶
	 */
	@RequestMapping("indexZuoqi")
	public String index(String roleName, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("zuoqiChange.index", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 骑兵进阶
	 */
	@RequestMapping("indexQibing")
	public String indexQibing(String roleName, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("qibingChange.index", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 骑兵进阶
	 */
	@RequestMapping("indexGuangyi")
	public String indexGuangyi(String roleName, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list", logDaoTemplate.paging("guangyiChange.index", paramMap));
		return DEFAULT_PATH;
	}
	
}
