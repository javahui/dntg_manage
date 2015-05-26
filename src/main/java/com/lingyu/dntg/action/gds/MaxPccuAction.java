package com.lingyu.dntg.action.gds;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.dao.gds.ServerRealTimeTotalDataDao;

/**
 * 服务器最大日峰值在线统计
 * @author Lian zhibin
 */
@Controller
@RequestMapping("maxPccu")
public class MaxPccuAction extends AbstractAction{
	@Resource private ServerRealTimeTotalDataDao serverRealTimeTotalDataDao;
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(String logMonth, String sortId, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(logMonth) && StringUtils.isNotBlank(sortId)) {
			Map paramMap = (Map)request.getAttribute("paramMap");
			List<Map> list = serverRealTimeTotalDataDao.selectMaxPccu(paramMap);
			modelMap.put("list", list);
		}
		modelMap.put("sortMap", toolDaoTemplate.selectList("serverSort.indexAllServer"));

		return DEFAULT_PATH;
	}

	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> list = serverRealTimeTotalDataDao.selectMaxPccu(paramMap);
		String[] titlesArray = new String[]{"平台","时间","服务器","最高在线数"};
		return super.exportXls(list, "服务器日峰值在线统计",titlesArray);
	}
}