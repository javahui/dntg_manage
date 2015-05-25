<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏配置文件管理 >> 配置文件解析 >> 列表</div>

		<div class="div_search">
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
						<td width="3%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
						<td>配置文件名</td>
						<td>原始文件名</td>
						<td>文件描述</td>
						<td>更新时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${list.records}" var="item" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" ></td>
						<td class="center">${item.fileName}</td>
						<td class="center">${item.newName}</td>
						<td class="center">${item.fileDesc}</td>
						<td class="center">${item.updateTime}</td>
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