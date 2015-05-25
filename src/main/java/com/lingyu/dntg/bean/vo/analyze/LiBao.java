package com.lingyu.dntg.bean.vo.analyze;

import com.lingyu.dntg.bean.AbstractBean;


public class LiBao extends AbstractBean{
	private static final long serialVersionUID = -5472594565252490861L;

	private String id;
	private String name;
	private boolean bind;
	private int jb;
	private int bingYb;
	private String desc;

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

	public boolean isBind() {
		return bind;
	}

	public void setBind(boolean bind) {
		this.bind = bind;
	}

	public int getJb() {
		return jb;
	}

	public void setJb(int jb) {
		this.jb = jb;
	}

	public int getBingYb() {
		return bingYb;
	}

	public void setBingYb(int bingYb) {
		this.bingYb = bingYb;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
