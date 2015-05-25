package com.lingyu.dntg.util;

import java.util.HashMap;
import java.util.Map;

public class ConfigConstants {
	/**
	 * session中保存的user标识
	 */
	public static final String USER_SESSION = "curUser";
	/**
	 * session中保存当前服务器标识
	 */
	public static final String SELECTED_SERVER_KEY = "curServerId";
	/**
	 * 平台名
	 */
	public static final String PLAT = "XL_MANAGE";
	
	/**
	 * notice的group名
	 */
	public static final String GROUP_NAME = "notice-group";
	
	/**
	 * 统计批处理的记录数
	 */
	public static final int STATISTICS_BATCH_SQL_SIZE = 2000;
	
	
	
	public enum UserLevel {
		ADMIN_LEVEL(0), NORMAL_LEVEL(1);
		public int value;private UserLevel(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 货币类型
	 */
	public enum MoneyType {
		RECHARGE_YB(0,"元宝"),RECHARGE_BYB(1,"绑定元宝"),RECHARGE_JB(2,"金币");
		public static Map getMap(){
			Map map = new HashMap();
			for (MoneyType obj : MoneyType.values()) {
				map.put(obj.value, obj.name);
			}
			return map;
		}
		public int value;
		public String name;
		private MoneyType(int value, String name) {
			this.value = value;
			this.name = name;
		}
		public String toString() {
			return name;
		}
	}
	
	/**
	 * 充值类型
	 */
	public enum ChargeType {
		内部人员充值(2),玩家奖励充值(3),玩家补偿充值(4);
		public static Map getMap(){
			Map map = new HashMap();
			for (ChargeType obj : ChargeType.values()) {
				map.put(obj.value+"", obj.name());
			}
			return map;
		}
		public int value;private ChargeType(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 是否需要游戏服务器计算
	 */
	public enum Calc{
		NO(0),YES(1);
		public int value;private Calc(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 充值webService返回代码
	 */
	public enum RechargeResult{
		SUCCESS("1", "成功"),
		LESS_THAN_ZERO("1001", "充值小于零"),
		MORE_THAN_MAX("1002", "充值大于最大值20亿"),
		BUS_EXCEPTION("1003", "充值业务异常"),
		ORDER_REPEAT("1004", "订单号重复"),
		ACCOUNT_NOT_EXSIT("1005", "帐号不存在"),
		SERVER_ID_ERROR("99996","服务器ID错误");
		public String value;
		public String name;
		private RechargeResult(String value, String name) {
			this.value = value;
			this.name = name;
		}
		/**
		 * 通过返回代码得到文本内容
		 */
		public static String getName(String value){
			for (RechargeResult rechargeResult : RechargeResult.values()) {
				if (rechargeResult.value.equals(value) ) {
					return rechargeResult.name;
				}
			}
			return "";
		}
	}
	/**
	 * 充值结果
	 */
	public enum ChargeResult{
		SUCCESS(1),FAILUARE(0);
		public int value;private ChargeResult(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 系统邮件状态
	 */
	public enum SystemEmailState{
		SENT(0),//已发送(审批过)
		UNAUDIT(1),//待审批
		UNDO(2);//取消发送
		public int value;private SystemEmailState(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 充值审批状态(isAudit)
	 */
	public enum RechargeAudit{
		UNAUDIT(0),//没审批
		AUDITED(1),//审批通过
		NOPASS(2),//没有通过审批
		CANCEL(3),//取消
		DIRECT(10);//直接充值
		public int value;private RechargeAudit(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 适用服务器
	 */
	public enum NoticeServer{
		NOGLOBAL(0),//指定服务器
		GLOBAL(1);//全局服务器
		public int value;private NoticeServer(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	/**
	 * 公告类型
	 */
	public enum NoticeType{
		SYSTEM(0),//系统
		WORLD(1);//世界
		public int value;private NoticeType(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	public static void main(String[] args) {
		System.out.println(com.lingyu.dntg.util.ConfigConstants.NoticeType.SYSTEM.value);
	}
	
	/**
	 * 公告状态
	 */
	public enum NoticeStatus{
		READY(0,"尚未发布"),PUBLISH(1,"已发布"),GOING(2,"进行中"),FINISHED(3,"已正常结束"),CANCELED(4, "已取消"),PASS(10, "过期");
		public static Map getMap(){
			Map map = new HashMap();
			for (NoticeStatus obj : NoticeStatus.values()) {
				map.put(obj.value, obj.name);
			}
			return map;
		}
		public int value;
		public String name;
		private NoticeStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}
		public String toString() {
			return name;
		}
	}
	
	/**
	 * 明人堂type
	 */
	public enum MingRenTangConfigtype{
		ZHOUDOULI(1),//战力排行
		RECHARGE(2),//充值排行
		CONSUME(3);//消费排行
		public int value;private MingRenTangConfigtype(int value) {this.value = value;}public String toString() { return this.value + ""; }
	}
	
	
	/**
	 * 美人数量统计
	 */
	public static final String STATISTIC_MEIREN_KEY = "meiren";
	/**
	 * 神将数量统计
	 */
	public static final String STATISTIC_SHENJIANG_KEY = "shenjiang";
	/**
	 * 角色等级
	 */
	public static final String STATISTIC_ROLELEVEL_KEY = "level";
	/**
	 * 宝石
	 */
	public static final String STATISTIC_BAOSHI_KEY = "baoshilevel";
	
	
	public static Map<String, String> statisticEventTypeMap = new HashMap<String, String>();
	static{
		statisticEventTypeMap.put("zuoqilevel", "坐骑阶层分布");
		statisticEventTypeMap.put("viplevel", "VIP等级分布");
		statisticEventTypeMap.put("level", "角色等级分布");
//		statisticEventTypeMap.put("qibinglevel", "骑兵阶层分布");
//		statisticEventTypeMap.put("baoshiCount", "宝石等级分布");
		statisticEventTypeMap.put("qibinlevel", "骑兵阶层分布");
		statisticEventTypeMap.put(STATISTIC_BAOSHI_KEY, "宝石等级分布");
		statisticEventTypeMap.put("guangyilevel", "光翼等级分布");
		statisticEventTypeMap.put(STATISTIC_MEIREN_KEY, "美人数量统计");
		statisticEventTypeMap.put(STATISTIC_SHENJIANG_KEY, "神将数量统计");
	}
	
	/**
	 * yb_consume_2013-11-19 
	 */
	public static final String LOG_FILE_YB_CONSUME = "yb_consume_";
	
}
