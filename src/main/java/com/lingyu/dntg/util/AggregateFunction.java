package com.lingyu.dntg.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * aggregate 聚合函数
 * @author Administrato
 *
 */
public class AggregateFunction {

	private List<Map> list;
	private String[] groupFieldNames = null;
	private String[] sumFieldNames = null;
	
	public AggregateFunction(List<Map> list){
		this.list = list;
	}
	
	public AggregateFunction group(String... fieldNames){
		groupFieldNames = fieldNames;
		return this;
	}
	
	public AggregateFunction sum(String... fieldNames){
		sumFieldNames = fieldNames;
		return this;
	}
	
	public void execute(){
        Map<String, Map> resultMap = new LinkedHashMap();
        for (Map map : this.list) {
        	String key = "";
        	for (String name : groupFieldNames) {
        		key += MapUtils.getString(map, name) + "_";
			}
        	if (ArrayUtils.isNotEmpty(sumFieldNames)) {
        		for (String sumFieldName : sumFieldNames) {
        			Map<String, Double> valueMap = (Map)MapUtils.getObject(resultMap, key, new LinkedHashMap());
        			valueMap.put(sumFieldName, MapUtils.getDoubleValue(map, sumFieldName) + MapUtils.getDoubleValue(valueMap, sumFieldName) );
        			resultMap.put(key , valueMap);
        		}
			}
        }
        this.list.clear();
        for (String key : resultMap.keySet()) {
        	String[] array = StringUtils.split(key, "_");
        	Map recordMap = new LinkedHashMap();
        	for (int i = 0; i < array.length; i++) {
        		recordMap.put(groupFieldNames[i], array[i]);
			}
        	recordMap.putAll(resultMap.get(key));
        	this.list.add(recordMap);
        }
	}
}