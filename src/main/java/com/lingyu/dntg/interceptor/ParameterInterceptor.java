package com.lingyu.dntg.interceptor;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.util.ConfigConstants;


/**
 * 对查询参数封装成一个map
 * @author donghui
 */
public class ParameterInterceptor extends HandlerInterceptorAdapter {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Map paramMap = new HashMap();
		Map requestParameterMap = request.getParameterMap();
		for (Object key : requestParameterMap.keySet()) {
			String[] array = (String[])requestParameterMap.get(key);
			String value = StringUtils.join(array, ",");
			if (StringUtils.isBlank(value)) {
				continue;
			}
			paramMap.put(key, StringUtils.trim(value));
			//如果参数名是serverIds,则split向paramMap放一个List集合以便mybatis foreach标签处理
			if ("serverIds".equals(key) && StringUtils.isNotBlank(value)) {
				paramMap.put("serverIdList", Arrays.asList(StringUtils.split(value, ",")));
			}
			else if (StringUtils.endsWith((String)key, "_list")) {//如果name以"_list"结尾
				String keyStr = (String)key;
				paramMap.put(keyStr.replaceFirst("_list", "List"), Arrays.asList(array));
			}
			else if (array.length > 1) {//多个
				paramMap.put(key + "List", Arrays.asList(array));
			}
		}
		//取出当前登陆用户信息
		HttpSession session = request.getSession();
		SessionUser sessionUser = (SessionUser)session.getAttribute(ConfigConstants.USER_SESSION);
		paramMap.put("sessionUser", sessionUser);
		
		//取出当前登陆服务器ID
		String serverId = LookupContext.getCurrentServerId();
		if (StringUtils.isBlank(serverId)) {
			serverId = (String)request.getSession().getAttribute(ConfigConstants.SELECTED_SERVER_KEY);
		}
		paramMap.put("currentServerId", serverId);
		log.debug("paramMap:" + paramMap);
		
		paramMap.put("nowTime", new Date());//当前时间
		request.setAttribute("paramMap", paramMap);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Class clz = handlerMethod.getBean().getClass();
		String moduleName = StringUtils.substringAfterLast(clz.getPackage().getName(), ".");
		String beanName = StringUtils.removeEnd(StringUtils.uncapitalize(clz.getSimpleName()), "Action") ;
//		String methodName = handlerMethod.getMethod().getName();
		String RequestMappingValue = handlerMethod.getMethod().getAnnotation(RequestMapping.class).value()[0];
		if (modelAndView != null && AbstractAction.DEFAULT_PATH.equals(modelAndView.getViewName())) {
			String path = StringUtils.join(new String[]{moduleName, beanName, RequestMappingValue}, "/");
			modelAndView.setViewName(path);
		};
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}
	
}
