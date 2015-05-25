package com.lingyu.dntg.service.gt;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.lingyu.dntg.service.AbstractService;
import com.xianling.remoteservice.guild.DelGuild;

/**
 * 删除帮会
 * @author ln
 *
 */
@Component
public class GuildService extends AbstractService {
	
	public String delete_AopLog(Map paramMap) throws Exception{
	    String serverId = paramMap.get("currentServerId").toString();
		DelGuild delGuild = WebServiceFactory.getWSSimple(serverId, DelGuild.class);
	    return delGuild.delGuild(paramMap.get("guildId").toString());
	}
	
}
