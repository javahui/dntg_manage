package com.lingyu.dntg.action.uam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.service.uam.RoleService;

/**
 * 角色管理
 * @author donghui
 */
@Controller
@RequestMapping("role")
public class RoleAction extends AbstractAction{
	@Resource private RoleService roleService;

	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("roleInfo.index", paramMap));
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
		paramMap.put("status", 1);
		modelMap.put("result", toolDaoTemplate.insert("roleInfo.insert", paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("roleInfo.byId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("roleInfo.update", paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.delete("roleInfo.delete", recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 菜单权限管理页面
	 */
	@RequestMapping("editActionInfo")
	public String editActionInfo(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("record", toolDaoTemplate.selectOne("roleInfo.byId", paramMap.get("id")));
		modelMap.put("actionInfoList", toolDaoTemplate.selectList("actionInfo.selectActionByUserRole", paramMap));
		return DEFAULT_PATH;
	}

	/**
	 * 保存菜单权限
	 * @param recordIds 菜单action id集合
	 * @param id 角色ID
	 */
	@RequestMapping("updateActionInfo")
	public String updateActionInfo(@RequestParam List<Integer> recordIds, @RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", roleService.updateRoleActionInfo(id, recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 服务器权限管理页面
	 */
	@RequestMapping("editServer")
	public String editServer(@RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		MultiValueMap mvMap = new MultiValueMap();
		List<Map> mapList = toolDaoTemplate.selectList("gameServer.getAllandIsCheck", id);
		for (Map map : mapList) {
			String sortName = MapUtils.getString(map, "sortName");
			mvMap.put(sortName, map);
		}

		modelMap.put("gameServerMap", mvMap);
		return DEFAULT_PATH;
	}

	/**
	 * 服务器权限管理页面
	 */
	@RequestMapping(value = "updateServer", method = RequestMethod.POST)
	public String updateServer(@RequestParam ArrayList<Integer> recordIds, @RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", roleService.updateRoleServer(id, recordIds));
		return "redirect:./index.do";
	}

}