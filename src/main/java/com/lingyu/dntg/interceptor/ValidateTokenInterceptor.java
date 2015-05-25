package com.lingyu.dntg.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ValidateTokenInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestToken = request.getParameter("token");
		HttpSession session = request.getSession();
		String sessionToken = (String)session.getAttribute("token");
		session.removeAttribute("token");
		if (Objects.equals(requestToken, sessionToken) ) {
			return true;
		}
		response.getWriter().print("repeat submit!");
		return false;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}
	


}
