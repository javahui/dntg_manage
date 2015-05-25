package com.lingyu.dntg.action.sm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.dynamicDataSource.GameDataSource;
import com.lingyu.dntg.dao.base.dynamicDataSource.LogDataSource;
import com.lingyu.dntg.service.sm.GameServerService;

/**
 * 服务器管理
 * @author donghui
 */
@Controller
@RequestMapping("gameServer")
public class GameServerAction extends AbstractAction{
	@Resource private GameServerService gameServerService;
	@Resource private GameDataSource gameDataSource;
	@Resource private LogDataSource logDataSource;
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("gameServer.indexList", paramMap));
		modelMap.put("sortMap", toolDaoTemplate.selectList("serverSort.indexAllServer"));
		
		return DEFAULT_PATH;
	}

	/**
	 * 查看详细信息
	 */
	@RequestMapping("show")
	public String show(@RequestParam("id") int id, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("gameServer.show", id));
		return DEFAULT_PATH;
	}

	/**
	 * 新增页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("sortMap", toolDaoTemplate.selectList("serverSort.indexAllServer"));
		return DEFAULT_PATH;
	}

	/**
	 * 保存
	 */
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.insert("gameServer.insert", paramMap));
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,   HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("gameServer.byId", id));
		modelMap.put("serverSort", toolDaoTemplate.selectList("serverSort.indexAllServer"));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("gameServer.update", paramMap));
		//重新加载DataSource信息
		String serverId = MapUtils.getString(paramMap, "serverId");
		gameDataSource.initDs(serverId);
		logDataSource.initDs(serverId);
		return "redirect:./index.do";
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.delete("gameServer.delete", recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 开启选中服务器
	 */
	@RequestMapping("updateGameServerStatusOpen")
	public String updateGameServerStatusOpen(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.update("gameServer.updateGameServerStatusOpen", recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 关闭选中服务器
	 */
	@RequestMapping("updateGameServerStatusClose")
	public String updateGameServerStatusColse(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.update("gameServer.updateGameServerStatusClose", recordIds));
		return "redirect:./index.do";
	}

	/**
	 * 更改全部服务器状态
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("itemStatusChangeWhole.do")
	public void changeWholeGameServerStatus(HttpServletRequest request, HttpServletResponse response){
		try {
			Map paramMap = (Map)request.getAttribute("paramMap");
			int result = toolDaoTemplate.update("gameServer.updateAllBySortId", paramMap);
			if(result!=0)
				response.getWriter().write("_true");
			else
				response.getWriter().write("_false");
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			 ExceptionUtils.printRootCauseStackTrace(e);
		}
	}
	
	/**
	 * 打开选择多服务器子窗口
	 */
	@RequestMapping("multiDiaglog")
	public String multiDiaglog(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		modelMap.put("gameServerMap", gameServerService.selectAllSortGameServersByUserId(sessionUser));
		return "dialog/server_multi_choice_diaglog";
	}
	
	/**
	 * 打开选择单个服务器子窗口
	 */
	@RequestMapping("singeDiaglog")
	public String singeDiaglog(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		modelMap.put("gameServerMap", gameServerService.selectAllSortGameServersByUserId(sessionUser));
		return "dialog/server_singe_choice_diaglog";
	}
	
}