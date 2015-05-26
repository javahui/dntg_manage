package com.lingyu.dntg.action.ulm;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 日志记录管理
 * @author donghui
 */
@Controller
@RequestMapping("operationLog")
public class OperationLogAction extends AbstractAction{
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("operationLog.index", paramMap));
		return DEFAULT_PATH;
	}
	
}