package com.lingyu.dntg.service.sm;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.vo.ActionInfo;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 左边菜单管理
 * @author donghui
 */
@Component
public class ActionInfoService extends AbstractService {

	/**
	 * 根据权限得到菜单列表
	 * @param userInfo 用户
	 */
	public List<ActionInfo> getMenuActionInfo(SessionUser user){
		//处理后返回的list
		List<ActionInfo> resultList = new ArrayList<ActionInfo>();
		
		//查询结果list
		List<ActionInfo> actionList = null;
		if(ConfigConstants.UserLevel.ADMIN_LEVEL.value == user.getUserLevel() ){
			actionList = toolDaoTemplate.selectList("actionInfo.adminGetUserAction", user.getUserLevel());
		}
		else{
			actionList = toolDaoTemplate.selectList("actionInfo.indexGetUserAction", user.getId());
		}
		
		//处理，子分类放在父分类的list里
		ActionInfo lastDirAction = null;
		for (ActionInfo actionInfo : actionList){
			if (actionInfo.getIsDir() == 1){
				resultList.add(actionInfo);
				lastDirAction = actionInfo;
			}else{
				List<ActionInfo> childActions = lastDirAction.getActionInfoList();
				if(childActions == null){
					childActions = new ArrayList<ActionInfo>();
					lastDirAction.setActionInfoList(childActions);
				}
				childActions.add(actionInfo);
			}
		}
		return resultList;
	}
	
	/**
	 * 从属性文件action-info.properties得到所有菜单节点记录
	 */
	public List<ActionInfo> getAllbyPropertiesFile(){
		ArrayList<ActionInfo> actionInfoList = new ArrayList();
		ResourceBundle actionInfoBundle = ResourceBundle.getBundle("properties/action-info");
		for(String key : actionInfoBundle.keySet()){
			int id = NumberUtils.toInt(key);
			String[] values = actionInfoBundle.getString(key).split("\t");;
			ActionInfo actionInfo = new ActionInfo(id, values);
			actionInfoList.add(actionInfo);
		}
		return actionInfoList;
	}
	
	/**
	 * 初始化所有记录
	 */
	public void initAll(List<ActionInfo> actionInfoList){
		toolDaoTemplate.delete("actionInfo.deleteAll");
		toolDaoTemplate.batchInsert("actionInfo.insert", actionInfoList);
	}
	
}