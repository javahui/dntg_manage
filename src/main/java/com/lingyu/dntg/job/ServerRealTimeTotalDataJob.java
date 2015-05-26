package com.lingyu.dntg.job;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.service.gds.ServerRealTimeTotalDataService;

/**
 * 实时分服总数据
 * @author donghui
 */
@Component
public class ServerRealTimeTotalDataJob {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource private ServerRealTimeTotalDataService serverRealTimeTotalDataService;

	public void run() {
		serverRealTimeTotalDataService.batchUpdateByLogHour(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH"));
	}

}
