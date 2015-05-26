package com.lingyu.dntg.action.cq;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 玩家充值统计
 * @author ln
 */
@Controller
@RequestMapping("statisticsRecharge")
public class StatisticsRechargeAction extends AbstractAction {

	@RequestMapping("index")
	public String index(String orderId,String roleId,String moneyMin,String moneyMax,String startTime,
		String endTime, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map) request.getAttribute("paramMap");
		modelMap.put("list",gameDaoTemplate.paging("rechargeRecord.selectRechargeStatistics", paramMap));
    	return DEFAULT_PATH;
	}
	
	/**
	 * 导出玩家充值统计Excel
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("rechargeRecord.selectRechargeStatisticsExcel", paramMap);
		String[] titlesArray = new String[]{"玩家账号","角色名","角色创建时间","充值次数","总充值量（元）","首次充值时间","最后一次充值时间","现有元宝"};
		return super.exportXls(dataList, "玩家充值统计", titlesArray);	
	}
	
}
