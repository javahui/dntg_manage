<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：数据仓库 >> 装备稀有度分布</div>
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
			<td>部位/品质</td>
			<td>武器</td>
			<td>衣服</td>
			<td>头盔</td>
			<td>项链</td>
			<td>护腕</td>
			<td>戒指</td>
			<td>护腿</td>
			<td>鞋子</td>
			<td>玉佩</td>
			<td>腰带</td>
			<td>左护符</td>
			<td>右护符</td>
			<td>左坠饰</td>
			<td>右坠饰</td>
			<td>鞍具</td>
			<td>缰绳</td>
			<td>蹄铁</td>
			<td>蹬具</td>
		</tr>
		<c:forEach items="${list}" var="item" >
		<tr class="tr_list_data">
			<c:forEach items="${item}" var="map">
				<td class="center">${map.value}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>