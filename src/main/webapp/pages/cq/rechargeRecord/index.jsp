<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：充值相关查询 >> 游戏充值查询</div>

	<div class="div_search">
		<form>
			<ul>
				<li>订单号：<input type="text" name="orderId" class="input_search" size="15" value="${paramMap.orderId}"></li>
				<li>角色名：<input type="text" name="roleName" class="input_search" size="15" maxlength="20" value="${paramMap.roleName}"></li>
				<li>角色账号：<input type="text" name="userGuid" class="input_search" size="15" maxlength="20" value="${paramMap.userGuid}"></li>
				<li>充值类型：
					<select name="rechargeType">
						<option value="">全部</option>
							<c:forEach items="${rechargeMap}" var="map">
								<option value="${map.key}" <c:if test="${paramMap.rechargeType == map.key}">selected="selected"</c:if> >${map.value}</option>
							</c:forEach>
					</select>
				</li>
				<li>货币类型：
					<select name="moneyType">
						<option value="">全部</option>
						<c:forEach items="${moneyMap}" var="map">
							<option value="${map.key}" <c:if test="${paramMap.moneyType==map.key}">selected="selected"</c:if>>${map.value}</option>
						</c:forEach>
					</select>
				</li>
				<li>
					是否成功：
					<select name="rechargeState">
						<option value="">全部</option>
						<option value="0" <c:if test="${paramMap.rechargeState==0}">selected="selected"</c:if> >成功</option>
						<option value="1" <c:if test="${paramMap.rechargeState==1}">selected="selected"</c:if> >失败</option>
					</select>
				</li>
				<li>
					时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
					</li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>
	
	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="10%">角色账号</td>
				<td width="10%">角色名</td>
				<td width="10%">订单ID</td>
				<td width="10%">充值类型</td>
				<td width="10%">货币类型</td>
				<td width="10%">充值RMB</td>
				<td width="10%">充值金额</td>
				<td width="8%">是否成功</td>
				<td width="22%">充值时间</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="left">${item.userGuid}</td>
					<td class="left">${item.roleName}</td>
					<td width="left">${item.orderId}</td>
					<td class="center">${rechargeMap[item.rechargeType]}</td>
					<td class="center">${moneyMap[item.moneyType]}</td>
					<td class="center"><fmt:formatNumber value="${item.rmb}" pattern="0.0"></fmt:formatNumber></td> 
					<td class="center">${item.moneyNum}</td>
					<td class="center"><c:if test="${item.rechargeState==0}">成功</c:if><c:if test="${item.rechargeState==1}">失败</c:if></td>
					<td class="center"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
				</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="9"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>

</div>
</body>
</html>