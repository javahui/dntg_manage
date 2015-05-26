package com.lingyu.dntg.service.gds;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.ServerRealTimeTotalData;
import com.lingyu.dntg.dao.gds.ServerRealTimeTotalDataDao;
import com.lingyu.dntg.service.AbstractService;

@Component
public class ServerRealTimeTotalDataService extends AbstractService{
	@Resource private ServerRealTimeTotalDataDao serverRealTimeTotalDataDao;

	/**
	 * 按一小时统计实时分服总数据
	 * @param logHour
	 */
	public void batchUpdateByLogHour(String logHour) {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("统计{}实时分服的数据", logHour);
		List<ServerRealTimeTotalData> serverRealTimeTotalDataList = gameDaoTemplate.selectListAllServers("serverRealTimeTotalData.getNewestByLogHour", logHour);
		int num = serverRealTimeTotalDataDao.batchUpdateByLogHour(logHour, serverRealTimeTotalDataList);
		log.info("实时分服总数据更新{}条记录 用时:{}", num, sw.getTime());
	}
	
	/**
	 * 按天统计实时分服总数据
	 * @param logDay
	 */
	public void batchUpdateByLogDay(String logDay) {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("恢复{}实时分服数据", logDay);
		List<ServerRealTimeTotalData> serverRealTimeTotalDataList = gameDaoTemplate.selectListAllServers("serverRealTimeTotalData.getNewestByLogDay", logDay);
		int num = serverRealTimeTotalDataDao.batchUpdateByLogDay(logDay, serverRealTimeTotalDataList);
		log.info("恢复{}的实时分服数据共{}条记录 用时:{}", logDay, num, sw.getTime());
	}
}

