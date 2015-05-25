<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 在线人数每日统计</div>

		<div class="div_search">
		<form name="searchForm" method="get" action="" >
		<ul>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"  class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button"  onclick="charts()"  id="bt">显示图表</button></li>
		</ul>
		</form>
	</div>

	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="25%"> 时间</td>
			<td width="25%"> ACCU（日均在线）</td>
			<td width="25%"> PCCU（日峰值在线）</td>
			<td></td>
		</tr>
		<c:choose>
			<c:when test="${not empty list.records }">
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					 <td class="center"> ${item.date}</td> 	
					 <td class="center"> ${item.accu}</td> 	
					 <td class="center"> ${item.puuc}</td> 					
					 <td></td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
	<div id="chartDiv">
		&nbsp;
         <div id="container" style="width: 98%">
        </div>
    </div>
</div>
</body>
</html>