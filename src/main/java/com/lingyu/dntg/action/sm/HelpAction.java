package com.lingyu.dntg.action.sm;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.job.AllServerStatisticsJob;
import com.lingyu.dntg.job.NoticeJob;
import com.lingyu.dntg.job.ServerRealTimeTotalDataJob;
import com.lingyu.dntg.job.ServersIntegrationReportJob;
import com.lingyu.dntg.job.TopOneThousandStatisticsJob;
import com.lingyu.dntg.job.ZhandouliRankJob;
import com.lingyu.dntg.util.GameDbUtils;
import com.lingyu.dntg.util.LogDbUtils;
import com.lingyu.dntg.util.ToolDbUtils;

/**
 * 非功能性,一些辅助功能
 * @author donghui
 */
@Controller
@RequestMapping("help")
public class HelpAction extends AbstractAction{
	
	@RequestMapping("log")
	public String log(String d, HttpServletRequest request, ModelMap modelMap) throws IOException{
		if(StringUtils.isBlank(d)) {
			d = DateFormatUtils.format(new Date(), "MM-dd");
		}
		String fileName = String.format("/logs/dm.%s.log", d);
		List<String> list = FileUtils.readLines(new File(fileName));
		modelMap.put("list", list);
		return "/help/log";
	}
	
	@RequestMapping("select")
	public String select(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			StopWatch sw = new StopWatch();
			sw.start();
			modelMap.put("list", ToolDbUtils.selectList(sql));
			modelMap.put("time", sw.getTime());
		}
		return DEFAULT_PATH;
	}
	
	@RequestMapping("selectGame")
	public String selectGame(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			StopWatch sw = new StopWatch();
			sw.start();
			modelMap.put("list", GameDbUtils.selectList(sql));
			modelMap.put("time", sw.getTime());
		}
		return DEFAULT_PATH;
	}
	
	@RequestMapping("selectLog")
	public String selectLog(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			StopWatch sw = new StopWatch();
			sw.start();
			modelMap.put("list", LogDbUtils.selectList(sql));
			modelMap.put("time", sw.getTime());
		}
		return DEFAULT_PATH;
	}
	
	@RequestMapping("update")
	public String update(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			modelMap.put("list", ToolDbUtils.update(sql));
		}
		return DEFAULT_PATH;
	}
	@RequestMapping("updateGame")
	public String updateGame(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			modelMap.put("list", GameDbUtils.update(sql));
		}
		return DEFAULT_PATH;
	}
	@RequestMapping("updateLog")
	public String updateLog(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		if (StringUtils.isNotBlank(sql)) {
			modelMap.put("list", LogDbUtils.update(sql));
		}
		return DEFAULT_PATH;
	}
	
	
	
	@RequestMapping("job")
	public String job(String sql, HttpServletRequest request, ModelMap modelMap) throws Exception{
		return DEFAULT_PATH;
	}
	
	@Resource private ServerRealTimeTotalDataJob serverRealTimeTotalDataJob;
	@RequestMapping("serverRealTimeTotalDataJob")
	public String serverRealTimeTotalDataJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		serverRealTimeTotalDataJob.run();
		return "redirect:./job.do";
	}
	
	@Resource private AllServerStatisticsJob allServerStatisticsJob;
	@RequestMapping("allServerStatisticsJob")
	public String allServerStatisticsJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		allServerStatisticsJob.run();
		return "redirect:./job.do";
	}
	
	@Resource private NoticeJob noticeJob;
	@RequestMapping("noticeJob")
	public String noticeJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		noticeJob.run();
		return "redirect:./job.do";
	}
	
	@Resource private ZhandouliRankJob zhandouliRankJob;
	@RequestMapping("zhandouliRankJob")
	public String zhandouliRankJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		zhandouliRankJob.run();
		return "redirect:./job.do";
	}
	
	@Resource private TopOneThousandStatisticsJob topOneThousandStatisticsJob;
	@RequestMapping("topOneThousandStatisticsJob")
	public String topOneThousandStatisticsJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		topOneThousandStatisticsJob.run();
		return "redirect:./job.do";
	}
	
	@Resource private ServersIntegrationReportJob serversIntegrationReportJob;
	@RequestMapping("serversIntegrationReportJob")
	public String serversIntegrationReportJob(HttpServletRequest request, ModelMap modelMap) throws Exception{
		serversIntegrationReportJob.run();
		return "redirect:./job.do";
	}
	
	@ResponseBody
	@RequestMapping("test")
	public Object test(HttpServletRequest request, ModelMap modelMap) throws Exception{
		return gameDaoTemplate.selectMapAllServers("rechargeRecord.vipLevelRmbDistribution");
	}
	
}