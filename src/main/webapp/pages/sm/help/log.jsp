<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<table class="tbl_list">
		<c:forEach items="${list}" var="item"><tr><td>${item}</td></tr></c:forEach>
	</table>
</body>
</html>