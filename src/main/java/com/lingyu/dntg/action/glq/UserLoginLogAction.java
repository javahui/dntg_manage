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
 * 用户登陆日志
 * @author ln
 *
 */
@Controller
@RequestMapping("userLoginLog")
public class UserLoginLogAction extends AbstractAction {

	/**
	 * 登陆日志列表
	 */
	@RequestMapping("index")
	public String index(String userId, String userName, String startTime,String endTime, HttpServletRequest request, ModelMap modelMap){
		if (StringUtils.isNotBlank(userId) || StringUtils.isNotBlank(userName) || StringUtils.isNotBlank(startTime) || StringUtils.isNotBlank(endTime)) {
			Map paramMap = (Map) request.getAttribute("paramMap");
			modelMap.put("list",logDaoTemplate.paging("userLogin.index", paramMap));
		}
		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = logDaoTemplate.selectList("userLogin.excelIndex", paramMap);
		String[] titlesArray = new String[]{"账号","角色名（角色ID）","登陆时间","登出时间","等级","ip地址"};
		return super.exportXls(dataList, "用户登陆日志", titlesArray);
	}
}
