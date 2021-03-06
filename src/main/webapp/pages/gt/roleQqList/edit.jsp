<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: GM工具 >> 超级会员 >> 修改</div>

		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">角色名:</td>
						<td class="td_edit_value"> ${record.userRoleName}</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">QQ号码：</td>
						<td class="td_edit_value">
							<input type="text" name="qq" class="input_edit_value validate[required,custom[integer]]" maxlength="10" value="${record.qq}">
							<span style="color:#FF003A;"> * </span>
						</td>>
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