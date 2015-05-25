package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;


/**
 * 玩家保有率统计
 * @author ln
 *
 */
@Controller
@RequestMapping("staticticsPlayerLost")
public class StaticticsPlayerLostAction extends AbstractAction{
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("keepCount.staticticsPlayLost", paramMap));
		return DEFAULT_PATH;
	}

}
