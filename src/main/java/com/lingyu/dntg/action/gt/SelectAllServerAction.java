package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.lingyu.dntg.action.AbstractAction;

/**
 * 51.com
 * 查询所有服务器
 * @author ln
 *
 */
@Controller
@RequestMapping("allServer")
public class SelectAllServerAction extends AbstractAction {
	@ResponseBody
	@RequestMapping(value="index", produces="text/plain;charset=UTF-8")
   public String index(HttpServletRequest request, ModelMap modelMap){
	   
	     Map paramMap = (Map) request.getAttribute("paramMap");
	     List<Map> list=toolDaoTemplate.selectList("gameServer.allServer", paramMap);	
	     JSONObject result = new JSONObject(); 
	      for (Map map : list) {
	    	 result.put(MapUtils.getString(map, "serverName"), str(MapUtils.getString(map,"gateUrl")));
		 }
	        return result.toString();
	  }

	/**
	 * 截取
	 */
	public String str(String param){
		String str = param.substring(0,param.lastIndexOf("d")-1);
		return str;
	}
	
}
