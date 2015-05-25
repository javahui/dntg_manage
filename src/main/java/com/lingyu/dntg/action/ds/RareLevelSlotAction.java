package com.lingyu.dntg.action.ds;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.util.AggregateFunction;
import com.lingyu.dntg.util.CrossTableFunction;

@Controller
@RequestMapping("rareLevelSlot")
public class RareLevelSlotAction extends AbstractAction{
	
	/**
	 * 装备稀有度分布列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List serverIdList = (List)paramMap.get("serverIdList");
		List<Map> list = gameDaoTemplate.selectListByServerIdList(serverIdList, "roleEquipSlot.selectGroupRareLevelSlot", null);
		if (CollectionUtils.isEmpty(list)) {
			return DEFAULT_PATH; 
		}
		new AggregateFunction(list).group("col", "row").sum("num").execute();
		Object[] orderRowFieldMap = {-70, -40, -55, -80, -82, -85, -25, -20, -90, -81, -95, -96, -97, -98, -101, -102, -103, -104};
		LinkedHashMap orderColFieldMap = new LinkedHashMap();
		orderColFieldMap.put("红色",5);
		orderColFieldMap.put("橙色",4);
		orderColFieldMap.put("紫色",3);
		orderColFieldMap.put("蓝色",2);
		orderColFieldMap.put("绿色",1);
		orderColFieldMap.put("白色",0);
		new CrossTableFunction(list).setOrderColFieldMap(orderColFieldMap).setOrderRowFieldMap(orderRowFieldMap).execute();
		modelMap.put("list", list);
		return DEFAULT_PATH;
	}
}