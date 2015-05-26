package com.lingyu.dntg.action.gcf;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.job.TopOneThousandStatisticsJob;
import com.lingyu.dntg.util.AsFileParseUtils;
/**
 * 名人堂的上传配置文件管理
 * @author donghui
 */
@Controller
@RequestMapping("mingRenTangConfig")
public class MingRenTangConfigAction extends AbstractAction{
	
	@Resource private TopOneThousandStatisticsJob job;
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("list", toolDaoTemplate.selectList("mingRenTangConfig.index"));
		return DEFAULT_PATH;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest request, ModelMap modelMap) throws IOException {
		if (!file.isEmpty()) {
			toolDaoTemplate.delete("mingRenTangConfig.deleteAll");
			File tempFile = new File(UUID.randomUUID().toString());
			file.transferTo(tempFile);
			List<Map> fileDataList = AsFileParseUtils.parse(tempFile);
			tempFile.delete();
			for (Map map : fileDataList) {
				System.out.println(map);
				String starttime = MapUtils.getString(map, "starttime");
				String finishtime = MapUtils.getString(map, "finishtime");
				String ver = MapUtils.getString(map, "ver");
				String id = MapUtils.getString(map, "id");
				String yaoqiu = MapUtils.getString(map, "yaoqiu");
				if (StringUtils.isNotBlank(starttime) && StringUtils.isNotBlank(finishtime) && StringUtils.isNotBlank(ver) && StringUtils.isNotBlank(id) && StringUtils.isNotBlank(yaoqiu)) {
					toolDaoTemplate.insert("mingRenTangConfig.insert", map);
				}
			}
			job.run();
		}
		return INDEX_PATH;
	}

}