package com.lingyu.dntg.action.gcf;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
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
 * 游戏配置文件管理
 * @author donghui
 */
@Controller
@RequestMapping("gameConfigFile")
public class GameConfigFileAction extends AbstractAction{
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		PagingList<Map> pagingList = toolDaoTemplate.paging("gameConfigFile.index", paramMap);
		for (Map map : pagingList.getRecords()) {
			String value = PropertyUtils.getGameFile(MapUtils.getString(map, "fileMapName"));
			map.put("fileMapName", value);
		}
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
		log.info("配置文件列表新增开始...");
		String oldName = file.getOriginalFilename();
		String newName = FilenameUtils.getBaseName(oldName) + "." + RandomStringUtils.randomNumeric(13) + "." + FilenameUtils.getExtension(oldName);
		String uploadPath = PropertyUtils.getCommons("game-config");
		String fullUploadPath = contextPath + uploadPath;
		new File(fullUploadPath).mkdirs();
		file.transferTo(new File(fullUploadPath  + newName));
		
		Map paramMap = (Map)request.getAttribute("paramMap");
		String fullFileName = contextPath + toolDaoTemplate.selectOne("gameConfigFile.getFileNameByFileMapNameAndGlobal", paramMap);
		if (new File(fullFileName).delete()) {
			log.info("成功删除游戏配置文件:[{}] 配置文件名:[{}] global:[{}]", fullFileName, paramMap.get("fileMapName"), paramMap.get("global"));
		}
		if (toolDaoTemplate.delete("gameConfigFile.deleteByFileMapNameAndGlobal", paramMap) > 0) {
			log.info("成功删除game_config_file记录  配置文件名:[{}] global:[{}]", paramMap.get("fileMapName"), paramMap.get("global"));
		}
		
		paramMap.put("filepath", uploadPath);
		paramMap.put("oldName", oldName);
		paramMap.put("newName", newName);
		paramMap.put("md5", DigestUtils.md5Hex(file.getInputStream()));
		if (toolDaoTemplate.insert("gameConfigFile.insert", paramMap) > 0){
			log.info("成功新增game_config_file记录  paramMap:{}]", paramMap);
		}
		
		this.updateGameCfServer(paramMap);
		return "redirect:./index.do";
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("gameConfigFile.byId", id));
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
			String fullFileName = contextPath + MapUtils.getString(paramMap, "filepath") + MapUtils.getString(paramMap, "newName");
			if (new File(fullFileName).delete()) {
				log.info("成功删除游戏配置文件:[{}] 配置文件名:[{}] global:[{}]", fullFileName, paramMap.get("fileMapName"), paramMap.get("global"));
			}
			String oldName = file.getOriginalFilename();
			String newName = FilenameUtils.getBaseName(oldName) + "." + RandomStringUtils.randomNumeric(13) + "." + FilenameUtils.getExtension(oldName);
			String uploadPath = PropertyUtils.getCommons("game-config");
			String fullUploadPath = contextPath + uploadPath;
			new File(fullUploadPath).mkdirs();
			file.transferTo(new File(fullUploadPath  + newName));
			paramMap.put("filepath", uploadPath);
			paramMap.put("oldName", oldName);
			paramMap.put("newName", newName);
			paramMap.put("md5", DigestUtils.md5Hex(file.getInputStream()));
		}
		modelMap.put("result", toolDaoTemplate.update("gameConfigFile.update",paramMap));
		this.updateGameCfServer(paramMap);
		return "redirect:./index.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		String contextPath = request.getSession().getServletContext().getRealPath("/") + "/";
		List<String> fileNameList = toolDaoTemplate.selectList("gameConfigFile.getFileNameByIds", recordIds);
		if (CollectionUtils.isEmpty(fileNameList)) {
			modelMap.put("result", 0);
			return "redirect:./index.do";
		}
		for (String fileName : fileNameList) {
			if (new File(contextPath + fileName).delete()) {
				log.info("成功删除游戏配置文件:[{}]", fileName);
			}
		}
		int num = toolDaoTemplate.delete("gameConfigFile.deleteIds", recordIds);
		if (num > 0) {
			log.info("成功删除游戏配置game_config_file [{}] 条记录 ids:[{}]", recordIds);
		}
		
		num = toolDaoTemplate.delete("gameCfServer.deleteByFileId", recordIds);
		if (num > 0) {
			log.info("成功删除游戏配置game_cf_server [{}] 条记录 ids:[{}]", recordIds);
		}
		modelMap.put("result", 1);
		return "redirect:./index.do";
	}
	
	/**
	 * 文件名选择框
	 */
	@ModelAttribute("gameFileMap")
	public Map gameFileMap() {return PropertyUtils.gameFileMap;}
	
	/**
	 * 如果指定服务器,修改关系
	 */
	private void updateGameCfServer(Map paramMap){
		int global = MapUtils.getIntValue(paramMap, "global");
		String oldServerIds = MapUtils.getString(paramMap, "oldServerIds");
		String serverIds = MapUtils.getString(paramMap, "serverIds");
		if (StringUtils.equals(oldServerIds, serverIds)) {
			return;
		}
		if (global == 0) {
			int num = toolDaoTemplate.delete("gameCfServer.deleteByFileMapName", paramMap);
			if (num > 0) {
				log.info("成功删除game_cf_server[{}]条记录 serverIdList:{} fileMapName:[{}]", num, paramMap.get("serverIdList"), paramMap.get("fileMapName"));
			}
			num = toolDaoTemplate.insert("gameCfServer.batchInsert", paramMap);
			if (num > 0) {
				log.info("成功新增game_cf_server[{}]条记录 serverIdList:{} fileMapName:[{}]", num, paramMap.get("serverIdList"), paramMap.get("fileMapName"));
			}
		}
	}

}