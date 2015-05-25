/**
 * 
 */
package com.lingyu.dntg.action.gt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.constants.log.GameLogEventType;
import com.lingyu.dntg.constants.log.StatisticsTaskGameEventTypeMapper;
import com.lingyu.dntg.constants.log.StatisticsTaskName;
import com.lingyu.dntg.service.gt.ServerStatisticsService;
import com.lingyu.dntg.service.sm.GameServerService;
import com.lingyu.dntg.util.ConfigConstants;
import com.lingyu.dntg.util.PropertyUtils;
import com.lingyu.dntg.util.URLUtils;

/**
 * @date 2013-11-26 下午10:40:08
 */
@Controller
@RequestMapping("serverStatistics")
public class ServerStatisticsAction extends AbstractAction {

	@Autowired
	private GameServerService gameServerService;
	@Autowired
	private ServerStatisticsService serverStatisticsService;

	/**
	 * 主动触发gate项目 ，生成consume yb file
	 * 
	 * @param request
	 *            [start,end] yyyy-MM-dd
	 * @param response
	 * @throws ParseException
	 */
	@RequestMapping("consumeybFile")
	public void genericYbConsumeFile(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		List<String> allGateurls = gameServerService.getAllServerGateUrl();
		Map paramMap = (Map) request.getAttribute("paramMap");
		String start = (String) paramMap.get("start");
		String end = (String) paramMap.get("end");
		Date startTime = null;
		if (StringUtils.isNotBlank(start)) {
			startTime = DateUtils.parseDate(start, new String[] { "yyyy-MM-dd" });
		}
		Date endTime = null;
		if (StringUtils.isNotBlank(end)) {
			endTime = DateUtils.parseDate(start, new String[] { "yyyy-MM-dd" });
		} else {
			endTime = new Date();
		}
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endTime);

		for (final String gate : allGateurls) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startTime);
			while (true) {
				String time = DateFormatUtils.format(calendar, "yyyy-MM-dd");
				URLUtils.getContentFromUrl(gate + "/dntgybcs?time=" + time, 1000);
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				if (DateUtils.isSameDay(calendar, endCalendar)) {
					break;
				}
			}
		}
	}

	private String[] getDay(String start, String end) {
		Date startTime = null;
		if (StringUtils.isNotBlank(start)) {
			try {
				startTime = DateUtils.parseDate(start, new String[] { "yyyy-MM-dd" });
			} catch (ParseException e) {
			}
		} else {
			return new String[0];
		}
		Date endTime = null;
		if (StringUtils.isNotBlank(end)) {
			try {
				endTime = DateUtils.parseDate(end, new String[] { "yyyy-MM-dd" });
			} catch (ParseException e) {
			}
		} else {
			endTime = new Date();
		}
		List<String> days = new ArrayList<String>();
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endTime);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime);
		while (true) {
			String time = DateFormatUtils.format(calendar, "yyyy-MM-dd");
			days.add(time);
			if (DateUtils.isSameDay(calendar, endCalendar)) {
				break;
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		return days.toArray(new String[0]);
	}

	/**
	 * 元宝主动统计
	 * 
	 * @date 2013-11-27 下午10:29:36
	 * @param request
	 *            时间 yyyy-MM-dd [start,end]，没有时间就是全部
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("index")
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map paramMap = (Map) request.getAttribute("paramMap");
		String start = (String) paramMap.get("start");
		String end = (String) paramMap.get("end");
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>(ConfigConstants.STATISTICS_BATCH_SQL_SIZE);

		final String filePath = PropertyUtils.getCommons("statistics-file");
		List<String> allGateurls = gameServerService.getAllServerGateUrl();
		if (StringUtils.isNotBlank(start)) {
			String days[] = getDay(start, end);
			for (final String gate : allGateurls) {
				String urlStr = gate + "/" + filePath;
				for (String time : days) {
					String url = urlStr + ConfigConstants.LOG_FILE_YB_CONSUME + time;
					List<Map<String, Object>> list = serverStatisticsService.analyzeYbConsume(url, time);
					allList.addAll(list);
					if (allList.size() >= ConfigConstants.STATISTICS_BATCH_SQL_SIZE) {
						toolDaoTemplate.insert("statisticsYbConsume.batchinsert", allList);
						allList.clear();
					}
				}
			}
		} else {
			for (final String gate : allGateurls) {
				String urlStr = gate + "/" + filePath;
				List<String> allUrls = URLUtils.getUrlListFromUrl(urlStr, 1000, "yb_consume_");
				for (String path : allUrls) {
					String url = urlStr + path;
					String time = path.substring("yb_consume_".length());
					List<Map<String, Object>> list = serverStatisticsService.analyzeYbConsume(url, time);
					allList.addAll(list);
					if (allList.size() >= ConfigConstants.STATISTICS_BATCH_SQL_SIZE) {
						toolDaoTemplate.insert("statisticsYbConsume.batchinsert", allList);
						allList.clear();
					}
				}
			}
		}
		if (!allList.isEmpty()) {
			toolDaoTemplate.insert("statisticsYbConsume.batchinsert", allList);
		}
		PrintWriter jw = response.getWriter();
		jw.print("success");
	}

	/**
	 * 等级主动统计
	 * 
	 * @date 2013-11-27 下午10:29:56
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("levelStatistics")
	public void levelStatistics(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Map<String, Object>> allList = new ArrayList<Map<String, Object>>(ConfigConstants.STATISTICS_BATCH_SQL_SIZE);
		final String filePath = PropertyUtils.getCommons("statistics-file");
		final List<String> sumType = new ArrayList<String>();
		sumType.add(ConfigConstants.STATISTIC_BAOSHI_KEY);
		sumType.add(ConfigConstants.STATISTIC_ROLELEVEL_KEY);
		List<String> allGateurls = gameServerService.getAllServerGateUrl();
		Map<String, List<String>> urls = new HashMap<String, List<String>>();
		for (final String gate : allGateurls) {
			String urlStr = gate + "/" + filePath;
			List<String> allUrls = URLUtils.getUrlListFromUrl(urlStr, 1000, "gs_statistics_");
			for (String path : allUrls) {
				String url = urlStr + path;
				String time = path.substring("gs_statistics_".length());
				List<String> durls = urls.get(time);
				if (durls == null) {
					durls = new ArrayList<String>();
					urls.put(time, durls);
				}
				durls.add(url);
				List<Map<String, Object>> list = serverStatisticsService.analyzeStatiscCount(url, time, sumType);
				allList.addAll(list);
				if (allList.size() >= ConfigConstants.STATISTICS_BATCH_SQL_SIZE) {
					// toolDaoTemplate.batchInsert("statisticsCount.insert",
					// allList);
					toolDaoTemplate.insert("statisticsCount.batchinsert", allList);
					allList.clear();
				}
			}
		}
		if (!allList.isEmpty()) {
			toolDaoTemplate.insert("statisticsCount.batchinsert", allList);
			allList.clear();
			// toolDaoTemplate.batchInsert("statisticsCount.insert", allList);
		}
		for (Entry<String, List<String>> entry : urls.entrySet()) {
			List<Map<String, Object>> countList = serverStatisticsService.analyzeStatiscCount(entry.getValue(), entry.getKey(), sumType);
			if (!countList.isEmpty()) {
				allList.addAll(countList);
				if (allList.size() >= ConfigConstants.STATISTICS_BATCH_SQL_SIZE) {
					toolDaoTemplate.insert("statisticsCount.batchinsert", allList);
					allList.clear();
				}
			}
		}
		if (!allList.isEmpty()) {
			toolDaoTemplate.insert("statisticsCount.batchinsert", allList);
			allList.clear();
		}
		PrintWriter jw = response.getWriter();
		jw.print("success");
	}

	/**
	 * 元宝统计查询
	 * 
	 * @date 2013-11-27 下午9:14:50
	 * @param startTime
	 * @param endTime
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("ybconsume")
	public String ybconsume(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		String event = (String) paramMap.get("sevent");
		List paging = null;
		if (StringUtils.isBlank(event)) {
			paging = toolDaoTemplate.selectList("statisticsYbConsume.selectYbConsume", paramMap);
		} else {
			paging = toolDaoTemplate.selectList("statisticsYbConsume.selectYbConsumeByEvent", paramMap);
		}
		modelMap.put("list", paging);
		modelMap.put("eventTypeMap2", StatisticsTaskGameEventTypeMapper.getRelateEventTypes(StatisticsTaskName.CONSUME_YB));
		modelMap.put("sevent", event);
		for (Object r : paging) {
			Map<String, Object> o = (Map) r;
			o.put("event", GameLogEventType.convertEventTypeToString((String) o.get("event")));
		}
		return DEFAULT_PATH;
	}

	/**
	 * 元宝消费统计Excel
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]> xls(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		List<Map> dataList = toolDaoTemplate.selectList("statisticsYbConsume.selectYbConsume", paramMap);
		for (int i = 0; i < dataList.size(); i++) {
			String event = GameLogEventType.convertEventTypeToString((String) dataList.get(i).get("event"));
			dataList.get(i).remove("event");
			dataList.get(i).put("event", event);
		}
		String[] titlesArray = new String[] { "事件", "总和" };
		return super.exportXls(dataList, "元宝消费", titlesArray);
	}

}
