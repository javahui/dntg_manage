package com.xianling.remoteservice.role;

import javax.jws.WebService;

@WebService(serviceName="Account")
public interface Account {

	/**
	 * 根据账号获取角色列表
	 * @param userId
	 * @return
	 */
	public String getAccountRoles(String userId, String serverId);
}
