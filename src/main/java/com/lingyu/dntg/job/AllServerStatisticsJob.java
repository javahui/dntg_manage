/**
 * 
 */
package com.lingyu.dntg.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;
import com.lingyu.dntg.service.gt.ServerStatisticsService;
import com.lingyu.dntg.service.sm.GameServerService;
import com.lingyu.dntg.util.ConfigConstants;
import com.lingyu.dntg.util.PropertyUtils;

/**
 * 所有服务器统计信息
 * 
 * @author JackChu
 * @date 2013-11-22 下午6:03:00
 */
@Component
public class AllServerStatisticsJob {

	private static final ExecutorService executors = Executors
			.newFixedThreadPool(2);

	// yb_consume_2009-03-26
	private static final String YB_CONSUME_FILE = "yb_consume_";
	// gs_statistics_2013-11-21
	private static final String GS_STATISTICS = "gs_statistics_";

	private static final Logger log = LoggerFactory
			.getLogger(AllServerStatisticsJob.class);
	
	@Autowired
	private ServerStatisticsService serverStatisticsService;
	@Autowired
	private GameServerService gameServerService;
	@Autowired
	private ToolDaoTemplate toolDaoTemplate;

	public void run() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		final String day = DateFormatUtils.format(calendar, "yyyy-MM-dd");
		log.info("AllServerStatisticsJob "+day);
		final String filePath = PropertyUtils.getCommons("statistics-file");
		final List<String> allGateurls = gameServerService.getAllServerGateUrl();
		final List<String> sumType = new ArrayList<String>();
		sumType.add(ConfigConstants.STATISTIC_BAOSHI_KEY);
		sumType.add(ConfigConstants.STATISTIC_ROLELEVEL_KEY);
		executors.execute(new Runnable() {
			@Override
			public void run() {
				
				List<String> urls = new ArrayList<String>();
				for (final String gate : allGateurls) {
					try {
						String urlStr = gate + "/" + filePath + YB_CONSUME_FILE
								+ day;
						urls.add(urlStr);
						List<Map<String, Object>> list = serverStatisticsService.analyzeYbConsume(urlStr, day);
//						toolDaoTemplate.batchInsert("statisticsYbConsume.insert", list);
						toolDaoTemplate.insert("statisticsYbConsume.batchinsert", list);
						urlStr = gate + "/" + filePath + GS_STATISTICS + day;
						list = serverStatisticsService.analyzeStatiscCount(urlStr, day,sumType);
//						toolDaoTemplate.batchInsert("statisticsCount.insert", list);
						toolDaoTemplate.insert("statisticsCount.batchinsert", list);
					} catch (Exception e) {
						log.error("",e);
					}
				}
				
				try{
					List<Map<String, Object>> countList  = serverStatisticsService.analyzeStatiscCount(urls, day, sumType);
					toolDaoTemplate.insert("statisticsCount.batchinsert", countList);
				}catch (Exception e) {
					log.error("",e);
				}
			}
		});
	}

	
}
