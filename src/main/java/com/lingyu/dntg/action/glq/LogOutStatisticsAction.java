package com.lingyu.dntg.action.glq;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 角色在线时长日志
 * @author ln
 *
 */
@Controller
@RequestMapping("logOutStatistics")
public class LogOutStatisticsAction extends AbstractAction {
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list",logDaoTemplate.paging("logOutStatistics.index", paramMap));
		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("logOutStatistics.excelIndex", paramMap);
		String[] titlesArray = new String[]{"角色名","在线时长(小时)","日期"};
		return super.exportXls(dataList, "用户在线时长", titlesArray);
	}
}
