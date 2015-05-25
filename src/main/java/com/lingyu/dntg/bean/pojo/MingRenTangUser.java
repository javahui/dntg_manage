package com.lingyu.dntg.bean.pojo;

import java.util.Date;

import com.lingyu.dntg.bean.AbstractBean;

/**
 * 明人堂的统计结果
 * @author donghui
 */
public class MingRenTangUser extends AbstractBean implements Comparable<MingRenTangUser>{
	private static final long serialVersionUID = -2579952417957573750L;
	
	private String userRoleId;
	private String userRoleName;
	private String platformName;
	private String serverId;
	private Date lastTime;
	private Integer num;
	private String data;
	private Integer index;
	
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
	/**
	 * 利用比较器实现充值金额从大到小
	 */
	@Override
	public int compareTo(MingRenTangUser o) {
		return o.getNum().compareTo(this.getNum());
	}
	
}
