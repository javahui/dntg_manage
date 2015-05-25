package com.lingyu.dntg.action.gdq;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 战斗力排行列表
 * @author donghui
 */
@Controller
@RequestMapping("rankZhandouli")
public class RankZhandouliAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.paging("rankZhandouli.index",paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("rankZhandouli.indexExcel", paramMap);
		String[] titlesArray = new String[]{"战斗力","角色名","升级时间"};
		return super.exportXls(dataList, "战斗力排行列表", titlesArray);	
	}
}