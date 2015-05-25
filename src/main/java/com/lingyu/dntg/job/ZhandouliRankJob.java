/**
 * 
 */
package com.lingyu.dntg.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.service.gt.ZhandouliService;

/**
 * @author Zhu Xingsheng
 * @date 2013-12-12 下午2:10:42
 */
@Component
public class ZhandouliRankJob {
	@Autowired
	private ZhandouliService zhandouliService;
	public void run(){
		zhandouliService.updateZhandouliRank();
	}

}
