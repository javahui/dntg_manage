package com.lingyu.dntg.bean.vo;

import com.lingyu.dntg.bean.AbstractBean;

public class PlayerVo extends AbstractBean{
	private static final long serialVersionUID = -1235216909074553928L;

	private String playerId;
	private String playerAccount;
	private String playerName;

	public PlayerVo(){}
	
	public String getPlayerId() {return playerId;}
	public void setPlayerId(String playerId) {this.playerId = playerId;}

	public String getPlayerAccount() {return playerAccount;}
	public void setPlayerAccount(String playerAccount) {this.playerAccount = playerAccount;}

	public String getPlayerName() {return playerName;}
	public void setPlayerName(String playerName) {this.playerName = playerName;}

	
}
