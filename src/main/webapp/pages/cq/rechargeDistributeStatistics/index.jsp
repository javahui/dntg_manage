<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: 游戏数据统计 >> 充值分布统计</div>

	<div class="div_search">
		<form>
		<ul>
			<li>
				时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="14.28%">充值金额数量</td>
				<td width="14.28%">1-99</td>
				<td width="14.28%">100-499</td>
				<td width="14.28%">500-999</td>
				<td width="14.28%">1000-4999</td>
				<td width="14.28%">5000-9999</td>
				<td width="14.28%">10000及以上</td>
			</tr>
			<c:forEach items="${list}" var="modelMap" varStatus="status">
				<tr class="tr_list_data">
					<td class="center"> 人数</td>
					<td class="center">${ modelMap.a1 }</td>
					<td class="center">${ modelMap.a2 }</td>
					<td class="center">${ modelMap.a3 }</td>
					<td class="center">${ modelMap.a4 }</td>
					<td class="center">${ modelMap.a5 }</td>
					<td class="center">${ modelMap.a6 }</td>
				</tr>
				<tr class="tr_list_data">
					<td class="center"> 比例</td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an1}"><fmt:formatNumber value="${ modelMap.an1 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an2}"><fmt:formatNumber value="${ modelMap.an2 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an3}"><fmt:formatNumber value="${ modelMap.an3 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an4}"><fmt:formatNumber value="${ modelMap.an4 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an5}"><fmt:formatNumber value="${ modelMap.an5 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
					<td class="center"><c:choose><c:when test="${ not empty modelMap.an6}"><fmt:formatNumber value="${ modelMap.an6 }" pattern="0.00"></fmt:formatNumber></c:when><c:otherwise>0.00</c:otherwise></c:choose></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</div>
</body>
</html>