package com.lingyu.dntg.constants.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLogEventType {

	
	public static final String RECHARGE_YB = "recharge_yb";
	public static final String ROLE_LOGOUT="role_logout";
	public static final String ROLE_CREATE = "role_create";
	public static final String ROLE_LOGIN = "role_login";
	public static final String ROLE_LEVEL_UPGRADE = "role_level_upgrade";
	
	public static final String MALL_BUY = "mall_buy";

	public static final String TASK_MAIN_FINISH = "task_main_finish";
	public static final String TASK_RICHANG_FINISH = "task_richang_finish";
	public static final String TASK_TAOFA_FINISH = "task_taofa_finish";

	/**
	 * 一键最优完成日常
	 */
	public static final String TASK_RICHANG_COMPLETEBEST = "task_richang_completebest";
	public static final String TASK_RICHANG_COMPLETE = "task_richang_complete";
	public static final String TASK_RICHANG_KUAISUFINISH = "task_richang_kuaisufinish";
	/**
	 * 降低日常任务难度
	 */
	public static final String TASK_RICHANG_DECREASEDIFF = "task_richang_decreasediff";
	/**
	 * 直接完成本环
	 */
	public static final String TASK_RICHANG_ZHIJIEFINISH ="task_richang_zhijiefinish";
	
	
	public static final String GONGHUI_TASK_FINISH = "gonghui_task_finish";
	
	public static final String ZUOQI_JINJIE = "zuoqi_change";
	
	public static final String EQUIP_JINJIE = "equip_jinjie";
	public static final String EQUIP_QIANGHUA = "equip_qianghua";
	/*
	equip_qianghua_qingxi	{userRoleId,equipGuid,[MoneyType.YB,count],[[goodsId,count]..]}	装备强化清洗时抛出
	equip_jianding_qingxi	{userRoleId,equipGuid,[MoneyType.YB,count],[[goodsId,count]..]}	装备鉴定清洗时抛出
	equip_jianding	{userRoleId, [[goodsId,count]..],[[moneyType,count]…]}	装备鉴定
	 * */
	public static final String EQUIP_QIANGHUA_QINGXI = "equip_qianghua_qingxi";
	public static final String EQUIP_JIANDING_QINGXI = "equip_jianding_qingxi";
	public static final String EQUIP_JIANDING = "equip_jianding";
	
	
	
	public static final String STAGE_ROLE_ENTER = "stage_role_enter";
	
	public static final String EMAIL_GET_ITEM = "email_get_item";
	public static final String EMAIL_DELETE = "email_delete";
	public static final String EMAIL_READ = "email_read";
	public static final String EMAIL_CREATE = "email_create";
	
	public static final String BOOTH_BUGGOODS = "booth_buyGoods";
	public static final String BOOTH_SELLGOODS = "booth_sellGoods";
	public static final String BOOTH_SELLJB = "booth_sellJb";
	public static final String BOOTH_SELLYB = "booth_sellYb";
	public static final String BOOTH_BUYJB = "booth_buyJb";
	public static final String BOOTH_BUYYB = "booth_buyYb";
	
	public static final String TRADE = "trade";
	
	public static final String HUODONG_REWARDS = "huodong_reward";
	
	public static final String BAOSHI_JIHUO = "baoshi_jihuo";
	public static final String BAOSHI_LEVEL_UPGRADE = "baoshi_level_upgrade";
	
	public static final String MEIREN_CHANMIAN = "meiren_chanmian";
	public static final String MEIREN_UPGRADE = "meiren_upgrade";
	public static final String MEIREN_LINGQU = "meiren_lingqu";
	
	public static final String PROP_USE = "prop_use";

	public static final String YB_EVENT = "yb_event";
	
	public static final String STAGE_STATISTICS = "stage_statistics"; 
	public static final String STAGE_ONLINE = "stage_online";

	/**
	 * husong_success_awards	{userRoleId, meiqi_id,yxb,exp,lingqi}	护送成功奖励
	 */
	public static final String HUSONG_SUCCESS_AWARDS = "husong_success_awards";
	/**
	 * 
		husong_fail_awards	{userRoleId, meiqi_id,yxb,exp,lingqi}	护送(被打劫)失败奖励
	 */
	public static final String HUSONG_FAIL_AWARDS = "husong_fail_awards";
	/**
	 * 
		husong_steal_awards	{userRoleId, meiqi_id,yxb,exp,lingqi}	护送打劫奖励
	 */
	public static final String HUSONG_STEAL_AWARDS = "husong_steal_awards";
	/**
	 * husong_refresh	{userRoleId,original_meiqi_id(刷新前),meiqi_id(刷新后),[[MoneyType,value]….]}	刷新美妻时抛出
	 */
	public static final String HUSONG_REFRESH = "husong_refresh";
	/**
	 * husong_select	{userRoleId,original_meiqi_id(刷新前),meiqi_id(刷新后),[[MoneyType,value]….]}	直接选取美妻时抛出
	 */
	public static final String HUSONG_SELECT = "husong_select";
	/**
	 * bag_drop_goods	[userRoleId, goodsId, count, rareLevel, attributes]	丢弃物品时抛出
	 */
	public static final String BAG_DROP_GOODS = "bag_drop_goods";
	
	//bag_open	[userRoleId,MoneyType,count(消耗元宝数目)]	背包仓库格位开启抛出
	public static final String BAG_OPEN = "bag_open";
	
	/**
	 * stage_pickup_goods	 [roleId, goodsId, count, rareLevel, attributes]	 场景拾取物品事件
	 */
	public static final String STAGE_PICKUP_GOODS = "stage_pickup_goods";
	/**
	 * stage_pickup_yxb	 [roleId, yxb]	 场景拾取游戏币事件
	 */
	public static final String STAGE_PICKUP_YXB = "stage_pickup_yxb";
	/**
	*	shenjiang_skill_upgrade	[userRoleId, shenjiangId, skillId, skillLevel]	神将技能升级
	 */
	public static final String SHENJIANG_SKILL_UPGRADE = "shenjiang_skill_upgrade";
	/**
	 * shenjiang_activate	[userRoleId,shenjiangId]	激活神将
	 */
	public static final String SHENJIANG_ACTIVATE = "shenjiang_activate";
	/*
	 * shenjiang_jihuo_jxt	[userRoleId, shenjiangId, jxtId, incrExp]	激活将星图
	shenjiang_activate_fail	[userRoleId, shenjiangId, incrZhenqi]	神将激活失败消耗
	shenjiang_jxt_exp_share	[userRoleId, shareRoleId, jxtId, shareIncrExp]	将星图经验分享
	shenjiang_jxt_decr	[userRoleId, moneyType, money, drcrGoodsMap, autoBuyMoney]	将星图进阶消耗
	shenjiang_jihuo_jxt_fail	[userRoleId, shenjiangId, jxtId, incrExp]	激活将星图失败
	shenjiang_skill_upgrade_decr	[userRoleId, decrZhenqi, moneyType, money, goodsId, goodsCount]	神将技能升级消耗
	 */
	/**激活将星图*/
	public static final String SHENJIANG_JIHUO_JXT = "shenjiang_jihuo_jxt";
	/**神将激活失败消耗*/
	public static final String SHENJIANG_ACTIVATE_FAIL = "shenjiang_activate_fail";
	/**将星图经验分享*/
	public static final String SHENJIANG_JXT_EXP_SHARE = "shenjiang_jxt_exp_share";
	/**将星图进阶消耗*/
	public static final String SHENJIANG_JXT_DECR = "shenjiang_jxt_decr";
	/**激活将星图失败*/
	public static final String SHENJIANG_JIHUO_JXT_FAIL = "shenjiang_jihuo_jxt_fail";
	/**神将技能升级消耗*/
	public static final String SHENJIANG_SKILL_UPGRADE_DECR = "shenjiang_skill_upgrade_decr";
	
	
	/**
	 * shenjiangjindi_enter	{roleId, fubenId, costYb, costGoods}	进入神将禁地
	 */
	public static final String SHENJIANGJINDI_ENTER = "shenjiangjindi_enter";
	/**
	 * 神将禁地奖励{roleId, fubenId, exp, zhenqi, yxb, awardGoods}
	 */
	public static final String SHENJIANGJINDI_AWARD="shenjiangjindi_award";
	/**
	 * {roleId, fubenId, costYb, costGoods, awardGoods}神将禁地挖BOSS尸体获得奖励
	 */
	public static final String SHENJIANGJINDI_GATHERBOSS="shenjiangjindi_gatherboss";

/*stage_role_revive	 [roleId, goodsId, goodsCount]	 角色复活事件
	stage_role_teleport	 [roleId, costYb, goodsId, goodsCount]	 筋斗云传送花费事件
	stage_gather	 [roleId, gatherId, exp, yxb, zhenqi, awardGoods]	 采集获得奖励事件
	stage_zuoqi_recoveryhp	 [roleId, costYb]	 坐骑瞬间回满血消耗元宝事件
	stage_zuoqi_revive	 [roleId, costYb]	 坐骑复活消耗元宝事件
	*/
	/**角色复活事件*/
	public static final String STAGE_ROLE_REVIVE="stage_role_revive";
	/**筋斗云传送花费事件*/
	public static final String STAGE_ROLE_TELEPORT="stage_role_teleport";
	/**采集获得奖励事件*/
	public static final String STAGE_GATHER="stage_gather";
	/**坐骑瞬间回满血消耗元宝事件*/
	public static final String STAGE_ZUOQI_RECOVERYHP="stage_zuoqi_recoveryhp";
	/**坐骑复活消耗元宝事件*/
	public static final String STAGE_ZUOQI_REVIVE="stage_zuoqi_revive";
	
	
	/*
	juqing_finish	{userRoleId, juqing_id}	完成剧情副本时抛出
	juqingfuben_accelerate	{userRoleId, juqing_id, costYb}	剧情副本加速扫荡
	juqingfuben_award	{userRoleId, juqing_id, exp, yxb, zhenqi, awardGoods}	领取剧情副本奖励时抛出
	*/
	/**完成剧情副本时抛出*/
	public static final String JUQING_FINISH="juqing_finish";
	/**剧情副本加速扫荡*/
	public static final String JUQINGFUBEN_ACCELERATE="juqingfuben_accelerate";
	/**领取剧情副本奖励时抛出*/
	public static final String JUQINGFUBEN_AWARD="juqingfuben_award";
	
	/*
	jiangli_qiandao_get_goods	[userRoleId, goods]	获取签到物品
	jiangli_online_reward_money	[userRoleId, moneyType, money]	在线奖励获得金钱
	jiangli_yaojiang_get_goods	[userRoleId, goods]	摇奖获得物品
	jiangli_zhoumo_qiandao_getgoods	[userRoleId, goods]	周末签到获得物品
	*/
	/**获取签到物品*/
	public static final String JIANGLI_QIANDAO_GET_GOODS="jiangli_qiandao_get_goods";
	/**在线奖励获得金钱*/
	public static final String JIANGLI_ONLINE_REWARD_MONEY="jiangli_online_reward_money";
	/**摇奖获得物品*/
	public static final String JIANGLI_YAOJIANG_GET_GOODS="jiangli_yaojiang_get_goods";
	/**周末签到获得物品*/
	public static final String JIANGLI_ZHOUMO_QIANDAO_GETGOODS="jiangli_zhoumo_qiandao_getgoods";
	
	/*
	shenshu_bei_steal_guoshi_buchang	[userRoleId, incrExp]	被抢收果实补偿
	shenshu_chishu_decr_money	[userRoleId, moneyType, moneyValue]	催熟消耗金钱
	shenshu_decr_guoshi_goods	[userRoleId, goodsId, goodsCount]	消耗果实物品
	shenshu_get_guoshi_goods	[userRoleId, goodsId, goodsCount]	获得果实物品
	shenshu_steal_guoshi_goods	[userRoleId, goodsId, goodsCount]	抢收果实获得的物品
	shenshu_watering_get	[userRoleId, exp]	浇水获得
*/
	public static final String SHENSHU_BEI_STEAL_GUOSHI_BUCHANG="shenshu_bei_steal_guoshi_buchang";
	public static final String SHENSHU_CHISHU_DECR_MONEY="shenshu_chishu_decr_money";
	public static final String SHENSHU_DECR_GUOSHI_GOODS="shenshu_decr_guoshi_goods";
	public static final String SHENSHU_GET_GUOSHI_GOODS="shenshu_get_guoshi_goods";
	public static final String SHENSHU_STEAL_GUOSHI_GOODS="shenshu_steal_guoshi_goods";
	public static final String SHENSHU_WATERING_GET="shenshu_watering_get";



	//goods_exchange	{userRoleId,[[goodsId,goodsCount]..],[[MoneyType,count]..]}	玩家兑换物品时候抛出
	public static final String GOODS_EXCHANGE="goods_exchange";

	//lvlibao_lingqu	{玩家id,[[goodsId,goodsCount]..],[[MoneyType,count]..],zhengqi,exp}	玩家领取等级礼包时候抛出
	public static final String LVLIBAO_LINGQU="lvlibao_lingqu";
	
	/*
	 * skill_upgrade	{userRoleId, skillId(技能id), skillLevel(此技能的等级), moneyType, decrMoney, decrZhenqi}	技能升级
		skill_use_book	{userRoleId, decrGoodsId, goodsCount}	 使用技能书事件
	 */
	/**技能升级*/
	public static final String SKILL_UPGRADE="skill_upgrade";
	/**使用技能书*/
	public static final String SKILL_USE_BOOK="skill_use_book";

	
	/*
	 vip_buy_libao	{userRoleId,vipLevel（购买的等级）,count所花元宝数目}	vip购买礼包时候抛出
	vip_lingqu_daylibao	{userRoleId,[[goodsId,goodsCount]…]}	领取每日礼包礼包
	vip_lingqu_weeklibao	{userRoleId,[[goodsId,goodsCount]…]}	领取每周礼包
	 */
	/**vip购买礼包*/
	public static final String VIP_BUY_LIBAO="vip_buy_libao";
	/**vip领取每日礼包*/
	public static final String VIP_LINGQU_DAYLIBAO="vip_lingqu_daylibao";
	/**vip领取每周礼包*/
	public static final String VIP_LINGQU_WEEKLIBAO="vip_lingqu_weeklibao";

	/**
	 * prop_use_acquire	{userRoleId,[[goodsId,count]..消耗物品],[[MoneyType,value]..消耗货币],decrZhenqi(消耗的真气),[[goodsId,count]..获得物品],[[MoneyType,value]..获得的货币],zhenqi(获得真气),exp(获得经验)}	使用道具获得真气，游戏币，经验，物品时候抛出*/
	public static final String PROP_USE_ACQUIRE="prop_use_acquire";
	
	//公会
	/**
	 * guild_create_decr_money	[userRoleId,moneyType,moneyValue,drcrGoodsMap]	创建公会消耗金钱
	 */
	public static final String GUILD_CREATE_DECR_MONEY="guild_create_decr_money";
	/**
	 * guild_contribute_money	[userRoleId, guildId, moneyType, moneyValue]	公会捐金钱
	 */
	public static final String GUILD_CONTRIBUTE_MONEY="guild_contribute_money";
	/**
	 * guild_contribute_goods	[userRoleId, guildId, goodsId, goodsCount]	公会捐物品
	 */
	public static final String GUILD_CONTRIBUTE_GOODS="guild_contribute_goods";
	

	/**
	 * 国战每日奖励领取
	 */
	public static final String GUOZHAN_LINGJIANG="guozhan_lingjiang";
	
	/**
	 * stage_dead_dropyxb	 [roleId, dropYxb]	 死亡掉落游戏币
	 */
	public static final String STAGE_DEAD_DROPYXB="stage_dead_dropyxb";

	
	/**
	 * attributebuff_change	{userRoleId,[goodsId,goodsCount]消耗的物品}	属性改变时候抛出
	 */
		public static final String ATTRIBUTEBUFF_CHANGE="attributebuff_change";

		/**
		 * baixian_reward	{userRoleId,count拜仙次数,shenxianId神仙id,[[MoneyType,count]..消耗的货币],[[MoneyType,count]..获得的货币],zhenqi获得真气,exp获得经验}	拜仙的时候抛出
		 */
		public static final String BAIXIAN_REWARD ="baixian_reward";
		
		/*toubao_level	{userRoleId,decrYb]}	等级投保
		toubao_lingqu_level	{userRoleId,money,moneyType]}	领取等级投保奖励
		toubao_lingqu_month	{userRoleId,money,moneyType]}	领取月投保奖励
		toubao_month	{userRoleId,decrYb]}	月投保*/
		/**
		 * toubao_level	{userRoleId,decrYb]}	等级投保
		 */
		public static final String TOUBAO_LEVEL ="toubao_level";/**
		 * toubao_lingqu_level	{userRoleId,money,moneyType]}	领取等级投保奖励
		 */
		public static final String TOUBAO_LINGQU_LEVEL ="toubao_lingqu_level";/**
		 * toubao_lingqu_month	{userRoleId,money,moneyType]}	领取月投保奖励
		 */
		public static final String TOUBAO_LINGQU_MONTH ="toubao_lingqu_month";/**
		 * toubao_month	{userRoleId,decrYb]}	月投保
		 */
		public static final String TOUBAO_MONTH ="toubao_month";
		
		/**
		 * qizhanbinqi_upgrade	{userRoleId,issuccess(是否成功),[[goodsId,goodsCount]..消耗的物品],[[moneyType,count]..消耗的钱],exp获取的,rank}
		 */
		public static final String QIZHANBINQI_UPGRADE ="qizhanbinqi_upgrade";
		
		/**
		 * lingdizhan_award	{userRoleId,moneyType, moneyVal, [[goodsId,count],[goodsId,count]…]}	领地战每日奖励领取
		 */
		public static final String LINGDIZHAN_AWARD ="lingdizhan_award";
		

		/**
		 * 活动商城购买 {roleId,[[goods]...],[[moneys]...]}
		 */
		public static final String HUODONG_MALL_BUY="huodong_mall_buy";
		

		public static final String STAGE_MEIREN_REVIVE="stage_meiren_revive";
		public static final String STAGE_MEIREN_RECOVERYHP="stage_meiren_recoveryhp";
		

		/**
		 * vip_huodong_choujiang	{userRoleId,vipLevel（抽奖等级）,[[goodsId,goodsCount]..获得的物品]}	vip活动抽奖时候抛出
		 */
		public static final String VIP_HUODONG_CHOUJIANG="vip_huodong_choujiang";
		/**
		 * vip_huodong_lingqu	{userRoleId,vipLevel（领取等级）,[[goodsId,goodsCount]..获得的物品]}	vip活动领固定取奖励时候抛出
		 */
		public static final String VIP_HUODONG_LINGQU="vip_huodong_lingqu";
		
		/**
		 * 超级会员QQ领取奖励
		 */
		public static final String VIP_QQ_GET_REWARDS="vip_qq_get_rewards";

		/**
		 * chengjiu_finish	{userRoleId,taskid,[[goodsId,count]…奖励物品]}	成就完成领取奖励时候抛出
		 */
		public static final String CHENGJIU_FINISH="chengjiu_finish";
		/**
		 * gift_code_rewards {userRoId,moneys,goods} 获取礼包码奖励
		 */
		public static final String GIFT_CODE_REWARDS="gift_code_rewards"; 
		

		/**
		 * goods_buy_back	{userRoleId ,goodsId,count,yxb(消耗游戏币)}	回购时候抛出
		 */
		public static final String GOODS_BUY_BACK="goods_buy_back"; 
		/**
		 * goods_sell	{userRoleId,goodsId,count,yxb(获得游戏币)}	 物品出售时候抛出
		 */
		public static final String GOODS_SELL="goods_sell"; 
		/**
		 * 正常聊天
		 */
		public static final String NORMAL_CHAT="normal_chat";
		/**
		 * gm聊天
		 */
		public static final String GM_CHAT="gm_chat";
		/**
		 * 账号登录
		 */
		public static final String ACCOUNT_LOGIN="io_login";
		

		/**
		 * xianjie_chenghao_duihuan	{玩家id,仙阶id,huoyuedu消耗活跃度]}	活跃度换仙阶称号的时候抛出
		 */
		public static final String XIANJIE_CHENGHAO_DUIHUAN="xianjie_chenghao_duihuan";
		
		/**
		 * xianjie_chenghao_jihuo	{玩家id,激活id,lijin激活获得礼金]}	激活称号的时候抛出
		 */
		public static final String XIANJIE_CHENGHAO_JIHUO="xianjie_chenghao_jihuo";
		
		/**
		 * xianjie_chenghao_qiyong	{玩家id,chenhaoid启用id}	仙阶称号启用时候抛出
		 */
		public static final String XIANJIE_CHENGHAO_QIYONG="xianjie_chenghao_qiyong";
		
		/**
		 * huoyuedu_miaosha	{玩家id,[moneytype,count]消耗,活跃度id}	秒杀活跃度时候抛出
		 */
		public static final String HUOYUEDU_MIAOSHA="huoyuedu_miaosha";
		
		/**
		 * xianjie_huoyuedu_linjiang	{玩家id,[[goodsid,count]…]}	每日兑换奖励的时候抛出
		 */
		public static final String XIANJIE_HUOYUEDU_LINJIANG="xianjie_huoyuedu_linjiang";	
		
		/**
		 * 排行活动获取物品
		 */
		public static final String HUODONG_RANK_AWARD = "huodong_rank_award";
		

		
		public static final String JINGJI_EVERYDAY_REWARD = "jingji_everyday_reward";
		public static final String JINGJI_EVERYHOUR_REWARD = "jingji_everyhour_reward";
		public static final String JINGJI_BUYCOUNT = "jingji_buycount";
		public static final String JINGJI_CLEARCD = "jingji_clearcd";
		public static final String JINGJI_REFRESHZHANLI = "jingji_refreshzhanli";
		
		//equip_cailiapjianding	{userRoleId,[[goodsId,count]..消耗],[[goods,count]..获得]}	鉴定材料合成时候抛出
		public static final String EQUIP_CAILIAPJIANDING = "equip_cailiapjianding";

		//微端登陆奖励
		public static final String WEIDUAN_REWARD = "weiduan_reward";
		
		//寻宝
		public static final String XUNBAO_GET_REWARDS = "xunbao_get_rewards";

		/**
		 * VIP开服领奖
		 */
		public static final String VIP_KAIFU_LINGQU = "vip_kaifu_lingqu";
		/**
		 * VIP开服抽奖
		 */
		public static final String VIP_KAIFU_CHOUJIANG = "vip_kaifu_choujiang";
		/**
		 * 坐骑升级返还
		 */
		public static final String ZUOQI_UPGRADE_FANHUAN = "zuoqi_upgrade_fanhuan";
		
		/**
		 * 7天登录(道具)
		 */
		public static final String LOGIN_REWARD_7 = "login_reward_7";

		/**
		 * 大富翁摇奖(花元宝    获得道具)
		 */
		public static final String DAFUWONG_YAOJIANG = "dafuwong_yaojiang";
		/**
		 *  大富翁兑换
		 */
		public static final String DAFUWONG_DUIHUAN = "dafuwong_duihuan";
		/**
		 * 头衔消耗(消耗道具)
		 */
		public static final String TOUXIAN_CHANGE = "touxian_change";
		/**
		 * 杀地煞七圣BOSS(获得铜钱)
		 */
		public static final String QISHENG_KILL_BOSS_REWARD = "qisheng_kill_boss_reward";
		/**
		 * 光翼进阶消耗
		 */
		public static final String GUANGYI_UPGRADE_LEVEL_DECR = "guangyi_upgrade_level_decr";
		/**
		 * 资源追回
		 */
		public static final String ZYDHUIHUAN_ZHUIHUI = "zydhuihuan_zhuihui";
		/**
		 * 合服活动奖励
		 */
		public static final String HEFUHUODONG_REWARD = "hefuhuodong_reward";
		/**
		 * 神秘转盘
		 */
		public static final String SHENMIZHUANPAN_CHANGE_RESOURCE = "shenmizhuanpan_change_resource";
		/**
		 * 神秘商店购买
		 */
		public static final String SHENMISHOP_BUY = "shenmishop_buy";
		/**
		 * 神秘商店 刷新
		 */
		public static final String SHENMISHOP_REFRESH = "shenmishop_refresh";
		
		//2013-11-22 15:26:44
		
		/**
		 * 祖巫升级 进阶 激活
		 */
		public static final String ZUWU_JINGJIE = "zuwu_jingjie";
		/**
		 * 祖巫副本完成
		 */
		public static final String ZUWUFUBEN_FINISH = "zuwufuben_finish";
		/**
		 * 祖巫副本刷新 和秒除cd
		 */
		public static final String ZUWUFUBEN_REFRESH = "zuwufuben_refresh";
		/**
		 * 技能书吞噬
		 */
		public static final String SKILL_BOOK_TUNSHI = "skill_book_tunshi";
		
		/**
		 * 寻宝激活
		 */
		public static final String XUNBAO_ACTIVATE = "xunbao_activate";
		/**
		 * 公会副本奖励
		 */
		public static final String GUILDFUBEN_REWARD = "guildfuben_reward";
		//2013-12-5 10:11:02
		/**
		 * 限时商城购买
		 */
		public static final String XIANSHIBUY_DECR = "xianshibuy_decr";
		
		/**
		 * 物品合成
		 */
		public static final String GOODS_HECHENG = "goods_hecheng";
		/**
		 * 手机验证
		 */
		public static final String PHONE_REWARD = "phone_reward";
		public static final String YINGYIN_REWARD = "yingyin_reward";

		public static final String BOOTH_SELL_YB = "booth_sell_yb";
		public static final String BOOTH_SELL_YXB = "booth_sell_yxb";
		
		//2013-12-13 11:04:49
		/**
		 * 72变广告
		 */
		public static final String CHANGE72_BUY = "change72_buy";
		/**
		 * 千服活动
		 */
		public static final String QIANFUHUODONG_REWARD = "qianfuhuodong_reward";
		/**
		 * 卡牌兑换
		 */
		public static final String KAPAI_DUIHUAN = "kapai_duihuan";
		/**
		 * 五连抽
		 */
		public static final String LIANCHOU_CHANGE_RESOURCE = "lianchou_change_resource";
		/**
		 * 限时团购
		 */
		public static final String XIANSHITUO_CHANGE_RESOURCE = "xianshituo_change_resource";
		
		/**
		 * 元神
		 */
		public static final String YUANSHEN_UPGRADE_LEVEL = "yuanshen_upgrade_level";
		
		/**
		 * 藏宝阁 --兑换物品
		 */
		public static final String CANGBAOGE_DUIHUAN_GOODS = "cangbaoge_duihuan_goods";
		/**
		 * 寻宝获得积分
		 */
		public static final String XUNBAO_JIFEN_GAIN = "xunbao_jifen_gain";
		/**
		 * 登录礼包
		 */
		public static final String LOGIN_LIBAO = "login_libao";
		

		/**
		 * 跨服消耗元宝
		 */
		public static final String KUAFU_LINGJIANG_DECRYB = "kuafu_lingjiang_decryb";
	
		
		/**
		 * 天命寻宝
		 */
		public static final String XUNBAO_TIANMING_REWARDS = "xunbao_tianming_rewards";
		
		/**
		 * 精彩活动
		 */
		public static final String JC_ACTIVITY_REWARD = "jc_activity_reward";

		/**
		 * 六连转 抽取
		 */
		public static final String SIX_ZHUANPAN_ZHUAN = "sixzhuanpan_zhuan";
		/**
		 * 六连转  刷新
		 */
		public static final String SIX_ZHUANPAN_FLUSH = "sixzhuanpan_flush";
		/**
		 * 使用元宝优惠卡
		 */
		public static final String  MALL_BUY2 = "mall_buy";
		
		/**
		 * 至尊特权
		 */
		public static final String  ZHIZUN_REWARD = "zhizun_reward";
		
		
		
		/**
		 * 神器进阶
		 */
		public static final String  SHENQI_JINJIE_CONSUME = "shenqi_jinjie_consume";
		/**
		 * 合成神丹
		 */
		public static final String  GOODS_HECHENG_SHENDAN = "goods_hecheng_shendan";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/**
	 * 元宝流水
	 */
	private static List<String> ybRelateEvents = new ArrayList<String>();

	/**
	 * 摆摊相关
	 */
	private static List<String> boothEvents = new ArrayList<String>();

	/**
	 * 物品消耗相关
	 */
	private static List<String> goodsComsume = new ArrayList<String>();

	private static Map<String, String> eventTypeMap = new HashMap<String, String>();

	static{
		
		ybRelateEvents.add(MALL_BUY);
		ybRelateEvents.add(ZUOQI_JINJIE);
		ybRelateEvents.add(EQUIP_JINJIE);
		ybRelateEvents.add(EQUIP_QIANGHUA);
		ybRelateEvents.add(EMAIL_GET_ITEM);
		ybRelateEvents.add(BOOTH_BUYYB);
		ybRelateEvents.add(BOOTH_SELLYB);
//		ybRelateEvents.add(TRADE);
		ybRelateEvents.add(RECHARGE_YB);
		ybRelateEvents.add(HUSONG_REFRESH);
		ybRelateEvents.add(HUSONG_SELECT);
		ybRelateEvents.add(TASK_RICHANG_COMPLETE);
		ybRelateEvents.add(TASK_RICHANG_COMPLETEBEST);
		ybRelateEvents.add(TASK_RICHANG_DECREASEDIFF);
		ybRelateEvents.add(TASK_RICHANG_KUAISUFINISH);
		ybRelateEvents.add(TASK_RICHANG_ZHIJIEFINISH);
		ybRelateEvents.add(DAFUWONG_YAOJIANG);
		ybRelateEvents.add(GUANGYI_UPGRADE_LEVEL_DECR);
		ybRelateEvents.add(ZYDHUIHUAN_ZHUIHUI);
		
		
		boothEvents.add(BOOTH_BUGGOODS);
		boothEvents.add(BOOTH_BUYJB);
		boothEvents.add(BOOTH_BUYYB);
		boothEvents.add(BOOTH_SELLGOODS);
		boothEvents.add(BOOTH_SELLJB);
		boothEvents.add(BOOTH_SELLYB);
		
		goodsComsume.add(PROP_USE);
		goodsComsume.add(GOODS_SELL);
		goodsComsume.add(TOUXIAN_CHANGE);
		

		eventTypeMap.put(BOOTH_BUYYB, "摆摊购买元宝");
		eventTypeMap.put(BOOTH_SELLYB, "摆摊出售元宝");
		eventTypeMap.put(BOOTH_SELLJB, "摆摊出售游戏币");
		eventTypeMap.put(BOOTH_BUYJB, "摆摊购买游戏币");
		eventTypeMap.put(BOOTH_SELLGOODS, "摆摊出售道具");
		eventTypeMap.put(BOOTH_BUGGOODS, "摆摊购买道具");
		
		eventTypeMap.put(BAG_DROP_GOODS, "丢弃物品");
		eventTypeMap.put(BAG_OPEN, "背包开格位");

		eventTypeMap.put(BAIXIAN_REWARD, "拜仙");
		
		eventTypeMap.put(CHENGJIU_FINISH, "成就达成");
		eventTypeMap.put(DAFUWONG_YAOJIANG, "大富翁摇奖");

		eventTypeMap.put(GUANGYI_UPGRADE_LEVEL_DECR, "光翼进阶消耗");
		eventTypeMap.put(HUODONG_MALL_BUY, "活动商城购买");
		eventTypeMap.put(HUOYUEDU_MIAOSHA, "活跃度秒杀");
		
		eventTypeMap.put(JINGJI_BUYCOUNT, "竞技场购买次数");
		eventTypeMap.put(JINGJI_CLEARCD, "竞技场清除CD");
		eventTypeMap.put(JINGJI_REFRESHZHANLI, "竞技场刷新战力");

		eventTypeMap.put(STAGE_MEIREN_REVIVE, "美人复活");

		eventTypeMap.put(TOUBAO_LEVEL, "等级投保");
		eventTypeMap.put(TOUBAO_MONTH, "月投保");

		eventTypeMap.put(XUNBAO_GET_REWARDS, "寻宝");
		eventTypeMap.put(ZYDHUIHUAN_ZHUIHUI, "资源追回");
		
		eventTypeMap.put(BAOSHI_JIHUO, "宝石激活");
		eventTypeMap.put(BAOSHI_LEVEL_UPGRADE, "宝石等级提升");
		
		eventTypeMap.put(EMAIL_CREATE, "邮件创建");
		eventTypeMap.put(EMAIL_DELETE, "邮件删除");
		eventTypeMap.put(EMAIL_READ, "邮件阅读");
		eventTypeMap.put(EMAIL_GET_ITEM, "邮件获取附件");
		
		eventTypeMap.put(EQUIP_JIANDING, "装备鉴定");
		eventTypeMap.put(EQUIP_JIANDING_QINGXI, "装备鉴定清洗");
		eventTypeMap.put(EQUIP_JINJIE, "装备进阶");
		eventTypeMap.put(EQUIP_QIANGHUA, "装备强化");
		eventTypeMap.put(EQUIP_QIANGHUA_QINGXI, "装备强化清洗");
		

		eventTypeMap.put(GONGHUI_TASK_FINISH, "公会任务完成");
		
		eventTypeMap.put(GOODS_EXCHANGE, "物品兑换");

		eventTypeMap.put(HUODONG_REWARDS, "活动奖励领取");
		
		eventTypeMap.put(HUSONG_FAIL_AWARDS, "护送失败奖励");
		eventTypeMap.put(HUSONG_SUCCESS_AWARDS, "护送成功奖励");
		eventTypeMap.put(HUSONG_STEAL_AWARDS, "护送打劫奖励");
		eventTypeMap.put(HUSONG_SELECT, "护送直接选取美妻");
		eventTypeMap.put(HUSONG_REFRESH, "护送刷新美妻");
		
		eventTypeMap.put(JIANGLI_ONLINE_REWARD_MONEY, "在线奖励获得金钱");
		eventTypeMap.put(JIANGLI_QIANDAO_GET_GOODS, "获取签到物品");
		eventTypeMap.put(JIANGLI_YAOJIANG_GET_GOODS, "摇奖获得物品");
		eventTypeMap.put(JIANGLI_ZHOUMO_QIANDAO_GETGOODS, "周末签到获得物品");
		
		eventTypeMap.put(JUQING_FINISH, "剧情副本完成");
		eventTypeMap.put(JUQINGFUBEN_ACCELERATE, "剧情副本加速扫荡");
		eventTypeMap.put(JUQINGFUBEN_AWARD, "领取剧情副本奖励");

		eventTypeMap.put(LVLIBAO_LINGQU, "领取等级礼包");
		
		eventTypeMap.put(MALL_BUY, "商城购买");
		
		eventTypeMap.put(MEIREN_CHANMIAN, "美人缠绵");
		eventTypeMap.put(MEIREN_LINGQU, "美人领取");
		eventTypeMap.put(MEIREN_UPGRADE, "美人等级提升");
		
		eventTypeMap.put(PROP_USE, "道具使用");
		eventTypeMap.put(GOODS_SELL, "物品出售");
		eventTypeMap.put(PROP_USE_ACQUIRE, "道具使用后获得与消耗");
		
		eventTypeMap.put(RECHARGE_YB, "元宝充值");
		
		eventTypeMap.put(ROLE_CREATE, "角色创建");
		eventTypeMap.put(ROLE_LEVEL_UPGRADE, "角色升级");
		eventTypeMap.put(ROLE_LOGIN, "角色登陆");
		eventTypeMap.put(ROLE_LOGOUT, "角色登出");
		

		eventTypeMap.put(SHENJIANG_ACTIVATE, "激活神将");
		eventTypeMap.put(SHENJIANG_ACTIVATE_FAIL, "激活神将失败");
		eventTypeMap.put(SHENJIANG_JIHUO_JXT, "激活将星图");
		eventTypeMap.put(SHENJIANG_JIHUO_JXT_FAIL, "激活将星图失败");
		eventTypeMap.put(SHENJIANG_JXT_DECR, "将星图进阶消耗");
		eventTypeMap.put(SHENJIANG_JXT_EXP_SHARE, "将星图经验分享");
		eventTypeMap.put(SHENJIANG_SKILL_UPGRADE, "神将技能升级");
		eventTypeMap.put(SHENJIANG_SKILL_UPGRADE_DECR, "神将技能升级消耗");
		
		eventTypeMap.put(SHENJIANGJINDI_AWARD, "神将禁地获取奖励");
		eventTypeMap.put(SHENJIANGJINDI_ENTER, "神将禁地进入");
		eventTypeMap.put(SHENJIANGJINDI_GATHERBOSS, "神将禁地挖BOSS");

		eventTypeMap.put(STAGE_GATHER, "采集获得奖励");
		eventTypeMap.put(STAGE_PICKUP_GOODS, "拾取物品");
		eventTypeMap.put(STAGE_PICKUP_YXB, "拾取游戏币");
		eventTypeMap.put(STAGE_ROLE_REVIVE, "角色复活");
		eventTypeMap.put(STAGE_ROLE_TELEPORT, "筋斗云传送花费");
		eventTypeMap.put(STAGE_ZUOQI_RECOVERYHP, "坐骑瞬间回满血消耗");
		eventTypeMap.put(STAGE_ZUOQI_REVIVE, "坐骑复活");
		
		eventTypeMap.put(SKILL_UPGRADE, "技能升级");
		eventTypeMap.put(SKILL_USE_BOOK, "使用技能书");

		eventTypeMap.put(QIZHANBINQI_UPGRADE, GameLogEventTypeName.QIZHANBINQI_UPGRADE);

		eventTypeMap.put(TASK_RICHANG_COMPLETE, GameLogEventTypeName.TASK_RICHANG_COMPLETE);
		eventTypeMap.put(TASK_RICHANG_COMPLETEBEST, GameLogEventTypeName.TASK_RICHANG_COMPLETEBEST);
		eventTypeMap.put(TASK_RICHANG_DECREASEDIFF, GameLogEventTypeName.TASK_RICHANG_DECREASEDIFF);
		eventTypeMap.put(TASK_RICHANG_KUAISUFINISH, GameLogEventTypeName.TASK_RICHANG_KUAISUFINISH);
		eventTypeMap.put(TASK_RICHANG_ZHIJIEFINISH, GameLogEventTypeName.TASK_RICHANG_ZHIJIEFINISH);
		eventTypeMap.put(TASK_MAIN_FINISH, GameLogEventTypeName.TASK_MAIN_FINISH);
		eventTypeMap.put(TASK_TAOFA_FINISH, GameLogEventTypeName.TASK_TAOFA_FINISH);
		eventTypeMap.put(TASK_RICHANG_FINISH, GameLogEventTypeName.TASK_RICHANG_FINISH);
		
		eventTypeMap.put(TRADE, GameLogEventTypeName.TRADE);

		eventTypeMap.put(VIP_BUY_LIBAO, GameLogEventTypeName.VIP_BUY_LIBAO);
		eventTypeMap.put(VIP_LINGQU_DAYLIBAO, GameLogEventTypeName.VIP_LINGQU_DAYLIBAO);
		eventTypeMap.put(VIP_LINGQU_WEEKLIBAO, GameLogEventTypeName.VIP_LINGQU_WEEKLIBAO);
		
		eventTypeMap.put(ZUOQI_JINJIE, GameLogEventTypeName.ZUOQI_JINJIE);

		eventTypeMap.put(JINGJI_EVERYDAY_REWARD, GameLogEventTypeName.JINGJI_EVERYDAY_REWARD);
		eventTypeMap.put(JINGJI_EVERYHOUR_REWARD, GameLogEventTypeName.JINGJI_EVERYHOUR_REWARD);
		

		eventTypeMap.put(XIANJIE_CHENGHAO_JIHUO, GameLogEventTypeName.XIANJIE_CHENGHAO_JIHUO);
		eventTypeMap.put(XIANJIE_CHENGHAO_DUIHUAN, GameLogEventTypeName.XIANJIE_CHENGHAO_DUIHUAN);
		eventTypeMap.put(TOUBAO_LINGQU_MONTH, GameLogEventTypeName.TOUBAO_LINGQU_MONTH);
		eventTypeMap.put(TOUBAO_LINGQU_LEVEL, GameLogEventTypeName.TOUBAO_LINGQU_LEVEL);

		eventTypeMap.put(XIANSHIBUY_DECR, GameLogEventTypeName.XIANSHIBUY_DECR);
		eventTypeMap.put(GOODS_HECHENG, GameLogEventTypeName.GOODS_HECHENG);
		eventTypeMap.put(GUILDFUBEN_REWARD, GameLogEventTypeName.GUILDFUBEN_REWARD);
		eventTypeMap.put(XUNBAO_ACTIVATE, GameLogEventTypeName.XUNBAO_ACTIVATE);
		eventTypeMap.put(SKILL_BOOK_TUNSHI, GameLogEventTypeName.SKILL_BOOK_TUNSHI);
		eventTypeMap.put(ZUWUFUBEN_REFRESH, GameLogEventTypeName.ZUWUFUBEN_REFRESH);
		eventTypeMap.put(ZUWUFUBEN_FINISH, GameLogEventTypeName.ZUWUFUBEN_FINISH);
		eventTypeMap.put(ZUWU_JINGJIE, GameLogEventTypeName.ZUWU_JINGJIE);
		eventTypeMap.put(SHENMISHOP_REFRESH, GameLogEventTypeName.SHENMISHOP_REFRESH);
		eventTypeMap.put(SHENMISHOP_BUY, GameLogEventTypeName.SHENMISHOP_BUY);
		eventTypeMap.put(SHENMIZHUANPAN_CHANGE_RESOURCE, GameLogEventTypeName.SHENMIZHUANPAN_CHANGE_RESOURCE);
		eventTypeMap.put(HEFUHUODONG_REWARD, GameLogEventTypeName.HEFUHUODONG_REWARD);
		eventTypeMap.put(ZYDHUIHUAN_ZHUIHUI, GameLogEventTypeName.ZYDHUIHUAN_ZHUIHUI);
		eventTypeMap.put(QISHENG_KILL_BOSS_REWARD, GameLogEventTypeName.QISHENG_KILL_BOSS_REWARD);
		eventTypeMap.put(TOUXIAN_CHANGE, GameLogEventTypeName.TOUXIAN_CHANGE);
		eventTypeMap.put(DAFUWONG_DUIHUAN, GameLogEventTypeName.DAFUWONG_DUIHUAN);
		eventTypeMap.put(LOGIN_REWARD_7, GameLogEventTypeName.LOGIN_REWARD_7);
		eventTypeMap.put(ZUOQI_UPGRADE_FANHUAN, GameLogEventTypeName.ZUOQI_UPGRADE_FANHUAN);
		eventTypeMap.put(VIP_KAIFU_CHOUJIANG, GameLogEventTypeName.VIP_KAIFU_CHOUJIANG);
		eventTypeMap.put(VIP_KAIFU_LINGQU, GameLogEventTypeName.VIP_KAIFU_LINGQU);
		eventTypeMap.put(XUNBAO_GET_REWARDS, GameLogEventTypeName.XUNBAO_GET_REWARDS);
		eventTypeMap.put(WEIDUAN_REWARD, GameLogEventTypeName.WEIDUAN_REWARD);
		eventTypeMap.put(EQUIP_CAILIAPJIANDING, GameLogEventTypeName.EQUIP_CAILIAPJIANDING);
		eventTypeMap.put(JINGJI_EVERYHOUR_REWARD, GameLogEventTypeName.JINGJI_EVERYHOUR_REWARD);
		eventTypeMap.put(XIANJIE_HUOYUEDU_LINJIANG, GameLogEventTypeName.XIANJIE_HUOYUEDU_LINJIANG);
		eventTypeMap.put(XIANJIE_CHENGHAO_QIYONG, GameLogEventTypeName.XIANJIE_CHENGHAO_QIYONG);
		eventTypeMap.put(YINGYIN_REWARD, GameLogEventTypeName.YINGYIN_REWARD);
		eventTypeMap.put(PHONE_REWARD, GameLogEventTypeName.PHONE_REWARD);
		
		eventTypeMap.put(CHANGE72_BUY, GameLogEventTypeName.CHANGE72_BUY);
		eventTypeMap.put(QIANFUHUODONG_REWARD, GameLogEventTypeName.QIANFUHUODONG_REWARD);
		eventTypeMap.put(KAPAI_DUIHUAN, GameLogEventTypeName.KAPAI_DUIHUAN);
		eventTypeMap.put(LIANCHOU_CHANGE_RESOURCE, GameLogEventTypeName.LIANCHOU_CHANGE_RESOURCE);
		eventTypeMap.put(XIANSHITUO_CHANGE_RESOURCE, GameLogEventTypeName.XIANSHITUO_CHANGE_RESOURCE);
		eventTypeMap.put(YUANSHEN_UPGRADE_LEVEL, GameLogEventTypeName.YUANSHEN_UPGRADE_LEVEL);
		eventTypeMap.put(CANGBAOGE_DUIHUAN_GOODS, GameLogEventTypeName.CANGBAOGE_DUIHUAN_GOODS);
		eventTypeMap.put(XUNBAO_JIFEN_GAIN, GameLogEventTypeName.XUNBAO_JIFEN_GAIN);
		eventTypeMap.put(LOGIN_LIBAO, GameLogEventTypeName.LOGIN_LIBAO);
		eventTypeMap.put(KUAFU_LINGJIANG_DECRYB, GameLogEventTypeName.KUAFU_LINGJIANG_DECRYB);
		eventTypeMap.put(XUNBAO_TIANMING_REWARDS, GameLogEventTypeName.XUNBAO_TIANMING_REWARDS);
		eventTypeMap.put(JC_ACTIVITY_REWARD, GameLogEventTypeName.JC_ACTIVITY_REWARD);
		
		eventTypeMap.put(SIX_ZHUANPAN_ZHUAN, GameLogEventTypeName.SIX_ZHUANPAN_ZHUAN);
		eventTypeMap.put(SIX_ZHUANPAN_FLUSH, GameLogEventTypeName.SIX_ZHUANPAN_FLUSH);
		eventTypeMap.put(MALL_BUY2, GameLogEventTypeName.MALL_BUY2);
		eventTypeMap.put(ZHIZUN_REWARD, GameLogEventTypeName.ZHIZUN_REWARD);
		
		eventTypeMap.put(SHENQI_JINJIE_CONSUME, GameLogEventTypeName.SHENQI_JINJIE_CONSUME);
		eventTypeMap.put(GOODS_HECHENG_SHENDAN, GameLogEventTypeName.GOODS_HECHENG_SHENDAN);
		
		
		
		
		
		
	}
	
	public static boolean containYbEvent(String eventType) {
		return ybRelateEvents.contains(eventType);
	}
	
	public static boolean containBoothEvent(String eventType) {
		return boothEvents.contains(eventType);
	}
	
	public static String convertEventTypeToString(String eventType){
		return eventTypeMap.get(eventType);
	}
	
	public static Map<String,String> getEventTypeMap(){
		return eventTypeMap;
	}


}
