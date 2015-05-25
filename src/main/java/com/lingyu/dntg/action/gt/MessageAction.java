package com.lingyu.dntg.action.gt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.email.SystemEmail;

/**
 * 玩家反馈信息列表
 * @author Lian zhibin
 */
@Controller
@RequestMapping("message")
public class MessageAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("gmMessage.index", paramMap));
		return DEFAULT_PATH;
	}

	/**
	 * 跳转回复页面
	 */
	@RequestMapping("addReply")
	public String addReply(HttpServletRequest request, ModelMap modelMap){
		return DEFAULT_PATH;
	}
	
	/**
	 * 回复
	 */
	@RequestMapping("saveReply.do")
	public String reply(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		toolDaoTemplate.insert("systemEmail.insertMessageReply", paramMap);
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		String title = MapUtils.getString(paramMap, "title");
		String content = MapUtils.getString(paramMap, "content");
		List roleIds = Arrays.asList(new String[]{ MapUtils.getString(paramMap, "userId")});
		try {
			SystemEmail systemEmail = WebServiceFactory.getWSSimple(SystemEmail.class);
			systemEmail.systemEmail(MapUtils.getIntValue(paramMap, "emailId"),roleIds ,0,title, content, 0 ,0 ,"", serverId);
		} catch (Exception e) {
			log.error("回复信息失败");
			modelMap.put("result", 0);
		}
		return INDEX_PATH;
	}
	
	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = toolDaoTemplate.selectList("gmMessage.excelIndex", paramMap);
		String[] titlesArray = new String[]{"标题","内容","用户名","账号","时间"};
		return super.exportXls(dataList, "玩家反馈信息查询", titlesArray);
	}
	
}