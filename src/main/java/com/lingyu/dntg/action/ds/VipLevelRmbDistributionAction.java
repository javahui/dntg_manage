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
@RequestMapping("vipLevelRmbDistribution")
public class VipLevelRmbDistributionAction extends AbstractAction{
	
	/**
	 * Vip等级及充值占比分布列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		List serverIdList = (List)paramMap.get("serverIdList");
		List<Map> list = gameDaoTemplate.selectListByServerIdList(serverIdList, "rechargeRecord.vipLevelRmbDistribution", paramMap);
		double totalNum = 0, totalRmb = 0;//统计全部的等级的用户数,总充值金额
		MultiValueMap mvMap = MultiValueMap.decorate(new LinkedHashMap()) ;
		for (Map map : list) {
			String level = MapUtils.getString(map, "level");
			totalNum += MapUtils.getIntValue(map, "num");
			totalRmb += MapUtils.getIntValue(map, "rmb");
			mvMap.put(level, map);
		}
		list.clear();
		
		for (Object level : mvMap.keySet()) {
			Collection<Map> coll = mvMap.getCollection(level);
			double totalLevelNum = 0, totalLevelRmb = 0;//统计每等级的用户数,总充值金额
			for (Map map : coll) {
				totalLevelNum += MapUtils.getIntValue(map, "num");
				totalLevelRmb += MapUtils.getIntValue(map, "rmb");
			}
			Map map = new HashMap();
			map.put("level", level);
			map.put("rankRmb", coll.iterator().next().get("rankRmb"));
			map.put("num", totalLevelNum);
			map.put("numRate", totalNum == 0 ? 0 : totalLevelNum / totalNum);
			map.put("rmb", totalLevelRmb);
			map.put("rmbRate", totalRmb == 0 ? 0 : totalLevelRmb / totalRmb);
			list.add(map);
		}
		if (CollectionUtils.isNotEmpty(list)) {
			Map totalMap = new HashMap();
			totalMap.put("level", "total");
			totalMap.put("rankRmb","");
			totalMap.put("num", totalNum);
			totalMap.put("numRate", 1);
			totalMap.put("rmb", totalRmb);
			totalMap.put("rmbRate", 1);
			list.add(totalMap);
			modelMap.put("list", list);
		}
		return DEFAULT_PATH;
	}
	
	/**
	 * Vip等级及充值占比分布列表
	 */
	@RequestMapping("test")
	public String test(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		List serverIdList = (List)paramMap.get("serverIdList");
		List<Map> list = gameDaoTemplate.selectListByServerIdList(serverIdList, "rechargeRecord.vipLevelRmbDistribution", paramMap);
		double totalNum = 0, totalRmb = 0;//统计全部的等级的用户数,总充值金额
		for (Map map : list) {
			totalNum += MapUtils.getDoubleValue(map, "num");
			totalRmb += MapUtils.getDoubleValue(map, "rmb");
		}
		new AggregateFunction(list).group("level", "rankRmb").sum("num", "rmb").execute();
		if (CollectionUtils.isNotEmpty(list)) {
			Map totalMap = new HashMap();
			totalMap.put("level", "total");
			totalMap.put("rankRmb","");
			totalMap.put("num", totalNum);
			totalMap.put("rmb", totalRmb);
			list.add(totalMap);
		}
		modelMap.put("list", list);
		modelMap.put("totalNum", totalNum);
		modelMap.put("totalRmb", totalRmb);
		return DEFAULT_PATH;
	}
	
}