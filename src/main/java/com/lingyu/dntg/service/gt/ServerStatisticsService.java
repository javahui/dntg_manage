/**
 * 
 */
package com.lingyu.dntg.service.gt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lingyu.dntg.bean.pojo.ServerRealTimeTotalData;
import com.lingyu.dntg.dao.gds.ServerRealTimeTotalDataDao;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.service.sm.GameServerService;
import com.lingyu.dntg.util.ConfigConstants;
import com.lingyu.dntg.util.PropertyUtils;
import com.lingyu.dntg.util.URLUtils;

/**
 * @date 2013-11-26 下午10:43:17
 */
@Service
public class ServerStatisticsService extends AbstractService {

	private static final Logger log = LoggerFactory.getLogger(ServerStatisticsService.class);

	@Resource private GameServerService gameServerService;
	@Resource private ServerRealTimeTotalDataDao serverRealTimeTotalDataDao;

	public void analyzeAllServerRealTime(String time) {
		final List<String> allGateurls = gameServerService.getAllServerGateUrl();
		final String filePath = PropertyUtils.getCommons("statistics-file");
		for (final String gate : allGateurls) {
			try {
				String urlStr = gate  + "/" + filePath + "real_time_" + time;
				if(gate.endsWith("/")){
					urlStr = gate  + filePath + "real_time_" + time;
				}
				String json = URLUtils.getContentFromUrl(urlStr, 2000);
				analyzeServerRealTime(json, time);
			} catch (Exception e) {
				log.error(gate, e);
			}
		}
	}

	/**
	 * json :Map<String,List<ServerRealTimeTotalData>>
	 * 
	 * @param time
	 */
	public void analyzeServerRealTime(String json, String time) {
		if (StringUtils.isNotEmpty(json)) {
			JSONObject jsonObject = JSONObject.parseObject(json);
			if(jsonObject.isEmpty()){
				return;
			}
			List<ServerRealTimeTotalData> list = new ArrayList<ServerRealTimeTotalData>();
			Map<String, String> delteParams = new HashMap<String, String>();
			String logHour = time.substring(0, time.lastIndexOf("-"));
			delteParams.put("logHour", logHour);
			for (Map.Entry<String, Object> entry : (Set<Map.Entry<String, Object>>) jsonObject.entrySet()) {
				String server = entry.getKey();
				delteParams.put("server", server);
				serverRealTimeTotalDataDao.deleteByLoghourAndServer(delteParams);
				JSONArray eventList = (JSONArray) entry.getValue();
				for (Object e : eventList) {
					ServerRealTimeTotalData data = JSONArray.toJavaObject((JSONObject) e, ServerRealTimeTotalData.class);
					data.setLogTime(new Timestamp(System.currentTimeMillis()));
					list.add(data);
				}
			}
			serverRealTimeTotalDataDao.batchInsert(logHour, list);
		}
	}

	public List<Map<String, Object>> analyzeYbConsume(String urlStr, String day) {
		String json = URLUtils.getContentFromUrl(urlStr, 1500);// <server,list<event,sum>>

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (StringUtils.isNotEmpty(json)) {
			JSONObject jsonObject = JSONObject.parseObject(json);
			for (Iterator entries = jsonObject.entrySet().iterator(); entries
					.hasNext();) {
				Map.Entry entry = (Map.Entry) entries.next();
				String server = String.valueOf(entry.getKey());
				Map<String, String> delteParams = new HashMap<String, String>();
				delteParams.put("server", server);
				delteParams.put("day", day);
				toolDaoTemplate
						.delete("statisticsYbConsume.deleteByDayAndServer",
								delteParams);
				JSONArray eventList = (JSONArray) entry.getValue();
				for (Object e : eventList) {
					JSONObject eventObject = (JSONObject) e;
					String event = eventObject.getString("event");
					Long sum = eventObject.getLong("sum");
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("day", day);
					params.put("event", event);
					params.put("sum", sum);
					params.put("server", server);
					list.add(params);
				}
			}
			log.debug("analyzeYbConsume:" + urlStr);
		}
		return list;
	}

	/**
	 * 算所有服和
	 * 
	 * @param allUrls
	 * @param day
	 * @param analyzeType
	 * @return
	 */
	public List<Map<String, Object>> analyzeStatiscCount(List<String> allUrls,
			String day, List<String> analyzeType) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Map<String, Long>> analyzeTypeMaps = new HashMap<String, Map<String, Long>>();
		for (String type : analyzeType) {
			analyzeTypeMaps.put(type, new HashMap<String, Long>(256));
		}
		List<String> jsonList = new ArrayList<String>(100);
		for (String url : allUrls) {
			String json = URLUtils.getContentFromUrl(url, 1500);// /<type,<server,list>>
			if (StringUtils.isNotEmpty(json)) {
				jsonList.add(json);
			}
		}

		String server = "global";
		deleteStatisticsCount(day, server);

		for (String json : jsonList) {
			JSONObject jsonObject = JSONObject.parseObject(json);// <type,<server,list>>

			for (Map.Entry entry : jsonObject.entrySet()) {
				String type = String.valueOf(entry.getKey());
				String typeKey = type;
				String typeValue = type;
				String valueKey = "pcount";// keySet.iterator().next();
				if ("qibinglevel".equals(type)) {
					typeKey = "qibinlevel";
				}
				if ("baoshiCount".equals(type)) {
					typeKey = "alevel";
					valueKey = "baoshiCount";
					typeValue = ConfigConstants.STATISTIC_BAOSHI_KEY;
				}

				if (!analyzeType.contains(typeValue)) {
					continue;
				}

				JSONObject serverListMap = (JSONObject) entry.getValue();
				for (Map.Entry serverLs : serverListMap.entrySet()) {
					// String server = String.valueOf(serverLs.getKey());
					JSONArray eventList = (JSONArray) serverLs.getValue();

					for (Object e : eventList) {
						JSONObject eventObject = (JSONObject) e;
						// int value = eventObject.getIntValue(typeKey);
						String value = eventObject.getString(typeKey);
						Long count = eventObject.getLong(valueKey);

						Map<String, Long> map = analyzeTypeMaps.get(typeValue);
						Long sum = map.get(value);
						if (sum == null) {
							map.put(value, count);
						} else {
							map.put(value, sum + count);
						}
					}
				}
			}
		}
		for (Entry<String, Map<String, Long>> entry : analyzeTypeMaps
				.entrySet()) {
			String type = entry.getKey();
			Map<String, Long> typemaps = entry.getValue();
			for (Entry<String, Long> e : typemaps.entrySet()) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("day", day);
				params.put("type", type);
				params.put("value", e.getKey());
				params.put("count", e.getValue());
				params.put("server", server);
				result.add(params);
			}
		}

		return result;
	}

	/**
	 * @param day
	 * @param server
	 */
	private void deleteStatisticsCount(String day, String server) {
		// Map<String, String> delteParams = new HashMap<String, String>();
		// delteParams.put("server", server);
		// delteParams.put("day", day);
		// toolDaoTemplate.delete("statisticsCount.deleteByDayAndServer",
		// delteParams);
	}

	public List<Map<String, Object>> analyzeStatiscCount(String urlStr,
			String day, List<String> excludesType) {
		String json = URLUtils.getContentFromUrl(urlStr, 1500);// Map<String,
																// Map<String,
		// List<JSONObject>>>
		// //<type,<server,list>>

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (StringUtils.isNotEmpty(json)) {
			JSONObject jsonObject = JSONObject.parseObject(json);
			for (Iterator entries = jsonObject.entrySet().iterator(); entries
					.hasNext();) {
				Map.Entry entry = (Map.Entry) entries.next();
				String type = String.valueOf(entry.getKey());
				String typeKey = type;
				String typeValue = type;
				String valueKey = "pcount";// keySet.iterator().next();
				if ("qibinglevel".equals(type)) {
					typeKey = "qibinlevel";
				}
				if ("baoshiCount".equals(type)) {
					typeKey = "alevel";
					valueKey = "baoshiCount";
					typeValue = ConfigConstants.STATISTIC_BAOSHI_KEY;
				}
				if (excludesType.contains(typeValue)) {
					continue;
				}
				JSONObject serverListMap = (JSONObject) entry.getValue();
				for (Map.Entry serverLs : serverListMap.entrySet()) {
					String server = String.valueOf(serverLs.getKey());
					deleteStatisticsCount(day, server);
					JSONArray eventList = (JSONArray) serverLs.getValue();

					for (Object e : eventList) {
						JSONObject eventObject = (JSONObject) e;
						// Set<String> keySet = new
						// HashSet<String>(eventObject.keySet());
						// keySet.remove(type);
						// int value = eventObject.getIntValue(typeKey);
						String value = eventObject.getString(typeKey);
						Long count = eventObject.getLong(valueKey);
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("day", day);
						params.put("type", typeValue);
						params.put("value", value);
						params.put("count", count);
						params.put("server", server);
						list.add(params);
					}

				}
			}
			log.debug("analyzeYbConsume:" + urlStr);
		}
		return list;
	}

}
