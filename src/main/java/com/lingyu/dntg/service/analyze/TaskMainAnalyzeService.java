package com.lingyu.dntg.service.analyze;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.lingyu.dntg.bean.vo.analyze.LiBao;
import com.lingyu.dntg.bean.vo.analyze.TaskMainConfig;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.AsFileParseUtils;

/**
 * 得到主线任务
 */
@Component
public class TaskMainAnalyzeService extends AbstractService{
	
	private static final String FILE_NAME = "taskMain.dat";

	public Map<String, LiBao> geTaskMain(){
		String contextPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "/";
		Map analyzeFileMap = toolDaoTemplate.selectOne("analyzeFile.byFileMapName", FILE_NAME);
		String filePath = MapUtils.getString(analyzeFileMap, "filePath");
		String newName = MapUtils.getString(analyzeFileMap, "newName");
		String fullFileName = contextPath + filePath + newName;
		Map result = new HashMap();
		for (Object object : AsFileParseUtils.parse(fullFileName)) {
			Map map = (Map)object;
			TaskMainConfig taskMainConfig = new TaskMainConfig();
			taskMainConfig.setId(MapUtils.getString(map, "id2"));
			taskMainConfig.setChapterSubId(MapUtils.getString(map, "id"));
			taskMainConfig.setTaskName(MapUtils.getString(map, "name2"));
			taskMainConfig.setCompleteNpcId(MapUtils.getString(map, "completeNpc"));
			taskMainConfig.setDescribe(MapUtils.getString(map, "describe"));
			taskMainConfig.setDuologue(MapUtils.getString(map, "duologue"));
			taskMainConfig.setPayType(MapUtils.getString(map, "pay"));
			taskMainConfig.setTrace(MapUtils.getString(map, "trace", "").split("_"));
			taskMainConfig.setRecevieLevel(MapUtils.getString(map, "limit"));
			taskMainConfig.setJb(MapUtils.getString(map, "gold"));
			taskMainConfig.setBoundOb(MapUtils.getString(map, "boundOb"));
			taskMainConfig.setExp(MapUtils.getString(map, "exp"));
			taskMainConfig.setPrestige(MapUtils.getString(map, "prestige"));
			taskMainConfig.setZhiqi(MapUtils.getString(map, "zhenqi"));
			result.put(taskMainConfig.getId() , taskMainConfig);
		}
		return result;
	}
}
