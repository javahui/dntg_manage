package com.lingyu.dntg.dao.base.dynamicDataSource;

import com.lingyu.dntg.bean.vo.SessionUser;


public class LookupContext {

	private static ThreadLocal<String> _serverId = new ThreadLocal();
	private static final ThreadLocal<SessionUser> _sessionUserInfo = new ThreadLocal();

	public static void setCurrentServerId(String serverId) {
		_serverId.set(serverId);
	}
	public static String getCurrentServerId() {
		return _serverId.get();
	}


	public static void setSessionUserInfo(SessionUser userInfo) {
		_sessionUserInfo.set(userInfo);
	}
	public static SessionUser getSessionUserInfo() {
		return _sessionUserInfo.get();
	} 
	
}
