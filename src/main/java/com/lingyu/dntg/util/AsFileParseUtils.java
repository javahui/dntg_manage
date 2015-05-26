package com.lingyu.dntg.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*import flex.messaging.io.SerializationContext;
import flex.messaging.io.amf.Amf3Input;*/

/**
 * as文件解析工具类
 */
public class AsFileParseUtils {
	private static final Logger log = LoggerFactory.getLogger(AsFileParseUtils.class);
	
	public static List parse(File file){
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
		/*	Amf3Input amf3In = new Amf3Input(new SerializationContext());
			amf3In.setInputStream(is);*/
			Object[] array = null;
			return Arrays.asList(array);
		} catch (Exception e) {
			log.error(ExceptionUtils.getMessage(e));
		}
		finally{
			IOUtils.closeQuietly(is);
		}
		return Collections.EMPTY_LIST;
	}
	
	public static List parse(String fileName){
		return AsFileParseUtils.parse(new File(fileName));
	}
}
