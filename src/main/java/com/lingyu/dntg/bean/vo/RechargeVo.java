package com.lingyu.dntg.bean.vo;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.lingyu.dntg.bean.AbstractBean;

public class RechargeVo extends AbstractBean{
	private static final long serialVersionUID = 1843048500166034562L;

	private int rechargeType;
	private String playerName;
	private int moneyType;
	private int moneyNum;
	private String content;

	public RechargeVo(){}
	
	public int getRechargeType() {return rechargeType;}
	public void setRechargeType(int rechargeType) {this.rechargeType = rechargeType;}
	
	public String getPlayerName() {return playerName;}
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	
	public int getMoneyType() {return moneyType;}
	public void setMoneyType(int moneyType) {this.moneyType = moneyType;}
	
	public int getMoneyNum() {return moneyNum;}
	public void setMoneyNum(int moneyNum) {this.moneyNum = moneyNum;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public List<String> getPlayerNameList(){
		return Arrays.asList(StringUtils.split(playerName,"\n\r"));
	}
}
