package com.lingyu.dntg.action.gt;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.remoteInvoke.WebServiceFactory;
import com.xianling.remoteservice.goods.SendEquip;

/**
 * 装备发放列表
 * @author donghui
 */
@Controller
@RequestMapping("sendEquipList")
public class SendEquipListAction extends AbstractAction{
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list",toolDaoTemplate.paging("sendEquipLog.index", paramMap));
		return DEFAULT_PATH;
	}
	
	/**
	 * 发送装备页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap){
		return DEFAULT_PATH;
	}
	
	/**
	 * 发送装备
	 */
	@RequestMapping("save")
	public String send(HttpServletRequest request, ModelMap modelMap){
		Map paramMap = (Map)request.getAttribute("paramMap");
		String equipName = MapUtils.getString(paramMap, "equipName");
		String title = MapUtils.getString(paramMap, "title");
		String content = MapUtils.getString(paramMap, "content");
		String userName = MapUtils.getString(paramMap, "userName");
		String userId = gameDaoTemplate.selectOne("userRole.existName",userName);
		String msg = "";
		try {
			SendEquip sendEquip = WebServiceFactory.getWSSimple(SendEquip.class);
			String result = sendEquip.sendEquip(new String[]{userId}, equipName, title, content);
			if ("1".equals(result)) {
				msg = "成功";
				toolDaoTemplate.insert("sendEquipLog.insert", paramMap);
			}
			else if ("2".equals(result)) {
				msg = "生成物品错误 ";
			}
			else if ("3".equals(result)) {
				 msg = "参数不全";
			}
		} catch (Exception e) {
			msg = "发送装备远程异常";
		}
		log.info("发送装备成功, 装备:[{}] 收件人userName:[{}] userId:[{}]", equipName, userName, userId);
		modelMap.put("result", msg);
		return "redirect:./index.do";
	}
	
}