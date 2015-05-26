<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 玩家保有率统计</div>
		
		<div class="div_search">
		<form name="searchForm" method="get" action="" >
		<ul>
			<li>角色创建时间:<input type="text"  name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				<input type="hidden" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
		<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="20%">时间</td>
				<td width="10%">注册数</td>
				<td width="10%">次日保有%</td>
				<td width="10%">三日保有%</td>
				<td width="10%">四日保有%</td>
				<td width="10%">五日保有%</td>
				<td width="10%">六日保有%</td>
				<td width="10%">七日保有%</td>
				<td width="10%">八日保有%</td>
			</tr>
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="modelMap" varStatus="status">
				<c:if test="${not empty modelMap.cdate }">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center">${modelMap.the_date}</td>
					<td class="right" >${modelMap.d}</td>
					<td class="right" ><c:if test="${modelMap.d1>0}"><fmt:formatNumber value="${modelMap.d1}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d1<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d2>0}"><fmt:formatNumber value="${modelMap.d2}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d2<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d3>0}"><fmt:formatNumber value="${modelMap.d3}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d3<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d4>0}"><fmt:formatNumber value="${modelMap.d4}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d4<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d5>0}"><fmt:formatNumber value="${modelMap.d5}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d5<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d6>0}"><fmt:formatNumber value="${modelMap.d6}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d6<=0}">0</c:if></td>
					<td class="right" ><c:if test="${modelMap.d7>0}"><fmt:formatNumber value="${modelMap.d7}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d7<=0}">0</c:if></td>
				</tr>
				</c:if>
				<c:if test="${empty modelMap.cdate }">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center">${modelMap.the_date}</td>
					<td class="center"  colspan="8">该日无注册玩家</td>
				</tr>
				</c:if>
				</c:forEach>
				<tr  class="tr_list_data"><td colspan="9">&nbsp;</td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="9"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</div>
</body>
</html>