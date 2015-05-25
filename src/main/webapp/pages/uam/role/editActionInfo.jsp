<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
function selectSonNode(obj){
	var checked = obj.checked;
	var v = parseInt(obj.id);
	for ( var i = 1; i < 50; i++) {
		var chkecBoxObj = $("#"+(v+i));
		if (chkecBoxObj.attr("disabled") != 'disabled') {
			chkecBoxObj.attr("checked",checked);
		}
	}
}
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 角色管理 >> 菜单权限管理</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="updateActionInfo.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">角色名</td>
						<td class="td_edit_value">${record.roleName}</td>
					</tr>
					<tr>
						<td class="td_edit_name">角色权限</td>
						<td class="td_edit_value">
							<c:forEach items="${actionInfoList}" var="item" varStatus="status">
								<c:if test="${item.isDir == 1}">
									<div><input type="checkbox"  onclick="selectSonNode(this)" id="${item.id}">${item.actionName}</div>
								</c:if>
								<c:if test="${item.isDir == 0}">
									<div style="text-indent:3em;">
										<input type="checkbox" name="recordIds" value="${item.id}" id="${item.id}"
											<c:if test="${item.actionLevel==0}"> disabled="disabled" </c:if> 
											<c:if test="${not empty item.actionRoleId}"> checked="checked" </c:if> 
										>  
										${item.actionName}<br/>
									</div>
								</c:if>
							</c:forEach>
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