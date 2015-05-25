package com.lingyu.dntg.dao.gt;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lingyu.dntg.dao.AbstractDaoTest;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.dao.glq.ConsumeBindybDetailDao;

public class ConsumeBindybDetailDaoTest extends AbstractDaoTest{
	@Resource private ConsumeBindybDetailDao consumeBindybDetailDao;
	
	@BeforeClass
	public static void before(){
		LookupContext.setCurrentServerId("F1");
	}
	
	@Test
	public void selectByMonth(){
		consumeBindybDetailDao.selectByMonth("2013_12", null);
	}
	@Test
	public void isExistTableByMonth(){
		consumeBindybDetailDao.isExistTableByMonth("2013_12");	
	}
}
