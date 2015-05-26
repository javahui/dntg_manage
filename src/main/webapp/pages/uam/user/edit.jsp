<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置:</span> 用户帐户管理 >> 用户管理 >> 修改</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">用户名</td>
						<td class="td_edit_value">
							<input type="text" name="loginName" id="loginName" class="input_edit_value validate[required]" value="${record.loginName}"  disabled="disabled" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">用户昵称</td>
						<td class="td_edit_value">
							<input type="text" name="userName" id="userName" class="input_edit_value validate[required]" value="${record.userName}" />
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">用户密码</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" name="password" id="password" class="input_edit_value" />
							<span style="color:red;">(不填写为不更改)</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">确认密码</td>
						<td class="td_edit_value" style="border-top:0px">
							<input type="password" id="confirmPassword" name="confirmPassword" class="input_edit_value validate[equals[password]]" />
							<span style="color:red;">(不填写为不更改)</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
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