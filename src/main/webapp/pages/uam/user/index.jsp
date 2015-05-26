<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 用户管理 >> 列表</div>

		<div class="div_search">
			<form>
				<ul>
					<li>用户名：<input name="loginName" class="input_search" size="15" maxlength="20" value="${paramMap.loginName}"></li>
					<li>用户昵称：<input name="userName" class="input_search" size="15" maxlength="20" value="${paramMap.userName}"></li>
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
			<form id="tableForm" action="">
				<table class="tbl_list">
					<tr class="tr_list_title">
						<td width="2%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
						<td width="20%">用户名</td>
						<td width="20%">用户昵称</td>
						<td width="55%">操作</td>
					</tr>
					<c:forEach items="${list.records}" var="item" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"  ></td>
						<td class="left">${item.loginName}</td>
						<td class="left">${item.userName}</td>
						<td class="center"><a href="edit.do?id=${item.id}">修改</a>
							<a href="show.do?id=${item.id}">详细信息</a>
							<a href="editRole.do?id=${item.id}">用户角色管理</a>
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