package com.lingyu.dntg.bean.pojo;

import java.util.Date;

import com.lingyu.dntg.bean.AbstractBean;

public class ServerRealTimeTotalData extends AbstractBean {
	private static final long serialVersionUID = -3036683828282177588L;

	private String serverId;
	private Integer todayCreate;
	private Integer todayLogin;
	private Integer onlineCount;
	private Integer chargeCountIncr;
	private Integer chargeCount;
	private Integer chargeTotal;
	private Float payOdds;
	private Integer arpu;
	private Integer accu;
	private Integer pccu;
	private Integer incrYb;
	private Integer decrYb;
	private Integer dt;
	private String logDay;
	private String logHour;
	private String logMinute;
	private Date logTime;
	private Date logUpdateTime;

	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public Integer getTodayCreate() {
		return todayCreate;
	}
	public void setTodayCreate(Integer todayCreate) {
		this.todayCreate = todayCreate;
	}
	public Integer getTodayLogin() {
		return todayLogin;
	}
	public void setTodayLogin(Integer todayLogin) {
		this.todayLogin = todayLogin;
	}
	public Integer getOnlineCount() {
		return onlineCount;
	}
	public void setOnlineCount(Integer onlineCount) {
		this.onlineCount = onlineCount;
	}
	public Integer getChargeCountIncr() {
		return chargeCountIncr;
	}
	public void setChargeCountIncr(Integer chargeCountIncr) {
		this.chargeCountIncr = chargeCountIncr;
	}
	public Integer getChargeCount() {
		return chargeCount;
	}
	public void setChargeCount(Integer chargeCount) {
		this.chargeCount = chargeCount;
	}
	public Integer getChargeTotal() {
		return chargeTotal;
	}
	public void setChargeTotal(Integer chargeTotal) {
		this.chargeTotal = chargeTotal;
	}
	public Float getPayOdds() {
		return payOdds;
	}
	public void setPayOdds(Float payOdds) {
		this.payOdds = payOdds;
	}
	public Integer getArpu() {
		return arpu;
	}
	public void setArpu(Integer arpu) {
		this.arpu = arpu;
	}
	public Integer getAccu() {
		return accu;
	}
	public void setAccu(Integer accu) {
		this.accu = accu;
	}
	public Integer getPccu() {
		return pccu;
	}
	public void setPccu(Integer pccu) {
		this.pccu = pccu;
	}
	public Integer getIncrYb() {
		return incrYb;
	}
	public void setIncrYb(Integer incrYb) {
		this.incrYb = incrYb;
	}
	public Integer getDecrYb() {
		return decrYb;
	}
	public void setDecrYb(Integer decrYb) {
		this.decrYb = decrYb;
	}
	public Integer getDt() {
		return dt;
	}
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	public String getLogDay() {
		return logDay;
	}
	public void setLogDay(String logDay) {
		this.logDay = logDay;
	}
	public String getLogHour() {
		return logHour;
	}
	public void setLogHour(String logHour) {
		this.logHour = logHour;
	}
	public String getLogMinute() {
		return logMinute;
	}
	public void setLogMinute(String logMinute) {
		this.logMinute = logMinute;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public Date getLogUpdateTime() {
		return logUpdateTime;
	}
	public void setLogUpdateTime(Date logUpdateTime) {
		this.logUpdateTime = logUpdateTime;
	}
}
