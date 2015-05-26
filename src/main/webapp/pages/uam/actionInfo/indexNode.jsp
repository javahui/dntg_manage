<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 超级管理 >> 菜单管理 >> <b>[${param.actionName }]</b>的子节点列表</div>
		
		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='addNode.do?id=${param.id}'">新增节点</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
				<li class="li_operate" onclick="window.location='./indexDir.do'">返回分支管理列表</li>
			</ul>
		</div>
		
		<div class="div_list">
		<form id="tableForm" action="">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="2%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
				<td>id</td>
				<td>菜单名</td>
				<td>菜单路径</td>
				<td>描述</td>
				<td>值</td>
				<td>排序值</td>
				<td>是否只有管理员权限才能分配这个节点</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
				<td align="center">${item.id}</td>
				<td align="center">${item.actionName}</td>
				<td align="center">${item.action}</td>
				<td align="center">${item.actionDesc}</td>
				<td align="center">${item.typeValue}</td>
				<td align="center">${item.orderValue}</td>
				<td align="center">
					<c:if test="${item.actionLevel==1}">否</c:if>
					<c:if test="${item.actionLevel==0}">是</c:if>
				</td>
				<td align="center">
					<a href="edit.do?id=${item.id}&isDir=${item.isDir}">修改</a>
					<a href="editRole.do?id=${item.id}&actionName=${item.actionName}">修改所属角色权限</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</form>
		</div>
		
	</div>
</body>
</html>