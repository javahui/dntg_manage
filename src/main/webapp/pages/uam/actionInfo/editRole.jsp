<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 修改所属角色权限</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="updateRole.do" method="post">
				<input type="hidden" name="actionId" value="${param.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">菜单名</td>
						<td class="td_edit_value">${param.actionName}</td>
					</tr>
					<tr>
						<td class="td_edit_name">角色权限</td>
						<td class="td_edit_value">
							<input id="checkallornot" name="checkallornot" type="checkbox">全选<br>
							<c:forEach items="${list}" var="item" varStatus="status">
									<input type="checkbox" name="recordIds" value="${item.id}"
										<c:if test="${item.isCheck > 0}"> checked="checked"  </c:if>
									>
									${item.roleName}<br/>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>
							<button type="button" onclick="window.location='./indexDir.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>