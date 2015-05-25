<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：GM工具 >> 解散帮会</div>
	<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>帮会名:<input type="text" name="name"  id="name"  value="${paramMap.name}"></li>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="16%">帮会名</td>
			<td width="16%">帮会等级</td>
			<td width="16%">帮主</td>
			<td width="16%">帮会战斗力</td>
			<td width="20%">操作</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"> ${item.name}</td>
			<td class="center">${item.level}</td>
			<td class="center">${item.userRoleName}</td>
			<td class="center">${item.fighting }</td>
			<td class="center"><a href="./delBank.do?guildId=${item.id}&name=${item.name}" onclick="return confirm('确定要解散吗')">解散 </a></td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</div>
</div>
</body>
</html>