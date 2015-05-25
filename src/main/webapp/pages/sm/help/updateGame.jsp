<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	游戏数据库修改页面
	<div class="div_search">
		<form method="post">
		<ul>
			<li><textarea rows="20" cols="10" name="sql">${paramMap.sql}</textarea></li>
			<li><button type="submit">修改</button></li>
		</ul>
		</form>
	</div>
	修改记录数：${list}
</body>
</html>