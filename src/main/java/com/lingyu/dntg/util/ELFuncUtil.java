package com.lingyu.dntg.util;

import java.util.Date;

public class ELFuncUtil {
	/**
	 * 
	 * EL方法用于连接两个字符串 </pre>
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String append(String str1, String str2) {
		return str1 + str2;
	}

	public static String appendTwo(String str1, String str2, String str3) {
		return str1 + str2 + str3;
	}

	public static Float getFloat(Object str1) {
		return ConvertObjectUtil.obj2float(str1);
	}

	public static Integer dateDiff(String d1s, String d2s) {

		Date d1 = TimeUtils.convertStringToDate(d1s);
		Date d2 = TimeUtils.convertStringToDate(d2s);
		return TimeUtils.twoDayDiffence(d1, d2);
	}

	/**
	 * 数组中是否包含某个元素
	 * 
	 * @param strs
	 * @param str
	 * @return
	 */
	public static boolean contains(String strs, String str) {
		if (strs == null || strs.length() == 0)
			return false;
		String[] strArray = strs.split(",");
		for (String _str : strArray) {
			if (_str.equals(str))
				return true;
		}
		return false;
	}
}
