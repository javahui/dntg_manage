package com.lingyu.dntg.service.uam;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lingyu.dntg.service.AbstractServiceTest;

public class UserServiceTest extends AbstractServiceTest{
	@Resource private UserService userService;
	
	@Test
	public void selectAllSortGameServers() {
		boolean b = userService.initAdmin();
		Assert.assertFalse(b);
	}
	
	@Test
	public void updateRole() {
		int userId = 1;//admin
		List<Integer> roleIds = Arrays.asList(new Integer[]{1});
		int upateResult = userService.updateRole_AopLog(userId, roleIds);
		Assert.assertEquals(upateResult, 1);
	}
	
	
}
