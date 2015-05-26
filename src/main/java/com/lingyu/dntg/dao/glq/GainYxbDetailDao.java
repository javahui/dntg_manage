package com.lingyu.dntg.dao.glq;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.dao.base.AbstractDao;

/**
 * 游戏币获取详细日志DAO
 * @author lian zhibin
 */
@Component
public class GainYxbDetailDao extends AbstractDao{

	
	/**
	 * 查询一个月份的数据
	 * @param month 月份
	 * @param paramMap	查询
	 */
	public PagingList selectByMonth(String month, Map paramMap){
		if (isExistTableByMonth(month)) {
			if (paramMap == null) {paramMap = new HashMap();}
			paramMap.put("month", month);
			return logDaoTemplate.paging("gainYxbDetail.index", paramMap);
		}
		else{
			return new PagingList();
		}
	}
	
	/**
	 *	判断一个consume_bindyb_detail_yyyy_mm形式的表名是否存在
	 * @param month 月份
	 */
	public boolean isExistTableByMonth(String month){
		String result = logDaoTemplate.selectOne("gainYxbDetail.existTableByMonth", month);
		return StringUtils.isNotBlank(result);
	}
}