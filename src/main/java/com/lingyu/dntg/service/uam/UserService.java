package com.lingyu.dntg.service.uam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.lingyu.dntg.bean.pojo.UserInfo;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 用户管理
 * @author donghui
 */
@Component
public class UserService extends AbstractService {
	
	/**
	 * 初始化admin
	 */
	public boolean initAdmin(){
		int count = (Integer)toolDaoTemplate.selectOne("userInfo.indexCount");
		if (count == 0){
			log.info("初始化admin...");
			UserInfo user = new UserInfo();
			user.setLoginName("admin");
			user.setUserName("admin");
			user.setPassword(DigestUtils.md5Hex("admin").substring(8, 24));
			user.setUserLevel(ConfigConstants.UserLevel.ADMIN_LEVEL.value);
			toolDaoTemplate.insert("userInfo.insert", user);
			log.info("初始化admin:{}", user);
			return true;
		}
		return false;
	}
	
	/**
	 * 保存
	 */
	public int insert_AopLog(Map paramMap){
		paramMap.put("userLevel", ConfigConstants.UserLevel.NORMAL_LEVEL.value);
		return toolDaoTemplate.insert("userInfo.insert", paramMap);
	}
	
	/**
	 * 重置密码
	 */
	public int updatePwd_AopLog(Map paramMap){
		return toolDaoTemplate.update("userInfo.updatePwd", paramMap);
	}
	
	/**
	 *  修改
	 */
	public int update_AopLog(Map paramMap){
		String password = MapUtils.getString(paramMap, "password");
		paramMap.put("password", DigestUtils.md5Hex(password).substring(8, 24));
		return toolDaoTemplate.update("userInfo.update", paramMap);
	}
	
	/**
	 * 批量删除
	 */
	public int delete_AopLog(List<Integer> recordIds){
		toolDaoTemplate.delete("userRole.batchDeleteByUserId", recordIds);
		return toolDaoTemplate.delete("userInfo.delete", recordIds);
	}
	
	/**
	 * 修改用户的角色权限
	 */
	public int updateRole_AopLog(int userId, List<Integer> roleIds){
		try{
			toolDaoTemplate.delete("userRole.deleteByUserId", userId);
			if (CollectionUtils.isEmpty(roleIds)) {
				return 1;
			}
			List<Map> paramsList = new ArrayList();
			for (int roleId : roleIds) {
				Map map = new HashMap();
				map.put("userId", userId);
				map.put("roleId", roleId);
				paramsList.add(map);
			}
			toolDaoTemplate.batchInsert("userRole.insert", paramsList);
		}
		catch(Exception e){
			log.error(null, e);
			return 0;
		}
		return 1;
	}
}