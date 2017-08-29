package com.lingyu.dntg.action.uam;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.service.sm.ActionInfoService;
import com.lingyu.dntg.service.sm.GameServerService;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 用户登陆,frame框架页面
 * @author donghui
 */
@Controller
public class AuthAction extends AbstractAction{
	@Resource private GameServerService gameServerService;
	@Resource private ActionInfoService actionInfoService;
	
	/**
	 * 用户登入
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = toolDaoTemplate.selectOne("userInfo.login", paramMap);
		if (sessionUser == null) {
			this.clearCookie(request, response);
			return "redirect:/";
		} 
		//设置服务器权限
		if (!sessionUser.getAllServer()) {
			int userId = sessionUser.getId();
			List<String> serverIdList  = toolDaoTemplate.selectList("userInfo.getServerByUserId", userId);
			List<Integer> roleUserIdList  = toolDaoTemplate.selectList("userInfo.getRoleUserId", userId);
			sessionUser.setOwnerServerIdList(serverIdList);
			sessionUser.setRoleUserIdList(roleUserIdList);
		}
		
		modelMap.put("title", toolDaoTemplate.selectOne("siteTitle.getTitle"));//设置页面title
		boolean rememberPassword = MapUtils.getBooleanValue(paramMap, "rememberPassword");
		if (rememberPassword) {
			response.addCookie(new Cookie("loginName", sessionUser.getLoginName()));
			response.addCookie(new Cookie("password", sessionUser.getPassword()));
		}else{
			this.clearCookie(request, response);
		}
		request.getSession().setAttribute(ConfigConstants.USER_SESSION, sessionUser);
		return "/frame/index";
	}
	
	/**
	 * top页面
	 */
	@RequestMapping("top")
	public String top(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		modelMap.put("gameServerMap", gameServerService.selectAllSortGameServersByUserId(sessionUser));
		String defaultServerId = null;
		if (sessionUser.getAllServer()) {
			defaultServerId = gameServerService.getDefaultServerIds();
		}
		else if(CollectionUtils.isNotEmpty(sessionUser.getOwnerServerIdList())){
			defaultServerId = sessionUser.getOwnerServerIdList().get(0);
		}
		modelMap.put("defaultServerId", defaultServerId);
		if (StringUtils.isNotBlank(defaultServerId)) {
			this.selectServer(defaultServerId, request, modelMap);
		}
		return "frame/top";  
	}
	
	/**
	 * left页面(菜单页面)
	 */
	@RequestMapping("left")
	public String left(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser user = (SessionUser)paramMap.get("sessionUser");
		modelMap.put("actionInfoList", actionInfoService.getMenuActionInfo(user)); 
		return "frame/left";  
	}
	
	/**
	 * 选择要切换到的服务器
	 */
	@ResponseBody
	@RequestMapping(value = "selectServer", method = RequestMethod.POST)
	public String selectServer(String serverId, HttpServletRequest request, ModelMap modelMap){
		request.getSession().setAttribute(ConfigConstants.SELECTED_SERVER_KEY, serverId);
		LookupContext.setCurrentServerId(serverId);
		return "ok";
	}
	
	/**
	 * 用户登出
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.removeAttribute(ConfigConstants.USER_SESSION);
		return "redirect:/";
	}
	
	/**
	 * 页面session过期
	 */
	@RequestMapping("expire.do")
	public String expire(){
		return "redirect:/expire.jsp";
	}
	
	/**
	 * 清空保存账号密码的cookie
	 */
	private void clearCookie(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		Stream.of(cookies)
			.filter(c -> StringUtils.equalsAny(c.getName(), "loginName", "password"))
			.forEach(c -> {
				c.setMaxAge(0);
				response.addCookie(c);
			});
	}
	
}
