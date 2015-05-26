package com.lingyu.dntg.action.uam;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.service.uam.UserService;

/**
 * 用户管理
 * @author donghui
 */
@Controller
@RequestMapping("user")
public class UserAction extends AbstractAction{
	@Resource private UserService userService;
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("userInfo.index", paramMap));
		return DEFAULT_PATH;
	}

	/**
	 * 查看详细信息
	 */
	@RequestMapping("show")
	public String show(@RequestParam("id") int id, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("userInfo.show", id));
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
		modelMap.put("result", userService.insert_AopLog(paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("userInfo.byId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 重置密码页面
	 */
	@RequestMapping("editPwd")
	public String editPwd(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser user = (SessionUser)paramMap.get("sessionUser");
		modelMap.put("record", toolDaoTemplate.selectOne("userInfo.byId", user.getId()));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(String password, String confirmPassword, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		if (StringUtils.isNotBlank(password)||StringUtils.isNotBlank(confirmPassword)) {
			modelMap.put("result", userService.update_AopLog(paramMap));
		}
		return "redirect:./index.do";
	}

	/**
	 * 重置密码
	 */
	@RequestMapping(value = "updatePwd", method = RequestMethod.POST)
	public String updatePwd(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", userService.updatePwd_AopLog(paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", userService.delete_AopLog(recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 跳转添加角色页面
	 */
	@RequestMapping("editRole")
	public String editRole(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap){
		modelMap.put("record", toolDaoTemplate.selectOne("userInfo.byId", id));
		modelMap.put("roleInfoList", toolDaoTemplate.selectList("roleInfo.byAll"));
		modelMap.put("userRole", toolDaoTemplate.selectList("userRole.getRoleByUserId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 跳转添加角色页面
	 */
	@RequestMapping("updateRole")
	public String updateRole(@RequestParam List<Integer> roleIds, @RequestParam int userId, HttpServletRequest request, ModelMap modelMap){
		modelMap.put("result", userService.updateRole_AopLog(userId, roleIds));
		return "redirect:./index.do";
	}

	/**
	 * 校验用户名
	 */
	@ResponseBody
	@RequestMapping("checkLoginName")
	public Object checkLoginName(String fieldId, String fieldValue) {
		Integer result = toolDaoTemplate.selectOne("userInfo.existLoingName", fieldValue);
		boolean bool = (result == 0 ? true : false);
		return new Object[]{fieldId, bool};
	}

	/**
	 * 校验用户昵称
	 */
	@ResponseBody
	@RequestMapping("checkUserName")
	public Object checkUserName(String fieldId, String fieldValue) {
		Integer result = toolDaoTemplate.selectOne("userInfo.existUserName", fieldValue);
		boolean bool = (result == 0 ? true : false);
		return new Object[]{fieldId, bool};
	}
}