<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：数据仓库 >> Vip等级及充值占比分布</div>
		<div class="div_search">
		<form method="post">
		<ul>
			<li>服务器:<input type="text" name="serverIds" id="serverIds" onclick="openServerDiglog()" class="validate[required]" value="${paramMap.serverIds}" readonly="readonly"></li>
			<li>
				时间:<input type="text" name="startTime"  size="10" readonly="readonly" value="${paramMap.startTime}" onfocus="WdatePicker()">
				- <input type="text" name="endTime" size="10" readonly="readonly" value="${paramMap.endTime}" onfocus="WdatePicker()">
			</li>
			<li>
				新注册用户天数:<input type="text" name="startDiffCreateDay" class="validate[min[1],custom[integer]]" size="2" value="${paramMap.startDiffCreateDay}">
				- <input type="text" name="endDiffCreateDay" size="2" class="validate[min[1],custom[integer]]" value="${paramMap.endDiffCreateDay}">
			</li>
			<li>
				未登陆的流失用户天数:<input type="text" name="startOnlineDay" class="validate[min[1],custom[integer]]" size="2" value="${paramMap.startOnlineDay}">
				- <input type="text" name="endOnlineDay" class="validate[min[1],custom[integer]]" size="2" value="${paramMap.endOnlineDay}">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td>Vip等级</td>
			<td>充值金额</td>
			<td>用户数</td>
			<td>占比</td>
			<td>总充值金额</td>
			<td>占比</td>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center">${item.level}</td>
			<td class="center">${item.rankRmb}</td>
			<td class="center"><fmt:formatNumber value="${item.num}" pattern="0"/></td>
			<td class="center"><fmt:formatNumber value="${item.numRate * 100}" pattern="0.00"/>%</td>
			<td class="center"><fmt:formatNumber value="${item.rmb}" pattern="0"/></td>
			<td class="center"><fmt:formatNumber value="${item.rmbRate * 100}" pattern="0.00"/>%</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>