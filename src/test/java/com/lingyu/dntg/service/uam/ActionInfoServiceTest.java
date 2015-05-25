package com.lingyu.dntg.service.uam;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.lingyu.dntg.bean.vo.ActionInfo;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.service.AbstractServiceTest;
import com.lingyu.dntg.service.sm.ActionInfoService;

public class ActionInfoServiceTest extends AbstractServiceTest{
	@Resource private ActionInfoService actionInfoService;
	
	@Test
	public void getMenuActionInfo() {
		SessionUser userInfo = toolDaoTemplate.selectOne("getUserByLoginName", "admin");
		log.debug("admin:[{}]", userInfo);
		List list = actionInfoService.getMenuActionInfo(userInfo);
		Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void getAllbyPropertiesFile() {
		List<ActionInfo> list = actionInfoService.getAllbyPropertiesFile();
		Assert.assertTrue(list.size() > 10);
	}
	
	@Test
	public void initAll() throws IOException {
		List<ActionInfo> actionInfoList = actionInfoService.getAllbyPropertiesFile();
		actionInfoService.initAll(actionInfoList);
	}
	
}
