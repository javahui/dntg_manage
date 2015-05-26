<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head></head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏数据统计 >> 等级分布统计</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>分布类型：
				<select name="type">
					<option value="">全部</option>
					<c:forEach items="${typeMap}" var="entry">
						<option value="${entry.key}" <c:if test="${paramMap.type==entry.key}">selected="selected"</c:if> >${entry.value}</option>
					</c:forEach>
				</select>
			</li>
			<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				&nbsp;<input type="hidden" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
			
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td>日期</td>	
			<td>等级</td>
			<td>总数</td>
			<td>类型</td>
		</tr>
		<c:if test="${not empty list }">
			<c:forEach items="${list.records}" var="scount" varStatus="status">
			<tr id="recordTr${status.index}" class="tr_list_data">
				<td class="center">${scount.day}</td>
				<td class="center">${scount.value}</td>
				<td class="center">${scount.count }</td>
				<td class="center">${typeMap[scount.type]}</td>
			</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="7"><base:pageSplit url="./index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</c:if>
	</table>
	</div>
                                    
	
</div>
</body>

</html>