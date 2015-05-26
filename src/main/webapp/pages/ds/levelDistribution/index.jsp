<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：数据仓库 >> 用户等级分布</div>
		<div class="div_search">
		<form method="post">
		<ul>
			<li>服务器:<input type="text" name="serverIds" id="serverIds" onclick="openServerDiglog()" class="validate[required]" value="${paramMap.serverIds}"></li>
			<li>时间:<input type="text" name="logTime" class="input_search" readonly="readonly" maxlength="20" value="${paramMap.logTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})">
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td>等级</td>
			<td>角色数</td>
			<td>占比</td>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr  class="tr_list_data">
			<td class="center">${item.level}</td>			
			<td class="center"><fmt:formatNumber value="${item.num}" pattern="0"/></td> 					
			<td class="center"><fmt:formatNumber value="${item.rate * 100}" pattern="0.00"/>%</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>