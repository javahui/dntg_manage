<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">

	<div id="div_position_nav">当前位置: GM工具 >> 超级会员面板配置 >> 列表</div>
	
	<div class="div_search">
		<form>
			<ul>
				<li>QQ:<input type="text" name="qq" value="${paramMap.qq}"></li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
				<li class="li_operate" onclick="window.location='add.do'">新增</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
		</ul>
	</div>
	
	<div class="div_list">
	<form id="tableForm">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="2%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
			<td width="4%">QQ</td>
			<td width="8%">最小充值需求</td>
			<td width="15%">图片</td>
			<td>适用服务器</td>
			<td width="8%">上传时间</td>
			<td width="3%">操作</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" ></td>
			<td class="center">${item.qq}</td>
			<td class="center">${item.minRecharge}</td>
			<td class="center">${item.pic}</td>
			<td class="left"><div class="word-break" style="width: 1000px"  title="${item.serverIds}">${item.serverIds}</div></td>
			<td class="center"><fmt:formatDate value="${item.logUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td class="center"><a href="edit.do?id=${item.id}">修改</a>
			</td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="10"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>