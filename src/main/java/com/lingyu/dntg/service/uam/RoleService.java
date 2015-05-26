package com.lingyu.dntg.service.uam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.lingyu.dntg.service.AbstractService;

/**
 * 角色管理
 * @author donghui
 */
@Component
public class RoleService extends AbstractService {
	
	/**
	 * 修改角色的菜单权限
	 */
	public int updateRoleActionInfo(int roleId, List<Integer> actionIds){
		try{
			toolDaoTemplate.delete("actionRole.deleteByRoleId", roleId);
			if (CollectionUtils.isEmpty(actionIds)) {
				return 1;
			}
			this.getParentNodeId(actionIds);
			Map map = new HashMap();
			map.put("roleId", roleId);
			map.put("actionIds", actionIds);
			toolDaoTemplate.insert("actionRole.insert", map);
		}
		catch(Exception e){
			log.error(null, e);
			return 0;
		}
		return 1;
	}
	
	/**
	 * 修改角色服务器权限
	 */
	public int updateRoleServer(int roleId, List<Integer> serverIds){
		try{
			toolDaoTemplate.delete("roleServer.deleteByRoleId", roleId);
			if (CollectionUtils.isEmpty(serverIds)) {
				return 1;
			}
			Map paramMap = new HashMap();
			paramMap.put("roleId", roleId);
			paramMap.put("serverIds", serverIds);
			toolDaoTemplate.insert("roleServer.insert", paramMap);
		}
		catch(Exception e){
			log.error(null, e);
			return 0;
		}
		return 1;
	}
	
	/**
	 * 添加子节点的父菜单
	 * @param actionIds
	 */
	private void getParentNodeId(List<Integer> actionIds){
		Set<Integer> set = new HashSet();
		for (int i : actionIds) {
			if (i%1000 ==0) {
				continue;
			}
			set.add(Integer.valueOf(i/1000+"000"));
		}
		actionIds.addAll(set);
	}
}