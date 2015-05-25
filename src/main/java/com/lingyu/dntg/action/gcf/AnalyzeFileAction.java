package com.lingyu.dntg.action.gcf;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.util.PropertyUtils;
/**
 * 解析配置文件管理
 * @author donghui
 */
@Controller
@RequestMapping("analyzeFile")
public class AnalyzeFileAction extends AbstractAction{
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		PagingList<Map> pagingList = toolDaoTemplate.paging("analyzeFile.index", paramMap);
		modelMap.put("list", pagingList);
		return DEFAULT_PATH;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(MultipartFile file, HttpServletRequest request, ModelMap modelMap) throws IOException {
		String contextPath = request.getSession().getServletContext().getRealPath("/") + "/";
		Map paramMap = (Map)request.getAttribute("paramMap");
		log.info("解析配置文件新增开始...");
		Map map = toolDaoTemplate.selectOne("analyzeFile.byFileMapName", paramMap.get("fileMapName"));
		String fullFileName = contextPath + MapUtils.getString(map, "filePath") + MapUtils.getString(map, "newName");
		if (MapUtils.isNotEmpty(map)) {
			if (new File(fullFileName).delete()) {
				log.info("成功删除解析配置文件:[{}] 配置文件名:[{}]", fullFileName, paramMap.get("fileMapName"));
			}
			int num = toolDaoTemplate.delete("deleteById", map.get("id"));
			if (num == 1) {
				log.info("成功删除analyze_file记录  配置文件名:[{}]", paramMap.get("fileMapName"));
			}
		}
		String fileName = file.getOriginalFilename();
		String filePath = PropertyUtils.getCommons("analyze-game-file");
		String fullUploadPath = contextPath + filePath;
		new File(fullUploadPath).mkdirs();
		file.transferTo(new File(fullUploadPath  + fileName));
		
		paramMap.put("filePath", filePath);
		paramMap.put("newName", file.getOriginalFilename());
		if (toolDaoTemplate.insert("analyzeFile.insert", paramMap) > 0){
			log.info("成功新增analyze_file记录  paramMap:{}]", paramMap);
		}
		return "redirect:./index.do";
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("analyzeFile.byId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MultipartFile file, HttpServletRequest request, ModelMap modelMap) throws IOException {
		String contextPath = request.getSession().getServletContext().getRealPath("/") + "/";
		Map paramMap = (Map)request.getAttribute("paramMap");
		if (!file.isEmpty()) {
			//删除原文件
			String fullFileName = contextPath + MapUtils.getString(paramMap, "filePath") + MapUtils.getString(paramMap, "newName");
			if (new File(fullFileName).delete()) {
				log.info("成功删除解析配置文件:[{}] 配置文件名:[{}]", fullFileName, paramMap.get("fileMapName"));
			}
			String fileName = file.getOriginalFilename();
			String filePath = PropertyUtils.getCommons("analyze-game-file");
			String fullUploadPath = contextPath + filePath;
			new File(fullUploadPath).mkdirs();
			file.transferTo(new File(fullUploadPath  + fileName));
			
			paramMap.put("filePath", filePath);
			paramMap.put("newName", file.getOriginalFilename());
		}
		modelMap.put("result", toolDaoTemplate.update("analyzeFile.update",paramMap));
		return "redirect:./index.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		String contextPath = request.getSession().getServletContext().getRealPath("/") + "/";
		List<String> fileNameList = toolDaoTemplate.selectList("analyzeFile.getFileNameByIds", recordIds);
		for (String fileName : fileNameList) {
			if (new File(contextPath + fileName).delete()) {
				log.info("成功删除解析配置文件:[{}]", fileName);
			}
		}
		int num = toolDaoTemplate.delete("analyzeFile.delete", recordIds);
		if (num > 0) {
			log.info("成功删除游戏配置analyze_file [{}] 条记录 ids:{}", num, recordIds);
		}
		modelMap.put("result", num);
		return "redirect:./index.do";
	}
	
	/**
	 * 文件名选择框
	 */
	@ModelAttribute("fileMap")
	public Map gameFileMap() {
		return PropertyUtils.analyzeFileMap;
	}
	
}