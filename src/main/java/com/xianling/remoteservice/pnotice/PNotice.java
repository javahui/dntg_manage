package com.xianling.remoteservice.pnotice;


import javax.jws.WebService;

@WebService(serviceName="PNotice")
public interface PNotice {
	
	public void noticeUpdate(String notice);
}
