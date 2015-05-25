package com.lingyu.dntg.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ToolDbUtilsTest {
	
	
	@Test
	public void selectList(){
		List l = ToolDbUtils.selectList("select * from game_server");
		Assert.assertNotEquals(l.size(), 0);
	}
	
	@Test
	public void selectObject(){
		Object o = ToolDbUtils.selectObject("select count(1) from game_server");
		Assert.assertNotNull(o);
	}
}
