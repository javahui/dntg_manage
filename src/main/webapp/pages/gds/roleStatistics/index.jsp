<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 角色等级区间统计</div>
		
		<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="50%">等级</td>
				<td width="50%">人数</td>
			</tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${ list}" var="modelMap" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center"> ${ modelMap.levelInterval}</td>
					<td class="center">	${ modelMap.roleCount} </td>
				</tr>
				</c:forEach>
			</c:when>
		</c:choose>
		</table>
	</div>
</div>
</body>
</html>