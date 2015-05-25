<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏配置文件管理 >> 明人堂配置 >> 列表</div>

		<div class="div_search">
			<form action="upload.do" method="post" enctype="multipart/form-data">
				<ul>
					<li>文件名: <input type="file" name="file" class="input_file_value validate[required]">
					<li><button type="submit">上传文件</button></li>
				</ul>
			</form>
		</div>

		<div class="div_operate">
			<ul>
			</ul>
		</div>

		<div class="div_list">
			<form id="tableForm" action="">
				<table class="tbl_list">
					<tr class="tr_list_title">
						<td width="3%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"></td>
						<td>版本</td>
						<td>类型</td>
						<td>数值要求</td>
						<td>开始时间</td>
						<td>结束时间</td>
					</tr>
					<c:forEach items="${list}" var="item" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
						<td class="center">${item.version}</td>
						<td class="center">
							<c:if test="${item.type == 1}">战力排行</c:if>
							<c:if test="${item.type == 2}">充值排行</c:if>
							<c:if test="${item.type == 3}">消费排行</c:if>
						</td>
						<td class="center">${item.yaoqiu}</td>
						<td class="center"><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td class="center"><fmt:formatDate value="${item.finishTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>