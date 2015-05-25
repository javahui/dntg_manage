package com.lingyu.dntg.interceptor;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.util.ConfigConstants;

public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object currentSessionUser = request.getSession().getAttribute(ConfigConstants.USER_SESSION);
		if (currentSessionUser == null) {//方便开发人员，自动登陆admin
			if ("127.0.0.1".equals(request.getRemoteHost())) {
				ToolDaoTemplate toolDaoTemplate = ContextLoader.getCurrentWebApplicationContext().getBean(ToolDaoTemplate.class);
				HashMap paramMap = new HashMap();
				paramMap.put("loginName", "admin");
				paramMap.put("hiddenPassword", "7a57a5a743894a0e");
				SessionUser sessionUser = toolDaoTemplate.selectOne("userInfo.login", paramMap);
				if (sessionUser == null) {
					response.sendRedirect(request.getContextPath() + "/expire.jsp");
					return false;
				}
				//设置服务器权限
				if (!sessionUser.getAllServer()) {
					int userId = sessionUser.getId();
					List<String> serverIdList  = toolDaoTemplate.selectList("userInfo.getServerByUserId", userId);
					List<Integer> roleUserIdList  = toolDaoTemplate.selectList("userInfo.getRoleUserId", userId);
					sessionUser.setOwnerServerIdList(serverIdList);
					sessionUser.setRoleUserIdList(roleUserIdList);
				}
				request.getSession().setAttribute(ConfigConstants.USER_SESSION, sessionUser);
				String serverId = "F1";
				request.getSession().setAttribute(ConfigConstants.SELECTED_SERVER_KEY, serverId);
				LookupContext.setCurrentServerId(serverId);
				return true;
			}
			else{
				response.sendRedirect(request.getContextPath() + "/expire.jsp");
				return false;
			}
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	


}
