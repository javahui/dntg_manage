package com.lingyu.dntg.action.glq;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 普通用户聊天日志
 * @author ln
 *
 */
@Controller
@RequestMapping("normalChatLog")
public class NormalChatLogAction extends AbstractAction {
	

	@RequestMapping("index")
	public String index(String roleName,String toRoleName,String type, String startTime,
			String endTime, HttpServletRequest request, ModelMap modelMap) {
		    if(StringUtils.isNotBlank(roleName)||StringUtils.isNotBlank(toRoleName)
		    	 ||StringUtils.isNotBlank(type)
		    	 ||StringUtils.isNotBlank(startTime)
		    	 ||StringUtils.isNotBlank(endTime)){
		    	
		    	Map paramMap = (Map) request.getAttribute("paramMap");
				modelMap.put("list",logDaoTemplate.paging("normalChat.index", paramMap));
		    	
		    }
		
		    modelMap.put("typeMap", getChatMap());
		
		return DEFAULT_PATH;
	}
	
		public  Map<Integer, String> getChatMap(){
		Map<Integer, String> chatMap=new HashMap<Integer, String>();
			chatMap.put(1,"普通");
			chatMap.put(2,"私聊");
			chatMap.put(3,"组队");
			chatMap.put(4,"公会");
			chatMap.put(5,"世界");
			chatMap.put(6,"喇叭");
			return chatMap;
		}

}
