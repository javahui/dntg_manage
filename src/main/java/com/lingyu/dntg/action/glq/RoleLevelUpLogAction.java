package com.lingyu.dntg.action.glq;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;


/**
 * 角色升级日志
 * @author ln
 *
 */
@Controller
@RequestMapping("roleLevelUpLog")
public class RoleLevelUpLogAction  extends AbstractAction{
	
	@RequestMapping("index")
	public String index(String userName, String startTime,
			String endTime, HttpServletRequest request, ModelMap modelMap){
		if ( StringUtils.isNotBlank(userName)
				|| StringUtils.isNotBlank(startTime)
				|| StringUtils.isNotBlank(endTime)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list",logDaoTemplate.paging("roleLevelUp.index", paramMap));
		
		}
		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("roleLevelUp.excelIndex", paramMap);
		String[] titlesArray = new String[]{"角色名","角色ID","等级","时间"};
		return super.exportXls(dataList, "角色升级", titlesArray);
	}
	
}
