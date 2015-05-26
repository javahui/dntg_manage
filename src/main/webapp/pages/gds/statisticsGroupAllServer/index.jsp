<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$(document).ready(function(){
	$("#recoverForm").validationEngine(); 
});
</script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏数据统计 >> 全服关键信息整合报表</div>
	<div class="div_search">
		<form method="post">
		<ul>
			<li>
				选择服务器：<input name="serverIds" id="serverIds" class="input_edit_value" readonly="readonly" value="${paramMap.serverIds}" onclick="openServerDiglog()">
			</li>
			<li>
				时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
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
				<td width="8%">时间</td>
				<td width="8%">新登录</td>
				<td width="8%">登录</td>
				<td width="8%">流失率%</td>
				<td width="8%">ACCU</td>
				<td width="8%">DT(分)</td>
				<td width="8%">新付费用户</td>
				<td width="8%">付费用户数</td>
				<td width="8%">付费率%</td>
				<td width="8%">充值</td>
				<td width="8%">ARPU</td>
			</tr>
			<c:forEach items="${list}" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center">${item.date} </td>
				<td class="center">${item.createCount}</td>
				<td class="center">${item.dCount}</td>
				<td class="center"><fmt:formatNumber value="${item.lost}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
				<td class="center"><fmt:formatNumber value="${item.accu}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
				<td class="center"><fmt:formatNumber value="${item.dt}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
				<td class="center">${item.cnt}</td>
				<td class="center">${item.distCount}</td>
				<td class="center"><fmt:formatNumber value="${item.pl}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
				<td class="center">${item.allRmb}</td>
				<td class="center"><fmt:formatNumber value="${item.arpu}" pattern="#.##" minFractionDigits="2"></fmt:formatNumber></td>
			</tr>
			</c:forEach>
			<c:if test="${list == null}"><tr class="tr_list_data"><td class="td_page_shift" colspan="12"><font color="red">由于数据量过大，请指定时间段以及服务器查询</font></td></tr></c:if>
		</table>
	</div>
	
	<form action="recover.do" id="recoverForm">
	<div class="div_operate">
		<ul>
			<li>查询无数据时使用此功能进行恢复:<input name="logDay" readonly="readonly" class="validate[required]" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d %H'})"></li>
			<li><button type="submit">确定</button></li>
		</ul>
	</div>
	</form>
</div>
</body>
</html>