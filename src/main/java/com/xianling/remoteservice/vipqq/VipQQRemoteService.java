package com.xianling.remoteservice.vipqq;

import javax.jws.WebService;

@WebService(serviceName="VipQQRemoteService")
public interface VipQQRemoteService {
	
	/**
	 * 更新VipQQ面板信息
	 * @param qq
	 * @param minRecharge
	 * @param pic
	 * @return
	 */
	public String updateVipQQ(String qq,int minRecharge,String pic);
	
	public void vipQqOK(String roleId,String qq,String userName);
}
