/**
 * 
 */
package com.lingyu.dntg.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author JackChu
 * @date  2013-11-25 下午5:08:17
 */
public class URLUtils {
	
	protected static final Logger log = LoggerFactory.getLogger(URLUtils.class);
	
	
	/**
	 * @param urlStr
	 * @param timeout an <code>int</code> that specifies the connect
     *               timeout value in milliseconds
	 * @return
	 */
	public static String getContentFromUrl(String urlStr,int timeout) {
		String json = null;
		try {
			URL url = new URL(urlStr);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(timeout);
			connection.connect();

			BufferedInputStream in = new BufferedInputStream(
					connection.getInputStream());
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			json = reader.readLine();// Map<String, List<Result>>
			
			reader.close();
			in.close();
			connection.disconnect();
		} catch (FileNotFoundException e) {
			log.error("404 !!!!  url:" + urlStr);
		} catch (SocketTimeoutException e) {
			log.error("timeout !!!!  url:" + urlStr);
		} catch (Exception e) {
			log.error("read from " + urlStr, e);
		}
		return json;
	}
	
	 private static List<String> getLink(final String s)
	 {
	  String regex  = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
	  final List<String> list = new ArrayList<String>();
	  final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
	  final Matcher ma = pa.matcher(s);
	  while (ma.find())
	  {
	   list.add(ma.group(2));
	  }
	  return list;
	 }
	
	public static List<String> getUrlListFromUrl(String urlStr,int timeout,String likeStr) {
		List<String> result = new ArrayList<String>();
		try {
			URL url = new URL(urlStr);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(timeout);
			connection.connect();

			BufferedInputStream in = new BufferedInputStream(
					connection.getInputStream());
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String   line=""; 
		    while((line   =   reader.readLine())!=null){ 
		    	List<String> links = getLink(line);
		    	if(!links.isEmpty() ){
		    		String e = links.get(0);
		    		if(StringUtils.isNotEmpty(e) && e.startsWith(likeStr)){
		    			result.add(e);
		    		}
		    	}
		    } 
		    
		    reader.close();
			in.close();
			connection.disconnect();
		} catch (FileNotFoundException e) {
			log.error("404 !!!!  url:" + urlStr);
		} catch (SocketTimeoutException e) {
			log.error("timeout !!!!  url:" + urlStr);
		} catch (Exception e) {
			log.error("read from " + urlStr, e);
		}
		return result;
	}

}
