package com.lingyu.dntg.bean.vo;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.lingyu.dntg.bean.AbstractBean;
import com.lingyu.dntg.dao.base.exception.ActionInfoFormatException;

public class ActionInfo extends AbstractBean{
	private static final long serialVersionUID = -3007942776289871088L;
	
	private Integer id;
	private String actionName;
	private String action;
	private String actionDesc;
	private String typeValue;
	private Integer isDir;
	private Integer orderValue;
	private Integer actionLevel;
	private List<ActionInfo> actionInfoList;
	
	public ActionInfo(){}
	
	public ActionInfo(int id, String[] values){
		this.id = id;
		if (ArrayUtils.isEmpty(values) || values.length < 6) {
			log.error("values:" + StringUtils.join(values,","), new ActionInfoFormatException());
			return;
		}
		this.actionName = values[0];
		this.action = values[1];
		this.actionDesc =  values[2];
		this.typeValue = values[3];
		this.isDir = NumberUtils.toInt(values[4]);
		this.orderValue = NumberUtils.toInt(values[5]);
		if (values.length == 7) {
			this.actionLevel = NumberUtils.toInt(values[6]);
		}
	}
	
	public ActionInfo(String actionName, String actionDesc) {
		this.actionName = actionName;
		this.actionDesc = actionDesc;
	}

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getActionName() {return actionName;}
	public void setActionName(String actionName) {this.actionName = actionName;}
	
	public String getAction() {return action;}
	public void setAction(String action) {this.action = action;}
	
	public String getActionDesc() {return actionDesc;}
	public void setActionDesc(String actionDesc) {this.actionDesc = actionDesc;}
	
	public String getTypeValue() {return typeValue;}
	public void setTypeValue(String typeValue) {this.typeValue = typeValue;}
	
	public Integer getIsDir() {return isDir;}
	public void setIsDir(Integer isDir) {this.isDir = isDir;}
	
	public Integer getOrderValue() {return orderValue;}
	public void setOrderValue(Integer orderValue) {this.orderValue = orderValue;}
	
	public Integer getActionLevel() {return actionLevel;}
	public void setActionLevel(Integer actionLevel) {this.actionLevel = actionLevel;}
	
	public List<ActionInfo> getActionInfoList() {return actionInfoList;}
	public void setActionInfoList(List<ActionInfo> actionInfoList) {this.actionInfoList = actionInfoList;}
	
	public String getParentValue(){
		if( typeValue != null && typeValue.length() > 3 ){
			return typeValue.substring(0, typeValue.length()-3);
		}
		return null;
	}

}
