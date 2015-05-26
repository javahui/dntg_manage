package com.lingyu.dntg.bean.pojo;

import com.lingyu.dntg.bean.AbstractBean;

public class UserInfo extends AbstractBean{
	private static final long serialVersionUID = -1697747287778427259L;
	
	private Integer id;
	private String loginName;
	private String userName;
	transient private String password;
	private Integer userLevel;
	
	public UserInfo(){}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getLoginName() {return loginName;}
	public void setLoginName(String loginName) {this.loginName = loginName;}
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public Integer getUserLevel() {return userLevel;}
	public void setUserLevel(Integer userLevel) {this.userLevel = userLevel;}
}
