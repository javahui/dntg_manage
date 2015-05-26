package com.lingyu.dntg.action.gdq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.gs.GsCount;

/**
 * 在线人数查询
 * @author donghui
 */
@Controller
@RequestMapping("onlineUserInfo")
public class OnlineUserInfoAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		try {
			List<String> result = new ArrayList<String>();
			GsCount gsCountWebService = WebServiceFactory.getWSSimple(serverId, GsCount.class);
			modelMap.put("count", gsCountWebService.onlineCount());
			String json = (String)gsCountWebService.stageCount();
			JSONArray jsonArray = JSON.parseArray(json);
			for (Object object : jsonArray) {
				JSONArray array = (JSONArray)object;
				result.add(StringUtils.join(array, ":"));
			}
			modelMap.put("stageCountInfo", result);
			modelMap.put("todayCount", gameDaoTemplate.selectOne("userRole.getTodayCreaterCount"));
			modelMap.put("totalCount", gameDaoTemplate.selectOne("userRole.indexCount"));
			
		} catch (Exception e) {
			modelMap.put("result", "连接游戏服务器失败");
		}
		return DEFAULT_PATH;
	}
}