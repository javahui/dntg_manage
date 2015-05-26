package com.xianling.remoteservice.gs;


import javax.jws.WebService;

@WebService(serviceName="GsCount")
public interface GsCount {
	public int onlineCount();
	
	public Object stageCount();
}
