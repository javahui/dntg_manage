<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: GM工具  >> 直接充值 >> 列表</div>

	<div class="div_search">
		<form name="searchForm">
		<ul>
			<li>角色名：<input type="text" name="playerName" class="input_search" size="15" maxlength="20" value="${paramMap.playerName}"></li>
			<li>服务器：<input type="text" name="serverId" id="serverId" value="${paramMap.serverId}"  onclick="openSingeChoiceServerDiglog()"> </li>
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
			<li>时间:<input name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>

	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='addDirect.do'">申请充值</li>
			<li class="li_operate" onclick="window.location='../serverStatistics/ybconsume.do'">元宝花费统计</li>
			<li class="li_operate" onclick="window.location='../statisticsCount/index.do'">各种等级分布统计</li>
		</ul>
	</div>

	<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="5%">服务器名</td>
				<td width="10%">用户账号</td>
				<td width="20%">角色名</td>
				<td width="5%">充值类型</td>
				<td width="4%">货币类型</td>
				<td width="5%">充值数量</td>
				<td width="8%">充值时间</td>
				<td width="6%">申请者</td>
				<td>备注</td>
			</tr>
			<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${item.serverName}</td>
					<td class="left"> <div class="word-break" style="width:150px" title="${item.playerAccount}">${item.playerAccount}</div> </td>
					<td class="left"> <div class="word-break" style="width:300px" title="${item.playerName}">${item.playerName}</div></td>
					<td class="center">${rechargeTypeMap[item.rechargeType]} </td>
					<td class="center">${moneyTypeMap[item.moneyType]} </td>
					<td class="right">${item.moneyNum}</td>
					<td class="center"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td class="center">${item.userName} </td>
					<td class="left"> <div class="word-break" style="width:600px" title="${item.content}">${item.content}</div> </td>
				</tr>
			</c:forEach>
			<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="indexDirect.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>

</div>
</body>
</html>