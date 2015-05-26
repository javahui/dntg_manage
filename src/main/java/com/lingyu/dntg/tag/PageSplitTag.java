package com.lingyu.dntg.tag;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 分页标签
 */
public class PageSplitTag extends TagSupport {
	private static final long serialVersionUID = -7160185234415516991L;

	private String url = ""; // 页面指向地址
	private String pageNo = ""; // 当前页面，字符串型，由外面传入
	private String paramsStr = ""; // 组装后的参数字符串
	private int totalPages = 1; // 总页面数
	private int count = 0; // 总记录数
	private int intPageNo = 1; // 当前页面
	private String type ;
	private int pageSize = 15; // 每一页面显示的最大记录数

	public PageSplitTag() {}

	public int doStartTag() throws JspException {
		if (count == 0) {
			return Tag.SKIP_BODY;
		}
		url = StringUtils.trimToEmpty(url);
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Map<String, String[]> paramsMap = request.getParameterMap();
		Enumeration en = request.getParameterNames();
		StringBuilder param = new StringBuilder();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			if ("pageNo".equals(key)||"pageSize".equals(key)||"result".equals(key) ||"fs".equals(key) ||"token".equals(key)){
				continue;
			}
			String[] arrayStr = paramsMap.get(key);
			if (ArrayUtils.isEmpty(arrayStr)){
				continue;
			}
			String value="";
			for(String str:arrayStr){
				try {
					value+="&" + key + "=" + URLEncoder.encode(str, "UTF-8");
				} catch (UnsupportedEncodingException e) {}
			}
			param.append(StringUtils.trimToEmpty(value));
		}
		paramsStr = param.toString();

		intPageNo = NumberUtils.toInt(pageNo, 1);
		if(intPageNo<1){
			intPageNo = 1;
		}
		
		if (count % pageSize > 0) {
			totalPages = count / pageSize + 1;
		} else {
			totalPages = count / pageSize;
		}
		if (intPageNo > totalPages) {
			intPageNo = totalPages;
		}
		return Tag.SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		StringBuilder reStr = new StringBuilder();
		reStr.append("<form name='splitPageForm' method='post' ");
		reStr.append("action='" + url + addParams(paramsStr) + "'>");
		reStr.append("<table align=\"right\" class=\"tbl_noborder\"><tr>");
		reStr.append("<td><font color='#990000'>第<b>" + intPageNo + "/" + totalPages + "</b>页");
		reStr.append("共<b>" + count + "</b>条</font>");
		if (totalPages < 2) {
			reStr.append("【首页】");
			reStr.append("【上页】");
			reStr.append("【下页】");
			reStr.append("【尾页】");
		} else {
			if (intPageNo < 2) {
				reStr.append("【首页】");
				reStr.append("【上页】");
				reStr.append(getUrl(intPageNo + 1, "下页"));
				reStr.append(getUrl(totalPages, "尾页"));
			} else if (intPageNo == totalPages) {
				reStr.append(getUrl(1, "首页"));
				reStr.append(getUrl(intPageNo - 1, "上页"));
				reStr.append("【下页】");
				reStr.append("【尾页】");
			} else {
				reStr.append(getUrl(1, "首页"));
				reStr.append(getUrl(intPageNo - 1, "上页"));
				reStr.append(getUrl(intPageNo + 1, "下页"));
				reStr.append(getUrl(totalPages, "尾页"));
			}
		}
		reStr.append("<input id='slcpageInput' style='display:none;width:37px' /></td>");
		reStr.append("<td><select id='slcpage' class='slc_page_shift' name='pageSize' onchange='document.forms[\"splitPageForm\"].submit()'>");
		
		for (int i = 10; i <= 100; i = i+10) {
			if(pageSize==i){
				reStr.append("<option value="+i+" selected>"+i+"</option>");
			}
			else{
				reStr.append("<option value="+i+">"+i+"</option>");
			}
		}
		reStr.append("</select></td>");
		if(totalPages>2){
			reStr.append("<td>&nbsp;到&nbsp;</td><td><input name='pageNo' align='absmiddle' size='4' type='text' ");
			reStr.append("class='input_page_shift' ");
			reStr.append("value='"+pageNo+"' >&nbsp;");
			reStr.append("<button type='submit''>确定</button> ");
		}
		reStr.append("</td></tr></table></form>");
		JspWriter writer = pageContext.getOut();
		try {
			writer.println(new String(reStr.toString().getBytes()));
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return (EVAL_PAGE);
	}

	private String getUrl(int pageNo, String name) {
		return "【<a href=" + dealUrl(url, pageNo) + " class='splitPage'>" + name + "</a>】";
	}

	private String dealUrl(String url, int pageNo) {
		return url + "?pageNo=" + pageNo +"&pageSize="+pageSize+ paramsStr;
	}

	private String addParams(String params) {
		if (params == null || params.equals("")) {
			return "";
		}
		return "?" + params.substring(1);
	}

	public void release() {
		super.release();
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
