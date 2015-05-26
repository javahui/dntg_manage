package com.xianling.remoteservice.account;

import javax.jws.WebService;

@WebService(serviceName="RechargeWeb")
public interface Recharge {
  	/**
	 * 游戏币充值
	 * @param serverId
	 * @param userId 
	 * @param rmb
	 * @param jb 充值的金币
	 * @param platformType 平台类型
	 * @param rechargetType 充值类型
	 * @return
	 */
	public String rechargeWebJb(String serverId, String userId, String orderId, int jb,String platformType,String rechargetType,String userRoleId);
  	/**
	 * 元宝充值
	 * @param serverId
	 * @param userId 
	 * @param rmb
	 * @param yb
	 * @param isCalc
	 * @param platformType
	 * @param rechargetType
	 * @return
	 */
	public String rechargeWebYb(String serverId, String userId, String orderId, double rmb,int yb,boolean isCalc,String platformType,String rechargetType,String userRoleId);
  	/**
	 *绑定元宝充值
	 * @param serverId
	 * @param userId 
	 * @param rmb
	 * @param bindyb
	 * @param platformType
	 * @param rechargetType
	 * @return
	 */
	public String rechargeWebBindYb(String serverId, String userId, String orderId, int bindyb,String platformType,String rechargetType,String userRoleId);
}
