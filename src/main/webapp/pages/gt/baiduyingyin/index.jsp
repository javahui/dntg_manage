<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: GM工具 >> 百度影音人数</div>

		<div class="div_list">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td>服务器</td>
					<td>num</td>
				</tr>
				<c:forEach items="${list}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.key}</td>
					<td class="center">${item.value}</td>
				</tr>
				</c:forEach>
				
				<c:if test="${empty list}"><tr class="tr_list_data"><td colspan="30"><font color="red">当前查询条件下无数据</font></td></tr></c:if>
			</table>
		</div>
	</div>
</body>
</html>