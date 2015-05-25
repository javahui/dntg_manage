package com.lingyu.dntg.bean.pojo;

import java.util.Date;

import com.lingyu.dntg.bean.AbstractBean;

/**
 * 明人堂的配置文件
 * @author donghui
 */
public class MingRenTangConfig extends AbstractBean{
	private static final long serialVersionUID = -4383515586063315509L;

	private String id;
	private String version;
	private String type;
	private Integer yaoqiu;
	private Date startTime;
	private Date finishTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getYaoqiu() {
		return yaoqiu;
	}
	public void setYaoqiu(Integer yaoqiu) {
		this.yaoqiu = yaoqiu;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
}
