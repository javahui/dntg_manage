package com.lingyu.dntg.util;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;

/**
 * 属性文件工具类
 * @author donghui
 */
public class PropertyUtils {
	
	public static Map gameFileMap = ResourceBundleUtils.getResourceMap("properties/game-file");
	public static Map commonsMap = ResourceBundleUtils.getResourceMap("properties/commons");
	public static Map analyzeFileMap = ResourceBundleUtils.getResourceMap("properties/web-config-file");
	
	public static String getGameFile(String key){
		return MapUtils.getString(gameFileMap, key, "");
	}
	
	public static String getCommons(String key){
		return MapUtils.getString(commonsMap, key, "");
	}
	
	public static String getAnalyzeFile(String key){
		return MapUtils.getString(analyzeFileMap, key, "");
	}


}
