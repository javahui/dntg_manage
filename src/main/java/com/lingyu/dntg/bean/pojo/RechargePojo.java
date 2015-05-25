package com.lingyu.dntg.bean.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.lingyu.dntg.bean.AbstractBean;
import com.lingyu.dntg.bean.vo.PlayerVo;
import com.lingyu.dntg.bean.vo.RechargeVo;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.util.ConfigConstants;

public class RechargePojo extends AbstractBean{
	private static final long serialVersionUID = 1843048500166034562L;

	private int id;
	private String playerAccount = "";
	private String playerId = "";
	private String playerName = "";
	private int moneyType;
	private int moneyNum;
	private int isCalc = ConfigConstants.Calc.NO.value;
	private String serverId = LookupContext.getCurrentServerId();
	private int rechargeType;
	private Date createTime = new Date();
	private String loginName = LookupContext.getSessionUserInfo().getLoginName();
	private String userName = LookupContext.getSessionUserInfo().getUserName();
	private int createBy = LookupContext.getSessionUserInfo().getId();
	private String failReason;
	private String content;
	private String auditor;//user loginName
	private int isAudit;

	public RechargePojo(){}
	
	public RechargePojo(RechargeVo vo, List<PlayerVo> playerList, int isAudit){
		this.isAudit = isAudit;
		this.moneyNum = vo.getMoneyNum();
		this.content = vo.getContent();
		this.moneyType = vo.getMoneyType();
		this.rechargeType = vo.getRechargeType();
		for (PlayerVo playerVo : playerList) {
			this.playerAccount = this.playerAccount + playerVo.getPlayerAccount() + " ";
			this.playerName = this.playerName + playerVo.getPlayerName() + " ";
			this.playerId = this.playerId + playerVo.getPlayerId() + " ";
		}
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getPlayerAccount() {return playerAccount;}
	public void setPlayerAccount(String playerAccount) {this.playerAccount = playerAccount;}
	
	public String getPlayerId() {return playerId;}
	public void setPlayerId(String playerId) {this.playerId = playerId;}
	
	public String getPlayerName() {return playerName;}
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	
	public int getMoneyType() {return moneyType;}
	public void setMoneyType(int moneyType) {this.moneyType = moneyType;}
	
	public int getMoneyNum() {return moneyNum;}
	public void setMoneyNum(int moneyNum) {this.moneyNum = moneyNum;}
	
	public int getIsCalc() {return isCalc;}
	public void setIsCalc(int isCalc) {this.isCalc = isCalc;}
	
	public String getServerId() {return serverId;}
	public void setServerId(String serverId) {this.serverId = serverId;}
	
	public int getRechargeType() {return rechargeType;}
	public void setRechargeType(int rechargeType) {this.rechargeType = rechargeType;}
	
	public Date getCreateTime() {return createTime;}
	public void setCreateTime(Date createTime) {this.createTime = createTime;}
	
	public String getLoginName() {return loginName;}
	public void setLoginName(String loginName) {this.loginName = loginName;}
	
	public String getUserName() {return userName;}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCreateBy() {return createBy;}
	public void setCreateBy(int createBy) {this.createBy = createBy;}
	
	public String getFailReason() {return failReason;}
	public void setFailReason(String failReason) {this.failReason = failReason;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public String getAuditor() {return auditor;}
	public void setAuditor(String auditor) {this.auditor = auditor;}
	
	public int getIsAudit() {return isAudit;}
	public void setIsAudit(int isAudit) {this.isAudit = isAudit;}
	
	public Set<PlayerVo> getPlayers(){
		String[] playerIdArray = StringUtils.split(this.playerId);
		String[] playerNameArray = StringUtils.split(this.playerName);
		String[] playerAccountArray = StringUtils.split(this.playerAccount);
		HashSet<PlayerVo> set = new HashSet();
		for (int i = 0; i < playerAccountArray.length; i++) {
			PlayerVo play = new PlayerVo();
			play.setPlayerAccount(playerAccountArray[i].trim());
			play.setPlayerId(playerIdArray[i].trim());
			play.setPlayerName(playerNameArray[i].trim());
			set.add(play);
		}
		return set;
	}
}
