<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：充值相关查询 >> 玩家充值统计</div>

	<div class="div_search">
		<form>
			<ul>
				<li>角色名:<input type="text"  name="userName"  value="${paramMap.userName}"/></li>
				<li>
					金额:<input type="text" name="moneyMin" class="input_search" size="10" value="${paramMap.moneyMin}"/>
					- <input type="text" name="moneyMax"   class="input_search" size="10"  value="${paramMap.moneyMax}"/>
				</li>
				<li>
					时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					-<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
				</li>
				<li><button type="submit">查询</button></li>
				<li><button type="button" onclick="exportXls()">Excel</button></li>
			</ul>
		</form>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="15%">玩家账号</td>
				<td width="10%">角色名</td>
				<td width="10%">角色创建时间</td>
				<td width="10%">充值次数</td>
				<td width="10%">总充值量(元)</td>
				<td width="10%">首次充值时间</td>
				<td width="10%">最后一次充值时间</td>
				<td width="10%">现有元宝</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.userId}</td>
					<td class="center">${item.userName}</td>
					<td class="center">${item.userCreateTime}</td>
					<td class="left">${item.num}</td>
					<td class="left"> <fmt:formatNumber value="${item.moneyNum}" pattern="0.0"></fmt:formatNumber></td>
					<td class="center"> <fmt:formatDate value="${item.firstTime}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td class="center"> <fmt:formatDate value="${item.lastTime}"  pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td class="left">${item.lingshi}</td>
				</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="8"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			<c:if test="list.records == null">
				<tr class="tr_list_data"><td class="td_page_shift" colspan="8"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:if>
		</table>
	</div>

</div>
</body>
</html>