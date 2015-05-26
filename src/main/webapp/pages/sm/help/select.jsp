<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	tool数据库查询
	<div class="div_search">
		<form method="post">
		<ul>
			<li><textarea rows="100" cols="50" name="sql" >${paramMap.sql}</textarea></li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<c:if test="${list != null }">
	执行时间:${time} 行数:${fn:length(list)}
	<table class="tbl_list">
		 <tr>
			<c:forEach items="${list[0]}" var="item">
				<td>${item.key}</td>
			</c:forEach>
		</tr>
		
		<c:forEach items="${list}" var="item">
		 <tr>
			<c:forEach items="${item}" var="it">
				<td>${it.value}</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>