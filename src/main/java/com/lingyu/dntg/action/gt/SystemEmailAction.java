package com.lingyu.dntg.action.gt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.bean.pojo.SystemEmailPojo;
import com.lingyu.dntg.bean.vo.SessionUser;
import com.lingyu.dntg.bean.vo.SystemEmailVO;
import com.lingyu.dntg.bean.vo.analyze.Goods;
import com.lingyu.dntg.bean.vo.pagin.PagingList;
import com.lingyu.dntg.service.analyze.GoodsAnalyzeService;
import com.lingyu.dntg.service.gt.SystemEmailService;
import com.lingyu.dntg.util.ConfigConstants;

/**
 * 系统邮件
 * @author donghui
 */
@Controller
@RequestMapping("systemEmail")
public class SystemEmailAction extends AbstractAction{
	@Resource private SystemEmailService systemEmailService;
	@Resource private GoodsAnalyzeService goodsAnalyzeService;
	
	private static ExecutorService exec = Executors.newFixedThreadPool(20);
	/**
	 * 系统邮件列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		PagingList<Map> pagingList = toolDaoTemplate.paging("systemEmail.index", paramMap);
		this.updateAttachmentsGoodsIdToGoodsName(pagingList);
		modelMap.put("list", pagingList);
		return DEFAULT_PATH;
	}
	
	/**
	 * 系统邮件审批列表
	 */
	@RequestMapping("indexAudit")
	public String indexAudit(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		PagingList<Map> pagingList = toolDaoTemplate.paging("systemEmail.indexAudit", paramMap);
		this.updateAttachmentsGoodsIdToGoodsName(pagingList);
		modelMap.put("list", pagingList);
		return DEFAULT_PATH;
	}
	
	/**
	 * 申请发放页面
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("goodsMap", goodsAnalyzeService.getGoods());
		return DEFAULT_PATH;
	}
	
	/**
	 * 超级会员转发到申请发放页面
	 */
	@RequestMapping("addRoleQqList")
	public String addRoleQqList(HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("goodsMap", goodsAnalyzeService.getGoods());
		return DEFAULT_PATH;
	}
	
	/**
	 * 申请发放
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(SystemEmailVO systemEmailVO, ModelMap modelMap) {
		modelMap.put("result", systemEmailService.save_AopLog(systemEmailVO));
		return INDEX_PATH;
	}
	
	/**
	 * 确认发送
	 */
	@RequestMapping("todo")
	public String todo(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		SessionUser sessionUser = (SessionUser)paramMap.get("sessionUser");
		List<SystemEmailPojo> systemEmailList = toolDaoTemplate.selectList("systemEmail.byIds", recordIds);
		for (final SystemEmailPojo email : systemEmailList) {
			//修改状态为已发
			Map map = new HashMap();
			map.put("checkName", sessionUser.getLoginName());
			map.put("state", ConfigConstants.SystemEmailState.SENT.value);
			map.put("id", email.getId());
			int num = toolDaoTemplate.update("systemEmail.updateState", map);
			if (num == 1) {
				log.info("更新邮件:{}状态已发送", email);
			}
			//开始按服务器发送
			String[] serverIdArray = StringUtils.split(email.getServerId(), ",");
			List<String> serverIdList = Arrays.asList(serverIdArray);
			serverIdList  = toolDaoTemplate.selectList("gameServer.getServerIdByRemoteUrlWithoutRepetition", serverIdList);
			for (final String serverId : serverIdList) {
				exec.execute(new Runnable() {
					@Override
					public void run() {
						boolean isFull = false;//是否全服发送标识
						List<String> roleIds = new ArrayList();
						if (email.getGlobalSend() == 0) {
							List<String> receiverNameList = email.getReceiverNameList();
							roleIds = gameDaoTemplate.selectListByServerId(email.getServerId(), "userRole.selectIdsByNames", receiverNameList);
							if (CollectionUtils.isEmpty(roleIds)) {
								log.error("系统邮件:{}的用户名List:{}没有找到", receiverNameList, email);
								return;
							}
							log.info("系统邮件指定用户发送:{}", email);
						}
						else if (email.getGlobalSend() == 1) {
							isFull = true;
							log.info("系统邮件全服发送:{}", email);
						}
						systemEmailService.sendEmail_AopLog(email, roleIds, StringUtils.substringBefore(serverId, ","), isFull);
					}
				});
			}
		}
		return "redirect:./indexAudit.do";
	}
	
	/**
	 * 批量取消
	 */
	@RequestMapping("undo")
	public String undo(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("recordIds", recordIds);
		int num = systemEmailService.undo_AopLog(paramMap);
		modelMap.put("result", num);
		return "redirect:./indexAudit.do";
	}
	
	/**
	 * 批量恢复取消发送的邮件
	 */
	@RequestMapping("redo")
	public String redo(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		paramMap.put("recordIds", recordIds);
		int num = systemEmailService.redo_AopLog(paramMap);
		log.info("成功恢复邮件:{}", recordIds);
		modelMap.put("result", num);
		return "redirect:./indexAudit.do";
	}
	
	/**
	 * 批量发送
	 */
	@RequestMapping("addBatch")
	public String addBatch(HttpServletRequest request, ModelMap modelMap) {
		return DEFAULT_PATH;
	}
	
	/**
	 * 批量发送确认
	 */
	@RequestMapping(value = "saveBatch", method = RequestMethod.POST)
	public String saveBatch(SystemEmailVO systemEmailVO, MultipartFile file, HttpServletRequest request, ModelMap modelMap) throws IOException {
		log.info("发系统邮件的批量补偿:{}", systemEmailVO);
		final MultiValueMap roleServerIdMvm = parseMailFile(file);
		Set<String> keySet = roleServerIdMvm.keySet();
		log.info("将要发送到的服务共计[{}]个", keySet.size());
		final SystemEmailPojo sm = new SystemEmailPojo(systemEmailVO);
		for (final String serverId : keySet) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
					List roleIds = (List)roleServerIdMvm.getCollection(serverId);
					systemEmailService.sendEmail_AopLog(sm, roleIds, serverId, false);
				}
			});
		}
		return INDEX_PATH;
	}
	
	/**
	 *	打开物品选择子窗口
	 */
	@RequestMapping("goodsQuery")
	public String goodsQuery(String goodsName, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("list", goodsAnalyzeService.query(goodsName));
		return "dialog/goods_diaglog";
	}
	
	/**
	 * 附加物品列表中的物品id换成物品名
	 */
	private void updateAttachmentsGoodsIdToGoodsName(PagingList<Map> pagingList){
		Map<String, Goods> goodsMap = goodsAnalyzeService.getGoods();
		for (Map map : pagingList.getRecords()) {
			String attachments = MapUtils.getString(map, "attachments");
			String[] goodsArray = StringUtils.contains(attachments, ":") ? StringUtils.split(attachments, ":") : StringUtils.split(attachments, ",");
			if (ArrayUtils.isEmpty(goodsArray)) {continue;}
			List<String> attachmentsList = new ArrayList();
			for (String goodsString : goodsArray) {
				String[] array = StringUtils.split(goodsString, ";");
				if (ArrayUtils.isEmpty(array) || array.length != 3) {
					continue;
				}
				Goods goods = goodsMap.get(array[0]);
				if (goods != null) {
					array[0] = goods.getName();
				}
				attachmentsList.add(StringUtils.join(array, ";"));
			}
			map.put("attachments", StringUtils.join(attachmentsList, ":"));
		}
	}
	
	/**
	 * 解析文件，得到serverid roleids
	 * @param multipartFile
	 * @return
	 */
	private MultiValueMap parseMailFile(MultipartFile multipartFile){
		MultiValueMap result = new MultiValueMap();
		try {
			List<String> list = IOUtils.readLines(multipartFile.getInputStream());
			for (String record : list) {
				String[] array = StringUtils.split(record);
				if (ArrayUtils.isNotEmpty(array) && array.length > 2 && StringUtils.countMatches(record, "-") == 3) {
					String roleId = array[1];
					String serverId = StringUtils.substringBefore(roleId, "UR");
					result.put(serverId, roleId);
				}
			}
		} catch (IOException e) {
			log.error("parseMailFile", e);
		}
		return result;
	}
	
}