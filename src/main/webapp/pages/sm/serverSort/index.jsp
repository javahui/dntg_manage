<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏服务器管理 >> 游戏服务器分类管理 >> 分类列表</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">新增</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
		</ul>
	</div>
	
	<div class="div_list">
	<form id="tableForm">
	<table  class="tbl_list">
		<tr class="tr_list_title">
			<td width="3%"><input id="checkallornot" name="checkallornot"  type="checkbox"/></td>
			<td width="20%">分类ID</td>
			<td width="20%">分类名称</td>
			<td width="20%">排序值</td>
			<td width="35%">操作</td>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr id="recordTr${status.index}" class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
			<td class="left">${item.id}</td>
			<td class="left">${item.sortName}</td>
			<td class="left">${item.orderNum}</td>
			<td class="center"><a href="edit.do?id=${item.id}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	</form>
	</div>
</div>
</body>

</html>