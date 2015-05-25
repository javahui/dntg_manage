/**
 * 
 */
package com.lingyu.dntg.service.gt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingyu.dntg.dao.base.daoTemplate.GameDaoTemplate;
import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;

/**
 * @author Zhu Xingsheng
 * @date 2013-12-12 下午2:18:04
 */
@Service
public class ZhandouliService {
	
	@Autowired
	private GameDaoTemplate gameDaoTemplate;
	@Autowired
	private ToolDaoTemplate toolDaoTemplate;
	
	public void updateZhandouliRank(){
		int batchSize = 1000;
		toolDaoTemplate.delete("serverRankTotal.deleteAll");
		String sql = "rankZhandouli.selectRankZhandouli";
		int limit = 500;
		Map<String, List<Map<String,Object>>> result = gameDaoTemplate.selectMapAllServers(sql, limit);
		Collection<List<Map<String, Object>>> values = result.values();
		List<Map<String,Object>> t = new ArrayList<Map<String,Object>>(batchSize);
		for(List<Map<String, Object>> list:values){
			t.addAll(list);
			if(t.size()>=batchSize){
				toolDaoTemplate.insert("serverRankTotal.batchinsert", t);
				t.clear();
			}
		}
		if(!t.isEmpty()){
			toolDaoTemplate.insert("serverRankTotal.batchinsert", t);
			t.clear();
		}
	}

}
