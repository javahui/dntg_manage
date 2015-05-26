package com.lingyu.dntg.dao.base.interceptor;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagingSQLInterceptor implements Interceptor {
	public Object intercept(Invocation invocation) throws Throwable {
		 if (invocation.getTarget() instanceof RoutingStatementHandler){
			RoutingStatementHandler statementHandler = (RoutingStatementHandler)invocation.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");  
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");  
            
			BoundSql boundSql = statementHandler.getBoundSql();
			Object parameterObject = boundSql.getParameterObject();
			String statmentName = mappedStatement.getId();
			String sql = boundSql.getSql();
			if (parameterObject instanceof Map) {
				Map parameterMap = (Map)parameterObject;
				if (parameterMap.containsKey("start") && parameterMap.containsKey("pageSize") && StringUtils.countMatches(statmentName, ".") == 1) {
	    			 int start = MapUtils.getIntValue(parameterMap, "start");
	    			 sql = sql +" LIMIT "+ start + "," + parameterMap.get("pageSize");
	    			 ReflectHelper.setValueByFieldName(boundSql, "sql", sql);
	          }
			}
		 }
		return invocation.proceed();
	}
	
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	
	public void setProperties(Properties properties) {
		// Auto-generated method stub
	}
}