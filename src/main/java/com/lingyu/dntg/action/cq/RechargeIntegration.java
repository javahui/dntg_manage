package com.lingyu.dntg.action.cq;

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
 * 连续充值统计
 * @author ln
 *
 */
@Controller
@RequestMapping("rechargeIntegration")
public class RechargeIntegration extends AbstractAction {
	
	@RequestMapping("index")
	public String index(String moneyMin,String moneyMax,String startTime,String endTime, HttpServletRequest request, ModelMap modelMap) {
		    if(StringUtils.isNotBlank(moneyMin)||StringUtils.isNotBlank(moneyMax)
		        ||StringUtils.isNotBlank(startTime) ||StringUtils.isNotBlank(endTime)){
		    }
		    Map paramMap = (Map) request.getAttribute("paramMap");
		    modelMap.put("list",gameDaoTemplate.paging("rechargeRecord.rechargeIntegration", paramMap));
	    	return DEFAULT_PATH;
	}
	
	/**
	 * 导出連續充值统计Excel
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("rechargeRecord.rechargeIntegrationExcel", paramMap);
		String[] titlesArray = new String[]{"玩家账号","充值次数","总充值量（元）","占选择服务器的充值百分比","最后一次充值时间"};
		return super.exportXls(dataList, "连续充值统计",titlesArray);
	}
}
