package com.xianling.remoteservice.email;

import java.util.List;

import javax.jws.WebService;

@WebService(serviceName="SystemEmail")
public interface SystemEmail {
	/**
	 * 发送邮件
	 * @return"000":输入有误,"001":角色名为空或角色不存在,null:正确
	 */
	public String systemEmail(int emailId,List<String> roleIds, int vipLevel,String subject, String content, int jb, int yb, String attachments, String serverId);
	
	/**
	 * 发送邮件
	 * @param type (0:非全服发送,1:全副发送)
	 * @return "000":输入有误,"001":角色名为空或角色不存在,null:正确
	 */
	public String systemEmail2(int emailId,List<String> roleIds, int vipLevel, String subject, String content, int jb, int yb, String attachments, String serverId,int type);
	/**
	 * 后台发送系统邮件
	 * @param emailId TODO
	 * @param receiveNames 接收者名字(name1, name2, ...)
	 * @param vipLevel VIP等级
	 * @param subject 标题
	 * @param content 内容
	 * @param bind 是否绑定(0:不绑定，1:绑定)
	 * @param jb 金币
	 * @param yb 元宝
	 * @param attachments 附件[ [goodsId, count],[goodsId, count]... ]
	 * @param type 0 || 1
	 * @param delayHours 延迟的小时数
	 * @return "000":输入有误,"001":角色名为空或角色不存在,null:正确
	 */
	public String systemEmail3(int emailId,List<String> roleIds, int vipLevel, String subject, String content, int jb, int yb, String attachments, String serverId,int type, int delayHours);
}
