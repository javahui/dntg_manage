<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="../component/jquery_plugin/jquery.md5.js"> </script>
<script type="text/javascript">
$.validationEngineLanguage.allRules.ajaxLoginName={
	"url": "checkLoginName.do",
	"alertTextOk": "√",
	"alertText": "用户名已存在",
	"alertTextLoad": "loading..."
};

$.validationEngineLanguage.allRules.ajaxUserName={
	"url": "checkUserName.do",
	"alertTextOk": "√",
	"alertText": "昵称已存在",
	"alertTextLoad": "loading..."
};

function submitForm(){
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
		<div id="div_position_nav"><span>当前位置:</span> 用户帐户管理 >> 用户管理 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do" method="post">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">用户名：</td>
						<td class="td_edit_value">
							<input type="text" name="loginName" class="input_edit_value validate[required,ajax[ajaxLoginName]]" maxlength="20" />
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">昵称：</td>
						<td class="td_edit_value">
							<input type="text" name="userName" class="input_edit_value validate[required,ajax[ajaxUserName]]" maxlength="20" />
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">用户密码：</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" name="password" id="password" class="input_edit_value validate[required]" maxlength="20"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">确认密码：</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" id="confirmPassword" class="input_edit_value validate[equals[password]]" maxlength="20"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name form-submit"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>