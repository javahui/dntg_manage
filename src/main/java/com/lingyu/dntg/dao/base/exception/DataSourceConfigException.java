package com.lingyu.dntg.dao.base.exception;

import java.sql.SQLException;

/**
 *错误的数据源配置
 * @author donghui
 */
public class DataSourceConfigException extends SQLException{
	private static final long serialVersionUID = -2756160137636722336L;

	public DataSourceConfigException(){}

	public DataSourceConfigException(String message) {
		super(message);
   }
}
