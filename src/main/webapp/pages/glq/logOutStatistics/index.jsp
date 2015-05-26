<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏日志 >> 用户在线时长</div>
	<div class="div_search">
		<form>
		<ul>
			<li>角色名:<input type="text" name="roleName" value="${paramMap.roleName}"/></li>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">												
			<td width="10%"> 角色名 </td>
			<td width="10%"> 在线时长 </td>
			<td width="10%"> 日期 </td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">						
			 <td class="center"> ${item.roleName}</td> 
			 <td class="center"> <fmt:formatNumber pattern="##.##"  value="${(item.onlineDuration-0.00001)/3600.001}"></fmt:formatNumber>小时</td>
			 <td class="center"> <fmt:formatDate value="${item.logDay}" pattern="yyyy-MM-dd"/></td>							
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="3"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</div>
	
</div>
</body>
</html>