package com.lingyu.dntg.dao.base.exception;

/**
 * 没有指定服务器数据源异常
 * @author donghui
 */
public class NullServerServerException extends NullPointerException{

	private static final long serialVersionUID = -340290143714207401L;
	
	public NullServerServerException(){}

	public NullServerServerException(String message) {
		super(message);
   }
}
