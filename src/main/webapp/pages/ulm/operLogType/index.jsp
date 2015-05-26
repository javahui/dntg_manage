<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"> 当前位置: 用户日志管理 >> 日志类型管理 >> 列表</div>
		
		<div class="div_search">
			<form>
				<ul>
					<li>类名:<input name="className" class="input_search" value="${paramMap.className}"/></li>
					<li>方法名:<input name="methodName" class="input_search" value="${paramMap.methodName}"/></li>
					<li>类型:<input name="type" class="input_search" value="${paramMap.type}"/></li>
					<li>描述:<input name="description" class="input_search" value="${paramMap.description}"/></li>
					<li><button type="submit">查询</button></li>
				</ul>
			</form>
		</div>
		
		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='refresh.do'">刷新进行日志记录的类的方法</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
			</ul>
		</div>
		
		<div class="div_list">
		<form id="tableForm" action="">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="2%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
				<td>类名</td>
				<td>方法名</td>
				<td>类型</td>
				<td>描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" /></td>
				<td class="center">${item.className}</td>
				<td class="center">${item.methodName}</td>
				<td class="center">${item.type}</td>
				<td class="center">${item.description}</td>
				<td class="center"> <a href="edit.do?id=${item.id}">修改</a> </td>
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