package com.lingyu.dntg.service.sm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.dao.base.exception.NullServerServerException;
import com.lingyu.dntg.service.AbstractService;
import com.lingyu.dntg.util.DbConnectionUtils;

@Component
public class GameServerService extends AbstractService {
	
	/**
	 * 根据权限得到相关服务器
	 * @param sessionUser 登陆用户
	 * @return key=运营商名 value=运营商下的所有服务器集合
	 */
	public Map selectAllSortGameServersByUserId(SessionUser sessionUser){
		MultiValueMap mvMap = MultiValueMap.decorate(new LinkedHashMap()) ;
		List<Map> mapList = toolDaoTemplate.selectList("gameServer.loadAllServerSortAndGameServerByUserId", sessionUser);
		for (Map map : mapList) {
			String sortName = MapUtils.getString(map, "sortName");
			mvMap.put(sortName, map);
		}
		return mvMap;
	}
	
	/**
	 * 管理员权限下随便设置一个可连接的serverId为默认
	 * @param userId 用户ID(主键)
	 */
	public String getDefaultServerIds(){
		List<String> list = toolDaoTemplate.selectList("gameServer.getServerIdsByAllserver");
		for (String serverId : list) {
			if (DbConnectionUtils.testGameServer(serverId)) {
				return serverId;
			}
		}
		log.error(null, new NullServerServerException("用户登陆得到可用的默认服务器失败"));
		return null;
	}
	
	public List<String> getAllServerGateUrl() {
		return toolDaoTemplate.selectList("gameServer.getAllServerGateurl");
	}

	/**
	 * 得到所有没有被跨服选中过的服务器
	 */
	public Map getKuafaServer(String kuafuId){
		MultiValueMap mvMap = MultiValueMap.decorate(new LinkedHashMap());
		List<Map> list = toolDaoTemplate.selectList("gameServer.getkuafuSever", kuafuId);
		for (Map map : list) {
			String sortName = MapUtils.getString(map, "sortName");
			mvMap.put(sortName, map);
		}
		return mvMap; 
	}
	
}
