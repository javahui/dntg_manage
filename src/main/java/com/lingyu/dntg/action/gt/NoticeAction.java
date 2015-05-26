package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 游戏公告
 * @author donghui
 */
@Controller
@RequestMapping("notice")
public class NoticeAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("notice.index", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 新增页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(int global,  HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("noticeStatus", ConfigConstants.NoticeStatus.READY.value);
		int num = toolDaoTemplate.insert("notice.insert", paramMap);
		if (num == 1) {
			log.info("新增公告成功 noticeId:{}", paramMap.get("noticeId"));
		}
		if (global == 0) {//指定服务器
			num = toolDaoTemplate.insert("notice.insertNoticeServer", paramMap);
			log.info("新增公告指定服务器列表{}条记录 noticeId:{} serverIds:{} ",num, paramMap.get("noticeId"), paramMap.get("serverIds"));
		}
		modelMap.put("result", num);
		return INDEX_PATH;
	}
	
	/**
	 * 发布
	 */
	@RequestMapping("publish")
	public String publish(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("noticeStatus", ConfigConstants.NoticeStatus.PUBLISH.value);
		modelMap.put("result", toolDaoTemplate.update("notice.updateNoticeStatus", paramMap));
		return INDEX_PATH;
	}
	
	/**
	 * 取消
	 */
	@RequestMapping("cancel")
	public String cancel(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("noticeStatus", ConfigConstants.NoticeStatus.CANCELED.value);
		modelMap.put("result", toolDaoTemplate.update("notice.updateNoticeStatus", paramMap));
		return INDEX_PATH;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		log.info("删除公告记录recordIds:{}", recordIds);
		int num = toolDaoTemplate.delete("notice.delete", recordIds);
		modelMap.put("result", num);
		num = toolDaoTemplate.delete("notice.deleteNoticeServer", recordIds);
		return "redirect:./index.do";
	}
	
	@ModelAttribute("noticeStatusMap")
	public Map moneyType(){
		return ConfigConstants.NoticeStatus.getMap();
	}
}