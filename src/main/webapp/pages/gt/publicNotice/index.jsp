<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：GM工具 >> 版本更新公告列表</div>

	<div class="div_search">
		<form name="searchForm" method="get" action="" >
		<ul>
			<li>服务器：<input name="serverId" id="serverId" class="input_search" value="${paramMap.serverId}" onclick="openSingeChoiceServerDiglog()"></li>
			<button type="submit">查询</button></li>
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
					<td width="25%">公告内容</td>
					<td width="22%">适用服务器</td>
					<td width="50%">操作</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" <c:if test="${item.id == sessionScope.curUser.id}"> disabled="disabled" </c:if> ></td>
					<td class="left"> <div class="word-break"><c:out value=" ${item.content}"  escapeXml="true" /> </div> </td>
					<td class="center" >${item.serverName}</td>
					<td class="center"><a href="edit.do?id=${item.id}">修改</a></td>
				</tr>
				</c:forEach>
				<c:if test="${empty list.records}"><tr class="tr_list_data"><td colspan="10"><font color="red">当前查询条件下无数据</font></td></tr></c:if>
			</table>
		</form>
	</div>
		
	<table class="tbl_list">
		<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
</div>
</body>
</html>