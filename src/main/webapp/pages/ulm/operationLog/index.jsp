<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"> 当前位置: 用户日志管理 >> 列表</div>

		<div class="div_search">
			<form>
				<ul>
					<li>操作者用户昵称：<input id="userName" type="text" name="userName" class="input_search" value="${paramMap.userName}"/></li>
					<li>
						时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
						-<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
					</li>
					<li><button type="submit">查询</button></li>
				</ul>
			</form>
		</div>

		<div class="div_list">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td width="15%">操作者用户昵称</td>
					<td width="15%">用户操作</td>
					<td width="50%">操作描述</td>
					<td>时间</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.userName}</td>
					<td class="center">${item.operation}</td>
					<td class="center">${item.description}</td>
					<td class="center">${item.operTime }</td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</table>
		</div>

	</div>
</body>
</html>