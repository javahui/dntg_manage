package com.xianling.remoteservice.notice;


import javax.jws.WebService;

@WebService(serviceName="SystemNotice")
public interface SystemNotice {
	public void systemNotice(String msg);
	
	public void notice(String msg);
	
}
