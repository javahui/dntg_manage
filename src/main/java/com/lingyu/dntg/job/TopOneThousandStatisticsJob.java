package com.lingyu.dntg.job;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import com.alibaba.fastjson.JSON;
import com.lingyu.dntg.bean.pojo.MingRenTangConfig;
import com.lingyu.dntg.bean.pojo.MingRenTangUser;
import com.lingyu.dntg.dao.base.AbstractDao;
import com.lingyu.dntg.util.ConfigConstants.MingRenTangConfigtype;

/**
 * @author donghui
 */
@Component
public class TopOneThousandStatisticsJob extends AbstractDao{
	
	public void run() {
		this.recharge();
		this.ybConsumeUser();
		this.zhandouli();
	}

	/**
	 * 统计所有服前一千名充值用户
	 */
	public void recharge() {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("开始统计明人堂充值用户");
		MingRenTangConfig mingRenTangConfig = toolDaoTemplate.selectOne("mingRenTangConfig.getTimeByType", MingRenTangConfigtype.RECHARGE.value);
		if (mingRenTangConfig == null) {
			log.warn("没有找到[充值用户]的明人堂的配置记录");
			return;
		}
		List<MingRenTangUser> list = gameDaoTemplate.selectListAllServers("rechargeRecord.getTopOneHundredRechargeUser", mingRenTangConfig);
		this.writeFile(mingRenTangConfig, list);
		log.info("统计前明人堂充值用户 用时:{}", sw.getTime());
	}
	
	/**
	 * 统计所有服前一千名元宝花费用户
	 */
	public void ybConsumeUser() {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("开始统计明人堂元宝花费用户");
		MingRenTangConfig mingRenTangConfig = toolDaoTemplate.selectOne("mingRenTangConfig.getTimeByType", MingRenTangConfigtype.CONSUME.value);
		if (mingRenTangConfig == null) {
			log.warn("没有找到[元宝花费]的明人堂的配置记录");
			return;
		}
		List<MingRenTangUser> list = gameDaoTemplate.selectListAllServers("roleDeceAccount.getOneHundredUser", mingRenTangConfig);
		this.writeFile(mingRenTangConfig, list);
		log.info("统计前明人堂元宝花费用户 用时:{}", sw.getTime());
	}
	
	/**
	 * 统计所有服前一千名战斗力
	 */
	public void zhandouli() {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("开始统计明人堂战斗力用户");
		MingRenTangConfig mingRenTangConfig =  toolDaoTemplate.selectOne("mingRenTangConfig.getTimeByType", MingRenTangConfigtype.ZHOUDOULI.value);
		if (mingRenTangConfig == null) {
			log.warn("没有找到[战斗力]的明人堂的配置记录");
			return;
		}
		List<MingRenTangUser> list = gameDaoTemplate.selectListAllServers("rankZhandouli.getTopOneHundredZhandouli", mingRenTangConfig);
		this.writeFile(mingRenTangConfig, list);
		log.info("统计明人堂元宝花费用户 用时:{}", sw.getTime());
	}

	/**
	 * 排序后取List集合前一千生成文件放在WebRoot/upload/top目录下
	 */
	private void writeFile(MingRenTangConfig mingRenTangConfig, List<MingRenTangUser> list){
		Collections.sort(list);
		if (list.size() > 1000) {
			list = list.subList(0, 1000);
		}
		int index = 1;
		for (MingRenTangUser user : list) {
			user.setIndex(index);
			index ++;
		}
		String path = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/") + "/upload/top/";
		File file = new File(path + mingRenTangConfig.getVersion() + "-" + mingRenTangConfig.getType());
		String jsonString = JSON.toJSONString(list, true);
		try {
			FileUtils.write(file, jsonString, "UTF-8");
		} catch (IOException e) {
			log.info(null, e);
		}
	}
	
	
}