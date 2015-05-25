package com.lingyu.dntg.service.init;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.vo.ActionInfo;
import com.lingyu.dntg.service.sm.ActionInfoService;

/**
 * 初始更新菜单记录
 * @author donghui
 */
@Component
public class InitActionInfo {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	@Resource private ActionInfoService actionInfoService;
	
	@PostConstruct
	public void init(){
		log.info("读取菜单配置文件,并更新所有数据库记录");
		List<ActionInfo> actionInfoList = actionInfoService.getAllbyPropertiesFile();
		actionInfoService.initAll(actionInfoList);
	}
	
}
