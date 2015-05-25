package com.lingyu.dntg.action.gt;

import java.net.URLEncoder;
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

import com.alibaba.fastjson.JSONObject;
import com.lingyu.dntg.action.AbstractAction;

/**
 * 百度激活码使用情况
 * @author ln
 */

@Controller
@RequestMapping("giftCode")
public class GiftCodeAction extends AbstractAction{
	
	@ResponseBody
	@RequestMapping(value="index", produces="text/plain;charset=UTF-8")
	 public String getGiftcode(HttpServletRequest request,ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
	    String batch = paramMap.get("batch").toString();
	    int num = Integer.parseInt(batch)/100;
	    paramMap.put("num", num);
	    try{
	    	StrBuilder result = new StrBuilder();
		    List<Map> list = toolDaoTemplate.selectList("giftCode.index", paramMap);
		    for (Map giftCodeMap : list) {
		    	String userInfoJson = MapUtils.getString(giftCodeMap, "useInfo");
		    	Map useInfoMap = JSONObject.parseObject(userInfoJson, Map.class);
				String[] results = {
		    		  MapUtils.getString(useInfoMap, "user"),
		    		  "495",
		    		  MapUtils.getString(useInfoMap, "server"),
		    		  URLEncoder.encode(MapUtils.getString(useInfoMap, "name"), "utf-8"),
		    		  MapUtils.getString(useInfoMap, "time"),
		    		  MapUtils.getString(giftCodeMap, "giftCode")
		    	};
		    	result.appendln(StringUtils.join(results, "\t"));
			}
			return result.toString();
	    }catch(Exception e){
	    	log.error("百度激活码错误", e);
	    	return "Error:-1";   //批号有错误
	    }
	 }
}
