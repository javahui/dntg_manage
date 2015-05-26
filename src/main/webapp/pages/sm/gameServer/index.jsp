<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
/**
 * 改变服务器状态(serverStatus:要更改的状态，sortId:服务器分类Id)
 */
function changeWholeServerStatus(serverStatus, sortId){
	var msg = "确认更改当前分类所有服务器状态？";
	if( !confirm(msg) ){
		return;
	}
	var params = {};
	params["sortId"] = sortId;
	params["serverStatus"] = serverStatus;
	$.post("./itemStatusChangeWhole.do", params, function(data){
		if(data == "_true"){
			window.location.reload();
		}else{
			alert("修改失败，请稍后重试");
		}
	}, "text");
}
</script>
</head>
<body>
<div id="div_right_frame">
	<!-- 说明块 -->
	<div id="div_position_nav">当前位置：超级管理  >> 游戏服务器管理 >> 服务器列表</div>
	
	<!-- 搜索块 -->
	<div class="div_search">
		<form>
			<ul>
				<li>服务器ID：<input type="text" name="serverId" class="input_search" size="20" maxlength="20" value="${paramMap.serverId}"></li>
				<li>分类：
					<select name="sortId">
						<option value="" >全部</option>
						<c:forEach items="${sortMap}" var="sortEntry"><option value="${sortEntry.id}" <c:if test="${paramMap.sortId==sortEntry.id}">selected="selected"</c:if>>${sortEntry.sortName}</option></c:forEach>
   				    </select>
				</li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>
	
	<!-- 操作块 -->
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">新增</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('updateGameServerStatusOpen.do')" title="开启勾选服务器">开启</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('updateGameServerStatusClose.do')" title="关闭勾选服务器">关闭</li>
			<li class="li_operate" onclick="changeWholeServerStatus(1, '${paramMap.sortId}')" title="开启全部当前分类服务器" id="open_all_server">全部开启<c:forEach items="${sortMap}" var="sortEntry"><c:if test="${paramMap.sortId==sortEntry.id}">-${sortEntry.sortName}</c:if></c:forEach></li>
			<li class="li_operate" onclick="changeWholeServerStatus(0, '${paramMap.sortId}')" title="关闭全部当前分类服务器" id="close_all_server">全部关闭<c:forEach items="${sortMap}" var="sortEntry"><c:if test="${paramMap.sortId==sortEntry.id}">-${sortEntry.sortName}</c:if></c:forEach></li>
		</ul>
	</div>

	<!-- 数据列表块 -->
	<div class="div_list">
	<form id="tableForm">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="3%"><input id="checkallornot" name="checkallornot"  type="checkbox" id="selectAll"/></td>
			<td width="5%">服务器ID</td>
			<td width="8%">服务器名</td>
			<td width="8%">服务器描述</td>
			<td width="8%">是否测试服</td>
			<td width="14%">游戏数据库url</td>
			<td width="14%">日志数据库url</td>
			<td width="14%">游戏入口url</td>
			<td width="12%">游戏服务器远程url</td>
			<td width="4%">状态</td>
			<td width="4%">分类</td>
			<td width="6%">操作</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr id="recordTr${status.index}" class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
			<td class="left"><a href="show.do?id=${item.id}">${item.serverId}</a></td>
			<td class="left">${item.serverName}</td>
			<td class="left">${item.serverDesc}</td>
			<td class="center"><c:if test="${item.isTest==0}">否</c:if><c:if test="${item.isTest==1}">是</c:if></td>
			<td class="left">${item.gameDbUrl}</td>
			<td class="left">${item.logDbUrl}</td>
			<td class="left">${item.gateUrl}</td>
			<td class="left">${item.gameServerRemoteUrl}</td>
			<td class="center"><c:if test="${item.serverStatus==1}"><span class="server-open">开启</span></c:if><c:if test="${item.serverStatus==0}"><span class="server-close">关闭</span></c:if></td>
			<td class="center">${item.sortName}</td>
			<td class="center"><a href="edit.do?id=${item.id}">修改</a>
				<a href="show.do?id=${item.id}">详细信息</a>
			</td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="11">
		<base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/>
		</td></tr>
	</table>
	</form>
	</div>
</div>
</body>

</html>