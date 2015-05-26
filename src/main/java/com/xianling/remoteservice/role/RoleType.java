package com.xianling.remoteservice.role;

import javax.jws.WebService;

@WebService(serviceName="RoleType")
public interface RoleType {

	/**
	 * 更新账号类型
	 * @param userId
	 * @return "000":账号不存在 "001":账号为空 "111": 更新角色类型成功

	 */
	public String updateRoleType(String roleId, String serverId, Integer roleType);
}
