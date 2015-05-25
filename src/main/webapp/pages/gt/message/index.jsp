<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：GM工具 >> 玩家反馈信息查询 >> 列表</div>
	
	<div class="div_search">
		<form>
			<ul>
				<li>用户名：<input type="text"  name="userName"  value="${paramMap.userName}" ></li>
				<li>账号：<input type="text"  name="userId"  value="${paramMap.userId}" ></li>
				<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
				</li>
				<li><button type="submit">查询</button></li>
				<li><button type="button" onclick="exportXls()">Excel</button></li>
			</ul>
		</form>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td>标题</td>
				<td width="35%">内容</td>
				<td width="10%">用户名</td>
				<td width="10%">账号</td>
				<td width="8%">时间</td>
				<td width="3%">操作</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="left"> <c:out value="  ${item.title}"  escapeXml="true" />  </td>
					<td class="left"> <c:out value=" ${item.content}"  escapeXml="true" />   </td>
					<td class="center">${item.userName}</td>
					<td class="center">${item.userId}</td>
					<td class="center"><fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td class="center"><a href="addReply.do?userName=${item.userName}&userId=${item.userId}">回复</a></td>
				</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="10"> <base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>
</div>
</body>
</html>