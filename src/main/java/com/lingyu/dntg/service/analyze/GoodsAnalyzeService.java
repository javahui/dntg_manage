package com.lingyu.dntg.service.analyze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.lingyu.dntg.bean.vo.analyze.Goods;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.AsFileParseUtils;

/**
 * 得到物品信息
 */
@Component
public class GoodsAnalyzeService extends AbstractService{
	private static final String FILE_NAME = "goods.jat";
	
	public Map<String, Goods> getGoods(){
		String contextPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "/";
		Map analyzeFileMap = toolDaoTemplate.selectOne("analyzeFile.byFileMapName", FILE_NAME);
		String filePath = MapUtils.getString(analyzeFileMap, "filePath");
		String fileName = MapUtils.getString(analyzeFileMap, "fileName");
		String fullFileName = contextPath + filePath + fileName;
		List goodsFileDataList = AsFileParseUtils.parse(fullFileName);
		if (CollectionUtils.isEmpty(goodsFileDataList)) {
			log.error("物品表{}文件没找到或者文件格式错误", fullFileName);
			return new HashMap();
		}
		Object[] array = (Object[])goodsFileDataList.get(0);
		Map result = new HashMap();
		for (Object object : array) {
			Map map = (Map)object;
			String id = MapUtils.getString(map, "id");
			String name = MapUtils.getString(map, "name");
			String maxstack = MapUtils.getString(map, "maxstack");
			if (StringUtils.isBlank(id) || StringUtils.isBlank(name)) {
				continue;
			}
			Goods goods = new Goods(id, name, maxstack);
			result.put(goods.getId() , goods);
		}
		return result;
	}
	
	/**
	 * 按物品名查找
	 */
	public List<Goods> query(String goodsName){
		List<Goods> result = new ArrayList();
		for (Goods goods : this.getGoods().values()) {
			if (StringUtils.contains(goods.getName(), goodsName)){
				result.add(goods);
			}
		}
		return result;
	}
}
