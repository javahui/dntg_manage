package com.lingyu.dntg.job;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lingyu.dntg.dao.base.AbstractDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-service.xml","classpath*:spring/spring-dao.xml","classpath*:spring/spring-quartz.xml" })
public class JobTest extends AbstractDao{
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource private NoticeJob noticeJob;
	@Resource private ServerRealTimeTotalDataJob serverRealTimeTotalDataJob;
	@Resource private ZhandouliRankJob zhandouliRankJob;
	@Resource private TopOneThousandStatisticsJob topOneThousandStatisticsJob;
	
	@Test
	public void getMenuActionInfo() {
		noticeJob.run();
	}
	
	@Test
	public void serverRealTimeTotalDataJob() {
		serverRealTimeTotalDataJob.run();
	}
	
	@Test
	public void zhandouliRankJob() {
		zhandouliRankJob.run();
	}
	
	@Test
	public void topOneThousandStatisticsJob_zhandouli() {
		topOneThousandStatisticsJob.zhandouli();
	}
	
}
