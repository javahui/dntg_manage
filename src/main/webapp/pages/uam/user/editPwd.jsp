<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="../component/jquery_plugin/jquery.md5.js"> </script>
<script type="text/javascript">
$.validationEngineLanguage.allRules.checkOldPwd={
	"url": "checkOldPwd.do",
	"alertTextOk": "√",
	"alertText": "昵称已存在",
	"alertTextLoad": "loading..."
};

function submitForm(){
	var md532 = $.md5($("#oldPwd").val()).substring(8,24);
	if ("${record.password}" != md532) {
		alert("原密码输入不正确")
		return;
	}
	if($("form:first").validationEngine("validate")){
		var md532 = $.md5($("#password").val());
		$("#password").val(md532.substring(8,24));
		document.forms[0].submit();
	}
}

</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 用户管理 >> 重置密码</div>

		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="updatePwd.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">您的登录名</td>
						<td class="td_edit_value">
							<input type="text" name="loginName" class="input_edit_value" value="${record.loginName}" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">当前密码</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" id="oldPwd" class="input_edit_value validate[required]" />
							<span style="color:red;">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">新密码</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" name="password" id="password" class="input_edit_value validate[required]" />
							<span style="color:red;">*</span>
						</td>
					</tr>
					 <tr>
						<td class="td_edit_name" style="border-top:0px">确认新密码</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" class="input_edit_value validate[equals[password]]" />
							<span style="color:red;">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value"><button type="button" onclick="submitForm()">提交</button></td>
					</tr> 
				</table>
			</form>
		</div>
	</div>
</body>
</html>