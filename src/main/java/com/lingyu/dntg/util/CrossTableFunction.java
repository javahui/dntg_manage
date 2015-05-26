package com.lingyu.dntg.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

public class CrossTableFunction {

	private List<Map> list;
	private String rowFieldName = "row";
	private String colFieldName = "col";
	private String numFieldName = "num";
	private Object[] orderRowFieldArray;
	private LinkedHashMap orderColFieldMap;
	
	public CrossTableFunction(List<Map> list){
		this.list = list;
	}
	
	public CrossTableFunction(List<Map> list, String rowFieldName, String colFieldName, String numFieldName){
		this.list = list;
		this.rowFieldName = rowFieldName;
		this.colFieldName = colFieldName;
		this.numFieldName = numFieldName;
	}
	
	public CrossTableFunction setOrderRowFieldMap(Object[] orderRowFieldMap) {
		this.orderRowFieldArray = orderRowFieldMap;
		return this;
	}
	
	public CrossTableFunction setOrderColFieldMap(LinkedHashMap orderColFieldMap) {
		this.orderColFieldMap = orderColFieldMap;
		return this;
	}
	
	public void execute(){
		Map dataMap = new HashMap();
		for (Map map : this.list) {
			String row = MapUtils.getString(map, rowFieldName);
			String col = MapUtils.getString(map, colFieldName);
			double num = MapUtils.getDoubleValue(map, numFieldName);
			dataMap.put(row + "_" + col, num);
		}
		list.clear();
		for (Object orderColFieldKey : orderColFieldMap.keySet()){
			Map recordMap = new LinkedHashMap();
			recordMap.put("", orderColFieldKey);
			for (Object orderRowField : orderRowFieldArray) {
				String key = orderRowField + "_" + orderColFieldMap.get(orderColFieldKey);
				double num = MapUtils.getDoubleValue(dataMap, key);
				recordMap.put(key, num);
			}
			list.add(recordMap);
		}
	}
}
