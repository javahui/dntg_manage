package com.lingyu.dntg.action.ulm;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.lingyu.dntg.action.AbstractAction;
import com.lingyu.dntg.service.AbstractService;

/**
 * 操作类型日志管理
 * @author donghui
 */
@Controller
@RequestMapping("operLogType")
public class operLogTypeAction extends AbstractAction{
	
	/**
	 * 列表
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("list", toolDaoTemplate.paging("operLogType.index", paramMap));
		return DEFAULT_PATH;
	}
	

	/**
	 * 查出所有进行aop日志拦截的类和方法同步到数据库
	 * 拦截规则 @see  com.lingyu.dntg.aop.OperationLogAOP
	 */
	@RequestMapping("refresh")
	public String refresh(HttpServletRequest request, ModelMap modelMap) {
		Collection<AbstractService> abstractServiceCollection= ContextLoader.getCurrentWebApplicationContext().getBeansOfType(AbstractService.class).values();
		for (AbstractService abstractService : abstractServiceCollection) {
			log.debug(abstractService.getClass().getName());
			String className = StringUtils.substringBefore(abstractService.getClass().getSimpleName(), "$");
			Method[] methodArray = abstractService.getClass().getMethods();
			for (Method method : methodArray) {
				String methodName = method.getName();
				if (StringUtils.endsWith(methodName, "_AopLog")) {
					HashMap map = new HashMap();
					map.put("methodName", methodName);
					map.put("className", className);
					int i = (Integer)toolDaoTemplate.selectOne("operLogType.byClazzCount", map);
					if (i == 0) {
						toolDaoTemplate.insert("operLogType.insert",map);
					}
				}
			}
		}
		return "redirect:./index.do";
	}
	
	/**
	 * 修改页面
	 */
	@RequestMapping("edit")
	public String edit(@RequestParam int id,  HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("record", toolDaoTemplate.selectOne("operLogType.byId", id));
		return DEFAULT_PATH;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, ModelMap modelMap) {
		Map paramMap = (Map)request.getAttribute("paramMap");
		modelMap.put("result", toolDaoTemplate.update("operLogType.update", paramMap));
		return "redirect:./index.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam List<Integer> recordIds, HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("result", toolDaoTemplate.delete("operLogType.delete", recordIds));
		return "redirect:./index.do";
	}
	
}