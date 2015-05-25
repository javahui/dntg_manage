package com.lingyu.dntg.bean.vo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.lingyu.dntg.bean.AbstractBean;

public class SystemEmailVO extends AbstractBean{
	private static final long serialVersionUID = -5441435703988322356L;
	
	private int globalSend;//是否全服方式
	private String serverId;
	private String receiverNames;//指定用户发送方式时的用户列表
	private String title;
	private String content;
	private int jb;//附加金币数量
	private int yb;//附加金币数量
	private int delayHours;//延迟小时数
	private List<AttachmentGoods> goodsList = new CopyOnWriteArrayList<AttachmentGoods>();//附加物品列表


	public int getGlobalSend() {return globalSend;}
	public void setGlobalSend(int globalSend) {this.globalSend = globalSend;}
	
	public String getServerId() {return serverId;}
	public void setServerId(String serverId) {this.serverId = serverId;}
	
	public String getReceiverNames() {	return receiverNames;}
	public void setReceiverNames(String receiverNames) {this.receiverNames = receiverNames;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public int getJb() {return jb;}
	public void setJb(int jb) {this.jb = jb;}
	
	public int getYb() {return yb;}
	public void setYb(int yb) {this.yb = yb;}

	public int getDelayHours() {return delayHours;}
	public void setDelayHours(int delayHours) {this.delayHours = delayHours;}
	
	public List<AttachmentGoods> getGoodsList() {return goodsList;}
	public void setGoodsList(List<AttachmentGoods> goodsList) {this.goodsList = goodsList;}
	
}
