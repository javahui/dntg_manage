<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 用户管理 >> 角色管理</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="updateRole.do">
				<input type="hidden" name="userId" value="${record.id}">
				
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">用户名</td>
						<td class="td_edit_value">
							<input type="text" name="userRoleName" class="input_edit_value" readonly="readonly" id="userRolename" maxlength="20" value="${record.userName}">
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">用户角色</td>
						<td class="td_edit_value">
							 <c:forEach items="${roleInfoList}" var="item" varStatus="status">
									<input type="checkbox" name="roleIds" value="${item.id}"
										<c:forEach items="${userRole}" var="it"><c:if test="${it.roleId==item.id}"> checked="checked" </c:if></c:forEach>
									/>  <a href="${ctx}/role/editActionInfo.do?id=${item.id}">${item.roleName}</a><br/>
							</c:forEach>
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