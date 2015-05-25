<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏相关数据查询 >> 玩家信息查询</div>

		<div class="div_search">
			<form>
				<ul>
					<li>角色名：<input type="text" name="name" class="input_search" value="${paramMap.name}"></li>
					<li>玩家账号：<input type="text" name="userId" class="input_search" value="${paramMap.userId}"></li>
					<li>等级区间：<input type="text" name="startLevel" class="input_search" value="${paramMap.startLevel}" size="6">
					                      - <input type="text" name="endLevel" class="input_search" value="${paramMap.endLevel}" size="6"></li>
					<li><button type="submit">查询</button></li>
					<li><button type="button" onclick="exportXls()">Excel</button></li>
				</ul>
			</form>
		</div>

		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="submitCheckedRecordIds('userforbidUse.do')">批量封号选中账号</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('userforbidSpeak.do')">批量禁言选中账号</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('userforbidUseAdmit.do')">批量解除封号选中账号</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('userforbidSpeakAdmit.do')">批量解除禁言选中账号</li>
			</ul>
		</div>
	
		<div class="div_list">
		<form id="tableForm" action="">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="3%"><input id="checkallornot" name="checkallornot"  type="checkbox"></td>
				<td width="10%">用户账号</td>
				<td width="10%">角色名</td>
				<td width="5%">职业</td>
				<td width="5%">性别</td>
				<td width="5%">等级</td>
				<td width="5%">当前经验</td>
				<td width="10%">最后上线时间</td>
				<td width="10%">最后离线时间</td>
				<td width="10%">角色创建时间</td>
				<td width="10%">服务器id</td>
				<td width="3%">封号状态</td>
				<td width="3%">禁言状态</td>
				<td width="5%">操作</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" ></td>
				<td class="center"> ${item.userId}</td>
				<td class="center"> ${item.name}</td>
				<td class="center"> ${item.job}</td>
				<td class="center"> ${item.sex == 1 ? '女' : '男'}</td>
				<td class="center"> ${item.level}</td>
				<td class="center"> ${item.exp}</td>
				<td class="center"> <fmt:formatDate value="${item.onlineTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td class="center"> <fmt:formatDate value="${item.offlineTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="center"> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="center">${item.serverId}</td>
				<td class="center">${item.fenghaoState == 1 ? '封号':'未封号'}</td>
				<td class="center">${item.jinYanState == 1 ? '禁言':'未禁言'}</td>
				<td class="center"> 
					<a href="show.do?id=${item.id}">详细信息</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</form>
		</div>

		<table class="tbl_list">
			<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>
</body>
</html>