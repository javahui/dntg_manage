package com.lingyu.dntg.action.gds;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 骑战兵器统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("qizhanWeapon")
public class QizhanWeaponAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", gameDaoTemplate.selectList("qizhanBinqi.index", paramMap));
		modelMap.put("qizhanbingqiTotalCount", gameDaoTemplate.selectList("qizhanBinqi.indexAllCount", paramMap));
		Object qizhanbingqiTotalCount = modelMap.get("qizhanbingqiTotalCount");
		String totalCount = qizhanbingqiTotalCount.toString();
		int allCount = Integer.parseInt(totalCount.substring(1, totalCount.length()-1));
		modelMap.put("allCount", allCount);

		return DEFAULT_PATH;
	}
}