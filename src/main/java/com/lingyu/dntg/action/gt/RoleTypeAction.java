package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.goods.SendEquip;
import com.xianling.remoteservice.role.RoleType;

/**
 * GM与指导员账号设置
 * @author Lian zhibin
 */
@Controller
@RequestMapping("roleType")
public class RoleTypeAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("roleType.index", paramMap));
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
		String serverId = MapUtils.getString(paramMap, "serverId");
		String userId = MapUtils.getString(paramMap, "userId");
		int roleType = MapUtils.getIntValue(paramMap, "roleType");
		String result = null;
		try {
			RoleType roleTypeWebService =  WebServiceFactory.getWSSimple(serverId, RoleType.class);
			result = roleTypeWebService.updateRoleType(userId, serverId, roleType);
			if ("000".equals(result)) {
				modelMap.put("result", "帐号不存在");
			}
			else if ("001".equals(result)) {
				modelMap.put("result", "账号为空");
			}
			else if ("111".equals(result)) {
				//发送物品给玩家
				SendEquip sendEquipWebService = WebServiceFactory.getWSSimple(serverId, SendEquip.class);
				sendEquipWebService.sendEquip(new String[]{userId}, "feixie:999:1;xiaolaba:999:1", "", "");
				modelMap.put("result", toolDaoTemplate.insert("roleType.insert", paramMap));
			}
		} catch (Exception e) {
			modelMap.put("result", "游戏服务器连接出错");
		}
		return INDEX_PATH;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("roleType.byId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		int id = MapUtils.getIntValue(paramMap, "id");
		String serverId = MapUtils.getString(paramMap, "serverId");
		String userId = MapUtils.getString(paramMap, "userId");
		int roleType = MapUtils.getIntValue(paramMap, "roleType");
		String result = null;
		try {
			RoleType roleTypeWebService =  WebServiceFactory.getWSSimple(serverId, RoleType.class);
			result = roleTypeWebService.updateRoleType(userId, serverId, roleType);
			if ("000".equals(result)) {
				modelMap.put("result", "帐号不存在");
			}
			else if ("001".equals(result)) {
				modelMap.put("result", "账号为空");
			}
			else if ("111".equals(result)) {
				if (roleType == 0) {
					modelMap.put("result", toolDaoTemplate.delete("roleType.deleteById", id));
				}
				else{
					modelMap.put("result", toolDaoTemplate.update("roleType.update", paramMap));
				}
			}
		} catch (Exception e) {
			modelMap.put("result", "游戏服务器连接出错");
		}
		return INDEX_PATH;
	}
	
	/**
	 * 校验角色名
	 */
	@ResponseBody
	@RequestMapping("checkUserName")
	public Object checkUserName(String fieldId, String fieldValue, String serverId) {
		List<String> list = gameDaoTemplate.selectListByServerId(serverId, "userRole.existName", fieldValue);
		boolean bool = (CollectionUtils.isNotEmpty(list) ? true : false);
		return new Object[]{fieldId, bool};
	}
	
}