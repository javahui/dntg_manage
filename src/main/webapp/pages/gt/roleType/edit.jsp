<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：GM与指导员账号配置 >> 修改</div>
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<input type="hidden" name="userId" value="${record.userId}">
				<input type="hidden" name="serverId" value="${record.serverId}">
				<table class="tbl_edit">
				<tr>
					<td class="td_edit_name" width="200">角色名</td>
					<td class="td_edit_value">${record.userId}</td>
				</tr>
				<tr>
					<td class="td_edit_name"> 服务器 </td>
					<td class="td_edit_value">${record.serverName}</td>
				</tr>
				<tr>
					<td class="td_edit_name"> 账号类型 </td>
					<td class="td_edit_value">
						<select name="roleType" id="roleType" >
								<option value="0">普通用户</option>
								<option value="1" <c:if test="${record.roleType==1}">selected='selected'</c:if> >指导员</option>
								<option value="2" <c:if test="${record.roleType==2}">selected='selected'</c:if> >GM</option>
						</select>
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