package  com.xianling.remoteservice.goods;

import javax.jws.WebService;

@WebService(serviceName="SendEquip")
public interface SendEquip {
	/**
	 * 
	 * @param roleIds 可以多人发送
	 * @param equipStr 装备字符串 (可以多件发送，也可以发送物品) 格式-> ID:数量:是否绑定:有限期:强化等级:品质:附加属性1,2,3,4,5,6;ID:数量:是否绑定:有限期:强化等级:品质:附加属性1,2,3,4,5,6
	 * @param subject 邮件标题
	 * @param content 邮件内容
	 * @return 1 成功 ，2 生成物品错误 3 参数不全
	 */
	public String sendEquip(String[] userIds,String equipStr,String subject, String content);

}
