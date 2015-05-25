package com.lingyu.dntg.dao.base.daoTemplate;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.vo.pagin.PagingList;

/**
 * tool库的dao
 * @author donghui
 */
@Component
public class ToolDaoTemplate{
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource private SqlSessionTemplate toolSqlSession;

	public PagingList paging(String statement, Map parameter) {
		int totalCount = (Integer)this.selectOne(statement + "Count", parameter);
		if (totalCount == 0) {
			return new PagingList();
		}
		if (!parameter.containsKey("pageNo")) {
			parameter.put("pageNo", 1);
		}
		if (!parameter.containsKey("pageSize")) {
			parameter.put("pageSize", 20);
		}
		int pageNo = MapUtils.getIntValue(parameter, "pageNo");
		int pageSize = MapUtils.getIntValue(parameter, "pageSize");
		
		PagingList result = new PagingList(pageNo, pageSize, totalCount);
		if(totalCount > 0){
			int start = result.getCurPageStartRowNum();
			parameter.put("start", start);
			List records = this.selectList(statement, parameter);
			result.setRecords(records);
		}
		return result;
	}
	
	/**
	 * 查询带有总计的记录集
	 */
	public PagingList pagingTotal(String statement, Map paramMap) {
		int totalCount = (Integer)this.selectOne(statement + "Count", paramMap);
		if (totalCount == 0) {
			return new PagingList();
		}
		totalCount ++;
		if (!paramMap.containsKey("pageNo")) {
			paramMap.put("pageNo", 1);
		}
		if (!paramMap.containsKey("pageSize")) {
			paramMap.put("pageSize", 20);
		}
		int pageNo = MapUtils.getIntValue(paramMap, "pageNo");
		int pageSize = MapUtils.getIntValue(paramMap, "pageSize");
		
		PagingList result = new PagingList(pageNo, pageSize, totalCount);
		if (totalCount > 0){
			int start = result.getCurPageStartRowNum();
			paramMap.put("start", start);
			List records = this.selectList(statement, paramMap);
			if (result.isEnd()) {
				//查找名为xxxTotal的Mapping Id作总计的SQL
				paramMap.remove("pageNo");
				paramMap.remove("pageSize");
				Map totalMap = this.selectOne(statement + "Total", paramMap);
				records.add(totalMap);
			}
			result.setRecords(records);
		}
		return result;
	}
	
	public <E> List<E> selectList(String statement) {
		return toolSqlSession.selectList(statement);
	}
	
	public <E> List<E> selectList(String statement, Object parameter) {
		return toolSqlSession.selectList(statement, parameter);
	}
	
	public <T> T selectOne(String statement) {
		return toolSqlSession.selectOne(statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		return toolSqlSession.selectOne(statement, parameter);
	}
	
	public int insert(String statement) {
		return toolSqlSession.insert(statement);
	}
	
	public int insert(String statement, Object parameter) {
		return toolSqlSession.insert(statement, parameter);
	}

	public int update(String statement) {
		return toolSqlSession.update(statement);
	}
	
	public int update(String statement, Object parameter) {
		return toolSqlSession.update(statement, parameter);
	}

	public int delete(String statement) {
		return toolSqlSession.delete(statement);
	}
	
	public int delete(String statement, Object parameter) {
		return toolSqlSession.delete(statement, parameter);
	}
	
	public void batchInsert(String statement, List paramsList){
		StopWatch sw = new StopWatch();
		sw.start();
		SqlSession batchSqlSession = null;
		try{
			batchSqlSession = toolSqlSession.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			for (Object record : paramsList) {
				batchSqlSession.insert(statement, record);
			}
		}
		catch(Exception e){log.error(null, e);}
		finally{
			if (batchSqlSession != null) {
				batchSqlSession.commit();
				batchSqlSession.close();
			}
		}
		log.debug("批量新增 {}条记录  statement:[{}] 完成时间:[{}]", paramsList.size(), statement, sw.getTime());
	} 
}
