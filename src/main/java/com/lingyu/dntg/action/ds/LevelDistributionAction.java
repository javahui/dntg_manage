package com.lingyu.dntg.action.ds;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.util.AggregateFunction;

@Controller
@RequestMapping("levelDistribution")
public class LevelDistributionAction extends AbstractAction{
	
	/**
	 * 用户等级分布列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		List serverIdList = (List)paramMap.get("serverIdList");
		List<Map> list = logDaoTemplate.selectListByServerIdList(serverIdList, "roleLevelUp.getLevelDistribution", paramMap);
		MultiValueMap mvMap = MultiValueMap.decorate(new LinkedHashMap()) ;
		double total = 0; 
		for (Map map : list) {
			int num = MapUtils.getIntValue(map, "num");
			String level = MapUtils.getString(map, "level");
			mvMap.put(level, num);
			total += num;
		}
		list.clear();
		for (Object key : mvMap.keySet()) {
			int levelTotal = 0;
			Collection<Integer> coll = mvMap.getCollection(key);
			for (Integer levelNum : coll) {
				levelTotal += levelNum;
			}
			Map map = new HashMap();
			map.put("level", key);
			map.put("num", levelTotal);
			map.put("rate", levelTotal / total);
			list.add(map);
		}
		if (CollectionUtils.isNotEmpty(list)) {
			Map totalMap = new HashMap();
			totalMap.put("level", "total");
			totalMap.put("num", total);
			totalMap.put("rate", 1);
			list.add(totalMap);
			modelMap.put("list", list);
		}
		return DEFAULT_PATH;
	}
	
	/**
	 * 用户等级分布列表
	 */
	@RequestMapping("test")
	public String test(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		List serverIdList = (List)paramMap.get("serverIdList");
		List<Map> list = logDaoTemplate.selectListByServerIdList(serverIdList, "roleLevelUp.getLevelDistribution", paramMap);
		double total = 0; 
		for (Map map : list) {
			total += MapUtils.getDoubleValue(map, "num");
		}
		modelMap.put("total", total);
		if (CollectionUtils.isNotEmpty(list)) {
			new AggregateFunction(list).group("level").sum("num").execute();
			Map totalMap = new HashMap();
			totalMap.put("level",  "total");
			totalMap.put("num", total);
			list.add(totalMap);
		}
		modelMap.put("list", list);
		return DEFAULT_PATH;
	}
}