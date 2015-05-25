<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计&nbsp;&gt;&gt;&nbsp;关键信息整合报表</div>
	<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
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
				<td width="8%">时间</td>
				<td width="5%">新登录</td>
				<td width="5%">登录</td>
				<td width="5%">登录次数</td>
				<td width="5%">人均登录次数</td>
				<td width="5%">流失率%</td>
				<td width="5%">次日保有%</td>
				<td width="5%">ACCU</td>
				<td width="5%">PCCU</td>
				<td width="5%">DT（分）</td>
				<td width="5%">新付费用户</td>
				<td width="5%">付费用户数</td>
				<td width="5%">付费率%</td>
				<td width="5%">充值</td>
				<td width="5%">ARPU</td>
				<td width="5%">元宝新增</td>
				<td width="5%">元宝消耗</td>
				<td width="5%">消耗比%</td>
			</tr>														
		<c:choose>
			<c:when test="${not empty list}">
				<c:forEach items="${list}" var="modelMap" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center"> ${ modelMap.date}</td>
					<td class="center">${ modelMap.createcount}</td>
					<td class="center">${ modelMap.ducount}</td>
					<td class="center">${ modelMap.dcount}</td>
					<td class="center"><fmt:formatNumber value="${ modelMap.davg}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="center"><fmt:formatNumber value="${ modelMap.lost*100}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="right" ><c:if test="${modelMap.d1>0}"><fmt:formatNumber value="${modelMap.d1}" pattern="##.##" minFractionDigits="2"  /></c:if><c:if test="${modelMap.d1<=0}">0</c:if></td>
					<td class="center"><fmt:formatNumber value="${ modelMap.accu}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="center">${ modelMap.puuc}</td>
					<td class="center"><fmt:formatNumber value="${ modelMap.dt}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="center">${ modelMap.cnt}</td>
					<td class="center">${ modelMap.distCount}</td>
					<td class="center"><fmt:formatNumber value="${ modelMap.pl*100}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="center">${ modelMap.allRmb}</td>
					<td class="center"><fmt:formatNumber value="${ modelMap.arpu}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
					<td class="center">${ modelMap.ybincr}</td>
					<td class="center">${ modelMap.ybconsume}</td>
					<td class="center"><fmt:formatNumber value="${ modelMap.ybconlv*100}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
				</tr>
				</c:forEach>
				</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="18"><font color="red">由于数据量过大，请指定时间段查询</font></td></tr>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</div>
</body>
</html>