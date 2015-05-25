package com.lingyu.dntg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 始终保持LookupContext的内容和session同步
 * @author donghui
 */
public class LookupSessionSyncInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String currentServerId = (String)request.getSession().getAttribute(ConfigConstants.SELECTED_SERVER_KEY);
		SessionUser currentUserInfo = (SessionUser)request.getSession().getAttribute(ConfigConstants.USER_SESSION);
		LookupContext.setSessionUserInfo(currentUserInfo);
		LookupContext.setCurrentServerId(currentServerId);
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	


}
