package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 坐骑升阶分布统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("zuoqiFenbu")
public class ZuoqiFenbuAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.selectList("roleZuoqi.index", paramMap));

		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("roleZuoqi.excelIndex", paramMap);
		String[] titlesArray = new String[]{"等级","人数","升阶到该阶级人数百分比"};
		return super.exportXls(dataList, "坐骑升阶分布统计", titlesArray);
	}
}