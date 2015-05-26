package com.lingyu.dntg.bean.vo.analyze;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.lingyu.dntg.bean.AbstractBean;

public class TaskMainConfig extends AbstractBean{
	private static final long serialVersionUID = 3444241496314167057L;
	
	private String id;
	private String chapterSubId;//大章节ID
	private int sequence;//任务序号
	private String payType;
	private String taskName;
	private String describe;
	private Object[] trace;
	private String completeNpcId;
	private String nextTaskId;
	private String duologue;//任务接取时发送的主界面对白
	private int recevieLevel;//角色接任务等级
	private int rewardItemBind;//奖励物品绑定
	private int isXinShou;//新手任务标识
	private Map<String,Integer> rewardItems;//奖励物品
	
	//奖励数值部分
	private Integer exp = 0;
	private Integer jb = 0; //任务奖励铜钱
	private Integer zhiqi = 0; //任务奖励真气
	private Integer prestige = 0;//任务奖励声望
	private Integer boundOb = 0;//任务奖励绑定元宝
	
	//任务奖励达成某成就序列
	private String rewardsSuccess;
	private String lastTaskId;
	private List<String> shenjiangnew = new ArrayList();
	
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getChapterSubId() {return chapterSubId;}
	public void setChapterSubId(String chapterSubId) {this.chapterSubId = chapterSubId;}
	
	public int getSequence() {return sequence;}
	public void setSequence(int sequence) {this.sequence = sequence;}
	
	public String getLastTaskId() {
		return lastTaskId;
	}

	public void setLastTaskId(String lastTaskId) {
		this.lastTaskId = lastTaskId;
	}

	public int getRewardItemBind() {
		return rewardItemBind;
	}

	public void setRewardItemBind(int rewardItemBind) {
		this.rewardItemBind = rewardItemBind;
	}

	public int getIsXinShou() {
		return isXinShou;
	}

	public void setIsXinShou(int isXinShou) {
		this.isXinShou = isXinShou;
	}

	public void setExp(Integer exp){
		this.exp = exp;
	}
	public void setExp(String exp){
		this.exp = NumberUtils.toInt(exp);
	}
	
	public Integer getExp(){
		return exp;
	}
	
	public void setJb(Integer jb){
		this.jb = jb;
	}
	public void setJb(String jb){
		this.jb = NumberUtils.toInt(jb);
	}
	
	public Integer getJb(){
		return jb;
	}
	
	public Integer getZhiqi() {
		return zhiqi;
	}

	public void setZhiqi(Integer zhiqi) {
		this.zhiqi = zhiqi;
	}
	public void setZhiqi(String zhiqi) {
		this.zhiqi = NumberUtils.toInt(zhiqi);
	}
	public Integer getPrestige() {
		return prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}
	public void setPrestige(String prestige) {
		this.prestige = NumberUtils.toInt(prestige);
	}

	public Integer getBoundOb() {
		return boundOb;
	}
	public void setBoundOb(Integer boundOb) {
		this.boundOb = boundOb;
	}
	public void setBoundOb(String boundOb) {
		this.boundOb = NumberUtils.toInt(boundOb);
	}

	public String getRewardsSuccess() {
		return rewardsSuccess;
	}

	public void setRewardsSuccess(String rewardsSuccess) {
		this.rewardsSuccess = rewardsSuccess;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getTaskName() {
		return taskName;
	}
	
	public int getRecevieLevel() {
		return recevieLevel;
	}

	public void setRecevieLevel(int recevieLevel) {
		this.recevieLevel = recevieLevel;
	}
	public void setRecevieLevel(String recevieLevel) {
		this.recevieLevel = NumberUtils.toInt(recevieLevel);
	}

 	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Object[] getTrace() {return trace;}
	public void setTrace(Object[] trace) {this.trace = trace;}

	public String getCompleteNpcId() {return completeNpcId;}
	public void setCompleteNpcId(String completeNpcId) {this.completeNpcId = completeNpcId;}

	public String getNextTaskId() {return nextTaskId;}
	public void setNextTaskId(String nextTaskId) {this.nextTaskId = nextTaskId;}

	public String getDuologue() {return duologue;}
	public void setDuologue(String duologue) {this.duologue = duologue;}

	public  Map<String, Integer> getRewardItems() {return rewardItems;}
	public void setRewardItems(Map<String, Integer> rewardItems) {this.rewardItems = rewardItems;}
	
	public List<String> getShenjiangnew() {return shenjiangnew;}
	public void setShenjiangnew(List<String> shenjiangnew) {this.shenjiangnew = shenjiangnew;}
	public void addShenjiang(String shenjiangId) {
		shenjiangnew.add(shenjiangId);
	}
	
}
