package com.lingyu.dntg.action.cq;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;

/**
 * 游戏充值查询
 * @author ln
 *
 */
@Controller
@RequestMapping("rechargeRecord")
public class RechargeRecordAction extends AbstractAction {
	

	@RequestMapping("index")
	public String index(String orderId,String roleName,String userGuid, String startTime,
			String rechargeType,String moneyType,String rechargeState,
			String endTime, HttpServletRequest request, ModelMap modelMap) {
		    if(StringUtils.isNotBlank(orderId)
		    	 ||StringUtils.isNotBlank(roleName)
		    	 ||StringUtils.isNotBlank(userGuid)
		    	 ||StringUtils.isNotBlank(rechargeType)
		    	 ||StringUtils.isNotBlank(moneyType)
		    	 ||StringUtils.isNotBlank(rechargeState)
		    	 ||StringUtils.isNotBlank(startTime)
		    	 ||StringUtils.isNotBlank(endTime)){
		    	Map paramMap = (Map) request.getAttribute("paramMap");
				modelMap.put("list",gameDaoTemplate.paging("rechargeRecord.index", paramMap));
		    }
	    	return DEFAULT_PATH;
	}
	
	@ModelAttribute("rechargeMap")
	public Map RechargeType(){
		Map rechargeMap=new HashMap();
		rechargeMap.put("1", "正常充值");
		rechargeMap.put("2", "内部人员充值");
	    rechargeMap.put("3", "玩家奖励充值");
	    rechargeMap.put("4", "玩家补偿充值");
		return rechargeMap;
	}
	
	@ModelAttribute("moneyMap")
	public Map<Integer,String> MoneyType(){
		Map<Integer,String> moneyTypeMap = new HashMap<Integer,String>();
		moneyTypeMap.put(1, "游戏币");
		moneyTypeMap.put(2, "元宝");
		moneyTypeMap.put(3, "绑定元宝");
		return moneyTypeMap;
	}
	
}
