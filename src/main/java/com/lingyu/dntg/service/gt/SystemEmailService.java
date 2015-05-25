package com.lingyu.dntg.service.gt;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.SystemEmailPojo;
import com.lingyu.dntg.bean.vo.SystemEmailVO;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.ConfigConstants;
import com.xianling.remoteservice.email.SystemEmail;

@Component
public class SystemEmailService extends AbstractService{
	
	/**
	 * 为了aop写日志,单独写了一个发送邮件方法
	 * @param roleIds 发送给服务器的用户列表,全服发送为null
	 * @param serverId 服务器id
	 * @param isFull 是否全服发送
	 * @return "000":输入有误,"001":角色名为空或角色不存在,"":正确
	 */
	public String sendEmail_AopLog(SystemEmailPojo sm, List<String> roleIds, String serverId, boolean isFull){
		if (CollectionUtils.isEmpty(roleIds)) {
			roleIds = null;
		}
		String result = null;
		try {
			SystemEmail systemEmailWebService = WebServiceFactory.getWSSimple(serverId, SystemEmail.class);
			int isAllServer = isFull ? 1 : 0;
			result = systemEmailWebService.systemEmail3(sm.getId(), roleIds, 0,sm.getTitle(), sm.getContent(),sm.getJb(),sm.getYb(),sm.getAttachmentsJson(), serverId, isAllServer, sm.getDelayHours());
			if (StringUtils.isBlank(result)) {
				log.info("批量发送系统邮件发送成功 serverId:{},roleids:{}", serverId, roleIds);
			}
			else if ("000".equals(result)) {
				log.info("批量发送输入有误");
			}
			else if ("001".equals(result)) {
				log.info("批量发送角色名为空或角色不存在!");
			}
		} catch (Exception e) {
			log.info("批量发送系统邮件远程服务器异常 serverId:{}", serverId);
		}
		if (StringUtils.isBlank(result)) {
			result = "";
		}
		return result;
	}
	
	/**
	 * 申请发放
	 */
	public SystemEmailPojo save_AopLog (SystemEmailVO systemEmailVO) {
		SystemEmailPojo sm = new SystemEmailPojo(systemEmailVO);
		toolDaoTemplate.insert("systemEmail.insert", sm);
		return sm;
	}
	
	/**
	 * 批量取消
	 */
	public int undo_AopLog (Map paramMap) {
		paramMap.put("state", ConfigConstants.SystemEmailState.UNDO.value);
		paramMap.put("recordIds", paramMap.get("recordIds"));
		int num = toolDaoTemplate.update("systemEmail.batchUpdate", paramMap);
		return num;
	}
	
	/**
	 * 批量恢复取消发送的邮件
	 */
	public int redo_AopLog (Map paramMap) {
		paramMap.put("state", ConfigConstants.SystemEmailState.UNAUDIT.value);
		paramMap.put("recordIds",  paramMap.get("recordIds"));
		int num = toolDaoTemplate.update("systemEmail.batchUpdate", paramMap);
		return num;
	}
}
