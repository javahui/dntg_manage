package com.lingyu.dntg.dao.gds;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.ServerRealTimeTotalData;
import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.dao.base.AbstractDao;

@Component
public class ServerRealTimeTotalDataDao extends AbstractDao{

	/**
	 * 查询
	 * @param month 月份
	 * @param paramMap	查询条件
	 */
	public PagingList selectByMonth(Map paramMap){
		String month = MapUtils.getString(paramMap, "logHour").substring(0, 7).replaceFirst("-", "_");
		if (isExistTableByMonth(month)) {
			if (paramMap == null) {paramMap = new HashMap();}
			paramMap.put("month", month);
			return toolDaoTemplate.pagingTotal("serverRealTimeTotalData.index", paramMap);
		}
		else{
			return new PagingList();
		}
	}
	
	
	public List<Map> selectXls(Map paramMap) {
		String month = MapUtils.getString(paramMap, "logHour").substring(0, 7).replaceFirst("-", "_");;
		if (isExistTableByMonth(month)) {
			if (paramMap == null) {paramMap = new HashMap();}
			paramMap.put("month", month);
			return toolDaoTemplate.selectList("serverRealTimeTotalData.xls", paramMap);
		}
		else{
			return Collections.EMPTY_LIST;
		}
	}
	
	public List<Map> selectMaxPccu(Map paramMap) {
		String month = MapUtils.getString(paramMap, "logMonth").substring(0, 7).replaceFirst("-", "_");
		if (isExistTableByMonth(month)) {
			if (paramMap == null) {paramMap = new HashMap();}
			String logMonth = month.replace("_", "-");
			paramMap.put("month", month);
			paramMap.put("logMonth", logMonth);
			return toolDaoTemplate.selectList("serverRealTimeTotalData.getMaxPccuBySortAndMonth", paramMap);
		}
		else{
			return Collections.EMPTY_LIST;
		}
	}
	
	/**
	 * 批量新增
	 */
	public int batchInsert(String logHour, List<ServerRealTimeTotalData> list){
		String month = logHour.substring(0, 7).replaceFirst("-", "_");
		//如果不存在,新增一张表serverRealTimeTotalData_yyyy_mm
		if (isExistTableByMonth(month) == false) {
			toolDaoTemplate.update("serverRealTimeTotalData.createTableByMonth", month);
		}
		if (CollectionUtils.isNotEmpty(list)) {
			Map paramMap = new HashMap();
			paramMap.put("month", month);
			paramMap.put("dataList", list);
			return toolDaoTemplate.insert("serverRealTimeTotalData.batchinsertServerRealTimeTotalData",paramMap);
		}
		else{
			return 0;
		}
	}
	
	/**
	 * 按服务器id和小时删除
	 */
	public int deleteByLoghourAndServer(Map paramMap){
		String month = MapUtils.getString(paramMap, "logHour").substring(0, 7).replaceFirst("-", "_");
		if (isExistTableByMonth(month)) {
			if (paramMap == null) {paramMap = new HashMap();}
			paramMap.put("month", month);
			return toolDaoTemplate.delete("serverRealTimeTotalData.deleteByLoghourAndServer",paramMap);
		}
		else{
			return 0;
		}
	}
	
	/**
	 * 批量一个小时更新记录
	 */
	public int batchUpdateByLogHour(String logHour, List<ServerRealTimeTotalData> serverRealTimeTotalDataList){
		String month = logHour.substring(0, 7).replaceFirst("-", "_");
		//如果不存在,新增一张表serverRealTimeTotalData_yyyy_mm
		if (isExistTableByMonth(month) == false) {
			toolDaoTemplate.update("serverRealTimeTotalData.createTableByMonth", month);
		}
		if (CollectionUtils.isNotEmpty(serverRealTimeTotalDataList)) {
			Map paramMap = new HashMap();
			paramMap.put("logHour", logHour);
			paramMap.put("month", month);
			paramMap.put("dataList", serverRealTimeTotalDataList);
			toolDaoTemplate.delete("serverRealTimeTotalData.deleteByLoghourAndServerIds", paramMap);
			return toolDaoTemplate.insert("serverRealTimeTotalData.batchinsertServerRealTimeTotalData",paramMap);
		}
		else{
			return 0;
		}
	}
	
	/**
	 * 批量一个小时更新记录
	 */
	public int batchUpdateByLogDay(String logDay, List<ServerRealTimeTotalData> serverRealTimeTotalDataList){
		String month = logDay.substring(0, 7).replaceFirst("-", "_");
		//如果不存在,新增一张表serverRealTimeTotalData_yyyy_mm
		if (isExistTableByMonth(month) == false) {
			toolDaoTemplate.update("serverRealTimeTotalData.createTableByMonth", month);
		}
		if (CollectionUtils.isNotEmpty(serverRealTimeTotalDataList)) {
			Map paramMap = new HashMap();
			paramMap.put("logDay", logDay);
			paramMap.put("month", month);
			toolDaoTemplate.delete("serverRealTimeTotalData.deleteByLogDay", paramMap);
			paramMap.put("dataList", serverRealTimeTotalDataList);
			return toolDaoTemplate.insert("serverRealTimeTotalData.batchinsertServerRealTimeTotalData",paramMap);
		}
		else{
			return 0;
		}
	}
	
	/**
	 *	判断一个serverRealTimeTotalData_yyyy_mm形式的表名是否存在
	 * @param month 月份
	 */
	public boolean isExistTableByMonth(String month){
		String result = toolDaoTemplate.selectOne("serverRealTimeTotalData.existTableByMonth", month);
		return StringUtils.isNotBlank(result);
	}
}
