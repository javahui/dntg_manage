package com.lingyu.dntg.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.Notice;
import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.lingyu.dntg.util.ConfigConstants;
import com.xianling.remoteservice.notice.SystemNotice;

@Component
public class NoticeJob {
	private static final Logger log = LoggerFactory.getLogger(NoticeJob.class);
	@Autowired private ToolDaoTemplate toolDaoTemplate;
	private static final ExecutorService executors = Executors.newFixedThreadPool(100);
	private List<String> allServerIdList = new ArrayList();
	
	@PostConstruct
	public void init(){
		allServerIdList = toolDaoTemplate.selectList("gameServer.getAllServerIdByGameDbUrlWithoutRepetition");
	}
	
	public void run(){
		String nowTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm");
		List<Notice> list = toolDaoTemplate.selectList("notice.getPublish", nowTime);
		StringBuilder sb = new StringBuilder();
		for (Notice notice : list) {
			sb.append(notice.getId() + ",");
		}
		log.info("时间:[{}]将要发送的公告有:{}", nowTime, sb);
		for (final Notice notice : list) {
			final int noticeId = notice.getId();
			List<String> serverIdList = null;
			if (notice.getGlobal() == 0) {
				serverIdList = toolDaoTemplate.selectList("notice.getServerIdsByNoticeId", noticeId);
				log.info("发公告:{} 服务器:{}", noticeId, serverIdList);
			}
			else{
				serverIdList = allServerIdList;
				log.info("发公告:{} 发送所有服务器", noticeId);
			}
			for (final String serverIds : serverIdList) {
				executors.execute(new Runnable() {
					@Override
					public void run() {
						try {
							SystemNotice systemNoticeWebService = WebServiceFactory.getWSSimple(StringUtils.substringBefore(serverIds, ","), SystemNotice.class, 5);
							if (ConfigConstants.NoticeType.WORLD.value == notice.getNoticeType()){
								systemNoticeWebService.notice(notice.getContent());
							} 
							else {
								systemNoticeWebService.systemNotice(notice.getContent());
							}
							log.info("发送公告成功 notice id:{}服务器:{} ", noticeId, serverIds);
						} catch (Exception e) {
							log.error("发送公告失败noticeId:{}服务器:{}", noticeId, serverIds);
						}
					}
				});
			}
			Map paramMap = notice.getUpdateNoticeStatusMap();
			int num = toolDaoTemplate.update("notice.updateFinishedCountAndStatus", paramMap);
			if (num == 1) {
				log.info("更新公告成功:{}", paramMap);
			}
		}
	}
}
