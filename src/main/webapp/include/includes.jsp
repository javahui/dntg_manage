<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/pageSplit.tld" prefix="base" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link type="text/css" rel="stylesheet" href="${ctx}/css/skin1/common.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/skin1/table.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/css/skin1/page.css" />


<script type="text/javascript" src="${ctx}/component/jquery/jquery-1.7.1.min.js"> </script>
<script type="text/javascript" src="${ctx}/component/jquery_plugin/jquery.blockUI.js"></script>
<script type="text/javascript" src="${ctx}/js/table/table.js"></script>
<script type="text/javascript" src="${ctx}/component/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/common/common.js"></script>
<script type="text/javascript" src="${ctx}/component/lhgdialog/lhgdialog.min.js"></script>

<script type="text/javascript" src="${ctx}/component/ueditor/editor_config.js"></script> 
<script type="text/javascript" src="${ctx}/component/ueditor/editor_all.js"></script> 
<link type="text/css" rel="stylesheet"  href="${ctx}/component/ueditor/themes/default/ueditor.css">

<link type="text/css" rel="stylesheet" href="${ctx}/component/validationEngine/validationEngine.jquery.css" />
<script type="text/javascript" src="${ctx}/component/validationEngine/jquery.validationEngine-zh_CN.js"></script> 
<script type="text/javascript" src="${ctx}/component/validationEngine/jquery.validationEngine.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var validateForm = $("form:first");
	validateForm.validationEngine();
	
	//防止表单重复提交
	validateForm.submit(function(){
		if(validateForm.validationEngine("validate")){	
			validateForm.find("button[type='submit']").attr('disabled','true');
		}
	});
	
	//token服务器的防止表单重复提交
	var token = "${sessionScope.token}";
	if (token != "") {
		$("form:first").append("<input type='hidden' value='${sessionScope.token}' name='token'>");
	}
	
	//提示操作成功或者失败
	var result = "${param.result}";
	if ($.trim(result) == "") {
		return;
	}
	else if (isNaN(result)) {
		$.blockUI({ message: result });
	}
	else if (parseInt(result) > 0) {
		$.blockUI({ message: '操作成功' });
	}
	else{
		$.blockUI({ message: '操作失败' });
	}
	setTimeout($.unblockUI, 1500);
});
</script>
