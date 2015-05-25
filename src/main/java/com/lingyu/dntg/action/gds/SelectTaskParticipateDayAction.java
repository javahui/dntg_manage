package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.service.analyze.TaskMainAnalyzeService;

/**
 * 玩家主线任务接取统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("selectTaskParticipateDay")
public class SelectTaskParticipateDayAction extends AbstractAction{
	@Resource private TaskMainAnalyzeService taskMainAnalyzeService;
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("taskMain.index", paramMap));
		return DEFAULT_PATH;
	}
	
	@ModelAttribute("taskMainMap")
	public Map moneyType(){
		return taskMainAnalyzeService.geTaskMain();
	}
}