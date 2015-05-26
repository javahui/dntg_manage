<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏信息查询 >> 实时在线人数</div>
		<div class="div_list">
			<br/>
			总创建人数:${totalCount},今日创建人数:${todayCount}<br/>
			当前在线总人数:${count}
			<br/>
			<br/>
			场景人数分布:
			<ul>
				<c:forEach items="${stageCountInfo}" var="node">
				<li style="float: none;">${node}</li>	
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>