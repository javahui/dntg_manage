package com.lingyu.dntg.service.gt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.RechargePojo;
import com.lingyu.dntg.bean.vo.PlayerVo;
import com.lingyu.dntg.bean.vo.RechargeVo;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.ConfigConstants;
import com.xianling.remoteservice.account.Recharge;

/**
 * 充值
 * @author donghui
 */
@Component
public class RechargeService extends AbstractService{
	
	/**
	 * 申请充值
	 */
	public int recharge(RechargeVo rechargeVo){
		List<PlayerVo> userRoleList = gameDaoTemplate.selectList("userRole.selectPlayer", rechargeVo.getPlayerNameList());
		RechargePojo pojo = new RechargePojo(rechargeVo, userRoleList, ConfigConstants.RechargeAudit.UNAUDIT.value);
		int num = toolDaoTemplate.insert("recharge.insert", pojo);
		if (num == 1) {
			log.info("成功申请充值记录:{} ", pojo);
		}
		return num;
	}

	/**
	 * 直接充值
	 */
	public String directRecharge(RechargeVo rechargeVo){
		if (this.checkDirectRecharge() == false) {
			return "没有直接充值权限";
		}
		List<PlayerVo> userRoleList = gameDaoTemplate.selectList("userRole.selectPlayer", rechargeVo.getPlayerNameList());
		RechargePojo pojo = new RechargePojo(rechargeVo, userRoleList, ConfigConstants.RechargeAudit.DIRECT.value);
		String result = this.webServiceRecharge(pojo);
		//如果webService充值成功
		if (StringUtils.isNotBlank(result)) {
			toolDaoTemplate.insert("recharge.insert", pojo);
			log.info("直接充值成功:{} ", pojo);
		}
		return ConfigConstants.RechargeResult.getName(result);
	}
	
	/**
	 * 批理申请充值
	 */
	public void batchAudit(List<Integer> recordIds) {
		log.info("批理申请充值recordIds:{}", recordIds);
		List<RechargePojo> list = toolDaoTemplate.selectList("recharge.getUnauditByIds", recordIds);
		for (RechargePojo pojo : list) {
			String result = this.webServiceRecharge(pojo);
			if (StringUtils.isNotBlank(result)) {
				Map updateParamMap = new HashMap();
				updateParamMap.put("id", pojo.getId());
				updateParamMap.put("auditor", LookupContext.getSessionUserInfo().getLoginName());
				if (ConfigConstants.RechargeResult.SUCCESS.value.equals(result)){
					updateParamMap.put("isAudit", ConfigConstants.RechargeAudit.AUDITED.value);
					updateParamMap.put("success", ConfigConstants.ChargeResult.SUCCESS.value);
				} 
				else {
					updateParamMap.put("isAudit", ConfigConstants.RechargeAudit.NOPASS.value);
					updateParamMap.put("success", ConfigConstants.ChargeResult.FAILUARE.value);
					String failReason = ConfigConstants.RechargeResult.getName(result);
					updateParamMap.put("failReason",failReason);
					
				}
				toolDaoTemplate.update("recharge.updateAudit", updateParamMap);
			}
		}
	}
	
	/**
	 * 调用webService充值
	 * @param pojo 充值记录
	 * @return  返回信息  {@see RechargeErrorCode}
	 */
	private String webServiceRecharge(RechargePojo pojo){
		String result = "";
		try {
			int moneyNum = pojo.getMoneyNum();
			String rechargeType = pojo.getRechargeType() + "";
			String platName = ConfigConstants.PLAT;
			int moneyType = pojo.getMoneyType();
			Recharge rechargeWebService = WebServiceFactory.getWSSimple(pojo.getServerId(), Recharge.class);
			Set<PlayerVo> playerSet = pojo.getPlayers();
			for (PlayerVo player : playerSet) {
				String orderId = System.currentTimeMillis() + "";
				String userId = player.getPlayerAccount().trim();
				String userRoleId = player.getPlayerId().trim();
				log.info("player:{}",player);
				String serverId = gameDaoTemplate.selectONeByServerId(pojo.getServerId(), "userRole.getServerIdById", userRoleId);
				//充值货币类型
				if (ConfigConstants.MoneyType.RECHARGE_YB.value == pojo.getMoneyType()) {
					boolean isCalc = false;
					Double rmb = pojo.getMoneyNum() / 10.0;
					result = rechargeWebService.rechargeWebYb(serverId, userId, orderId, rmb, moneyNum, isCalc, platName, rechargeType, userRoleId);
				}
				else if (ConfigConstants.MoneyType.RECHARGE_BYB.value == moneyType) {
					result = rechargeWebService.rechargeWebBindYb(serverId, userId, orderId, moneyNum, platName, rechargeType, userRoleId);
				}
				else{
					result = rechargeWebService.rechargeWebJb(serverId, userId, orderId, moneyNum, platName, rechargeType ,userRoleId);
				}
			}
		}
		catch (Exception e) {
			log.error("充值系统调用异常 serverId:"+pojo.getServerId(), e);
		}
		log.info("调用webService充值信息:{} result:{} 返回结果:[{}]", pojo, result, ConfigConstants.RechargeResult.getName(result));
		return result;
	}
	
	/**
	 * 校验直接充值权限
	 */
	public boolean checkDirectRecharge(){
		SessionUser sessionUser = LookupContext.getSessionUserInfo();
		if (sessionUser.getAllServer()) {
			return true;
		}
		else{
			int num =  (Integer)toolDaoTemplate.selectOne("actionRole.checkdDirectRecharge", sessionUser.getId());
			return num != 0;
		}
	}
	
}
