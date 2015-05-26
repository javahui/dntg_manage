package com.lingyu.dntg.service.init;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lingyu.dntg.service.uam.UserService;

@Component
public class InitAdminUser {
	@Resource private UserService userService;
	
	/**
	 * 初始化admin用户
	 */
	@PostConstruct
	public void initAdmin(){
		userService.initAdmin();
	}
	
}
