<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：超级管理 >> 游戏服务器管理 >> 跨服赛区分布 <div>
	<div class="div_search">
		<form name="searchForm">
		<ul>
			<li>赛区名:<input type="text" name="name"  id="name"  value="${paramMap.name}"></li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">新增赛区</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('batchSaveFile.do')">生成文件</li>
		</ul>
	</div>
	
	<div class="div_list">
	<form id="tableForm" action="">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="1%"><input id="checkallornot" name="checkallornot" type="checkbox"></td>
			<td width="4%">服务器ID</td>
			<td width="7%">赛区名</td>
			<td width="6%">ip</td>
			<td width="3%">端口</td>
			<td width="77%">跨服的服务器</td>
			<td width="4%">操作</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
			<td class="center">${item.serverid}</td>
			<td class="center">${item.name}</td>
			<td class="center">${item.ip}</td>
			<td class="center">${item.port}</td>
			<td><input size="200" id="f${status.index}" onclick="openServerDiglog('f${status.index}',true)" value="${item.serverIds}" readonly="readonly" title="点击详情" style="border:0px;cursor:pointer"></td>
			<td class="center"><a href="./edit.do?id=${item.id}">修改 </a></td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="7"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>