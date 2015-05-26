package com.lingyu.dntg.service.ulm;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.pojo.OperationLog;
import com.lingyu.dntg.bean.pojo.SystemEmailPojo;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.bean.vo.SystemEmailVO;
import com.lingyu.dntg.service.AbstractService;

/**
 * aop拦截后保存日志记录
 * 定义的方法以名形式
 * <pre>
 * 	如UserService的updatePwd_AopLog方法 = "updatePwd" + "User" + "Log"
 * 方法中参数为:最后一个参数为方法返回值
 * </pre>
 * @author donghui
 */
@Component
public class OperationLogService extends AbstractService {

	/**
	 * 重置密码
	 */
	public void updatePwdUserLog(Map paramMap, Object returnVal){
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		this.saveLog("用户密码修改", "修改了用户[" + sessionUser.getUserName() + "]的密码");
	}

	/**
	 * 解除帮派
	 */
	public void deleteGuildLog(Map paramMap,Object returnVal){
		String serverId = paramMap.get("currentServerId").toString();
		String name = paramMap.get("name").toString();
		this.saveLog("解散帮派", "解除了["+serverId+"]服"+name+"帮派");
	}
	
	/**
	 * 系统邮件审批
	 * @param returnVal "000":输入有误,"001":角色名为空或角色不存在,null:正确, error 远程调用失败
	 */
	public void sendEmailSystemEmailLog(SystemEmailPojo sm, List<String> roleIds, String serverId, boolean isFull, String returnVal){
	    String state = (String)returnVal;
	    StringBuilder description = new StringBuilder("邮件[" + sm.getId() + "]");
	    if (state == "") {
	    	description.append("发送成功");
		}
	    else if ("000".equals(state)) {
	    	description.append("输入有误");
		}
	    else if("001".equals(state)){
	    	description.append("角色名为空或角色不存在");
	    }
	    else if("error".equals(state)){
	    	description.append("远程调用失败");
		}
	    this.saveLog("发送邮件", description.toString());
	}
	
	/**
	 * 申请发放
	 */
	public void saveSystemEmailLog (SystemEmailVO systemEmailVO, SystemEmailPojo returnVal) {
		this.saveLog("申请发放邮件","申请邮件id:[" + returnVal.getId() +"]");
	}	
	
	/**
	 * 批量取消
	 */
	public void undoSystemEmailLog (Map paramMap,Object returnVal) {
		String recordIds = paramMap.get("recordIds").toString();
		this.saveLog("批量取消邮件", "取消邮件:"+recordIds);
	}
	
	/**
	 * 批量恢复取消发送的邮件
	 */
	public void redoSystemEmailLog (Map paramMap,Object returnVal) {
		String recordIds = paramMap.get("recordIds").toString();
		this.saveLog("批量恢复邮件", "恢复邮件:"+recordIds);
	}
	
	/**
	 * 保存日志
	 */
	private void saveLog(String operation, String description){
        OperationLog operationLog = new OperationLog(operation, description);
        toolDaoTemplate.insert("operationLog.insert", operationLog);
        log.debug("成功插入日志记录:{}", operationLog);
	}
}