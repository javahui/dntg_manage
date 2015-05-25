package com.lingyu.dntg.bean.vo;

import org.apache.commons.lang3.StringUtils;

public class AttachmentGoods{
	private String id;//物品
	private String count;//数量
	private String binding;//是否绑定
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getCount() {return count;}
	public void setCount(String count) {this.count = count;}
	
	public String getBinding() {return binding;}
	public void setBinding(String binding) {this.binding = binding;}
	
	@Override
	public String toString() {
		return StringUtils.join(new String[]{id,count,binding}, ";");
	}
}
