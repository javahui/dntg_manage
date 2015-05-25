<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏相关数据查询 >> 等级排行列表</div>
		
		<div class="div_search">
		<form>
			<ul>
				<li><button type="button"  onclick="exportXls()">Excel</button></li>
			</ul>
		</form>
		</div>

		<div class="div_list">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td width="33%">角色等级</td>
					<td width="33%">角色名</td>
					<td width="33%">升级时间</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.roleLevel}</td>
					<td class="center">${item.roleName}</td>
					<td class="center">${item.updateTime}</td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</table>
		</div>

	</div>
</body>
</html>