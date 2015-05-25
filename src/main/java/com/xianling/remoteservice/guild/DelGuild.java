package com.xianling.remoteservice.guild;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="DelGuild")
public interface DelGuild {
	
	/**
	 * 解算公会
	 * @param guildId 公会ID
	 * @return 1失败 0成功
	 */
	@WebMethod
	public String delGuild(String guildId);

}
