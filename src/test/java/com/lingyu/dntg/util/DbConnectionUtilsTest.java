package com.lingyu.dntg.util;



import org.junit.Assert;
import org.junit.Test;

public class DbConnectionUtilsTest {
	
	
	@Test
	public void testGameServer(){
		boolean result = DbConnectionUtils.testGameServer("F1");
		Assert.assertTrue(result);
	}
	
	@Test
	public void testLogServer(){
		boolean result = DbConnectionUtils.testLogServer("F1");
		Assert.assertTrue(result);
	}
	
	
}
