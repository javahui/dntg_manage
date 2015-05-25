<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: 游戏数据统计 >> 玩家连续充值统计</div>

	<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>金额:<input type="text" name="moneyMin" class="input_search" size="10" value="${paramMap.moneyMin}"/>
				-&nbsp;<input type="text" name="moneyMax"   class="input_search" size="10"  value="${paramMap.moneyMax}"/>
			</li>
			<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;
			</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="16%">玩家账号</td>
				<td width="16%">充值次数</td>
				<td width="16%">总充值量(元)</td>
				<td width="16%">占选择服务器的充值百分比</td>
				<td width="20%">最后一次充值时间</td>
			</tr>
			<c:choose>
				<c:when test="${not empty list.records}">
					<c:forEach items="${list.records}" var="modelMap" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"> ${ modelMap.user_guid}</td>
						<td class="left">${ modelMap.cnt}</td>
						<td class="left"><fmt:formatNumber value="${ modelMap.srmb}" pattern="0.0"></fmt:formatNumber></td>
						<td class="left"><fmt:formatNumber value="${ modelMap.srmb/modelMap.allrmb*100}" pattern="0.00"></fmt:formatNumber></td>
						<td class="center"> <fmt:formatDate value="${ modelMap.ctime}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					</tr>
					</c:forEach>
					<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
					</c:when>
					<c:otherwise>
						<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><font color="red">当前查询条件下无数据</font></td></tr>
					</c:otherwise>
			</c:choose>
		</table>
	</div>

</div>
</body>
</html>