<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置:用户帐户管理 >> 角色管理 >> 角色列表</div>

		<div class="div_search">
			<form>
				<ul>
					<li>角色名：<input type="text"  id="roleName" name="roleName" class="input_search" size="15" maxlength="20" value="${paramMap.roleName}"/></li>
					<li><button type="submit">查询</button></li>
				</ul>
			</form>
		</div>

		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='add.do'">新增</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
			</ul>
		</div>

		<div class="div_list">
			<form id="tableForm">
				<table class="tbl_list">
					<tr class="tr_list_title">
						<td width="3%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
						<td>id</td>
						<td>角色名</td>
						<td>角色描述</td>
						<td>状态</td>
						<td>是否全服权限</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${list.records}" var="item" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" <c:if test="${item.id == sessionScope.curUser.id}"> disabled="disabled" </c:if> ></td>
						<td class="center">${item.id}</td>
						<td class="center">${item.roleName}</td>
						<td class="center">${item.roleDesc}</td>
						<td class="center">
							<c:if test="${item.status == 1}">正常</c:if>
							<c:if test="${item.status != 1}">禁用</c:if>
						</td>
						<td class="center">
							<c:if test="${item.allServer == 1}">是</c:if>
							<c:if test="${item.allServer != 1}">否</c:if>
						</td>
						<td class="center">
							<a href="./edit.do?id=${item.id}">修改</a>
							<a href="./editActionInfo.do?id=${item.id}">菜单权限管理</a>
							<c:if test="${item.allServer != 1}">
								<a href="editServer.do?id=${item.id}&roleName=${item.roleName}">服务器权限管理</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</table>
			</form>
		</div>

		<table class="tbl_list">
			<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>
</body>
</html>