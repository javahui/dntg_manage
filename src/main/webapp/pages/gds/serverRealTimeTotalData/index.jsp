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
	<div id="div_position_nav">当前位置: 游戏数据统计 >> 实时分服总数据</div>
	
	<div class="div_operate">
		<form>
		<ul>
			<li>时间:<input id="logHour" name="logHour" class="input_search" size="14" readonly="readonly" maxlength="20" value="${paramMap.logHour}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH',maxDate:'%y-%M-%d %H'})"></li>
			<li><button type="submit">select</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
		<table class="tbl_list">
		<tr class="tr_list_title">
			<td>统计时间</td>
			<td>平台</td>
			<td>服务器名</td>
			<td>新角色</td>
			<td>今日登录</td>
			<td>当前在线数</td>
			<td>最高在线数</td>
			<td>充值人数</td>
			<td>充值总量（元）</td>
			<td>付费率</td>
			<td>Arpu</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center">${item.logTime}</td>
			<td class="center">${item.sortName}</td>
			<td class="center">${item.serverName}</td>
			<td class="center">${item.todayCreate} </td>
			<td class="center">${item.todayLogin} </td>
			<td class="center">${item.onlineCount} </td>
			<td class="center">${item.pccu} </td>
			<td class="center">${item.chargeCount } </td>
			<td class="center">${item.chargeTotal } </td>
			<td class="center"><fmt:formatNumber pattern="##.##" value="${item.payOdds * 100}" />%</td>
			<td class="center">${item.arpu } </td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="11"><base:pageSplit url="./index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
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