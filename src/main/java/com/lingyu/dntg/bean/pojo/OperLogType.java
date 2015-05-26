package com.lingyu.dntg.bean.pojo;

import com.lingyu.dntg.bean.AbstractBean;

public class OperLogType extends AbstractBean{
	private static final long serialVersionUID = -7939490487989033126L;
	
	private Integer id;
	private String className;
	private String methodName;
	private String type;
	private String description;
	
	public OperLogType(){}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getClassName() {return className;}
	public void setClassName(String className) {this.className = className;}

	public String getMethodName() {return methodName;}
	public void setMethodName(String methodName) {this.methodName = methodName;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	
}
