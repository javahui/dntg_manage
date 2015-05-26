package com.lingyu.dntg.bean.pojo;

import java.util.HashMap;
import java.util.Map;

import com.lingyu.dntg.bean.AbstractBean;
import com.lingyu.dntg.util.ConfigConstants;

public class Notice extends AbstractBean{
	private static final long serialVersionUID = -4827974261930536934L;

	private int id;
	private String content;
	private int global;
	private int repeatCount;
	private int finishedCount;
	private int noticeType;
	private int noticeStatus;
	

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}

	public int getGlobal() {return global;}
	public void setGlobal(int global) {this.global = global;}

	public int getRepeatCount() {return repeatCount;}
	public void setRepeatCount(int repeatCount) {this.repeatCount = repeatCount;}

	public int getFinishedCount() {return finishedCount;}
	public void setFinishedCount(int finishedCount) {this.finishedCount = finishedCount;}

	public int getNoticeType() {return noticeType;}
	public void setNoticeType(int noticeType) {this.noticeType = noticeType;}

	public int getNoticeStatus() {return noticeStatus;}
	public void setNoticeStatus(int noticeStatus) {this.noticeStatus = noticeStatus;}
	

	/**
	 * 根据notice数据得到一个用以修改noticeStatus和repeatCount的map参数
	 */
	public Map getUpdateNoticeStatusMap(){
		Map map = new HashMap();
		map.put("id", this.id);
		this.repeatCount ++ ;
		map.put("repeatCount", this.repeatCount);
		if (finishedCount <= repeatCount) {//发布次数完成,状态修改为已正常结束
			map.put("noticeStatus", ConfigConstants.NoticeStatus.FINISHED.value);
		}
		else{//状态修改为进行中
			map.put("noticeStatus", ConfigConstants.NoticeStatus.GOING.value);
		}
		return map;
	}
}
