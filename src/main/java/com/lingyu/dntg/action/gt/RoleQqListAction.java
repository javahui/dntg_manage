package com.lingyu.dntg.action.gt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.vipqq.VipQQRemoteService;

/**
 * 超级会员名单
 * @author donghui
 */
@Controller
@RequestMapping("roleQqList")
public class RoleQqListAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("roleQqList.index", paramMap));
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
	 * 新增页面
	 */
	@RequestMapping("addInner")
	public String addInner(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam String id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", gameDaoTemplate.selectOne("roleQqList.byId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 保存新增
	 */
	@RequestMapping("save")
	public String save(@RequestParam String userRoleName, @RequestParam String qq, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		try {
			VipQQRemoteService vipQQRemoteService = WebServiceFactory.getWSSimple(paramMap.get("currentServerId").toString(), VipQQRemoteService.class);
			String id = gameDaoTemplate.selectOne("userRole.existName", userRoleName);
			vipQQRemoteService.vipQqOK(id, qq, sessionUser.getUserName());
		} catch (Exception e) {
			log.error("超级会员新增失败", e);
			modelMap.put("result", 0);	
		}
		return INDEX_PATH;
	}
	
	/**
	 * 添加内部人员名单
	 */
	@RequestMapping("saveInner")
	public String saveInner(@RequestParam String playerNames, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		List<String> roleNameList  = Arrays.asList(StringUtils.split(playerNames,"\n\r"));
		List<String> userRoleIdList = gameDaoTemplate.selectList("userRole.selectIdsByNames", roleNameList);
		try {
			VipQQRemoteService vipQQRemoteService = WebServiceFactory.getWSSimple(paramMap.get("currentServerId").toString(), VipQQRemoteService.class);
			for (String userRoleId : userRoleIdList) {
				vipQQRemoteService.vipQqOK(userRoleId, "内部人员", sessionUser.getUserName());
			}
		} catch (Exception e) {
			log.error(null, e);
			modelMap.put("result", 0);
		}
		return INDEX_PATH;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("update")
	public String update(@RequestParam String qq, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", gameDaoTemplate.update("roleQqList.update", paramMap));
		return INDEX_PATH;
	}
	
	/**
	 * 校验角色名
	 */
	@ResponseBody
	@RequestMapping("checkUserRoleName")
	public Object checkLoginName(String fieldId, String fieldValue) {
		String id = gameDaoTemplate.selectOne("userRole.existName", fieldValue);
		boolean bool = (id != null ? true : false);
		return new Object[]{fieldId, bool};
	}
	
	/**
	 * 校验多个角色名
	 */
	@ResponseBody
	@RequestMapping("checkUserRoleNames")
	public Object checkLoginNames(String fieldId, String fieldValue) {
		List<String> roleNameList  = Arrays.asList(StringUtils.split(fieldValue,"\n\r"));
		List<String> selectRoleNameList = gameDaoTemplate.selectList("userRole.selectIdsByNames", roleNameList);
		boolean bool = (roleNameList.size() == selectRoleNameList.size() ? true : false);
		return new Object[]{fieldId, bool};
	}
}