package com.lingyu.dntg.action.gdq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.analyze.Goods;
import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.constants.log.RoleConstant;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.lingyu.dntg.service.analyze.GoodsAnalyzeService;
import com.xianling.remoteservice.shutup.ShutUpFreeze;

/**
 * 玩家信息管理
 * @author donghui
 */
@Controller
@RequestMapping("gameUserInfo")
public class GameUserInfoAction extends AbstractAction{
	@Resource private GoodsAnalyzeService goodsAnalyzeService;
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(String userId, String name, String startLevel, String endLevel, HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(userId)||StringUtils.isNotBlank(name)||StringUtils.isNotBlank(startLevel)||StringUtils.isNotBlank(endLevel)) {
			Map paramMap = (Map)request.getAttribute("paramMap");
			modelMap.put("list", gameDaoTemplate.paging("userRole.index", paramMap));
		}
		return DEFAULT_PATH;
	}
	
	/**
	 * 批量封号
	 */
	@RequestMapping("userforbidUse")
	public String userforbidUse(@RequestParam List<String> recordIds, HttpServletRequest request, ModelMap modelMap) {
		log.info("批量封号recordIds:{}", recordIds);
		Map paramMap = (Map)request.getAttribute("paramMap");
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		try{
			ShutUpFreeze shutUpFreezeWebService = WebServiceFactory.getWSSimple(serverId, ShutUpFreeze.class);
			String result = shutUpFreezeWebService.fengHaoByRoleIds(StringUtils.join(recordIds, ","));
			if (result == null){
				for (String userId : recordIds) {
					Map map = new HashMap();
					map.put("userId", userId);
					map.put("serverId", serverId);
					map.put("isCanUse", 1);
					int updateNum = toolDaoTemplate.update("userForbid.updateUserForbidUse",  map);
					if (updateNum == 0) {
						paramMap.putAll(map);
						paramMap.put("isCanUse", 1);
						paramMap.put("isCanSpeak", 0);
						toolDaoTemplate.insert("userForbid.insert", paramMap);
					}
				}
			}
		}
		catch(Exception e){
			modelMap.addAttribute("result", "封号远程调用错误");
		}
		return INDEX_PATH;
	}
	
	/**
	 * 批量禁言
	 */
	@RequestMapping("userforbidSpeak")
	public String userforbidSpeak(@RequestParam List<String> recordIds, HttpServletRequest request, ModelMap modelMap) {
		log.info("批量禁言recordIds:{}", recordIds);
		Map paramMap = (Map)request.getAttribute("paramMap");
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		try{
			ShutUpFreeze shutUpFreezeWebService = WebServiceFactory.getWSSimple(serverId, ShutUpFreeze.class);
			Object result = shutUpFreezeWebService.shutUpByRoleIds(StringUtils.join(recordIds, ","));
			if (result == null){
				for (String userId : recordIds) {
					Map map = new HashMap();
					map.put("userId", userId);
					map.put("serverId", serverId);
					map.put("isCanSpeak", 1);
					int updateNum = toolDaoTemplate.update("userForbid.updateUserForbidSpeak",  map);
					if (updateNum == 0) {
						paramMap.putAll(map);
						paramMap.put("isCanUse",0);
						paramMap.put("isCanSpeak", 1);
						toolDaoTemplate.insert("userForbid.insert", paramMap);
					}
				}
			}
		}
		catch(Exception e){
			modelMap.addAttribute("result", "禁言远程调用错误");
		}
		return INDEX_PATH;
	}
	
	/**
	 * 批量解除封号
	 */
	@RequestMapping("userforbidUseAdmit")
	public String userforbidUseAdmit(@RequestParam List<String> recordIds, HttpServletRequest request, ModelMap modelMap) {
		log.info("批量解除封号recordIds:{}", recordIds);
		Map paramMap = (Map)request.getAttribute("paramMap");
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		try{
			ShutUpFreeze shutUpFreezeWebService = WebServiceFactory.getWSSimple(serverId, ShutUpFreeze.class);
			String result = shutUpFreezeWebService.jieChuFenghaoByRoleIds(StringUtils.join(recordIds, ","));
			if (result == null) {
				for (String userId : recordIds) {
					Map map = new HashMap();
					map.put("userId", userId);
					map.put("serverId", serverId);
					map.put("isCanUse", 0);
					int updateNum = toolDaoTemplate.update("userForbid.updateUserForbidUse",  map);
					if (updateNum == 0) {
						paramMap.putAll(map);
						paramMap.put("isCanUse", 0);
						paramMap.put("isCanSpeak", 0);
						toolDaoTemplate.insert("userForbid.insert", paramMap);
					}
				}
			}
		}
		catch(Exception e){
			modelMap.addAttribute("result", "解除封号远程调用错误");
		}
		return INDEX_PATH;
	}
	
	/**
	 * 批量解除禁言
	 */
	@RequestMapping("userforbidSpeakAdmit")
	public String userforbidSpeakAdmit(@RequestParam List<String> recordIds, HttpServletRequest request, ModelMap modelMap) {
		log.info("批量解除禁言recordIds:{}", recordIds);
		Map paramMap = (Map)request.getAttribute("paramMap");
		String serverId = MapUtils.getString(paramMap, "currentServerId");
		try{
			ShutUpFreeze shutUpFreezeWebService = WebServiceFactory.getWSSimple(serverId, ShutUpFreeze.class);
			String result = shutUpFreezeWebService.jieJinByRoleIds(StringUtils.join(recordIds, ","));
			if (result == null) {
				for (String userId : recordIds) {
					Map map = new HashMap();
					map.put("userId", userId);
					map.put("serverId", serverId);
					map.put("isCanSpeak", 0);
					int updateNum = toolDaoTemplate.update("userForbid.updateUserForbidSpeak",  map);
					if (updateNum == 0) {
						paramMap.putAll(map);
						paramMap.put("isCanUse",0);
						paramMap.put("isCanSpeak", 0);
						toolDaoTemplate.insert("userForbid.insert", paramMap);
					}
				}
			}
		}
		catch(Exception e){
			modelMap.addAttribute("result", "解除禁言远程调用错误");
		}
		return INDEX_PATH;
	}
	
	/**
	 * 查看详细信息
	 */
	@RequestMapping("show")
	public String show(@RequestParam String id, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("record", gameDaoTemplate.selectOne("userRole.show", id));
		modelMap.put("friend", gameDaoTemplate.selectList("userRole.getRoleFriend", id));
		modelMap.put("foe", gameDaoTemplate.selectList("userRole.getRoleFoe", id));
		modelMap.put("roleBaoshi", gameDaoTemplate.selectList("roleBaoshi.getRoleBaoshi", id));
		modelMap.put("roleZuoqi", gameDaoTemplate.selectOne("roleZuoqi.getRoleZuoqi", id));
		modelMap.put("equipMap", RoleConstant.getEquipMap());
		
		Map<String, Goods> goodsMap = goodsAnalyzeService.getGoods();
		List<Map> mapList = gameDaoTemplate.selectList("roleEquipSlot.getRoleEquipSlot", paramMap);
		for (Map map : mapList) {
			String goodsId = MapUtils.getString(map, "goodsId");
			Goods goodsInfo = goodsMap.get(goodsId);
			if (goodsInfo != null) {
				map.put("goodsName", goodsInfo.getName());
			}
		}
		modelMap.put("roleEquipSlot", mapList);
		return DEFAULT_PATH;
	}
	
	/**
	 * 背包
	 */
	@RequestMapping("rolebags")
	public String rolebags(@RequestParam String id, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("record", gameDaoTemplate.selectOne("userRole.show", id));
		modelMap.put("roleBagState", gameDaoTemplate.selectOne("roleBagState.getRoleBagState", id));

		Map<String, Goods> goodsMap = goodsAnalyzeService.getGoods();
		PagingList<Map> pagingList = gameDaoTemplate.paging("roleBagSlot.getRoleBagSlot", paramMap);
		for (Map map : pagingList.getRecords()) {
			String goodsId = MapUtils.getString(map, "goodsId");
			Goods goodsInfo = goodsMap.get(goodsId);
			if (goodsInfo != null) {
				map.put("goodsName", goodsInfo.getName());
			}
		}
		modelMap.put("roleBagSlot", pagingList);

		return DEFAULT_PATH;
	}

	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam String userId,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", gameDaoTemplate.selectOne("userRole.byId", userId));
		return DEFAULT_PATH;
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("userForbid.update", paramMap));
		return "redirect:./index.do";
	}
	
	/**
	 * 打开选择用户子窗口
	 */
	@RequestMapping("indexDiaglog")
	public String indexDiaglog(@RequestParam String serverId, String userId, String name, String startLevel, String endLevel, String startVipLevel, String endVipLevel,
			HttpServletRequest request, ModelMap modelMap) {
		if (StringUtils.isNotBlank(userId) || StringUtils.isNotBlank(name) || StringUtils.isNotBlank(startLevel) || StringUtils.isNotBlank(endLevel) || StringUtils.isNotBlank(startVipLevel) || StringUtils.isNotBlank(endVipLevel)) {
			Map paramMap = (Map)request.getAttribute("paramMap");
			modelMap.put("list", gameDaoTemplate.selectListByServerId(serverId, "userRole.indexDiaglog", paramMap));
		}
		return "dialog/game_user_diaglog";
	}
	
	/**
	 * 导出xls文件
	 */
	@RequestMapping("xls")
	public ResponseEntity<byte[]>  xls(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		List<Map> dataList = gameDaoTemplate.selectList("userRole.excelIndex", paramMap);
		String[] titlesArray = new String[]{"用户账号","角色名","职业","性别","等级","当前经验","最后上线时间","最后离线时间","角色创建时间","服务器id","封号状态","禁言状态"};
		return super.exportXls(dataList, "玩家信息查询", titlesArray);
	}
}