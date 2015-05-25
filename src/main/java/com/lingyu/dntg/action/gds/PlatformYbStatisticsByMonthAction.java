package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 平台每月元宝充值统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("platformYbStatisticsByMonth")
public class PlatformYbStatisticsByMonthAction extends AbstractAction{
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(String sortId, String startMonth,String endMonth, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(sortId) && StringUtils.isNotBlank(startMonth) && StringUtils.isNotBlank(startMonth)) {
			Map paramMap = (Map)request.getAttribute("paramMap");
			List<String> serverIdList = toolDaoTemplate.selectList("gameServer.getServerBySortId",paramMap);
			List<Map> resultList = logDaoTemplate.selectListByServerIdList(serverIdList,"ybConsume.getYbByMonth", paramMap) ;
			//利用Bag来sum同一日期的元宝
			HashBag bag = new HashBag();
			for (Map recordsMap : resultList) {
				String logMonth = MapUtils.getString(recordsMap, "logMonth");
				int yb = MapUtils.getIntValue(recordsMap, "yb");
				bag.add(logMonth, yb);
			}
			TreeMap map = new TreeMap();
			for (Object logMonth : bag.uniqueSet()) {
				map.put(logMonth, bag.getCount(logMonth));
			}
			modelMap.put("map", map);
		}
		return DEFAULT_PATH;
	}
	
	@ModelAttribute("sortMap")
	public List moneyType(){
		return toolDaoTemplate.selectList("serverSort.indexAllServer");
	}
}