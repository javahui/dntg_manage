<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：gm工具 >> GM与指导员账号管理 >> 账号状态列表</div>

	<div class="div_search">
		<form>
		<ul>
			<li>账号:<input type="text" name="userId"  id="userId" value="${paramMap.userId}"></li>
			<li>
				类型:<select name="roleType" >
					<option value="">全部</option>
					<option value=1 <c:if test="${paramMap.roleType == 1}">selected='selected'</c:if> >指导员</option>
					<option value=2 <c:if test="${paramMap.roleType == 2}">selected='selected'</c:if> >GM</option>
				</select>
			</li>
			<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>

	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">添加账号权限</li>
		</ul>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="20%">服务器</td>
				<td width="20%"> 角色名 </td>
				<td width="20%"> 用户类型</td>
				<td width="20%"> 修改时间</td>
				<td width="20%"> 操作 </td>
			</tr>
			<c:forEach items="${list.records }" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center"> ${item.serverName}</td>
				<td class="center"> ${item.userId}</td>
				<td class="center">
					<c:if test="${item.roleType==1}">指导员</c:if>
					<c:if test="${item.roleType==2}">GM</c:if>
				</td>
				<td class="center"> <fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td class="center"> <a href="./edit.do?id=${item.id}">修改</a> </td>
			</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="5"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>

</div>
</body>
</html>