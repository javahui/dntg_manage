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
 * 每日新增充值统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("rechargeStatisticsNewByDay")
public class RechargeStatisticsNewByDayAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("rechargeRecord.indexNewDay", paramMap));

		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("rechargeRecord.excelNewIndex", paramMap);
		String[] titlesArray = new String[]{"时间","开服天数","新增充值用户数"};
		return super.exportXls(dataList, "每日新增充值统计", titlesArray);
	}
}