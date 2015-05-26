<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置:</span> GM工具  >> 引导员禁言列表</div>

		<div class="div_search">
			<form name="searchForm">
			<ul>
				<li>账号：<input type="text" name="userId" class="input_search" size="30" maxlength="30" value="${paramMap.userId}"></li>
				<li>角色名：<input type="text" name="name" class="input_search" size="30" maxlength="30" value="${paramMap.name}"></li>
				<li>状态：
					<select name="status">
						<option>全部</option>
						<option value="fengHao" <c:if test="${paramMap.status == 'fengHao'}"> selected=selected</c:if> >封号</option>
						<option value="jinYan"  <c:if test="${paramMap.status == 'jinYan'}"> selected=selected</c:if> >禁言</option>
					</select>
				</li>
				<li><button type="submit">查询</button></li>
			</ul>
			</form>
		</div>

		<div class="div_list">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td>用户ID</td>
					<td width="20%">用户账号</td>
					<td width="10%">角色名</td>
					<td width="10%">是否禁言</td>
					<td width="10%">是否封号</td>
					<td width="10%">时间</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center"> ${item.userRoleId}</td>
					<td class="center"> ${item.userId} </td>														
					<td class="center"> ${item.name} </td>														
					<td class="center"> 
						<c:if test="${item.jinYan == 1}"> 禁言	</c:if>
						<c:if test="${item.jinYan != 1}"> 未禁言	</c:if>
					</td>	
					<td class="center">
						<c:if test="${item.fengHao == 1}"> 封号	</c:if>
						<c:if test="${item.fengHao != 1}"> 未封号	</c:if>
					</td>														
					<td class="center"> <fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				</tr>
				</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</table>
		</div>
	</div>
</body>
</html>