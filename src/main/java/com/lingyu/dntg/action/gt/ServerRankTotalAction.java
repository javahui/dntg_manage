package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 百度全服战斗力排行榜
 * 
 * @author ln
 * 
 */
@Controller
@RequestMapping("serverRankTotal")
public class ServerRankTotalAction extends AbstractAction {
	
	@ResponseBody
	@RequestMapping(value="index", produces="text/plain;charset=UTF-8")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		List<Map> list = toolDaoTemplate.selectList("serverRankTotal.index", paramMap);
		StrBuilder result = new StrBuilder();
		result.append("userId\t"+"userName\t"+"roleId\t"+"roleName\t"+"serverId\t"+"level\t"+"rank\t"+"lastLogin\t"+"loginCount\n");
		for (Map map : list) {
			String[] array = {
				MapUtils.getString(map, "userId"),
				"",
				MapUtils.getString(map, "roleId"),
				MapUtils.getString(map, "roleName"),
				MapUtils.getString(map, "serverid"),
				MapUtils.getString(map, "level"),
				MapUtils.getString(map, "rank"),
				MapUtils.getString(map, "lastLogin"),
				MapUtils.getString(map, "loginCount")
			};
			result.appendln(StringUtils.join(array, "\t"));
		}
		return result.toString();
	}
}
