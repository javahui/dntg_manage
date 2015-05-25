package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 版本更新公告
 * @author Lian zhibin
 */
@Controller
@RequestMapping("publicNotice")
public class PublicNoticeAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("publicNotice.index", paramMap));
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
	public String save(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.insert("publicNotice.insert", paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("publicNotice.byId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("publicNotice.update", paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.delete("publicNotice.delete", recordIds));
		return "redirect:./index.do";
	}
}