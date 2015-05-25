package com.lingyu.dntg.constants.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StatisticsTaskGameEventTypeMapper {
	
	private static Map<String, EventTypeNode> eventTypeNodes = new HashMap<String,EventTypeNode>();
	private static Map<String, List<EventTypeNode>> statisticsEventTypeMap = new HashMap<String, List<EventTypeNode>>();
	private static Map<String, List<String>> statisticsEventTypeNameMap = new HashMap<String, List<String>>();
	
	static{
		
		initEventTypeNodes();
		buildMap();
		
	}
	
	/**
	 * 获取指定统计任务对应的事件类型
	 */
	public static List<EventTypeNode> getRelateEventTypes(String statisticsTaskName){
		
		return statisticsEventTypeMap.get(statisticsTaskName);
	}

	/**
	 * 指定事件是否和统计任务有关联
	 */
	public static boolean isRelated(String statisticsTaskName,String eventType){
		return statisticsEventTypeNameMap.get(statisticsTaskName).contains(eventType);
	}
	
	/**
	 * 初始化事件节点
	 */
	private static void initEventTypeNodes() {
		// TODO Auto-generated method stub
		eventTypeNodes.put(GameLogEventType.BOOTH_BUYYB,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_BUYYB, GameLogEventTypeName.BOOTH_BUYYB) );
		eventTypeNodes.put(GameLogEventType.BOOTH_SELLYB,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_SELLYB, GameLogEventTypeName.BOOTH_SELLYB) );
		eventTypeNodes.put(GameLogEventType.BOOTH_SELLJB,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_SELLJB, GameLogEventTypeName.BOOTH_SELLJB) );
		eventTypeNodes.put(GameLogEventType.BOOTH_BUYJB,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_BUYJB, GameLogEventTypeName.BOOTH_BUYJB) );
		eventTypeNodes.put(GameLogEventType.BOOTH_SELLGOODS,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_SELLGOODS, GameLogEventTypeName.BOOTH_SELLGOODS) );
		eventTypeNodes.put(GameLogEventType.BOOTH_BUGGOODS,new EventTypeNode("BOOTH", GameLogEventType.BOOTH_BUGGOODS, GameLogEventTypeName.BOOTH_BUGGOODS) );
		eventTypeNodes.put(GameLogEventType.BAG_DROP_GOODS,new EventTypeNode("BAG", GameLogEventType.BAG_DROP_GOODS, GameLogEventTypeName.BAG_DROP_GOODS) );
		eventTypeNodes.put(GameLogEventType.BAG_OPEN,new EventTypeNode("BAG", GameLogEventType.BAG_OPEN, GameLogEventTypeName.BAG_OPEN) );
		eventTypeNodes.put(GameLogEventType.BAOSHI_JIHUO,new EventTypeNode("BAOSHI", GameLogEventType.BAOSHI_JIHUO, GameLogEventTypeName.BAOSHI_JIHUO) );
		eventTypeNodes.put(GameLogEventType.BAOSHI_LEVEL_UPGRADE,new EventTypeNode("BAOSHI", GameLogEventType.BAOSHI_LEVEL_UPGRADE, GameLogEventTypeName.BAOSHI_LEVEL_UPGRADE) );
		eventTypeNodes.put(GameLogEventType.EMAIL_CREATE,new EventTypeNode("EMAIL", GameLogEventType.EMAIL_CREATE, GameLogEventTypeName.EMAIL_CREATE) );
		eventTypeNodes.put(GameLogEventType.EMAIL_DELETE,new EventTypeNode("EMAIL", GameLogEventType.EMAIL_DELETE, GameLogEventTypeName.EMAIL_DELETE) );
		eventTypeNodes.put(GameLogEventType.EMAIL_READ,new EventTypeNode("EMAIL", GameLogEventType.EMAIL_READ, GameLogEventTypeName.EMAIL_READ) );
		eventTypeNodes.put(GameLogEventType.EMAIL_GET_ITEM,new EventTypeNode("EMAIL", GameLogEventType.EMAIL_GET_ITEM, GameLogEventTypeName.EMAIL_GET_ITEM) );
		eventTypeNodes.put(GameLogEventType.EQUIP_JIANDING,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_JIANDING, GameLogEventTypeName.EQUIP_JIANDING) );
		eventTypeNodes.put(GameLogEventType.EQUIP_JIANDING_QINGXI,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_JIANDING_QINGXI, GameLogEventTypeName.EQUIP_JIANDING_QINGXI) );
		eventTypeNodes.put(GameLogEventType.EQUIP_JINJIE,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_JINJIE, GameLogEventTypeName.EQUIP_JINJIE) );
		eventTypeNodes.put(GameLogEventType.EQUIP_QIANGHUA,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_QIANGHUA, GameLogEventTypeName.EQUIP_QIANGHUA) );
		eventTypeNodes.put(GameLogEventType.EQUIP_QIANGHUA_QINGXI,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_QIANGHUA_QINGXI, GameLogEventTypeName.EQUIP_QIANGHUA_QINGXI) );
		eventTypeNodes.put(GameLogEventType.GONGHUI_TASK_FINISH,new EventTypeNode("GONGHUITASK", GameLogEventType.GONGHUI_TASK_FINISH, GameLogEventTypeName.GONGHUI_TASK_FINISH) );
		eventTypeNodes.put(GameLogEventType.GOODS_EXCHANGE,new EventTypeNode("EXCHANGE", GameLogEventType.GOODS_EXCHANGE, GameLogEventTypeName.GOODS_EXCHANGE) );
		eventTypeNodes.put(GameLogEventType.HUODONG_REWARDS,new EventTypeNode("HUODONG", GameLogEventType.HUODONG_REWARDS, GameLogEventTypeName.HUODONG_REWARDS) );
		eventTypeNodes.put(GameLogEventType.HUSONG_FAIL_AWARDS,new EventTypeNode("HUSONG", GameLogEventType.HUSONG_FAIL_AWARDS, GameLogEventTypeName.HUSONG_FAIL_AWARDS) );
		eventTypeNodes.put(GameLogEventType.HUSONG_SUCCESS_AWARDS,new EventTypeNode("HUSONG", GameLogEventType.HUSONG_SUCCESS_AWARDS, GameLogEventTypeName.HUSONG_SUCCESS_AWARDS) );
		eventTypeNodes.put(GameLogEventType.HUSONG_STEAL_AWARDS,new EventTypeNode("HUSONG", GameLogEventType.HUSONG_STEAL_AWARDS, GameLogEventTypeName.HUSONG_STEAL_AWARDS) );
		eventTypeNodes.put(GameLogEventType.HUSONG_SELECT,new EventTypeNode("HUSONG", GameLogEventType.HUSONG_SELECT, GameLogEventTypeName.HUSONG_SELECT) );
		eventTypeNodes.put(GameLogEventType.HUSONG_REFRESH,new EventTypeNode("HUSONG", GameLogEventType.HUSONG_REFRESH, GameLogEventTypeName.HUSONG_REFRESH) );
		eventTypeNodes.put(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY,new EventTypeNode("JIANGLI", GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY, GameLogEventTypeName.JIANGLI_ONLINE_REWARD_MONEY) );
		eventTypeNodes.put(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS,new EventTypeNode("JIANGLI", GameLogEventType.JIANGLI_QIANDAO_GET_GOODS, GameLogEventTypeName.JIANGLI_QIANDAO_GET_GOODS) );
		eventTypeNodes.put(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS,new EventTypeNode("JIANGLI", GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS, GameLogEventTypeName.JIANGLI_YAOJIANG_GET_GOODS) );
		eventTypeNodes.put(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS,new EventTypeNode("JIANGLI", GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS, GameLogEventTypeName.JIANGLI_ZHOUMO_QIANDAO_GETGOODS) );
		eventTypeNodes.put(GameLogEventType.JUQING_FINISH,new EventTypeNode("JUQING", GameLogEventType.JUQING_FINISH, GameLogEventTypeName.JUQING_FINISH) );
		eventTypeNodes.put(GameLogEventType.JUQINGFUBEN_ACCELERATE,new EventTypeNode("JUQING", GameLogEventType.JUQINGFUBEN_ACCELERATE, GameLogEventTypeName.JUQINGFUBEN_ACCELERATE) );
		eventTypeNodes.put(GameLogEventType.JUQINGFUBEN_AWARD,new EventTypeNode("JUQING", GameLogEventType.JUQINGFUBEN_AWARD, GameLogEventTypeName.JUQINGFUBEN_AWARD) );
		eventTypeNodes.put(GameLogEventType.LVLIBAO_LINGQU,new EventTypeNode("LVLIBAO", GameLogEventType.LVLIBAO_LINGQU, GameLogEventTypeName.LVLIBAO_LINGQU) );
		eventTypeNodes.put(GameLogEventType.MALL_BUY,new EventTypeNode("MALL", GameLogEventType.MALL_BUY, GameLogEventTypeName.MALL_BUY) );
		eventTypeNodes.put(GameLogEventType.MEIREN_CHANMIAN,new EventTypeNode("MEIREN", GameLogEventType.MEIREN_CHANMIAN, GameLogEventTypeName.MEIREN_CHANMIAN) );
		eventTypeNodes.put(GameLogEventType.MEIREN_LINGQU,new EventTypeNode("MEIREN", GameLogEventType.MEIREN_LINGQU, GameLogEventTypeName.MEIREN_LINGQU) );
		eventTypeNodes.put(GameLogEventType.MEIREN_UPGRADE,new EventTypeNode("MEIREN", GameLogEventType.MEIREN_UPGRADE, GameLogEventTypeName.MEIREN_UPGRADE) );
		eventTypeNodes.put(GameLogEventType.PROP_USE,new EventTypeNode("PROP", GameLogEventType.PROP_USE, GameLogEventTypeName.PROP_USE) );
		eventTypeNodes.put(GameLogEventType.PROP_USE_ACQUIRE,new EventTypeNode("PROP", GameLogEventType.PROP_USE_ACQUIRE, GameLogEventTypeName.PROP_USE_ACQUIRE) );
		eventTypeNodes.put(GameLogEventType.RECHARGE_YB,new EventTypeNode("RECHARGE", GameLogEventType.RECHARGE_YB, GameLogEventTypeName.RECHARGE_YB) );
		eventTypeNodes.put(GameLogEventType.ROLE_CREATE,new EventTypeNode("ROLE", GameLogEventType.ROLE_CREATE, GameLogEventTypeName.ROLE_CREATE) );
		eventTypeNodes.put(GameLogEventType.ROLE_LEVEL_UPGRADE,new EventTypeNode("ROLE", GameLogEventType.ROLE_LEVEL_UPGRADE, GameLogEventTypeName.ROLE_LEVEL_UPGRADE) );
		eventTypeNodes.put(GameLogEventType.ROLE_LOGIN,new EventTypeNode("ROLE", GameLogEventType.ROLE_LOGIN, GameLogEventTypeName.ROLE_LOGIN) );
		eventTypeNodes.put(GameLogEventType.ROLE_LOGOUT,new EventTypeNode("ROLE", GameLogEventType.ROLE_LOGOUT, GameLogEventTypeName.ROLE_LOGOUT) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_ACTIVATE,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_ACTIVATE, GameLogEventTypeName.SHENJIANG_ACTIVATE) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_ACTIVATE_FAIL,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_ACTIVATE_FAIL, GameLogEventTypeName.SHENJIANG_ACTIVATE_FAIL) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_JIHUO_JXT,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_JIHUO_JXT, GameLogEventTypeName.SHENJIANG_JIHUO_JXT) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL, GameLogEventTypeName.SHENJIANG_JIHUO_JXT_FAIL) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_JXT_DECR,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_JXT_DECR, GameLogEventTypeName.SHENJIANG_JXT_DECR) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_JXT_EXP_SHARE,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_JXT_EXP_SHARE, GameLogEventTypeName.SHENJIANG_JXT_EXP_SHARE) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_SKILL_UPGRADE,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_SKILL_UPGRADE, GameLogEventTypeName.SHENJIANG_SKILL_UPGRADE) );
		eventTypeNodes.put(GameLogEventType.SHENJIANG_SKILL_UPGRADE_DECR,new EventTypeNode("SHENJIANG", GameLogEventType.SHENJIANG_SKILL_UPGRADE_DECR, GameLogEventTypeName.SHENJIANG_SKILL_UPGRADE_DECR) );
		eventTypeNodes.put(GameLogEventType.SHENJIANGJINDI_AWARD,new EventTypeNode("JINDI", GameLogEventType.SHENJIANGJINDI_AWARD, GameLogEventTypeName.SHENJIANGJINDI_AWARD) );
		eventTypeNodes.put(GameLogEventType.SHENJIANGJINDI_ENTER,new EventTypeNode("JINDI", GameLogEventType.SHENJIANGJINDI_ENTER, GameLogEventTypeName.SHENJIANGJINDI_ENTER) );
		eventTypeNodes.put(GameLogEventType.SHENJIANGJINDI_GATHERBOSS,new EventTypeNode("JINDI", GameLogEventType.SHENJIANGJINDI_GATHERBOSS, GameLogEventTypeName.SHENJIANGJINDI_GATHERBOSS) );
		eventTypeNodes.put(GameLogEventType.STAGE_GATHER,new EventTypeNode("STAGE", GameLogEventType.STAGE_GATHER, GameLogEventTypeName.STAGE_GATHER) );
		eventTypeNodes.put(GameLogEventType.STAGE_PICKUP_GOODS,new EventTypeNode("STAGE", GameLogEventType.STAGE_PICKUP_GOODS, GameLogEventTypeName.STAGE_PICKUP_GOODS) );
		eventTypeNodes.put(GameLogEventType.STAGE_PICKUP_YXB,new EventTypeNode("STAGE", GameLogEventType.STAGE_PICKUP_YXB, GameLogEventTypeName.STAGE_PICKUP_YXB) );
		eventTypeNodes.put(GameLogEventType.STAGE_ROLE_REVIVE,new EventTypeNode("STAGE", GameLogEventType.STAGE_ROLE_REVIVE, GameLogEventTypeName.STAGE_ROLE_REVIVE) );
		eventTypeNodes.put(GameLogEventType.STAGE_ROLE_TELEPORT,new EventTypeNode("STAGE", GameLogEventType.STAGE_ROLE_TELEPORT, GameLogEventTypeName.STAGE_ROLE_TELEPORT) );
		eventTypeNodes.put(GameLogEventType.STAGE_ZUOQI_RECOVERYHP,new EventTypeNode("STAGE", GameLogEventType.STAGE_ZUOQI_RECOVERYHP, GameLogEventTypeName.STAGE_ZUOQI_RECOVERYHP) );
		eventTypeNodes.put(GameLogEventType.STAGE_ZUOQI_REVIVE,new EventTypeNode("STAGE", GameLogEventType.STAGE_ZUOQI_REVIVE, GameLogEventTypeName.STAGE_ZUOQI_REVIVE) );
		eventTypeNodes.put(GameLogEventType.SKILL_UPGRADE,new EventTypeNode("SKILL", GameLogEventType.SKILL_UPGRADE, GameLogEventTypeName.SKILL_UPGRADE) );
		eventTypeNodes.put(GameLogEventType.SKILL_USE_BOOK,new EventTypeNode("SKILL", GameLogEventType.SKILL_USE_BOOK, GameLogEventTypeName.SKILL_USE_BOOK) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_COMPLETE,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_COMPLETE, GameLogEventTypeName.TASK_RICHANG_COMPLETE) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_COMPLETEBEST,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_COMPLETEBEST, GameLogEventTypeName.TASK_RICHANG_COMPLETEBEST) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_DECREASEDIFF,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_DECREASEDIFF, GameLogEventTypeName.TASK_RICHANG_DECREASEDIFF) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_KUAISUFINISH,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_KUAISUFINISH, GameLogEventTypeName.TASK_RICHANG_KUAISUFINISH) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_ZHIJIEFINISH, GameLogEventTypeName.TASK_RICHANG_ZHIJIEFINISH) );
		eventTypeNodes.put(GameLogEventType.TASK_MAIN_FINISH,new EventTypeNode("TASK", GameLogEventType.TASK_MAIN_FINISH, GameLogEventTypeName.TASK_MAIN_FINISH) );
		eventTypeNodes.put(GameLogEventType.TASK_TAOFA_FINISH,new EventTypeNode("TASK", GameLogEventType.TASK_TAOFA_FINISH, GameLogEventTypeName.TASK_TAOFA_FINISH) );
		eventTypeNodes.put(GameLogEventType.TASK_RICHANG_FINISH,new EventTypeNode("TASK", GameLogEventType.TASK_RICHANG_FINISH, GameLogEventTypeName.TASK_RICHANG_FINISH) );
		eventTypeNodes.put(GameLogEventType.TRADE,new EventTypeNode("TRADE", GameLogEventType.TRADE, GameLogEventTypeName.TRADE) );
		eventTypeNodes.put(GameLogEventType.VIP_BUY_LIBAO,new EventTypeNode("VIP", GameLogEventType.VIP_BUY_LIBAO, GameLogEventTypeName.VIP_BUY_LIBAO) );
		eventTypeNodes.put(GameLogEventType.VIP_LINGQU_DAYLIBAO,new EventTypeNode("VIP", GameLogEventType.VIP_LINGQU_DAYLIBAO, GameLogEventTypeName.VIP_LINGQU_DAYLIBAO) );
		eventTypeNodes.put(GameLogEventType.VIP_LINGQU_WEEKLIBAO,new EventTypeNode("VIP", GameLogEventType.VIP_LINGQU_WEEKLIBAO, GameLogEventTypeName.VIP_LINGQU_WEEKLIBAO) );	
		eventTypeNodes.put(GameLogEventType.ZUOQI_JINJIE, new EventTypeNode("ZUOQI", GameLogEventType.ZUOQI_JINJIE, GameLogEventTypeName.ZUOQI_JINJIE));
		
		eventTypeNodes.put(GameLogEventType.GUILD_CONTRIBUTE_GOODS, new EventTypeNode("GUILD", GameLogEventType.GUILD_CONTRIBUTE_GOODS, GameLogEventTypeName.GUILD_CONTRIBUTE_GOODS));
		eventTypeNodes.put(GameLogEventType.GUILD_CONTRIBUTE_MONEY, new EventTypeNode("GUILD", GameLogEventType.GUILD_CONTRIBUTE_MONEY, GameLogEventTypeName.GUILD_CONTRIBUTE_MONEY));
		eventTypeNodes.put(GameLogEventType.GUILD_CREATE_DECR_MONEY, new EventTypeNode("GUILD", GameLogEventType.GUILD_CREATE_DECR_MONEY, GameLogEventTypeName.GUILD_CREATE_DECR_MONEY));
	
		eventTypeNodes.put(GameLogEventType.GUOZHAN_LINGJIANG, new EventTypeNode("GUOZHAN", GameLogEventType.GUOZHAN_LINGJIANG, GameLogEventTypeName.GUOZHAN_LINGJIANG));
		eventTypeNodes.put(GameLogEventType.STAGE_DEAD_DROPYXB, new EventTypeNode("STAGE", GameLogEventType.STAGE_DEAD_DROPYXB, GameLogEventTypeName.STAGE_DEAD_DROPYXB));
	
		eventTypeNodes.put(GameLogEventType.ATTRIBUTEBUFF_CHANGE, new EventTypeNode("ATTRIBUTEBUFF", GameLogEventType.ATTRIBUTEBUFF_CHANGE, GameLogEventTypeName.ATTRIBUTEBUFF_CHANGE));

		eventTypeNodes.put(GameLogEventType.TOUBAO_LEVEL, new EventTypeNode("TOUBAO", GameLogEventType.TOUBAO_LEVEL, GameLogEventTypeName.TOUBAO_LEVEL));
		eventTypeNodes.put(GameLogEventType.TOUBAO_LINGQU_LEVEL, new EventTypeNode("TOUBAO", GameLogEventType.TOUBAO_LINGQU_LEVEL, GameLogEventTypeName.TOUBAO_LINGQU_LEVEL));
		eventTypeNodes.put(GameLogEventType.TOUBAO_LINGQU_MONTH, new EventTypeNode("TOUBAO", GameLogEventType.TOUBAO_LINGQU_MONTH, GameLogEventTypeName.TOUBAO_LINGQU_MONTH));
		eventTypeNodes.put(GameLogEventType.TOUBAO_MONTH, new EventTypeNode("TOUBAO", GameLogEventType.TOUBAO_MONTH, GameLogEventTypeName.TOUBAO_MONTH));
		
		eventTypeNodes.put(GameLogEventType.BAIXIAN_REWARD, new EventTypeNode("BAIXIAN", GameLogEventType.BAIXIAN_REWARD, GameLogEventTypeName.BAIXIAN_REWARD));
		
		eventTypeNodes.put(GameLogEventType.QIZHANBINQI_UPGRADE, new EventTypeNode("QIZHANBINGQI", GameLogEventType.QIZHANBINQI_UPGRADE, GameLogEventTypeName.QIZHANBINQI_UPGRADE));

		eventTypeNodes.put(GameLogEventType.LINGDIZHAN_AWARD, new EventTypeNode("LINGDIZHAN", GameLogEventType.LINGDIZHAN_AWARD, GameLogEventTypeName.LINGDIZHAN_AWARD));

		eventTypeNodes.put(GameLogEventType.HUODONG_MALL_BUY, new EventTypeNode("HUODONG", GameLogEventType.HUODONG_MALL_BUY, GameLogEventTypeName.HUODONG_MALL_BUY));
		
		eventTypeNodes.put(GameLogEventType.STAGE_MEIREN_RECOVERYHP, new EventTypeNode("STAGE", GameLogEventType.STAGE_MEIREN_RECOVERYHP, GameLogEventTypeName.STAGE_MEIREN_RECOVERYHP));
		eventTypeNodes.put(GameLogEventType.STAGE_MEIREN_REVIVE, new EventTypeNode("STAGE", GameLogEventType.STAGE_MEIREN_REVIVE, GameLogEventTypeName.STAGE_MEIREN_REVIVE));
		
		eventTypeNodes.put(GameLogEventType.VIP_HUODONG_CHOUJIANG, new EventTypeNode("VIP", GameLogEventType.VIP_HUODONG_CHOUJIANG, GameLogEventTypeName.VIP_HUODONG_CHOUJIANG));
		eventTypeNodes.put(GameLogEventType.VIP_HUODONG_LINGQU, new EventTypeNode("VIP", GameLogEventType.VIP_HUODONG_LINGQU, GameLogEventTypeName.VIP_HUODONG_LINGQU));
		eventTypeNodes.put(GameLogEventType.VIP_QQ_GET_REWARDS, new EventTypeNode("VIP", GameLogEventType.VIP_QQ_GET_REWARDS, GameLogEventTypeName.VIP_QQ_GET_REWARDS));
		
		eventTypeNodes.put(GameLogEventType.CHENGJIU_FINISH, new EventTypeNode("CHENGJIU", GameLogEventType.CHENGJIU_FINISH, GameLogEventTypeName.CHENGJIU_FINISH));
		
		eventTypeNodes.put(GameLogEventType.GIFT_CODE_REWARDS, new EventTypeNode("GIFTCODE", GameLogEventType.GIFT_CODE_REWARDS, GameLogEventTypeName.GIFT_CODE_REWARDS));
		
		eventTypeNodes.put(GameLogEventType.GOODS_BUY_BACK, new EventTypeNode("BAG", GameLogEventType.GOODS_BUY_BACK, GameLogEventTypeName.GOODS_BUY_BACK));
		eventTypeNodes.put(GameLogEventType.GOODS_SELL, new EventTypeNode("BAG", GameLogEventType.GOODS_SELL, GameLogEventTypeName.GOODS_SELL));
		

		eventTypeNodes.put(GameLogEventType.HUOYUEDU_MIAOSHA, new EventTypeNode("XIANJIE", GameLogEventType.HUOYUEDU_MIAOSHA, GameLogEventTypeName.HUOYUEDU_MIAOSHA));
		eventTypeNodes.put(GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN, new EventTypeNode("XIANJIE", GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN, GameLogEventTypeName.XIANJIE_CHENGHAO_DUIHUAN));
		eventTypeNodes.put(GameLogEventType.XIANJIE_CHENGHAO_JIHUO, new EventTypeNode("XIANJIE", GameLogEventType.XIANJIE_CHENGHAO_JIHUO, GameLogEventTypeName.XIANJIE_CHENGHAO_JIHUO));
		eventTypeNodes.put(GameLogEventType.XIANJIE_CHENGHAO_QIYONG, new EventTypeNode("XIANJIE", GameLogEventType.XIANJIE_CHENGHAO_QIYONG, GameLogEventTypeName.XIANJIE_CHENGHAO_QIYONG));
		eventTypeNodes.put(GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG, new EventTypeNode("XIANJIE", GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG, GameLogEventTypeName.XIANJIE_HUOYUEDU_LINJIANG));

		eventTypeNodes.put(GameLogEventType.HUODONG_RANK_AWARD,new EventTypeNode("HUODONG", GameLogEventType.HUODONG_RANK_AWARD, GameLogEventTypeName.HUODONG_RANK_AWARD) );
		
		eventTypeNodes.put(GameLogEventType.EQUIP_CAILIAPJIANDING,new EventTypeNode("EQUIP", GameLogEventType.EQUIP_CAILIAPJIANDING, GameLogEventTypeName.EQUIP_CAILIAPJIANDING) );
		eventTypeNodes.put(GameLogEventType.JINGJI_BUYCOUNT,new EventTypeNode("JINGJI", GameLogEventType.JINGJI_BUYCOUNT, GameLogEventTypeName.JINGJI_BUYCOUNT) );
		eventTypeNodes.put(GameLogEventType.JINGJI_CLEARCD,new EventTypeNode("JINGJI", GameLogEventType.JINGJI_CLEARCD, GameLogEventTypeName.JINGJI_CLEARCD) );
		eventTypeNodes.put(GameLogEventType.JINGJI_EVERYDAY_REWARD,new EventTypeNode("JINGJI", GameLogEventType.JINGJI_EVERYDAY_REWARD, GameLogEventTypeName.JINGJI_EVERYDAY_REWARD) );
		eventTypeNodes.put(GameLogEventType.JINGJI_EVERYHOUR_REWARD,new EventTypeNode("JINGJI", GameLogEventType.JINGJI_EVERYHOUR_REWARD, GameLogEventTypeName.JINGJI_EVERYHOUR_REWARD) );
		eventTypeNodes.put(GameLogEventType.JINGJI_REFRESHZHANLI,new EventTypeNode("JINGJI", GameLogEventType.JINGJI_REFRESHZHANLI, GameLogEventTypeName.JINGJI_REFRESHZHANLI) );

		eventTypeNodes.put(GameLogEventType.WEIDUAN_REWARD,new EventTypeNode("LINGJIANG", GameLogEventType.WEIDUAN_REWARD, GameLogEventTypeName.WEIDUAN_REWARD) );
		

		eventTypeNodes.put(GameLogEventType.VIP_KAIFU_CHOUJIANG,new EventTypeNode("VIP", GameLogEventType.VIP_KAIFU_CHOUJIANG, GameLogEventTypeName.VIP_KAIFU_CHOUJIANG) );
		eventTypeNodes.put(GameLogEventType.VIP_KAIFU_LINGQU,new EventTypeNode("VIP", GameLogEventType.VIP_KAIFU_LINGQU, GameLogEventTypeName.VIP_KAIFU_LINGQU) );
		
		eventTypeNodes.put(GameLogEventType.ZUOQI_UPGRADE_FANHUAN,new EventTypeNode("ZUOQI", GameLogEventType.ZUOQI_UPGRADE_FANHUAN, GameLogEventTypeName.ZUOQI_UPGRADE_FANHUAN) );
		
		eventTypeNodes.put(GameLogEventType.XUNBAO_GET_REWARDS,new EventTypeNode("XUNBAO", GameLogEventType.XUNBAO_GET_REWARDS, GameLogEventTypeName.XUNBAO_GET_REWARDS) );

		eventTypeNodes.put(GameLogEventType.LOGIN_REWARD_7,new EventTypeNode("LOGIN_REWARD_7", GameLogEventType.LOGIN_REWARD_7, GameLogEventTypeName.LOGIN_REWARD_7) );
		eventTypeNodes.put(GameLogEventType.DAFUWONG_YAOJIANG,new EventTypeNode("DAFUWENG", GameLogEventType.DAFUWONG_YAOJIANG, GameLogEventTypeName.DAFUWONG_YAOJIANG) );
		eventTypeNodes.put(GameLogEventType.DAFUWONG_DUIHUAN,new EventTypeNode("DAFUWENG", GameLogEventType.DAFUWONG_DUIHUAN, GameLogEventTypeName.DAFUWONG_DUIHUAN) );
		eventTypeNodes.put(GameLogEventType.TOUXIAN_CHANGE,new EventTypeNode("TOUXIAN", GameLogEventType.TOUXIAN_CHANGE, GameLogEventTypeName.TOUXIAN_CHANGE) );
		eventTypeNodes.put(GameLogEventType.QISHENG_KILL_BOSS_REWARD,new EventTypeNode("QISHENG_KILL", GameLogEventType.QISHENG_KILL_BOSS_REWARD, GameLogEventTypeName.QISHENG_KILL_BOSS_REWARD) );
		eventTypeNodes.put(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR,new EventTypeNode("GUANGYI", GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR, GameLogEventTypeName.GUANGYI_UPGRADE_LEVEL_DECR) );
		eventTypeNodes.put(GameLogEventType.ZYDHUIHUAN_ZHUIHUI,new EventTypeNode("ZIYUANZHUIHUI", GameLogEventType.ZYDHUIHUAN_ZHUIHUI, GameLogEventTypeName.ZYDHUIHUAN_ZHUIHUI) );

		eventTypeNodes.put(GameLogEventType.HEFUHUODONG_REWARD,new EventTypeNode("HEFUHUODONG", GameLogEventType.HEFUHUODONG_REWARD, GameLogEventTypeName.HEFUHUODONG_REWARD) );
		eventTypeNodes.put(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE,new EventTypeNode("HEFUHUODONG", GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE, GameLogEventTypeName.SHENMIZHUANPAN_CHANGE_RESOURCE) );
		eventTypeNodes.put(GameLogEventType.SHENMISHOP_BUY,new EventTypeNode("HEFUHUODONG", GameLogEventType.SHENMISHOP_BUY, GameLogEventTypeName.SHENMISHOP_BUY) );
		eventTypeNodes.put(GameLogEventType.SHENMISHOP_REFRESH,new EventTypeNode("HEFUHUODONG", GameLogEventType.SHENMISHOP_REFRESH, GameLogEventTypeName.SHENMISHOP_REFRESH) );

		eventTypeNodes.put(GameLogEventType.ZUWU_JINGJIE,new EventTypeNode("ZUWU", GameLogEventType.ZUWU_JINGJIE, GameLogEventTypeName.ZUWU_JINGJIE) );
		eventTypeNodes.put(GameLogEventType.ZUWUFUBEN_FINISH,new EventTypeNode("ZUWU", GameLogEventType.ZUWUFUBEN_FINISH, GameLogEventTypeName.ZUWUFUBEN_FINISH) );
		eventTypeNodes.put(GameLogEventType.ZUWUFUBEN_REFRESH,new EventTypeNode("ZUWU", GameLogEventType.ZUWUFUBEN_REFRESH, GameLogEventTypeName.ZUWUFUBEN_REFRESH) );
		eventTypeNodes.put(GameLogEventType.SKILL_BOOK_TUNSHI,new EventTypeNode("SKILLBOOK", GameLogEventType.SKILL_BOOK_TUNSHI, GameLogEventTypeName.SKILL_BOOK_TUNSHI) );
	
		eventTypeNodes.put(GameLogEventType.XUNBAO_ACTIVATE,new EventTypeNode("XUNBAOACTIVATE", GameLogEventType.XUNBAO_ACTIVATE, GameLogEventTypeName.XUNBAO_ACTIVATE) );
		eventTypeNodes.put(GameLogEventType.GUILDFUBEN_REWARD,new EventTypeNode("GUILDFUBENREWARD", GameLogEventType.GUILDFUBEN_REWARD, GameLogEventTypeName.GUILDFUBEN_REWARD) );
	
		eventTypeNodes.put(GameLogEventType.XIANSHIBUY_DECR,new EventTypeNode("XIANSHIBUY", GameLogEventType.XIANSHIBUY_DECR, GameLogEventTypeName.XIANSHIBUY_DECR) );
	
		eventTypeNodes.put(GameLogEventType.GOODS_HECHENG,new EventTypeNode("GOODS_HECHENG", GameLogEventType.GOODS_HECHENG, GameLogEventTypeName.GOODS_HECHENG) );
	
//		eventTypeNodes.put(GameLogEventType.BOOTH_SELL_YB,new EventTypeNode("BOOTH_SELL_YB", GameLogEventType.BOOTH_SELL_YB, GameLogEventTypeName.BOOTH_SELL_YB) );
//		eventTypeNodes.put(GameLogEventType.BOOTH_SELL_YXB,new EventTypeNode("BOOTH_SELL_YXB", GameLogEventType.BOOTH_SELL_YXB, GameLogEventTypeName.BOOTH_SELL_YXB) );
		
		
		eventTypeNodes.put(GameLogEventType.YINGYIN_REWARD,new EventTypeNode("YINGYIN_REWARD", GameLogEventType.YINGYIN_REWARD, GameLogEventTypeName.YINGYIN_REWARD) );
		eventTypeNodes.put(GameLogEventType.PHONE_REWARD,new EventTypeNode("PHONEREWARD", GameLogEventType.PHONE_REWARD, GameLogEventTypeName.PHONE_REWARD) );
	
		eventTypeNodes.put(GameLogEventType.CHANGE72_BUY,new EventTypeNode("CHANGE72BUY", GameLogEventType.CHANGE72_BUY, GameLogEventTypeName.CHANGE72_BUY) );
		eventTypeNodes.put(GameLogEventType.QIANFUHUODONG_REWARD,new EventTypeNode("QIANFUHUODONG_REWARD", GameLogEventType.QIANFUHUODONG_REWARD, GameLogEventTypeName.QIANFUHUODONG_REWARD) );
		eventTypeNodes.put(GameLogEventType.KAPAI_DUIHUAN,new EventTypeNode("KAPAI_DUIHUAN", GameLogEventType.KAPAI_DUIHUAN, GameLogEventTypeName.KAPAI_DUIHUAN) );
		eventTypeNodes.put(GameLogEventType.LIANCHOU_CHANGE_RESOURCE,new EventTypeNode("LIANCHOU_CHANGE_RESOURCE", GameLogEventType.LIANCHOU_CHANGE_RESOURCE, GameLogEventTypeName.LIANCHOU_CHANGE_RESOURCE) );
		eventTypeNodes.put(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE,new EventTypeNode("XIANSHITUO_CHANGE_RESOURCE", GameLogEventType.XIANSHITUO_CHANGE_RESOURCE, GameLogEventTypeName.XIANSHITUO_CHANGE_RESOURCE) );
		
		eventTypeNodes.put(GameLogEventType.YUANSHEN_UPGRADE_LEVEL,new EventTypeNode("YUANSHEN_UPGRADE_LEVEL", GameLogEventType.YUANSHEN_UPGRADE_LEVEL, GameLogEventTypeName.YUANSHEN_UPGRADE_LEVEL) );
		eventTypeNodes.put(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS,new EventTypeNode("CANGBAOGE_DUIHUAN_GOODS", GameLogEventType.CANGBAOGE_DUIHUAN_GOODS, GameLogEventTypeName.CANGBAOGE_DUIHUAN_GOODS) );
		eventTypeNodes.put(GameLogEventType.XUNBAO_JIFEN_GAIN,new EventTypeNode("XUNBAO_JIFEN_GAIN", GameLogEventType.XUNBAO_JIFEN_GAIN, GameLogEventTypeName.XUNBAO_JIFEN_GAIN) );
		eventTypeNodes.put(GameLogEventType.LOGIN_LIBAO,new EventTypeNode("LOGIN_LIBAO", GameLogEventType.LOGIN_LIBAO, GameLogEventTypeName.LOGIN_LIBAO) );
		eventTypeNodes.put(GameLogEventType.KUAFU_LINGJIANG_DECRYB,new EventTypeNode("KUAFU_LINGJIANG_DECRYB", GameLogEventType.KUAFU_LINGJIANG_DECRYB, GameLogEventTypeName.KUAFU_LINGJIANG_DECRYB) );
		eventTypeNodes.put(GameLogEventType.XUNBAO_TIANMING_REWARDS,new EventTypeNode("XUNBAO_TIANMING_REWARDS", GameLogEventType.XUNBAO_TIANMING_REWARDS, GameLogEventTypeName.XUNBAO_TIANMING_REWARDS) );
		eventTypeNodes.put(GameLogEventType.JC_ACTIVITY_REWARD,new EventTypeNode("JC_ACTIVITY_REWARD", GameLogEventType.JC_ACTIVITY_REWARD, GameLogEventTypeName.JC_ACTIVITY_REWARD) );

		eventTypeNodes.put(GameLogEventType.SIX_ZHUANPAN_ZHUAN,new EventTypeNode("SIX_ZHUANPAN_ZHUAN", GameLogEventType.SIX_ZHUANPAN_ZHUAN, GameLogEventTypeName.SIX_ZHUANPAN_ZHUAN) );
		eventTypeNodes.put(GameLogEventType.SIX_ZHUANPAN_FLUSH,new EventTypeNode("JC_ACTIVITY_REWARD", GameLogEventType.SIX_ZHUANPAN_FLUSH, GameLogEventTypeName.SIX_ZHUANPAN_FLUSH) );
		eventTypeNodes.put(GameLogEventType.MALL_BUY2,new EventTypeNode("MALL_BUY2", GameLogEventType.MALL_BUY2, GameLogEventTypeName.MALL_BUY2) );
		eventTypeNodes.put(GameLogEventType.ZHIZUN_REWARD,new EventTypeNode("ZHIZUN_REWARD", GameLogEventType.ZHIZUN_REWARD, GameLogEventTypeName.ZHIZUN_REWARD) );
		
		eventTypeNodes.put(GameLogEventType.SHENQI_JINJIE_CONSUME,new EventTypeNode("SHENQI_JINJIE_CONSUME", GameLogEventType.SHENQI_JINJIE_CONSUME, GameLogEventTypeName.SHENQI_JINJIE_CONSUME) );
		eventTypeNodes.put(GameLogEventType.GOODS_HECHENG_SHENDAN,new EventTypeNode("GOODS_HECHENG_SHENDAN", GameLogEventType.GOODS_HECHENG_SHENDAN, GameLogEventTypeName.GOODS_HECHENG_SHENDAN) );

	}
	
	private static void buildMap() {
		//消耗YB
		buildYbComsumeMap();
		//获得YB
		buildYbGainMap();
		
		//YXB
		buildYxbConsumeMap();
		//YXB
		buildYxbGainMap();
		
		//BindYB
		buildBindYbConsumeMap();
		//BindYB
		buildBindYbGainMap();
		
		//游戏内活跃事件每日统计
		buildGameParticipateMap();
		
		buildLevelUpgradeMap();
		buildLogoutMap();
		
		//物品消耗
		buildPropConsumeMap();
		//获得物品
		buildPropGainMap();
		
		//游戏内活跃事件货币得失统计
		buildGameFunctionMoneyDistributeMap();
		
	}

	private static void buildPropGainMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();

		statisticsEventTypeMap.put(StatisticsTaskName.GAIN_PROP, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAIN_PROP, nameNodes);

		nameNodes.add(GameLogEventType.VIP_KAIFU_CHOUJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_KAIFU_CHOUJIANG));
		
		nameNodes.add(GameLogEventType.GOODS_EXCHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_EXCHANGE));

		nameNodes.add(GameLogEventType.XUNBAO_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN));

		nameNodes.add(GameLogEventType.LOGIN_REWARD_7);
		nodes.add(eventTypeNodes.get(GameLogEventType.LOGIN_REWARD_7));
		
		nameNodes.add(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS));
		
		nameNodes.add(GameLogEventType.VIP_KAIFU_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_KAIFU_LINGQU));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETE));

		nameNodes.add(GameLogEventType.DAFUWONG_YAOJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_YAOJIANG));
		
		nameNodes.add(GameLogEventType.DAFUWONG_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_DUIHUAN));
		
		nameNodes.add(GameLogEventType.ZYDHUIHUAN_ZHUIHUI);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZYDHUIHUAN_ZHUIHUI));
		
		nameNodes.add(GameLogEventType.ZUOQI_UPGRADE_FANHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_UPGRADE_FANHUAN));
		
		nameNodes.add(GameLogEventType.WEIDUAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.WEIDUAN_REWARD));
		
		nameNodes.add(GameLogEventType.JINGJI_EVERYDAY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYDAY_REWARD));

		nameNodes.add(GameLogEventType.JINGJI_EVERYHOUR_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYHOUR_REWARD));

		nameNodes.add(GameLogEventType.EQUIP_CAILIAPJIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_CAILIAPJIANDING));
		
		nameNodes.add(GameLogEventType.HUODONG_RANK_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_RANK_AWARD));
		
		nameNodes.add(GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG));
		
		nameNodes.add(GameLogEventType.GOODS_BUY_BACK);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_BUY_BACK));
		
		nameNodes.add(GameLogEventType.GIFT_CODE_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GIFT_CODE_REWARDS));

		nameNodes.add(GameLogEventType.LINGDIZHAN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.LINGDIZHAN_AWARD));
		
		nameNodes.add(GameLogEventType.GUOZHAN_LINGJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUOZHAN_LINGJIANG));
		
		nameNodes.add(GameLogEventType.CHENGJIU_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHENGJIU_FINISH));
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));

		nameNodes.add(GameLogEventType.VIP_HUODONG_CHOUJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_HUODONG_CHOUJIANG));

		nameNodes.add(GameLogEventType.VIP_HUODONG_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_HUODONG_LINGQU));

		nameNodes.add(GameLogEventType.VIP_QQ_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_QQ_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.TASK_MAIN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_MAIN_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_TAOFA_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_TAOFA_FINISH));
		
		nameNodes.add(GameLogEventType.GONGHUI_TASK_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.GONGHUI_TASK_FINISH));
		
		nameNodes.add(GameLogEventType.EMAIL_GET_ITEM);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_GET_ITEM));
		
		nameNodes.add(GameLogEventType.BOOTH_BUGGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUGGOODS));
		
		nameNodes.add(GameLogEventType.HUODONG_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_REWARDS));
		
		nameNodes.add(GameLogEventType.PROP_USE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE));
		
		nameNodes.add(GameLogEventType.STAGE_PICKUP_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_PICKUP_GOODS));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_AWARD));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_GATHERBOSS);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_GATHERBOSS));
		
		nameNodes.add(GameLogEventType.STAGE_GATHER);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_GATHER));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_AWARD));
		
		nameNodes.add(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS));
		
		nameNodes.add(GameLogEventType.LVLIBAO_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.LVLIBAO_LINGQU));
		
		nameNodes.add(GameLogEventType.VIP_BUY_LIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_BUY_LIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_DAYLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_DAYLIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_WEEKLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_WEEKLIBAO));
		
		nameNodes.add(GameLogEventType.HEFUHUODONG_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.HEFUHUODONG_REWARD));

		nameNodes.add(GameLogEventType.SHENMISHOP_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_BUY));

		nameNodes.add(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.ZUWUFUBEN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWUFUBEN_FINISH));
		
		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));
		
		
		nameNodes.add(GameLogEventType.GUILDFUBEN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILDFUBEN_REWARD));
		
		nameNodes.add(GameLogEventType.XIANSHIBUY_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHIBUY_DECR));
		
		nameNodes.add(GameLogEventType.GOODS_HECHENG);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_HECHENG));
		
		nameNodes.add(GameLogEventType.PHONE_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.PHONE_REWARD));
		
		nameNodes.add(GameLogEventType.YINGYIN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.YINGYIN_REWARD));
		
		nameNodes.add(GameLogEventType.CHANGE72_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHANGE72_BUY));
		
		nameNodes.add(GameLogEventType.QIANFUHUODONG_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIANFUHUODONG_REWARD));
		
		nameNodes.add(GameLogEventType.KAPAI_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.KAPAI_DUIHUAN));
		
		nameNodes.add(GameLogEventType.LIANCHOU_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.LIANCHOU_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.XUNBAO_JIFEN_GAIN);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_JIFEN_GAIN));
		nameNodes.add(GameLogEventType.LOGIN_LIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.LOGIN_LIBAO));
		
		nameNodes.add(GameLogEventType.XUNBAO_TIANMING_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_TIANMING_REWARDS));
		
		nameNodes.add(GameLogEventType.JC_ACTIVITY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JC_ACTIVITY_REWARD));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_ZHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_ZHUAN));
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_FLUSH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_FLUSH));
		nameNodes.add(GameLogEventType.MALL_BUY2);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY2));
		
		nameNodes.add(GameLogEventType.ZHIZUN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZHIZUN_REWARD));
		
		nameNodes.add(GameLogEventType.GOODS_HECHENG_SHENDAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_HECHENG_SHENDAN));
		
	}

	private static void buildPropConsumeMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.CONSUME_PROP, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.CONSUME_PROP, nameNodes);
		
		nameNodes.add(GameLogEventType.EQUIP_CAILIAPJIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_CAILIAPJIANDING));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.MEIREN_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_UPGRADE));
		
		nameNodes.add(GameLogEventType.GOODS_SELL);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_SELL));
		
		nameNodes.add(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS));
		
		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));
		
		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));
		
		nameNodes.add(GameLogEventType.ATTRIBUTEBUFF_CHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ATTRIBUTEBUFF_CHANGE));

		nameNodes.add(GameLogEventType.GUILD_CONTRIBUTE_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CONTRIBUTE_GOODS));
		
		nameNodes.add(GameLogEventType.GUILD_CREATE_DECR_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CREATE_DECR_MONEY));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.YUANSHEN_UPGRADE_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.YUANSHEN_UPGRADE_LEVEL));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));

		nameNodes.add(GameLogEventType.EQUIP_JIANDING_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING_QINGXI));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_GATHERBOSS);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_GATHERBOSS));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLGOODS));
		
		nameNodes.add(GameLogEventType.BAOSHI_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_JIHUO));
		
		nameNodes.add(GameLogEventType.BAOSHI_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_LEVEL_UPGRADE));
		
		nameNodes.add(GameLogEventType.PROP_USE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE));
		
		nameNodes.add(GameLogEventType.BAG_DROP_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAG_DROP_GOODS));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_REVIVE));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_TELEPORT);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_TELEPORT));
		
		nameNodes.add(GameLogEventType.SKILL_USE_BOOK);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_USE_BOOK));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));
		
		nameNodes.add(GameLogEventType.TOUXIAN_CHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUXIAN_CHANGE));

		nameNodes.add(GameLogEventType.HEFUHUODONG_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.HEFUHUODONG_REWARD));
		
		nameNodes.add(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.ZUWU_JINGJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWU_JINGJIE));
		
		nameNodes.add(GameLogEventType.SKILL_BOOK_TUNSHI);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_BOOK_TUNSHI));
		
		nameNodes.add(GameLogEventType.GOODS_HECHENG);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_HECHENG));
		
		nameNodes.add(GameLogEventType.CHANGE72_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHANGE72_BUY));
		
		nameNodes.add(GameLogEventType.KAPAI_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.KAPAI_DUIHUAN));
		
		nameNodes.add(GameLogEventType.LIANCHOU_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.LIANCHOU_CHANGE_RESOURCE));

		nameNodes.add(GameLogEventType.XUNBAO_TIANMING_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_TIANMING_REWARDS));

		nameNodes.add(GameLogEventType.SHENJIANG_JXT_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JXT_DECR));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_ENTER);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_ENTER));
		
		nameNodes.add(GameLogEventType.XUNBAO_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.DAFUWONG_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_DUIHUAN));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_FLUSH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_FLUSH));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_ZHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_ZHUAN));
		
		nameNodes.add(GameLogEventType.ZHIZUN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZHIZUN_REWARD));
		
		nameNodes.add(GameLogEventType.MALL_BUY2);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY2));
		
		
		nameNodes.add(GameLogEventType.SHENQI_JINJIE_CONSUME);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENQI_JINJIE_CONSUME));
		

	}

	private static void buildBindYbGainMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.GAIN_BINDYB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAIN_BINDYB, nameNodes);

		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_JIHUO));
		
		nameNodes.add(GameLogEventType.GIFT_CODE_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GIFT_CODE_REWARDS));
		
		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_LEVEL));
		
		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_MONTH));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
	}

	private static void buildBindYbConsumeMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.CONSUME_BINDYB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.CONSUME_BINDYB, nameNodes);
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));
		
		nameNodes.add(GameLogEventType.HUSONG_SELECT);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SELECT));
		
		nameNodes.add(GameLogEventType.HUSONG_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_REFRESH));
		
		nameNodes.add(GameLogEventType.JINGJI_REFRESHZHANLI);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_REFRESHZHANLI));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING_QINGXI));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));
		
		
		nameNodes.add(GameLogEventType.CHANGE72_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHANGE72_BUY));
	}

	private static void buildYxbGainMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.GAIN_YXB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAIN_YXB, nameNodes);
//		
		nameNodes.add(GameLogEventType.TASK_MAIN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_MAIN_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_TAOFA_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_TAOFA_FINISH));

		nameNodes.add(GameLogEventType.JINGJI_EVERYDAY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYDAY_REWARD));

		nameNodes.add(GameLogEventType.JINGJI_EVERYHOUR_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYHOUR_REWARD));
		
		nameNodes.add(GameLogEventType.GOODS_SELL);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_SELL));
		
		nameNodes.add(GameLogEventType.BAIXIAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAIXIAN_REWARD));
		
		nameNodes.add(GameLogEventType.GIFT_CODE_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GIFT_CODE_REWARDS));
		
		nameNodes.add(GameLogEventType.LINGDIZHAN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.LINGDIZHAN_AWARD));
		
		nameNodes.add(GameLogEventType.GONGHUI_TASK_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.GONGHUI_TASK_FINISH));
		
		nameNodes.add(GameLogEventType.EMAIL_GET_ITEM);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_GET_ITEM));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLGOODS));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLYB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLYB));
		
		nameNodes.add(GameLogEventType.BOOTH_BUYJB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYJB));
		
		nameNodes.add(GameLogEventType.HUODONG_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_REWARDS));
		
		nameNodes.add(GameLogEventType.PROP_USE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE));
		
		nameNodes.add(GameLogEventType.GUOZHAN_LINGJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUOZHAN_LINGJIANG));
		
		nameNodes.add(GameLogEventType.HUSONG_SUCCESS_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SUCCESS_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_FAIL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_FAIL_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_STEAL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_STEAL_AWARDS));
		
		nameNodes.add(GameLogEventType.STAGE_PICKUP_YXB);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_PICKUP_YXB));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_AWARD));
		
		nameNodes.add(GameLogEventType.STAGE_GATHER);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_GATHER));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_AWARD));
		
		nameNodes.add(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY));
		
		nameNodes.add(GameLogEventType.LVLIBAO_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.LVLIBAO_LINGQU));
		
		nameNodes.add(GameLogEventType.QISHENG_KILL_BOSS_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.QISHENG_KILL_BOSS_REWARD));
		
	}

	private static void buildYxbConsumeMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.CONSUME_YXB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.CONSUME_YXB, nameNodes);

		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETE));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_DECREASEDIFF);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_DECREASEDIFF));
		
		nameNodes.add(GameLogEventType.MEIREN_CHANMIAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_CHANMIAN));
		
		nameNodes.add(GameLogEventType.MEIREN_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_UPGRADE));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_TELEPORT);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_TELEPORT));
		
		nameNodes.add(GameLogEventType.GOODS_BUY_BACK);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_BUY_BACK));
		
		nameNodes.add(GameLogEventType.STAGE_DEAD_DROPYXB);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_DEAD_DROPYXB));
		
		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));
		
		nameNodes.add(GameLogEventType.GUILD_CONTRIBUTE_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CONTRIBUTE_MONEY));

		nameNodes.add(GameLogEventType.GUILD_CREATE_DECR_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CREATE_DECR_MONEY));
		
		nameNodes.add(GameLogEventType.STAGE_MEIREN_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_RECOVERYHP));
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING));
		
		nameNodes.add(GameLogEventType.BOOTH_BUGGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUGGOODS));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLJB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLJB));
		
		nameNodes.add(GameLogEventType.BOOTH_BUYYB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYYB));
		
		nameNodes.add(GameLogEventType.BAOSHI_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_JIHUO));
		
		nameNodes.add(GameLogEventType.BAOSHI_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_LEVEL_UPGRADE));
		
		nameNodes.add(GameLogEventType.SHENJIANG_SKILL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_SKILL_UPGRADE));

		nameNodes.add(GameLogEventType.SHENJIANG_JIHUO_JXT);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JIHUO_JXT));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JXT_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JXT_DECR));
		
		nameNodes.add(GameLogEventType.SHENJIANG_SKILL_UPGRADE_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_SKILL_UPGRADE_DECR));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_RECOVERYHP));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_REVIVE));
		
		nameNodes.add(GameLogEventType.SKILL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_UPGRADE));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));
		
		nameNodes.add(GameLogEventType.ZYDHUIHUAN_ZHUIHUI);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZYDHUIHUAN_ZHUIHUI));
		
		
		nameNodes.add(GameLogEventType.CHANGE72_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHANGE72_BUY));
		
	}

	private static void buildYbComsumeMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.CONSUME_YB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.CONSUME_YB, nameNodes);

		nameNodes.add(GameLogEventType.XUNBAO_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.JINGJI_CLEARCD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_CLEARCD));

		nameNodes.add(GameLogEventType.JINGJI_BUYCOUNT);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_BUYCOUNT));

		nameNodes.add(GameLogEventType.JINGJI_REFRESHZHANLI);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_REFRESHZHANLI));
		
		nameNodes.add(GameLogEventType.HUOYUEDU_MIAOSHA);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUOYUEDU_MIAOSHA));
		
		nameNodes.add(GameLogEventType.BAIXIAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAIXIAN_REWARD));
		
		nameNodes.add(GameLogEventType.TOUBAO_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LEVEL));

		nameNodes.add(GameLogEventType.TOUBAO_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_MONTH));
		
		nameNodes.add(GameLogEventType.STAGE_MEIREN_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_REVIVE));
		
		nameNodes.add(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING_QINGXI));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETEBEST);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETEBEST));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_KUAISUFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_KUAISUFINISH));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));
		
		nameNodes.add(GameLogEventType.ZYDHUIHUAN_ZHUIHUI);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZYDHUIHUAN_ZHUIHUI));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.BOOTH_BUGGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUGGOODS));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLYB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLYB));
		
		nameNodes.add(GameLogEventType.BOOTH_BUYJB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYJB));
		
		nameNodes.add(GameLogEventType.BAOSHI_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_JIHUO));
		
		nameNodes.add(GameLogEventType.BAOSHI_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_LEVEL_UPGRADE));
		
		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));

		nameNodes.add(GameLogEventType.HUSONG_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_REFRESH));
		
		nameNodes.add(GameLogEventType.HUSONG_SELECT);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SELECT));
		
		nameNodes.add(GameLogEventType.BAG_OPEN);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAG_OPEN));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JXT_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JXT_DECR));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_ENTER);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_ENTER));

		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_GATHERBOSS);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_GATHERBOSS));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_TELEPORT);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_TELEPORT));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_REVIVE));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_ACCELERATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_ACCELERATE));
		
		nameNodes.add(GameLogEventType.VIP_BUY_LIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_BUY_LIBAO));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
		
		nameNodes.add(GameLogEventType.DAFUWONG_YAOJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_YAOJIANG));

		nameNodes.add(GameLogEventType.SHENMISHOP_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_BUY));
		
		nameNodes.add(GameLogEventType.SHENMISHOP_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_REFRESH));
		
//		nameNodes.add(GameLogEventType.ZUWU_JINGJIE);
//		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWU_JINGJIE));
		
		nameNodes.add(GameLogEventType.ZUWUFUBEN_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWUFUBEN_REFRESH));
		
		nameNodes.add(GameLogEventType.XUNBAO_ACTIVATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_ACTIVATE));
		
		nameNodes.add(GameLogEventType.XIANSHIBUY_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHIBUY_DECR));
		
		nameNodes.add(GameLogEventType.CHANGE72_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHANGE72_BUY));
		
		nameNodes.add(GameLogEventType.LIANCHOU_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.LIANCHOU_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.XUNBAO_TIANMING_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_TIANMING_REWARDS));
		
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_ZHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_ZHUAN));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_FLUSH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_FLUSH));
		
		nameNodes.add(GameLogEventType.MALL_BUY2);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY2));
		
		nameNodes.add(GameLogEventType.ZHIZUN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZHIZUN_REWARD));
		

	}
	
	private static void buildYbGainMap() {
		
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.GAIN_YB, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAIN_YB, nameNodes);
		
		nameNodes.add(GameLogEventType.RECHARGE_YB);
		nodes.add(eventTypeNodes.get(GameLogEventType.RECHARGE_YB));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLGOODS));
		
		nameNodes.add(GameLogEventType.BOOTH_SELLJB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLJB));

		nameNodes.add(GameLogEventType.BOOTH_BUYYB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYYB));
		
		
	}
	
	private static void buildGameParticipateMap() {
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.GAME_PARTICIPATE, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAME_PARTICIPATE, nameNodes);

		nameNodes.add(GameLogEventType.WEIDUAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.WEIDUAN_REWARD));

		nameNodes.add(GameLogEventType.ZYDHUIHUAN_ZHUIHUI);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZYDHUIHUAN_ZHUIHUI));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));
		
		nameNodes.add(GameLogEventType.QISHENG_KILL_BOSS_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.QISHENG_KILL_BOSS_REWARD));
		
		nameNodes.add(GameLogEventType.SKILL_USE_BOOK);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_USE_BOOK));
		
		nameNodes.add(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.CANGBAOGE_DUIHUAN_GOODS));
		
		nameNodes.add(GameLogEventType.SKILL_BOOK_TUNSHI);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_BOOK_TUNSHI));
		
		nameNodes.add(GameLogEventType.GUILDFUBEN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILDFUBEN_REWARD));
		
		nameNodes.add(GameLogEventType.XUNBAO_ACTIVATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_ACTIVATE));
		
		nameNodes.add(GameLogEventType.ZUWUFUBEN_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWUFUBEN_REFRESH));
		
		nameNodes.add(GameLogEventType.TOUXIAN_CHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUXIAN_CHANGE));
		
		nameNodes.add(GameLogEventType.ZUWUFUBEN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWUFUBEN_FINISH));
		
		nameNodes.add(GameLogEventType.DAFUWONG_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_DUIHUAN));
		
		nameNodes.add(GameLogEventType.ZUWU_JINGJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWU_JINGJIE));
		
		nameNodes.add(GameLogEventType.DAFUWONG_YAOJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_YAOJIANG));
		
		nameNodes.add(GameLogEventType.LOGIN_REWARD_7);
		nodes.add(eventTypeNodes.get(GameLogEventType.LOGIN_REWARD_7));
		
		nameNodes.add(GameLogEventType.HEFUHUODONG_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.HEFUHUODONG_REWARD));
		
		nameNodes.add(GameLogEventType.SHENMISHOP_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_BUY));
		
		nameNodes.add(GameLogEventType.SHENMISHOP_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_REFRESH));
		
		nameNodes.add(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.VIP_KAIFU_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_KAIFU_LINGQU));

		nameNodes.add(GameLogEventType.VIP_KAIFU_CHOUJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_KAIFU_CHOUJIANG));

		nameNodes.add(GameLogEventType.XUNBAO_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.ZUOQI_UPGRADE_FANHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_UPGRADE_FANHUAN));
		
		nameNodes.add(GameLogEventType.WEIDUAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.WEIDUAN_REWARD));
		
		nameNodes.add(GameLogEventType.EQUIP_CAILIAPJIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_CAILIAPJIANDING));

		nameNodes.add(GameLogEventType.JINGJI_EVERYDAY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYDAY_REWARD));

		nameNodes.add(GameLogEventType.JINGJI_EVERYHOUR_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYHOUR_REWARD));
		
		nameNodes.add(GameLogEventType.JINGJI_CLEARCD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_CLEARCD));

		nameNodes.add(GameLogEventType.JINGJI_BUYCOUNT);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_BUYCOUNT));

		nameNodes.add(GameLogEventType.JINGJI_REFRESHZHANLI);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_REFRESHZHANLI));
		
		nameNodes.add(GameLogEventType.HUODONG_RANK_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_RANK_AWARD));
		
		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_DUIHUAN));
		
		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_JIHUO));
		
		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_QIYONG);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_QIYONG));
		
		nameNodes.add(GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_HUOYUEDU_LINJIANG));
		
		nameNodes.add(GameLogEventType.HUOYUEDU_MIAOSHA);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUOYUEDU_MIAOSHA));
		
		nameNodes.add(GameLogEventType.GOODS_BUY_BACK);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_BUY_BACK));
		
		nameNodes.add(GameLogEventType.GOODS_SELL);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_SELL));
		
		nameNodes.add(GameLogEventType.SKILL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SKILL_UPGRADE));
		
		nameNodes.add(GameLogEventType.GIFT_CODE_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GIFT_CODE_REWARDS));
		
		nameNodes.add(GameLogEventType.GUILD_CONTRIBUTE_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CONTRIBUTE_GOODS));

		nameNodes.add(GameLogEventType.GUILD_CREATE_DECR_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CREATE_DECR_MONEY));
		
		nameNodes.add(GameLogEventType.GUILD_CONTRIBUTE_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILD_CONTRIBUTE_MONEY));

		nameNodes.add(GameLogEventType.GUOZHAN_LINGJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUOZHAN_LINGJIANG));
		
		nameNodes.add(GameLogEventType.ATTRIBUTEBUFF_CHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ATTRIBUTEBUFF_CHANGE));
		
		nameNodes.add(GameLogEventType.TOUBAO_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LEVEL));
		
		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_LEVEL));
		
		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_MONTH));
		
		nameNodes.add(GameLogEventType.TOUBAO_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_MONTH));
		
		nameNodes.add(GameLogEventType.BAIXIAN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAIXIAN_REWARD));
		
		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));

		nameNodes.add(GameLogEventType.LINGDIZHAN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.LINGDIZHAN_AWARD));

		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));
		
		nameNodes.add(GameLogEventType.STAGE_MEIREN_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_RECOVERYHP));

		nameNodes.add(GameLogEventType.STAGE_MEIREN_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_REVIVE));
		
		nameNodes.add(GameLogEventType.CHENGJIU_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.CHENGJIU_FINISH));

		nameNodes.add(GameLogEventType.VIP_HUODONG_CHOUJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_HUODONG_CHOUJIANG));

		nameNodes.add(GameLogEventType.VIP_HUODONG_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_HUODONG_LINGQU));

		nameNodes.add(GameLogEventType.VIP_QQ_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_QQ_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.BAG_OPEN);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAG_OPEN));
		
		nameNodes.add(GameLogEventType.BAOSHI_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_JIHUO));

		nameNodes.add(GameLogEventType.BAOSHI_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_LEVEL_UPGRADE));

		nameNodes.add(GameLogEventType.BOOTH_BUGGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUGGOODS));

		nameNodes.add(GameLogEventType.BOOTH_BUYYB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYYB));

		nameNodes.add(GameLogEventType.BOOTH_BUYJB);
		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYJB));
		
		nameNodes.add(GameLogEventType.EMAIL_DELETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_DELETE));
		
		nameNodes.add(GameLogEventType.EMAIL_GET_ITEM);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_GET_ITEM));
		
		nameNodes.add(GameLogEventType.EMAIL_READ);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_READ));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING_QINGXI));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.GONGHUI_TASK_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.GONGHUI_TASK_FINISH));
		
		nameNodes.add(GameLogEventType.GOODS_EXCHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_EXCHANGE));
		
		nameNodes.add(GameLogEventType.HUODONG_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_REWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_FAIL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_FAIL_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_REFRESH));
		
		nameNodes.add(GameLogEventType.HUSONG_SELECT);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SELECT));
		
		nameNodes.add(GameLogEventType.HUSONG_STEAL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_STEAL_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_SUCCESS_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SUCCESS_AWARDS));
		
		nameNodes.add(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY));
		
		nameNodes.add(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS));
		
		nameNodes.add(GameLogEventType.JUQING_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQING_FINISH));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_ACCELERATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_ACCELERATE));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_AWARD));
		
		nameNodes.add(GameLogEventType.LVLIBAO_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.LVLIBAO_LINGQU));
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));
		
		nameNodes.add(GameLogEventType.MEIREN_CHANMIAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_CHANMIAN));
		
		nameNodes.add(GameLogEventType.MEIREN_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_LINGQU));
		
		nameNodes.add(GameLogEventType.MEIREN_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_UPGRADE));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
		
		nameNodes.add(GameLogEventType.SHENJIANG_ACTIVATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_ACTIVATE));
		
		nameNodes.add(GameLogEventType.SHENJIANG_ACTIVATE_FAIL);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_ACTIVATE_FAIL));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JIHUO_JXT);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JIHUO_JXT));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL));
		
		nameNodes.add(GameLogEventType.SHENJIANG_SKILL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_SKILL_UPGRADE));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_AWARD));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_ENTER);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_ENTER));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_GATHERBOSS);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_GATHERBOSS));
		
		nameNodes.add(GameLogEventType.STAGE_GATHER);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_GATHER));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_REVIVE));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_TELEPORT);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_TELEPORT));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_RECOVERYHP));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_REVIVE));
//		
		nameNodes.add(GameLogEventType.TASK_MAIN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_MAIN_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_TAOFA_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_TAOFA_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETE));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETEBEST);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETEBEST));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_DECREASEDIFF);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_DECREASEDIFF));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_KUAISUFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_KUAISUFINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH));
		
		nameNodes.add(GameLogEventType.VIP_BUY_LIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_BUY_LIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_DAYLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_DAYLIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_WEEKLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_WEEKLIBAO));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_ZHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_ZHUAN));
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_FLUSH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_FLUSH));
		nameNodes.add(GameLogEventType.MALL_BUY2);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY2));
		nameNodes.add(GameLogEventType.ZHIZUN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZHIZUN_REWARD));
		
		nameNodes.add(GameLogEventType.JC_ACTIVITY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JC_ACTIVITY_REWARD));
		
	}
	
	
	private static void buildLevelUpgradeMap() {
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.LEVEL_UPGRADE, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.LEVEL_UPGRADE, nameNodes);
		
		nameNodes.add(GameLogEventType.ROLE_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ROLE_LEVEL_UPGRADE));
		
	}
	
	private static void buildLogoutMap() {
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.LOG_OUT, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.LOG_OUT, nameNodes);
		
		nameNodes.add(GameLogEventType.ROLE_LOGOUT);
		nodes.add(eventTypeNodes.get(GameLogEventType.ROLE_LOGOUT));
		
	}
	
	
	private static void buildGameFunctionMoneyDistributeMap() {
		List<EventTypeNode> nodes = new ArrayList<EventTypeNode>();
		List<String> nameNodes = new ArrayList<String>();
		
		statisticsEventTypeMap.put(StatisticsTaskName.GAME_FUNCTION_MONEY_DISTRIBUTE, nodes);
		statisticsEventTypeNameMap.put(StatisticsTaskName.GAME_FUNCTION_MONEY_DISTRIBUTE, nameNodes);

		nameNodes.add(GameLogEventType.SHENMISHOP_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_BUY));
		
		nameNodes.add(GameLogEventType.SHENMISHOP_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMISHOP_REFRESH));
		
		nameNodes.add(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENMIZHUANPAN_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUANGYI_UPGRADE_LEVEL_DECR));

		nameNodes.add(GameLogEventType.DAFUWONG_YAOJIANG);
		nodes.add(eventTypeNodes.get(GameLogEventType.DAFUWONG_YAOJIANG));
		
		nameNodes.add(GameLogEventType.QISHENG_KILL_BOSS_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.QISHENG_KILL_BOSS_REWARD));
		
		nameNodes.add(GameLogEventType.XUNBAO_ACTIVATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_ACTIVATE));
		
		nameNodes.add(GameLogEventType.ZYDHUIHUAN_ZHUIHUI);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZYDHUIHUAN_ZHUIHUI));
		
		nameNodes.add(GameLogEventType.QIZHANBINQI_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.QIZHANBINQI_UPGRADE));

		
		
		
		
		
		nameNodes.add(GameLogEventType.XUNBAO_GET_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.XUNBAO_GET_REWARDS));
		
		nameNodes.add(GameLogEventType.EQUIP_CAILIAPJIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_CAILIAPJIANDING));

		nameNodes.add(GameLogEventType.JINGJI_EVERYDAY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYDAY_REWARD));

		nameNodes.add(GameLogEventType.JINGJI_EVERYHOUR_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_EVERYHOUR_REWARD));
		
		nameNodes.add(GameLogEventType.JINGJI_CLEARCD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_CLEARCD));

		nameNodes.add(GameLogEventType.JINGJI_BUYCOUNT);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_BUYCOUNT));

		nameNodes.add(GameLogEventType.JINGJI_REFRESHZHANLI);
		nodes.add(eventTypeNodes.get(GameLogEventType.JINGJI_REFRESHZHANLI));
		
		nameNodes.add(GameLogEventType.XIANJIE_CHENGHAO_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANJIE_CHENGHAO_JIHUO));
		
		nameNodes.add(GameLogEventType.HUOYUEDU_MIAOSHA);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUOYUEDU_MIAOSHA));
		
		nameNodes.add(GameLogEventType.GOODS_BUY_BACK);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_BUY_BACK));
		
		nameNodes.add(GameLogEventType.GOODS_SELL);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_SELL));
		
		nameNodes.add(GameLogEventType.GIFT_CODE_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.GIFT_CODE_REWARDS));
		
		nameNodes.add(GameLogEventType.STAGE_DEAD_DROPYXB);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_DEAD_DROPYXB));
		
		nameNodes.add(GameLogEventType.TOUBAO_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LEVEL));
		
		nameNodes.add(GameLogEventType.TOUBAO_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_MONTH));
		
		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_LEVEL);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_LEVEL));

		nameNodes.add(GameLogEventType.TOUBAO_LINGQU_MONTH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TOUBAO_LINGQU_MONTH));

		nameNodes.add(GameLogEventType.STAGE_MEIREN_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_REVIVE));

		nameNodes.add(GameLogEventType.STAGE_MEIREN_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_MEIREN_RECOVERYHP));

		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));
		
		nameNodes.add(GameLogEventType.BAG_OPEN);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAG_OPEN));
		
		nameNodes.add(GameLogEventType.BAOSHI_JIHUO);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_JIHUO));

		nameNodes.add(GameLogEventType.BAOSHI_LEVEL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.BAOSHI_LEVEL_UPGRADE));

//		nameNodes.add(GameLogEventType.BOOTH_BUGGOODS);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUGGOODS));
//
//		nameNodes.add(GameLogEventType.BOOTH_BUYYB);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYYB));
//
//		nameNodes.add(GameLogEventType.BOOTH_BUYJB);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_BUYJB));

//		nameNodes.add(GameLogEventType.BOOTH_SELLGOODS);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLGOODS));
//		
//		nameNodes.add(GameLogEventType.BOOTH_SELLJB);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLJB));
//		
//		nameNodes.add(GameLogEventType.BOOTH_SELLYB);
//		nodes.add(eventTypeNodes.get(GameLogEventType.BOOTH_SELLYB));
		
		nameNodes.add(GameLogEventType.EMAIL_DELETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_DELETE));
		
		nameNodes.add(GameLogEventType.EMAIL_GET_ITEM);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_GET_ITEM));
		
		nameNodes.add(GameLogEventType.EMAIL_READ);
		nodes.add(eventTypeNodes.get(GameLogEventType.EMAIL_READ));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING));
		
		nameNodes.add(GameLogEventType.EQUIP_JIANDING_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JIANDING_QINGXI));
		
		nameNodes.add(GameLogEventType.EQUIP_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_JINJIE));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.EQUIP_QIANGHUA_QINGXI);
		nodes.add(eventTypeNodes.get(GameLogEventType.EQUIP_QIANGHUA_QINGXI));
		
		nameNodes.add(GameLogEventType.GONGHUI_TASK_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.GONGHUI_TASK_FINISH));
		
		nameNodes.add(GameLogEventType.GOODS_EXCHANGE);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_EXCHANGE));
		
		nameNodes.add(GameLogEventType.HUODONG_REWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_REWARDS));
		
		nameNodes.add(GameLogEventType.HUODONG_MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUODONG_MALL_BUY));
		
		nameNodes.add(GameLogEventType.HUSONG_FAIL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_FAIL_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_REFRESH));
		
		nameNodes.add(GameLogEventType.HUSONG_SELECT);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SELECT));
		
		nameNodes.add(GameLogEventType.HUSONG_STEAL_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_STEAL_AWARDS));
		
		nameNodes.add(GameLogEventType.HUSONG_SUCCESS_AWARDS);
		nodes.add(eventTypeNodes.get(GameLogEventType.HUSONG_SUCCESS_AWARDS));
		
		nameNodes.add(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ONLINE_REWARD_MONEY));
		
		nameNodes.add(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_QIANDAO_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_YAOJIANG_GET_GOODS));
		
		nameNodes.add(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS);
		nodes.add(eventTypeNodes.get(GameLogEventType.JIANGLI_ZHOUMO_QIANDAO_GETGOODS));
		
		nameNodes.add(GameLogEventType.JUQING_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQING_FINISH));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_ACCELERATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_ACCELERATE));
		
		nameNodes.add(GameLogEventType.JUQINGFUBEN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JUQINGFUBEN_AWARD));
		
		nameNodes.add(GameLogEventType.LVLIBAO_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.LVLIBAO_LINGQU));
		
		nameNodes.add(GameLogEventType.MALL_BUY);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY));
		
		nameNodes.add(GameLogEventType.MEIREN_CHANMIAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_CHANMIAN));
		
		nameNodes.add(GameLogEventType.MEIREN_LINGQU);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_LINGQU));
		
		nameNodes.add(GameLogEventType.MEIREN_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.MEIREN_UPGRADE));
		
		nameNodes.add(GameLogEventType.PROP_USE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE));
		
		nameNodes.add(GameLogEventType.PROP_USE_ACQUIRE);
		nodes.add(eventTypeNodes.get(GameLogEventType.PROP_USE_ACQUIRE));
		
		nameNodes.add(GameLogEventType.RECHARGE_YB);
		nodes.add(eventTypeNodes.get(GameLogEventType.RECHARGE_YB));
		
		nameNodes.add(GameLogEventType.SHENJIANG_ACTIVATE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_ACTIVATE));
		
		nameNodes.add(GameLogEventType.SHENJIANG_ACTIVATE_FAIL);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_ACTIVATE_FAIL));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JIHUO_JXT);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JIHUO_JXT));
		
		nameNodes.add(GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_JIHUO_JXT_FAIL));
		
		nameNodes.add(GameLogEventType.SHENJIANG_SKILL_UPGRADE);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANG_SKILL_UPGRADE));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_AWARD));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_ENTER);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_ENTER));
		
		nameNodes.add(GameLogEventType.SHENJIANGJINDI_GATHERBOSS);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENJIANGJINDI_GATHERBOSS));
		
		nameNodes.add(GameLogEventType.STAGE_GATHER);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_GATHER));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_REVIVE));
		
		nameNodes.add(GameLogEventType.STAGE_ROLE_TELEPORT);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ROLE_TELEPORT));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_RECOVERYHP);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_RECOVERYHP));
		
		nameNodes.add(GameLogEventType.STAGE_ZUOQI_REVIVE);
		nodes.add(eventTypeNodes.get(GameLogEventType.STAGE_ZUOQI_REVIVE));
//		
		nameNodes.add(GameLogEventType.TASK_MAIN_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_MAIN_FINISH));
//		
		nameNodes.add(GameLogEventType.TASK_RICHANG_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_TAOFA_FINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_TAOFA_FINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETE);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETE));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_COMPLETEBEST);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_COMPLETEBEST));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_DECREASEDIFF);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_DECREASEDIFF));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_KUAISUFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_KUAISUFINISH));
		
		nameNodes.add(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH);
		nodes.add(eventTypeNodes.get(GameLogEventType.TASK_RICHANG_ZHIJIEFINISH));
		
		nameNodes.add(GameLogEventType.VIP_BUY_LIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_BUY_LIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_DAYLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_DAYLIBAO));
		
		nameNodes.add(GameLogEventType.VIP_LINGQU_WEEKLIBAO);
		nodes.add(eventTypeNodes.get(GameLogEventType.VIP_LINGQU_WEEKLIBAO));
		
		nameNodes.add(GameLogEventType.ZUOQI_JINJIE);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUOQI_JINJIE));
		
		nameNodes.add(GameLogEventType.LINGDIZHAN_AWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.LINGDIZHAN_AWARD));
		
		nameNodes.add(GameLogEventType.ZUWUFUBEN_REFRESH);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZUWUFUBEN_REFRESH));
		
		nameNodes.add(GameLogEventType.GUILDFUBEN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.GUILDFUBEN_REWARD));
		
		nameNodes.add(GameLogEventType.LIANCHOU_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.LIANCHOU_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE);
		nodes.add(eventTypeNodes.get(GameLogEventType.XIANSHITUO_CHANGE_RESOURCE));
		
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_ZHUAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_ZHUAN));
		nameNodes.add(GameLogEventType.SIX_ZHUANPAN_FLUSH);
		nodes.add(eventTypeNodes.get(GameLogEventType.SIX_ZHUANPAN_FLUSH));
		nameNodes.add(GameLogEventType.MALL_BUY2);
		nodes.add(eventTypeNodes.get(GameLogEventType.MALL_BUY2));
		nameNodes.add(GameLogEventType.ZHIZUN_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.ZHIZUN_REWARD));
		
		nameNodes.add(GameLogEventType.JC_ACTIVITY_REWARD);
		nodes.add(eventTypeNodes.get(GameLogEventType.JC_ACTIVITY_REWARD));
		
		nameNodes.add(GameLogEventType.SHENQI_JINJIE_CONSUME);
		nodes.add(eventTypeNodes.get(GameLogEventType.SHENQI_JINJIE_CONSUME));
		nameNodes.add(GameLogEventType.GOODS_HECHENG_SHENDAN);
		nodes.add(eventTypeNodes.get(GameLogEventType.GOODS_HECHENG_SHENDAN));
	}
	
	
	public static void main(String[] args) {
		
		List<EventTypeNode> nodes = getRelateEventTypes(StatisticsTaskName.CONSUME_YB);
		System.out.println(nodes.size());
		
	}
	
}
