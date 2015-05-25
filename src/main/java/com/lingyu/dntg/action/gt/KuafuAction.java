package com.lingyu.dntg.action.gt;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.alibaba.fastjson.JSON;
import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.service.sm.GameServerService;


/**
 * 跨服赛区分布
 * @author donghui
 */
@Controller
@RequestMapping("kuafu")
public class KuafuAction extends AbstractAction {
	@Resource private GameServerService gameServerService;
	
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		PagingList<Map> pl = toolDaoTemplate.paging("kuafu.index", paramMap);
		for (Map map : pl.getRecords()) {
			List<String> serversList = toolDaoTemplate.selectList("kuafu.getServerByKuafuId", map.get("id"));
			map.put("serverIds", StringUtils.join(serversList.iterator(),","));
		}
		modelMap.put("list", pl);
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
	public String save(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.insert("kuafu.insert", paramMap));
		toolDaoTemplate.insert("kuafu.insertServers", paramMap);
		this.saveFile(MapUtils.getIntValue(paramMap, "id"));
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("kuafu.byId", id));
		List<String> serversList = toolDaoTemplate.selectList("kuafu.getServerByKuafuId", id);
		modelMap.put("serverIds", StringUtils.join(serversList.iterator(),","));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("kuafu.update", paramMap));
		List kuaFuIdList = Arrays.asList(new String[]{MapUtils.getString(paramMap, "id")});
		toolDaoTemplate.delete("kuafu.deleteServers", kuaFuIdList);
		toolDaoTemplate.insert("kuafu.insertServers", paramMap);
		this.saveFile(MapUtils.getIntValue(paramMap, "id"));
		return "redirect:./index.do";
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<String> recordIds, HttpServletRequest request, ModelMap modelMap) {
		String contextPath = request.getSession().getServletContext().getRealPath("/");
		//删除文件
		List<String> serverIdList = toolDaoTemplate.selectList("kuafu.getServerIdBykuaFuId", recordIds);
		List<String> kuafuServerIdList = toolDaoTemplate.selectList("kuafu.getkuafuServeIdById", recordIds);
		serverIdList.addAll(kuafuServerIdList);
		for (String serverId : serverIdList) {
			new File(contextPath + "/upload/kuafu/" + serverId).delete();
		}
		toolDaoTemplate.delete("kuafu.deleteServers", recordIds);
		modelMap.put("result", toolDaoTemplate.delete("kuafu.delete", recordIds));
		return "redirect:./index.do";
	}
	
	/**
	 * 批量保存为文件
	 */
	@RequestMapping("batchSaveFile")
	public String batchSaveFile(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		for (int kuafuId : recordIds) {
			this.saveFile(kuafuId);
		}
		return INDEX_PATH;
	}
	
	/**
	 * 打开选择服务器子窗口
	 */
	@RequestMapping("serverDiaglog")
	public String openKuafuServers(String kuafuId, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("gameServerMap", gameServerService.getKuafaServer(kuafuId));
		return DEFAULT_PATH;
	}
	
	/**
	 * 接口返回json形式的跨服信息
	 */
	@ResponseBody
	@RequestMapping("")
	public Object getKuafu(@RequestParam String id, HttpServletRequest request, ModelMap modelMap) {
		Map map = toolDaoTemplate.selectOne("kuafu.byId", id);
		if (MapUtils.isEmpty(map)) {
			return null;
		}
		List<String> serversList = toolDaoTemplate.selectList("kuafu.getServerByKuafuId", id);
		map.put("serverIds", StringUtils.join(serversList.iterator(),","));
		return map;
	}

	/**
	 * 保存每个跨服信息为一个物理文件
	 */
	private void saveFile(int kuafuId){
		String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "/upload/kuafu/";
		Map map = toolDaoTemplate.selectOne("kuafu.byId", kuafuId);
		String kuafuServerid = MapUtils.getString(map, "serverid");
		List<String> serversList = toolDaoTemplate.selectList("kuafu.getServerByKuafuId", kuafuId);
		serversList.add(kuafuServerid);
		String kuafuJson = JSON.toJSONString(map, true);
		for (String serverId : serversList) {
			try {
				FileUtils.write(new File(path + serverId), kuafuJson, "utf-8");
			} catch (IOException e) {
				log.error(null, e);
			}
		}
	}
}
