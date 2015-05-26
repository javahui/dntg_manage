package com.lingyu.dntg.dao.base;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lingyu.dntg.dao.base.daoTemplate.GameDaoTemplate;
import com.lingyu.dntg.dao.base.daoTemplate.LogDaoTemplate;
import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;

public class AbstractDao {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 游戏数据库DAO
	 */
	@Resource protected GameDaoTemplate gameDaoTemplate;
	
	/**
	 * 游戏日志库DAO
	 */
	@Resource protected LogDaoTemplate logDaoTemplate;
	
	/**
	 * tool库的dao
	 */
	@Resource protected ToolDaoTemplate toolDaoTemplate;
}
