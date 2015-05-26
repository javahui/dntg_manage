package com.lingyu.dntg.dao.base.exception;

/**
 * action-info.properties属性文件记录转换ActionInfo类格式异常
 * @author donghui
 */
public class ActionInfoFormatException extends Exception{
	private static final long serialVersionUID = -7243315096900126209L;

	public ActionInfoFormatException(){}

	public ActionInfoFormatException(String message) {
		super(message);
   }
}
