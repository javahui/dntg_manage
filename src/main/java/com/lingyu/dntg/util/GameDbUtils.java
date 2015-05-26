package com.lingyu.dntg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;

/**
 * dbUtils根据当前serverId连接游戏数据库
 * @author donghui
 */
public class GameDbUtils {  
	private static final Logger log = LoggerFactory.getLogger(GameDbUtils.class);
	
	
    public static Connection getConnection() {
    	String serverId = LookupContext.getCurrentServerId();
		String gameDbUrl = (String)ToolDbUtils.selectObject("SELECT game_db_url FROM game_server WHERE server_id = '" + serverId+"'");
		String[] dbUrlArray = StringUtils.split(gameDbUrl, ";");
		if (dbUrlArray == null || dbUrlArray.length != 3) {
			log.warn("serverId:{}的url格式错误:{}", serverId, gameDbUrl);
			return null;
		}
		String url = "jdbc:mysql://" + dbUrlArray[0] + "?characterEncoding=utf8";
		String name = dbUrlArray[1];
		String pwd = dbUrlArray[2];
		String driver = "com.mysql.jdbc.Driver";
        Connection conn = null;  
        DbUtils.loadDriver(driver);  
        try {  
            conn = DriverManager.getConnection(url, name, pwd);  
        } catch (SQLException e) {
        	log.error(null, e);
        }
        return conn;  
    }
    
    public static List<Map> selectList(String sql) {
    	Connection conn = getConnection();  
    	QueryRunner qr = new QueryRunner();
    	List<Map> results = null;
    	try {
    		results = (List)qr.query(conn,sql,  new MapListHandler());  
    	} catch (SQLException e) {  
    		e.printStackTrace();  
    	} finally {  
    		DbUtils.closeQuietly(conn);  
    	} 
    	return results;
    }
    
    public static int update(String sql) throws SQLException {
        Connection conn = getConnection();  
        QueryRunner qr = new QueryRunner();
        int num = 0;
        try {
        	num = qr.update(conn, sql);  
        }  catch (SQLException e) {  
    		e.printStackTrace();  
    	} finally {  
            DbUtils.closeQuietly(conn);  
        } 
        return num;
    }
    
    public static Object selectObject(String sql) {
    	if (GameDbUtils.selectList(sql).size() > 0) {
    		Map map = GameDbUtils.selectList(sql).get(0);
    		return map.values().iterator().next();
		}
    	return null;
    }
    
    public static Map selectMap(String sql) {
    	List<Map> list = GameDbUtils.selectList(sql);
    	if (CollectionUtils.isEmpty(list)) {
			return new HashMap();
		}
    	return list.get(0);
    }  
  
}  