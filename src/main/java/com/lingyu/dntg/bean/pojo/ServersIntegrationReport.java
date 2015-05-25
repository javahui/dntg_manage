package com.lingyu.dntg.bean.pojo;

import java.util.Date;

import com.lingyu.dntg.bean.AbstractBean;

public class ServersIntegrationReport extends AbstractBean{
	private static final long serialVersionUID = -7023784965750783049L;
	
	private Integer id;
	private String date;
	private Date logTime  = new Date();;
	private String serverId;
	private Integer distCount;
	private Integer allRmb;
	private Integer cnt;
	private Integer createCount;
	private Float accu;
	private Integer pccu;
	private Long ybIncr;
	private Long ybConsume;
	private Integer dCount;
	private Integer lsDcount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public Integer getDistCount() {
		return distCount;
	}
	public void setDistCount(Integer distCount) {
		this.distCount = distCount;
	}
	public Integer getAllRmb() {
		return allRmb;
	}
	public void setAllRmb(Integer allRmb) {
		this.allRmb = allRmb;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public Integer getCreateCount() {
		return createCount;
	}
	public void setCreateCount(Integer createCount) {
		this.createCount = createCount;
	}
	public Float getAccu() {
		return accu;
	}
	public void setAccu(Float accu) {
		this.accu = accu;
	}
	public Integer getPccu() {
		return pccu;
	}
	public void setPccu(Integer pccu) {
		this.pccu = pccu;
	}
	public Long getYbIncr() {
		return ybIncr;
	}
	public void setYbIncr(Long ybIncr) {
		this.ybIncr = ybIncr;
	}
	public Long getYbConsume() {
		return ybConsume;
	}
	public void setYbConsume(Long ybConsume) {
		this.ybConsume = ybConsume;
	}
	public Integer getdCount() {
		return dCount;
	}
	public void setdCount(Integer dCount) {
		this.dCount = dCount;
	}
	public Integer getLsDcount() {
		return lsDcount;
	}
	public void setLsDcount(Integer lsDcount) {
		this.lsDcount = lsDcount;
	}
}

