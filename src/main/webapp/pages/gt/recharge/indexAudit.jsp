<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: GM工具 >> 充值审批 >> 列表</div>

	<div class="div_search">
		<form>
			<ul>
				<li>角色名：<input type="text" name="playerName" class="input_search" size="15" maxlength="20" value="${paramMap.playerName}"></li>
				<li>服务器：
					<input name="serverId" id="serverId" class="input_search" value="${paramMap.serverId}" onclick="openSingeChoiceServerDiglog()">
				</li>
				<li>充值类型：
					<select name="rechargeType">
						<option value="">全部</option>
						<c:forEach items="${rechargeTypeMap}" var="map">
							<option value="${map.key}" <c:if test="${paramMap.rechargeType==map.key}">selected="selected"</c:if> >${map.value}</option>
						</c:forEach>
					</select>
				</li>
				<li>货币类型：
					<select name="moneyType">
						<option value="">全部</option>
						<c:forEach items="${moneyTypeMap}" var="map">
							<option value="${map.key}" <c:if test="${paramMap.moneyType==map.key}">selected="selected"</c:if> >${map.value}</option></c:forEach>
					</select>
				</li>
				<li>时间:<input type="text" name="startTime" class="input_search" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					- <input type="text" name="endTime"  class="input_search" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
				</li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>

	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="submitCheckedRecordIds('audit.do')">审核</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('cancel.do')">取消</li>
		</ul>
	</div>

	<div class="div_list">
	<form id="tableForm" action="">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="1%"><input id="checkallornot" name="checkallornot" type="checkbox" /></td>
			<td width="3%">服务器名</td>
			<td width="9%">用户账号</td>
			<td width="9%">角色名</td>
			<td width="5%">充值类型</td>
			<td width="3%">货币类型</td>
			<td width="3%">充值数量</td>
			<td width="5%">充值时间</td>
			<td width="4%">申请者</td>
			<td width="10%">备注</td>
			<td width="4%">失败原因</td>
			<td width="3%">审批状态</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
			<td class="center">${item.serverName}</td>
			<td class="center">${item.playerAccount}</td>
			<td class="center">${item.playerName}</td>
			<td class="center">${rechargeTypeMap[item.rechargeType]}</td>
			<td class="center">${moneyTypeMap[item.moneyType]}</td>
			<td class="center">${item.moneyNum}</td>
			<td class="center"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td class="center">${item.userName} </td>
			<td class="left">${item.content}</td>
			<td class="left"> ${item.failReason} </td>
			<td class="center">
				<c:choose>
					<c:when test="${item.isAudit == 0}">没审批</c:when>
					<c:when test="${item.isAudit == 1}">审批通过</c:when>
					<c:when test="${item.isAudit == 2}">未能过审批</c:when>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
	</form>
	</div>

	<table class="tbl_list">
		<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="indexAudit.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
</div>
</body>
</html>