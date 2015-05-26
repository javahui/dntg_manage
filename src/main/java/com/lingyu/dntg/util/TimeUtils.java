package com.lingyu.dntg.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @description 时间转换器
 *
 * @author LiuJuan
 * @created 2011-4-2 上午10:05:17
 */
public class TimeUtils {
	
	private static final Logger log = LoggerFactory.getLogger(TimeUtils.class);
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat simpleDateFormatLong = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat simpleDateFormatHour = new SimpleDateFormat("yyyy-MM-dd HH");
	
//	private static DateFormat dateFormat = DateFormat.getDateInstance();
	
	/**
	 * Timestamp转yyyyMMdd
	 */
	public static String timeConvertString(Timestamp time) {
		if (time == null) {
			return null;
		}
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMMdd");
		
		String str = simpleFormat.format(time);
		
		return str;
	}

	/**
	 * Timestamp 转换成 yyyy-MM-dd形式
	 * @param time
	 * @return
	 */
	public static String convertString(Timestamp time) {
		if (time == null) {
			return null;
		}
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String str = simpleFormat.format(time);
		
		return str;
	}
	
	/**
	 * String 转换成 Timestamp
	 * @param time
	 * @return
	 */
	public static Timestamp convertTimestamp(String time) {
		if (time == null || "".equals(time)) {
			return null;
		}
		return Timestamp.valueOf(time);
	}
	/**
	 * 把yyyy-MM-dd HH:mm的日期形式转换为yyyyMMddHHmm
	 * @param time
	 * @return
	 */
	public static String convert2TightTimeFormat(String time){
		if(time == null || "".equals(time)){
			return null;
		}
		return time.replaceAll("[^\\d]","");
	}
	
	/**
	 * 把标准的日期形式转换为紧凑形式(eg:yyyy-MM-dd HH:mm To yyyyMMdd)
	 * @param time
	 * @return
	 */
	public static String convert2Day(String time){
		if(time == null || "".equals(time)){
			return null;
		}
		String t = time.substring(0, 10);
		return t.replaceAll("[^\\d]","");
	}
	/**
	 * yyyy-MM-dd转换为Date
	 * @param str
	 * @return
	 */
	public static Date convertStringToDate(String str){
		Date date = null;
		try {
			date = simpleDateFormat.parse(str);
		} catch (ParseException e) {
			log.error(str+" convert to datetime failed", e);
		}
		return date;
	}
	
	/**
	 * 把紧凑的日期转为标准格式
	 * @param dateTime
	 * @return
	 */
	public static String convertTight2NormalFormat(String dateTime){
		StringBuilder builder = new StringBuilder();
		if(dateTime.length() == 8){
			builder.append( dateTime.substring(0, 4) ).append( "-" )
					.append( dateTime.substring(4, 6) ).append( "-" )
					.append( dateTime.substring(6) );
		}else{// if(dateTime.length() == 12){
			builder.append( dateTime.substring(0, 4) ).append( "-" )
			.append( dateTime.substring(4, 6) ).append( "-" )
			.append( dateTime.substring(6, 8) ).append( " " )
			.append( dateTime.substring(8, 10) ).append( ":" )
			.append( dateTime.substring(10) );
		}
		return builder.toString();
	}
	/**
	 * 返回指定之日后的第几天的yyyy-MM-dd的形式
	 * @param str
	 * @param nextCount
	 * @return
	 */
	public static String getNextNumDaysStr(Date date, int num){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, num);
		
		return simpleDateFormat.format( c.getTime() );
	}
	
	public static String getBeforeNumDaysStr(Date date, int num){
		if(num>0){
			num=num-num*2;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, num);
		
		return simpleDateFormat.format( c.getTime() );
	}
	
	/**
	 * 设置startTime、endTime的相差天数<=30
	 * @param paramMap
	 */
	public static void updateStartEndTimeLessThan30(StringBuilder startBuilder, StringBuilder endBuilder){
		String startTime = startBuilder.toString();
		String endTime = endBuilder.toString();
		
		try{
			//startTime、 endTime都为空
			if( stringIsNull(startTime) && stringIsNull(endTime) ){
				Date end = new Date();
				startBuilder.append(getNextNumDaysStr(end, -30));
				endBuilder.append( simpleDateFormat.format(end) );
				
			//startTime为空、 endTime不为空
			}else if( stringIsNull(startTime) && !stringIsNull(endTime) ){
				Date end = simpleDateFormat.parse(endTime);
				startBuilder.append( getNextNumDaysStr(end, -30) );
			//startTime不为空、 endTime为空
			}else if( !stringIsNull(startTime) && stringIsNull(endTime) ){
				Date start = simpleDateFormat.parse(startTime);
				endBuilder.append( getNextNumDaysStr(start, 30) );
			//startTime、 endTime都不为空
			}else{
				Date startDate = simpleDateFormat.parse(startTime);
				Date endDate = simpleDateFormat.parse(endTime);
				//两个日期相差天数
				int diffence = twoDayDiffence(startDate, endDate);
				//如果相差大于30天，则限制为30天
				if( diffence > 30 ){
					endBuilder.delete(0, endBuilder.length()).append( getNextNumDaysStr(startDate, 30) );
				}
			}
		}catch(Exception e){
			log.error(null,e);
		}

	}
	
	/**
	 * 比较两个日期的相差天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int twoDayDiffence(Date date1, Date date2){
		if( null==date1 || null == date2){
			return -1;
		}
		long diffenceMill = date1.getTime() - date2.getTime();
		return (int)(diffenceMill / (24*60*60*1000));
	}
	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean stringIsNull(String str){
		if(str == null || str.equals("")){
			return true;
		}
		return false;
	}
	/**
	 * 把日期转换为yyyy-MM-dd的形式
	 * @param date
	 * @return
	 */
	public static String convertDateToStr(Date date){
		return simpleDateFormat.format(date);
	}
	/**
	 * 把日期转换为yyyy-MM-dd HH:mm:ss的形式
	 * @param date
	 * @return
	 */
	public static String convertDateToLongStr(Date date){
		return simpleDateFormatLong.format(date);
	}
	/**
	 * 把日期转换为yyyy-MM-dd HH的形式
	 * @param date
	 * @return
	 */
	public static String convertDateToHourStr(Date date){
		return simpleDateFormatHour.format(date);
	}
	
	public static String getCurJinCouDate(Date date){
		String str = simpleDateFormat.format(date);
		return str.replaceAll("[^\\d]", "");
	}
	
	public static void main(String[] args) {
		StringBuilder builder1 = new StringBuilder();
		StringBuilder builder2 = new StringBuilder("2011-04-03");
		updateStartEndTimeLessThan30(builder1, builder2);
		System.out.println( builder1 + "\t" + builder2);
	}
}
