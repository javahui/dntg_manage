package com.lingyu.dntg.bean.pojo;

import java.util.Date;

import com.lingyu.dntg.bean.AbstractBean;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;

public class OperationLog extends AbstractBean{
	private static final long serialVersionUID = -4511314619461601638L;
	
	private Integer userId;
	private String operation;
	private String description;
	private Date operTime = new Date();
	
	public OperationLog(){}
	
	public OperationLog(String operation, String description){
		UserInfo userInfo = LookupContext.getSessionUserInfo();
		this.userId = userInfo.getId();
		this.operation = operation;
		this.description = description;
	}
	
	public Integer getUserId() {return userId;}
	public void setUserId(Integer userId) {this.userId = userId;}
	
	public String getOperation() {return operation;}
	public void setOperation(String operation) {this.operation = operation;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
	public Date getOperTime() {return operTime;}
	public void setOperTime(Date operTime) {this.operTime = operTime;}
	
}