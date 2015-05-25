package com.lingyu.dntg.service.analyze;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.lingyu.dntg.bean.vo.analyze.LiBao;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.AsFileParseUtils;

/**
 * 得到礼包
 */
@Component
public class LiBaoAnalyzeService extends AbstractService{
	
	private static final String FILE_NAME = "LiBao.jat";


	public Map<String, LiBao> getLiBao(){
		String contextPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "/";
		Map analyzeFileMap = toolDaoTemplate.selectOne("analyzeFile.byFileMapName", FILE_NAME);
		String filePath = MapUtils.getString(analyzeFileMap, "filePath");
		String fileName = MapUtils.getString(analyzeFileMap, "fileName");
		String fullFileName = contextPath + filePath + fileName;
		List fileDataList = AsFileParseUtils.parse(fullFileName);
		if (CollectionUtils.isEmpty(fileDataList)) {
			log.error("礼包{}文件没找到或者文件格式错误", fullFileName);
			return new HashMap();
		}
		Map result = new HashMap();
		for (Object object : fileDataList) {
			Map map = (Map)object;
			LiBao liBao = new LiBao();
			liBao.setId(MapUtils.getString(map, "id"));
			liBao.setName(MapUtils.getString(map, "name"));
			liBao.setDesc(MapUtils.getString(map, "des"));
			liBao.setBind( MapUtils.getBooleanValue(map, "bangding"));
			liBao.setBingYb(MapUtils.getIntValue(map, "bindgold"));
			liBao.setJb(MapUtils.getIntValue(map, "money"));
			result.put(liBao.getId() , liBao);
		}
		return result;
	}
	
	
}
