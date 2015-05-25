package com.lingyu.dntg.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String value;
	
	private String pattern = "yyyy-MM-dd HH:mm:ss";
//	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	@Override
	public int doStartTag() throws JspException {
		
		if( value != null && value.length() > 0 ){
			
			Date date = new Date( Long.parseLong(""+value) );
			
//			if( pattern == null || pattern.length()==0 ){
//				pattern = DEFAULT_PATTERN;
//			}
			
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			
			try {
				pageContext.getOut().write( sdf.format(date) );
			} catch (IOException e) {
				throw new JspException(e.getMessage());
			}
		}
		return super.doStartTag();
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
}
