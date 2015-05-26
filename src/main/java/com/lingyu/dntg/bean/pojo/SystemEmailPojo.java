package com.lingyu.dntg.bean.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.lingyu.dntg.bean.AbstractBean;
import com.lingyu.dntg.bean.vo.AttachmentGoods;
import com.lingyu.dntg.bean.vo.SystemEmailVO;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.util.ConfigConstants;

public class SystemEmailPojo extends AbstractBean{
	private static final long serialVersionUID = -1205295506401153535L;
	
	private int id;
	private int globalSend;//是否全服方式
	private String serverId = "";
	private String receiverNames;//指定用户发送方式时的用户列表
	private String title;
	private String content;
	private int jb;//附加金币数量
	private int yb;//附加金币数量
	private int delayHours; 
	private String attachments;//附件物品组成的字符串(物品id;物品数量;是否绑定:物品id;物品数量;是否绑定...)
	private Date createTime = new Date();
	private String userName = LookupContext.getSessionUserInfo().getLoginName();
	private int createBy = LookupContext.getSessionUserInfo().getId();
	private int state = ConfigConstants.SystemEmailState.UNAUDIT.value;
	
	public SystemEmailPojo(){	}
	
	public SystemEmailPojo(SystemEmailVO systemEmailVO){
		try {PropertyUtils.copyProperties(this, systemEmailVO);}
		catch (Exception e) {e.printStackTrace();}
		List<AttachmentGoods> attachmentGoodsList = systemEmailVO.getGoodsList();
		for (AttachmentGoods goods : attachmentGoodsList) {
			if (StringUtils.isBlank(goods.getId())) {
				attachmentGoodsList.remove(goods);
			}
		}
		attachments = StringUtils.join(attachmentGoodsList.toArray(), ":");
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
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
	
	public String getAttachments() {return attachments;}
	public void setAttachments(String attachments) {this.attachments = attachments;}
	
	public Date getCreateTime() {return createTime;}
	public void setCreateTime(Date createTime) {this.createTime = createTime;}

	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	
	public int getCreateBy() {return createBy;}
	public void setCreateBy(int createBy) {this.createBy = createBy;}
	
	public int getState() {return state;}
	public void setState(int state) {this.state = state;}
	
	public List<String> getReceiverNameList(){
		String[] array = StringUtils.split(this.receiverNames, ",");
		return Arrays.asList(array);
	}
	
	/**
	 * 得到附件物品的json
	 */
	public String getAttachmentsJson(){
		if (StringUtils.isBlank(attachments)) {
			return null;
		}
		List resultList = new ArrayList();
		String[] goodsArray = StringUtils.contains(attachments, ":") ? StringUtils.split(attachments, ":") : StringUtils.split(attachments, ",");
		for (String goodsString : goodsArray) {
			Map map = new HashMap();
			String[] array = StringUtils.split(goodsString, ";");
			if (ArrayUtils.isEmpty(array)) { continue; }
			if (array.length == 2) {
				map.put("goodsId", array[0]);
				map.put("goodsCount", array[1]);
			}
			else if (array.length == 3) {
				map.put("goodsId", array[0]);
				map.put("goodsCount", array[1]);
				map.put("bindOrNot", array[2]);
			}
			else{
				continue;
			}
			resultList.add(map);
		}
		return JSON.toJSONString(resultList);
	}
}
