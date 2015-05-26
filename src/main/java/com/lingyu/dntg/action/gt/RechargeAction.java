package com.lingyu.dntg.action.gt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.vo.RechargeVo;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.service.gt.RechargeService;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 游戏元宝申请
 * @author donghui
 */
@Controller
@RequestMapping("recharge")
public class RechargeAction extends AbstractAction{
	@Resource private RechargeService rechargeService;
	/**
	 * 充值列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("recharge.index", paramMap));
		modelMap.put("auditMap", getAuditMap());
		return DEFAULT_PATH;
	}		
	
	public  Map<Integer, String> getAuditMap(){
		
		Map<Integer, String> auditMap=new HashMap<Integer, String>();
		auditMap.put(0,"未审批");
		auditMap.put(1,"审批通过");
		auditMap.put(2,"未通过审批");
		return auditMap;
	}

	/**
	 * 充值审批列表
	 */
	@RequestMapping("indexAudit")
	public String indexAudit(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("recharge.indexAudit", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 直接充值列表
	 */
	@RequestMapping("indexDirect")
	public String indexDirect(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("recharge.indexDirect", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 充值页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 直接充值页面
	 */
	@RequestMapping("addDirect")
	public String addDirect(HttpServletRequest request, ModelMap modelMap) {
		if (rechargeService.checkDirectRecharge() == false) {//重要功能,权限检验
			modelMap.put("result", "没有直接充值权限");
			return "redirect:./indexDirect.do";
		}
		return DEFAULT_PATH;
	}
	
	/**
	 * 充值
	 */
	@RequestMapping("save")
	public String save(RechargeVo rechargeVo, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", rechargeService.recharge(rechargeVo));
		return INDEX_PATH;
	}
	
	/**
	 * 直接充值
	 */
	@RequestMapping("saveDirect")
	public String saveDirect(RechargeVo rechargeVo, HttpServletRequest request, ModelMap modelMap) {
		String result = rechargeService.directRecharge(rechargeVo);
		modelMap.put("result", result);
		return "redirect:./indexDirect.do";
	}
	
	/**
	 * 批量审批
	 */
	@RequestMapping("audit.do")
	public String audit(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap){
		rechargeService.batchAudit(recordIds);	
		return "redirect:./indexAudit.do";
	}
	
	/**
	 * 批量取消
	 */
	@RequestMapping("cancel.do")
	public String cancel(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("recordIds", recordIds);
		paramMap.put("isAuditCancel", ConfigConstants.RechargeAudit.CANCEL.value);
		toolDaoTemplate.update("recharge.updateAuditCancel", paramMap);
		return "redirect:./indexAudit.do";
	}

	/**
	 * 根据角色账号和服务器ID远程拉取账号下角色列表
	 */
	@ResponseBody
	@RequestMapping("checkUserIds")
	public Object checkUserIdsByServerId(String fieldId, @RequestParam("fieldValue") String playerName){
		List<String> playerNameList = Arrays.asList(StringUtils.split(playerName, "\n"));
		List<String> list = gameDaoTemplate.selectListByServerId(LookupContext.getCurrentServerId(), "userRole.selectName", playerNameList);
		List subtractList = ListUtils.subtract(playerNameList, list);
		boolean bool = (subtractList.size() == 0 ? true : false);
		return new Object[]{fieldId, bool};
	}
	
	
	@ModelAttribute("moneyTypeMap")
	public Map moneyType(){
		return ConfigConstants.MoneyType.getMap();
	}
	@ModelAttribute("rechargeTypeMap")
	public Map rechargeType(){
		return ConfigConstants.ChargeType.getMap();
	}
	
}