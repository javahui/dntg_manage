<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：GM工具 >> 充值 >> 列表</div>
	
	<div class="div_search">
		<form>
			<ul>
				<li>
					审批状态:
					<select name="isAudit">
						<option value="">全部</option>
						<c:forEach items="${auditMap}" var="entry">
							<option value="${entry.key}" <c:if test="${paramMap.isAudit==entry.key}">selected="selected"</c:if> >${entry.value}</option>
						</c:forEach>
					</select>
				</li>
				<li>角色名：<input name="playerName" class="input_search" size="15" maxlength="20" value="${paramMap.playerName}"></li>
				<li>服务器：<input name="serverId" id="serverId" size="12" class="input_search" value="${paramMap.serverId}" onclick="openSingeChoiceServerDiglog()"></li>
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
							<option value="${map.key}" <c:if test="${paramMap.moneyType == map.key}">selected="selected"</c:if> >${map.value}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					时间:<input name="startTime" class="input_search" size="10" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					- <input name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
				</li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">充值申请</li>
		</ul>
	</div>
	
	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="9%">服务器名</td>
				<td width="9%">用户账号</td>
				<td width="9%">角色名</td>
				<td width="7%">充值类型</td>
				<td width="7%">货币类型</td>
				<td width="5%">充值数量</td>
				<td width="11%">充值时间</td>
				<td width="7%">申请者</td>
				<td width="7%">审批者</td>
				<td width="13%">备注</td>
				<td width="4%">审批状态</td>
			</tr>
			
			<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.serverName}</td>
					<td class="left">${item.playerAccount}</td>
					<td class="left">${item.playerName}</td>
					<td class="center">${rechargeTypeMap[item.rechargeType]}</td>
					<td class="center">${moneyTypeMap[item.moneyType]}</td>
					<td class="right">${item.moneyNum}</td>
					<td class="center"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td class="center">${item.userName} </td>
					<td class="center">${item.auditor} </td>
					<td class="left"> <div class="word-break" title="${item.content}">${item.content}</div> </td>
					<td class="center">
						<c:if test="${item.isAudit == 0}">未审批</c:if>
						<c:if test="${item.isAudit == 1}">通过审批</c:if>
						<c:if test="${item.isAudit == 2}">未通过审批</c:if>
						<input type="hidden" value="${item.id}" name="id">
					</td>
				</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="12"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>

</div>
</body>
</html>