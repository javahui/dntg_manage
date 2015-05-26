<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置:</span> 用户帐户管理 >> 角色管理 >> 角色列表</div>

		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">角色名</td>
						<td class="td_edit_value">
							<input type="text" name="roleName" id="roleName" class="input_edit_value validate[required]" value="${record.roleName}" maxlength="20"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">是否全服权限：</td>
						<td class="td_edit_value">
							<select name="allServer">
								<option value="0" <c:if test="${record.allServer == 0}"> selected="selected" </c:if> >否</option>
								<option value="1" <c:if test="${record.allServer == 1}"> selected="selected" </c:if> >是</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">角色描述</td>
						<td class="td_edit_value">
							<textarea name="roleDesc" id="roleDesc" rows="5" cols="50">${record.roleDesc}</textarea>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>&nbsp;&nbsp;
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>