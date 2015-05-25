package com.lingyu.dntg.constants.log;

import java.util.HashMap;
import java.util.Map;

public class RoleConstant {
	//坐骑
	private static final int ZUOQI = -5;
	//时装
	private static final int SHIZHUANG = -65;
	//武器
	private static final int WEAPON = -70;
	//头盔
	private static final int HEADER = -55;
	//发型
	private static final int HAIR = -50;
	//护肩
	private static final int HUJIAN = -45;
	//上衣
	private static final int SHANGYI = -40;
	//下装
	private static final int XIAZHUANG = -25;
	//鞋子
	private static final int SHOE = -20;
	//翅膀
	private static final int CHIBANG = -43;
	//颈部
	private static final int JINGBU = -80;
	//腰部
	private static final int YAOBU = -81;
	//手套
	private static final int SHOUTAO = -82;
	//戒指
	private static final int JIEZHI = -85;
	private static final int JIEZHI1 = -86;
	//装饰
	private static final int ZHUANGSHI = -90;
	private static final int ZHUANGSHI1 = -91;
	
	
	private static final Map<Integer, String> equipPartMap = new HashMap<Integer, String>();
	static{
		equipPartMap.put(ZUOQI, "坐骑");
		equipPartMap.put(SHIZHUANG, "时装");
		equipPartMap.put(WEAPON, "武器");
		equipPartMap.put(HEADER, "头盔");
		equipPartMap.put(HAIR, "发型");
		equipPartMap.put(HUJIAN, "护肩");
		equipPartMap.put(SHANGYI, "上衣");
		equipPartMap.put(XIAZHUANG, "下装");
		equipPartMap.put(SHOE, "鞋子");
		equipPartMap.put(CHIBANG, "翅膀");
		equipPartMap.put(JINGBU, "肩部");
		equipPartMap.put(YAOBU, "腰部");
		equipPartMap.put(SHOUTAO, "手套");
		equipPartMap.put(JIEZHI, "戒指");
		equipPartMap.put(JIEZHI1, "戒指");
		equipPartMap.put(ZHUANGSHI, "装饰");
		equipPartMap.put(ZHUANGSHI1, "装饰");
	}
	
	public static Map<Integer, String> getEquipMap(){
		return equipPartMap;
	}
	
	
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	
}
