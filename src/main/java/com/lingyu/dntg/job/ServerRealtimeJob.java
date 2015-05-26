/**
 * 
 */
package com.lingyu.dntg.job;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.service.gt.ServerStatisticsService;

/**
 * @author JackChu
 * @date 2013-11-25 下午4:59:31
 */
@Component
public class ServerRealtimeJob {

	@Autowired
	private ServerStatisticsService serverStatisticsService;
	
	private static final ExecutorService executors = Executors.newFixedThreadPool(1);

	private static final Logger log = LoggerFactory
			.getLogger(ServerRealtimeJob.class);

	public void run() {
		StopWatch sw = new StopWatch();
		sw.start();
		final CountDownLatch latch = new CountDownLatch(1);
		Calendar calendar = java.util.Calendar.getInstance(); //
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, -1);
		final String time = DateFormatUtils
				.format(calendar, "yyyy-MM-dd HH-mm");

		executors.execute(new Runnable() {
			@Override
			public void run() {
				try {
					serverStatisticsService.analyzeAllServerRealTime(time);
				} catch (Exception e) {
					log.error("", e);
				}
				latch.countDown();
			}
		});
		try {
			latch.await();
		} catch (InterruptedException e) {
			log.error("", e);
		}
		log.info("ServerRealtimeJob,runtime:[{}] 完成时间:[{}]", time, sw.getTime());
	}

}
