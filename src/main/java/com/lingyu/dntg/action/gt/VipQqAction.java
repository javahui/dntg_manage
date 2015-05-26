package com.lingyu.dntg.action.gt;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.vipqq.VipQQRemoteService;

/**
 * 超级会员面板配置
 * @author Lian zhibin
 */
@Controller
@RequestMapping("vipQq")
public class VipQqAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public void index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("vipQq.index", paramMap));
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
	@RequestMapping(value="save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		toolDaoTemplate.insert("vipQq.insert", paramMap);
		modelMap.put("result", toolDaoTemplate.insert("vipQq.insertServers", paramMap));
		List<String> serverIdList = (List)paramMap.get("serverIdList");
		for (String serverId : serverIdList) {
			String qq = MapUtils.getString(paramMap, "qq");
			int minRecharge = MapUtils.getIntValue(paramMap, "minRecharge");
			String pic = MapUtils.getString(paramMap, "pic");
			try {
				VipQQRemoteService vipQQRemoteService = WebServiceFactory.getWSSimple(serverId, VipQQRemoteService.class);
				vipQQRemoteService.updateVipQQ(qq, minRecharge, pic);
			} catch (Exception e) {
				log.error("远程调用超级会员面板配置出错!");
				continue;
			}
		}
		return "redirect:./index.do";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("vipQq.byId", id));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("vipQq.update", paramMap));
		return INDEX_PATH;
	}

	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		toolDaoTemplate.delete("vipQq.deleteServers", recordIds);
		modelMap.put("result", toolDaoTemplate.delete("vipQq.delete", recordIds));
		return "redirect:./index.do";
	}
}