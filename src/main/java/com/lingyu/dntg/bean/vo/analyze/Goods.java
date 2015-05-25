package com.lingyu.dntg.bean.vo.analyze;

import org.apache.commons.lang3.math.NumberUtils;

import com.lingyu.dntg.bean.AbstractBean;

public class Goods extends AbstractBean{
	private static final long serialVersionUID = 4548079703662030884L;

	public Goods(String id, String name, String maxStack){
		this.id = id;
		this.name = name;
		this.maxStack = NumberUtils.toInt(maxStack);
	}
	
	private String id;
	private String name;
	private int maxStack;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxStack() {
		return maxStack;
	}
	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}
}
