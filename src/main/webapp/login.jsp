<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<title>${title}</title>
<link type="text/css" rel="stylesheet" href="css/skin1/login.css" />
<script type="text/javascript" src="component/jquery_plugin/jquery.md5.js"> </script>
<script type="text/javascript">
function trim(str){
	return str.replace( /(^\s*)|(\s$)/g,"" );
}
function submitLoginForm(){
	var loginName = trim($("#loginName").val());
	var loginPass = trim($("#password").val());
	if( loginName == null || loginName == "" || loginPass == null || loginPass == ""){
		return false;
	} 
	var md532 = $.md5($("#password").val());
	$("#password").val(md532.substring(8,24));
}

function onPassChange(){
	document.getElementById("hpass").value="";
}
</script>
</head>
<body>
<div id="div-login">
	<div id="login-top"></div>
	<div id="login-content">
		<form name="loginForm" onsubmit="return submitLoginForm();" action="login.do" method="post">
		<table id="login-table">
			<tr>
				<td class="right">用户名:</td>
				<td class="left"><input type="text" tabindex="1" name="loginName" id="loginName" value="${cookie.loginName.value}" class="validate[required] input-class"/></td>
				<td rowspan="2"> <input type="submit" value="登录" class="submit-class"></td>
			</tr>
			<tr>
				<td class="right">密&nbsp;码:</td>
				<td class="left">
					<input type="password" onchange="onPassChange()" tabindex="2" name="password" id="password" value="${cookie.password.value}" class="validate[required] input-class"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="checkbox"  value="true" name="rememberPassword" <c:if test="${cookie.password.value != null}"> checked="checked"</c:if>/>&nbsp;记住密码</td>
			</tr>
			<tr><td colspan="3" class="company-center">上海灵娱网络科技有限公司 版权所有</td></tr>
		</table>
		<input type="hidden" id="hpass" name="hiddenPassword" value="${cookie.password.value}" />
		</form>
	</div>
</div>

</body>
</html>