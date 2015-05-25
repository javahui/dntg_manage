package com.lingyu.dntg.action.gt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 游戏账号封停
 * @author Lian zhibin
 */
@Controller
@RequestMapping("userForbid")
public class UserForbidAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("userForbid.index", paramMap));

		return DEFAULT_PATH;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String update(String receiverNames, String serverId, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<String> userRoleNames = Arrays.asList(receiverNames.split(","));
		paramMap.put("userNames", userRoleNames);
		List<Integer> uids= gameDaoTemplate.selectListByServerId(serverId, "userRole.selectIdByName", paramMap);
		paramMap.put("userIds", uids);
		modelMap.put("result", toolDaoTemplate.insert("userForbid.batchInsert", paramMap));
		return "redirect:./index.do";
	}
	
	/**
	 * 封停/解封
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("userforbidUse.do")
	public String isCanUse(String isCanUse, HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		if("0".equals(isCanUse)){
			//可用账号传入则进行封停
			modelMap.put("result", toolDaoTemplate.update("userForbid.userForbidUseBan", paramMap));
		}else{
			//不可用账号传入则进行解封
			modelMap.put("result", toolDaoTemplate.update("userForbid.userForbidUse", paramMap));
		}
		
		return "redirect:./index.do";
	}	

	/**
	 * 禁言/解禁
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("userforbidSpeak.do")
	public String isCanSpeak(String isCanSpeak, HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		if("0".equals(isCanSpeak)){
			//可用账号传入则进行禁言
			modelMap.put("result", toolDaoTemplate.update("userForbid.userForbidSpeakBan", paramMap));
		}else{
			//不可用账号传入则进行解禁
			modelMap.put("result", toolDaoTemplate.update("userForbid.userForbidSpeak", paramMap));
		}
		
		return "redirect:./index.do";
	}	
}