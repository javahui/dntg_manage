package com.lingyu.dntg.action.gt;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.service.gt.GuildService;




/**
 * 解散帮会列表
 * @author ln
 *
 */
@Controller
@RequestMapping("guild")
public class GuildAction extends AbstractAction {
	@Resource private GuildService guildService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("guild.index", paramMap));
		//return DEFAULT_PATH;
		return "gt/guild/index";
	}
	
	
	
	
	@RequestMapping("delBank")
	public String delBank(HttpServletRequest request, ModelMap modelMap) throws Exception{
		Map paramMap = (Map)request.getAttribute("paramMap");
		
		String result = guildService.delete_AopLog(paramMap);
		if(result.equals("0")){
			modelMap.put("result", "1");
		}else{
			modelMap.put("result", "0");
		}
		return "redirect:./index.do";
	}
	
	
	
}
