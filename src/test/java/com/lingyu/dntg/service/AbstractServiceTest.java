package com.lingyu.dntg.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lingyu.dntg.dao.base.AbstractDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-service.xml","classpath*:spring/spring-dao.xml" })
public abstract class AbstractServiceTest extends AbstractDao{
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	
	
}
