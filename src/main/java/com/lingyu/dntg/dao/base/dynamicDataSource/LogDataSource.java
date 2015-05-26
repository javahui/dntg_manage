package com.lingyu.dntg.dao.base.dynamicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.lingyu.dntg.util.DbConnectionUtils;
import com.lingyu.dntg.util.ToolDbUtils;

/**
 * LOG库的自定义多数据源
 * @author donghui
 */
public class LogDataSource extends AbstractRoutingDataSource {
	private final Logger log = LoggerFactory.getLogger(getClass()); 
	
	private Map<String,DruidDataSource> dataSources = new ConcurrentHashMap<String, DruidDataSource>();
	private int maxActive = DruidAbstractDataSource.DEFAULT_MAX_ACTIVE_SIZE;
    private int initialSize = DruidAbstractDataSource.DEFAULT_INITIAL_SIZE;
    private int maxWait = DruidAbstractDataSource.DEFAULT_MAX_WAIT;
    private int minIdle = DruidAbstractDataSource.DEFAULT_MIN_IDLE;
    
	public void init(){}
	
	/**
	 * 加载一个服务器的数据源
	 */
	public DataSource initDs(String serverId){
		String logDbUrl = (String)ToolDbUtils.selectObject("SELECT log_db_url FROM game_server WHERE server_id = '" + serverId+"'");
		String[] dbUrlArray = StringUtils.split(logDbUrl, ";");
		if (dbUrlArray == null || dbUrlArray.length != 3) {
			log.warn("serverId:{}的url格式错误:{}", serverId, logDbUrl);
			return null;
		}
		String url = "jdbc:mysql://" + dbUrlArray[0] + "?characterEncoding=utf8";
		String username = dbUrlArray[1];
		String pwd = dbUrlArray[2];
		if (DbConnectionUtils.testConection(serverId, url, username, pwd) == false) {
			return null;
		}
		DruidDataSource ds = new DruidDataSource();
		ds.setMaxActive(maxActive);
		ds.setInitialSize(initialSize);
		ds.setMaxWait(maxWait);
		ds.setMinIdle(minIdle);
		ds.setUrl(url);  
		ds.setUsername(username);
		ds.setPassword(pwd);
		dataSources.put(serverId, ds);
		return ds;
	}
	
	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return this.getConnection(null, null);
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		DruidDataSource ds = (DruidDataSource)determineTargetDataSource();
		if (ds == null) {
			String serverId = (String)determineCurrentLookupKey();
			throw new SQLException("数据源初始化失败 serverId:[" + serverId +"]");
		}
		if (username == null && password == null) {
			return ds.getConnection();
		}
		else{
			return ds.getConnection(username, password);
		}
	}

	@Override
	protected DataSource determineTargetDataSource() {
		String serverId = (String)determineCurrentLookupKey();
		DataSource dataSource = dataSources.get(serverId);
		if (StringUtils.isNotBlank(serverId) && dataSource == null) {
			return initDs(serverId);
		}
		return dataSource;
	}
	@Override
	protected Object determineCurrentLookupKey() {
		return LookupContext.getCurrentServerId();
	}

	public int getMaxActive() {return maxActive;}
	public void setMaxActive(int maxActive) {this.maxActive = maxActive;}

	public int getInitialSize() {return initialSize;}
	public void setInitialSize(int initialSize) {this.initialSize = initialSize;}

	public int getMaxWait() {return maxWait;}
	public void setMaxWait(int maxWait) {this.maxWait = maxWait;}

	public int getMinIdle() {return minIdle;}
	public void setMinIdle(int minIdle) {this.minIdle = minIdle;}
}
