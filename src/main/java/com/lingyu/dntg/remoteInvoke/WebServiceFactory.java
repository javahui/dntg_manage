package com.lingyu.dntg.remoteInvoke;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.lingyu.dntg.dao.base.daoTemplate.ToolDaoTemplate;
import com.lingyu.dntg.dao.base.dynamicDataSource.LookupContext;
import com.xianling.remoteservice.account.Recharge;
import com.xianling.remoteservice.email.SystemEmail;
import com.xianling.remoteservice.goods.SendEquip;
import com.xianling.remoteservice.gs.GsCount;
import com.xianling.remoteservice.guild.DelGuild;
import com.xianling.remoteservice.notice.SystemNotice;
import com.xianling.remoteservice.pnotice.PNotice;
import com.xianling.remoteservice.role.Account;
import com.xianling.remoteservice.role.RoleType;
import com.xianling.remoteservice.shutup.ShutUpFreeze;
import com.xianling.remoteservice.vipqq.VipQQRemoteService;

@Component
public class WebServiceFactory implements ApplicationContextAware {
	protected static final Logger log = LoggerFactory.getLogger(WebServiceFactory.class);
	private static ConcurrentHashMap<String, Map<String, Object>> websServiceMap = new ConcurrentHashMap<String, Map<String,Object>>();
	private static ExecutorService exec = Executors.newCachedThreadPool();
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {WebServiceFactory.applicationContext = applicationContext;}
	
	/**
	 * 每新加一个webService都需在此注册
	 */
	private static Map<Class, String[]> wsParamMap = new HashMap<Class, String[]>();
	static{
		wsParamMap.put(Recharge.class, new String[]{"Recharge", "RechargeEndPointPort", "account"});
		wsParamMap.put(SystemEmail.class, new String[]{"SystemEmail", "SystemEmailEndPointPort", "email"});
		wsParamMap.put(SendEquip.class, new String[]{"SendEquip", "SendEquipEndPointPort", "goods"});
		wsParamMap.put(GsCount.class, new String[]{"GsCount", "GsCountEndPointPort", "gs"});
		wsParamMap.put(SystemNotice.class, new String[]{"SystemNotice", "SystemNoticeEndPointPort", "notice"});
		wsParamMap.put(PNotice.class, new String[]{"PNotice", "PNoticeEndPointPort", "pnotice"});
		wsParamMap.put(Account.class, new String[]{"Account", "AccountEndPointPort", "role"});
		wsParamMap.put(RoleType.class, new String[]{"RoleType", "RoleTypeEndPointPort", "role"});
		wsParamMap.put(ShutUpFreeze.class, new String[]{"ShutUpFreeze", "ShutUpFreezeEndPointPort", "shutup"});
		wsParamMap.put(VipQQRemoteService.class, new String[]{"VipQQRemoteService", "VipQQRemoteServiceEndPointPort", "vipqq"});
		wsParamMap.put(DelGuild.class, new String[]{"DelGuild", "DelGuildEndPointPort", "guild"});
	}


	public static <T> T getWSSimple(final Class<T> clz) throws Exception{
		String serverId = LookupContext.getCurrentServerId();
		return WebServiceFactory.getWSSimple(serverId, clz, 3);
	}
	public static <T> T getWSSimple(String serverId,final Class<T> clz) throws Exception{
		return WebServiceFactory.getWSSimple(serverId, clz, 3);
	}
	
	public static <T> T getWSSimple(String serverId, final Class<T> clz, int timeout) throws Exception{
		Map<String, Object> serverMap = websServiceMap.get(serverId);
		if (serverMap == null) {
			serverMap = new HashMap();
		}
		websServiceMap.putIfAbsent(serverId, serverMap);
		
		Object webObj = serverMap.get(clz);
		if (webObj == null){
			ToolDaoTemplate toolDaoTemplate = applicationContext.getBean(ToolDaoTemplate.class); 
			String gameServerRemoteUrl = toolDaoTemplate.selectOne("gameServer.getGameServerRemoteUrlByServerId", serverId);
			if (StringUtils.isBlank(gameServerRemoteUrl)) {
				log.warn("服务器:[{}]远程连接为空", serverId);
			}
			//远程请求参数
			final String[] paramArray = wsParamMap.get(clz);
			final String qnameStr = "http://"+paramArray[2]+".remoteservice.xianling.com/";
			final URL url = new URL(gameServerRemoteUrl + "/" +paramArray[0]+ "?wsdl");
			Future<Object> future = exec.submit(new Callable<Object>() {
				 @Override
				 public Object call() throws Exception {
					log.info("远程请求 url:{}" ,url);
					Service service = Service.create(url, new QName(qnameStr, clz.getSimpleName()));
			        return service.getPort(new QName(qnameStr, paramArray[1]), clz);
				 } 
			 });
			 try {
				webObj = future.get(timeout, TimeUnit.SECONDS);
				if( webObj != null ){
					serverMap.put(paramArray[0], webObj);
				}
			} catch (Exception e) {
				log.error("服务器:" + serverId + " url:" + url, e);
				future.cancel(true);
				throw e;
			}
		}
		return (T)webObj;
	}

}
