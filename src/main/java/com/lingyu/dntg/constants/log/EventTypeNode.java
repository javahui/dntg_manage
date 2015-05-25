package com.lingyu.dntg.constants.log;

import com.lingyu.dntg.bean.AbstractBean;

public class EventTypeNode extends AbstractBean{
	private static final long serialVersionUID = -4812093421269837847L;

	public EventTypeNode(String eventGroup,String eventType,String eventTypeName) {
		
		this.eventGroup = eventGroup;
		this.key = eventType;
		this.value = eventTypeName;
		
	}
	
	private String eventGroup;
	
	private String key;
	
	private String value;

	public String getEventGroup() {
		return eventGroup;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	
	

}
