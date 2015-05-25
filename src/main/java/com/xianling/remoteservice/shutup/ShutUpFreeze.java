package com.xianling.remoteservice.shutup;

import javax.jws.WebService;

@WebService(serviceName="ShutUpFreeze")
public interface ShutUpFreeze {

	/**
	 * 封号
	 * @param userId 用户id
	 * @param serverId 服务器id
	 * @return errorCode (null 表示成功,000:账号不存在,001:账号为空)
	 */
	public String fengHao(String userId,String serverId);
	
	/**
	 * 解封
	 * @param userId
	 * @param serverId
	 * @return errorCode (null 表示成功)
	 */
	public String jieChuFengHao(String userId,String serverId);
	
	/**
	 * 解禁
	 * @param userId
	 * @param serverId
	 * @return errorCode (null 表示成功)
	 */
	public String jieJin(String userId,String serverId);
	
	/**
	 * 禁言
	 * @param userId
	 * @param serverId
	 * @return errorCode (null 表示成功)
	 */
	public String shutUp(String userId,String serverId);

	/**
	 * 根据角色ID批量禁言
	 * @param roleIds
	 * @return
	 */
	public Object shutUpByRoleIds(String roleIds);
	/**
	 * 根据角色id批量解除禁言
	 * @param roleIds 根据,分隔
	 * @return
	 */
	public String jieJinByRoleIds(String roleIds);
	/**
	 * 根据角色ID批量封号(根据,分隔)
	 * @param roleIds
	 * @return
	 */
	public String fengHaoByRoleIds(String roleIds);
	/**
	 * 根据角色ID批量解除封号
	 * @param roleIds
	 * @return
	 */
	public String jieChuFenghaoByRoleIds(String roleIds);
}
