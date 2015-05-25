<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: GM工具 >> 装备发放 >> 列表</div>

		<div class="div_search">
			<form action="index.do">
			<ul>
				<li>接收人:<input name="loginName"  value="${paramMap.loginName}" /></li>
				<li>发送人:<input name="sendName"  value="${paramMap.sendName}" /></li>
				<li><button type="submit">查询</button></li>
			</ul>
			</form>
		</div>

		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='add.do'">发送装备</li>
			</ul>
		</div>

		<div class="div_list">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td>服务器</td>
					<td>接收人</td>
					<td>发送人</td>
					<td>物品</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.serverId}</td>
					<td class="center">${item.loginName}</td>
					<td class="center">${item.sendName}</td>
					<td class="center">${item.goods}</td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</table>
		</div>

	</div>
</body>
</html>