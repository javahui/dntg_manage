<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏数据统计 >> 主线任务接取统计</div>
		<div class="div_search">
		<form>
		<ul>
			<li>
				角色创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>

	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="20%"> 任务名称</td>
			<td width="20%"> 任务需求等级 </td>
			<td width="20%"> 接取人数 </td>
			<td> </td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			 <td class="center"> ${taskMainMap[item.currentTaskId].taskName}</td> 				
			 <td class="center"> ${taskMainMap[item.currentTaskId].recevieLevel}</td>
			 <td class="center"> ${item.count}</td>					
			 <td></td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</div>
</div>
</body>
</html>