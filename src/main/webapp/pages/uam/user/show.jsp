<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 用户管理 >> 查看详细信息</div>
		<div class="div_edit">
			<div class="content-box-header"></div>
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name" width="200">用户ID</td>
					<td class="td_edit_value">${record.id}</td>
				</tr>
				<tr>
					<td class="td_edit_name">用户名</td>
					<td class="td_edit_value">${record.loginName}</td>
				</tr>
				<tr>
					<td class="td_edit_name">用户昵称</td>
					<td class="td_edit_value">${record.userName}</td>
				</tr>
				<tr>
					<td class="td_edit_name"></td>
					<td><button type="button" onclick="window.location='./index.do'">返回</button></td>
			</table>
		</div>
	</div>
</body>
</html>