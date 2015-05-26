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
 * 每日充值统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("rechargeStatisticsByDay")
public class RechargeStatisticsByDayAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("rechargeRecord.indexDay", paramMap));
		return DEFAULT_PATH;
	}	

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("rechargeRecord.excelIndex", paramMap);
		String[] titlesArray = new String[]{"时间","充值人数","充值次数","充值金额(元)","充值元宝","ARPU"};
		return super.exportXls(dataList, "每日充值统计", titlesArray);
	}
}