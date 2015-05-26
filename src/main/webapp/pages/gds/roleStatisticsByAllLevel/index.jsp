<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 玩家全等级人数统计</div>

	<div class="div_search">
		<form name="searchForm" method="get" action="" >
		<ul>
			<li>角色创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="15%">等级</td>
				<td width="15%">人数</td>
				<td width="15%">百分比%</td>
				<td width="55%"></td>
			</tr>
		<c:choose>
			<c:when test="${not empty list.records}">
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<c:if test="${status.index==0 }">
					<tr id="recordTr${item.allCount}" class="tr_list_data">
						<td class="right" >总人数</td>
						<td class="right" >${item.allCount} </td>
						<td class="right">100.0000</td>
						<td></td>
					</tr>
				</c:if>
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="right">${item.level}</td>
					<td class="right">${item.cnt} </td>
					<td class="right">${item.lv_cnt} </td>
					<td></td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</div>
</body>
</html>