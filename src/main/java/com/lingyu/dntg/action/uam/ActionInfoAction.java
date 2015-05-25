package com.lingyu.dntg.action.uam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 菜单管理
 * @author donghui
 */
@Controller
@RequestMapping("actionInfo")
public class ActionInfoAction extends AbstractAction{
	
	/**
	 * 分支列表
	 */
	@RequestMapping("indexDir")
	public String indexDir(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.selectList("actionInfo.indexDir", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 节点列表
	 */
	@RequestMapping("indexNode")
	public String indexNode(@RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("list", toolDaoTemplate.selectList("actionInfo.indexNodeByDirId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 新增菜单分支页面
	 */
	@RequestMapping("addDir")
	public String addDir(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 新增菜单节点页面
	 */
	@RequestMapping("addNode")
	public String addNode(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		int dirId = MapUtils.getIntValue(paramMap, "dirId");
		Integer id = 0;
		if (dirId == 0) {
			id = toolDaoTemplate.selectOne("actionInfo.getNewDirId");
		}
		else{
			id = toolDaoTemplate.selectOne("actionInfo.getNewNodeIdByDirId", dirId);
		}
		paramMap.put("id", id);
		modelMap.put("result", toolDaoTemplate.insert("actionInfo.addInsert", paramMap));
		return "redirect:./indexDir.do";
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("actionInfo.byId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 修改所属角色权限页面
	 */
	@RequestMapping("editRole")
	public String editRole(@RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("list", toolDaoTemplate.selectList("actionInfo.getAllRoleByActionId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("actionInfo.update",paramMap));
		return "redirect:./indexDir.do";
	}
	
	/**
	 * 修改菜间的角色权限
	 */
	@RequestMapping(value = "updateRole", method = RequestMethod.POST)
	public String updateRole(@RequestParam int actionId, @RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		toolDaoTemplate.delete("actionRole.deleteByActionId", actionId);
		Map paramMap = new HashMap();
		paramMap.put("actionId", actionId);
		paramMap.put("roleIds", recordIds);
		toolDaoTemplate.insert("actionRole.insertRoleIds", paramMap);
		return "redirect:./indexDir.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.delete("actionInfo.delete",recordIds));
		return "redirect:./indexDir.do";
	}
	
}