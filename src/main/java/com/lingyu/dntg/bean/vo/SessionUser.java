package com.lingyu.dntg.bean.vo;

import java.util.ArrayList;
import java.util.List;

import com.lingyu.dntg.bean.pojo.UserInfo;

public class SessionUser extends UserInfo{
	private static final long serialVersionUID = 249852146289476909L;

	private boolean allServer;
	private List<String> ownerServerIdList = new ArrayList();//拥有权限的服务器
	private List<Integer> roleUserIdList = new ArrayList();//有相同角色权限的所有userId
	
	public boolean getAllServer() {return allServer;}
	public void setAllServer(boolean allServer) {this.allServer = allServer;}
	
	public List<String> getOwnerServerIdList() {return ownerServerIdList;}
	public void setOwnerServerIdList(List<String> ownerServerIdList) {this.ownerServerIdList = ownerServerIdList;}
	
	public List<Integer> getRoleUserIdList() {return roleUserIdList;}
	public void setRoleUserIdList(List<Integer> roleUserIdList) {this.roleUserIdList = roleUserIdList;}
}
