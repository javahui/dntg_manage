package com.lingyu.dntg.service.sm;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lingyu.dntg.service.AbstractServiceTest;

public class GameServerServiceTest extends AbstractServiceTest{
	@Resource private GameServerService gameServerService;

//	@Test
//	public void selectAllSortGameServers() throws IOException {
//		Map result = gameServerService.selectAllSortGameServers();
//		Assert.assertTrue(result.size() >1 );
//	}
	
//	@Test
//	public void selectAllSortGameServersByUserId() throws IOException {
//		int adminUserId = 1;
//		Map result = gameServerService.selectAllSortGameServersByUserId(adminUserId);
//		log.debug("size:{}",result.size());
//	}
//	
//	@Test
//	public void loginSetDefaultServerId() throws IOException {
//		int adminUserId = 1;
//		String result = gameServerService.loginSetDefaultServerId(adminUserId);
//		log.info("loginSetDefaultServerId result:[{}]" ,result);
//		Assert.assertNotNull(result);
//	}
}
