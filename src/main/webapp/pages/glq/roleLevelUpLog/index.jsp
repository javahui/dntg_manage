<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏日志查询 >> 角色升级</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>角色名:<input type="text" name="userName" value="${paramMap.userName}"/></li>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="10%"> 角色名 </td>
			<td width="10%"> 角色ID </td>
			<td width="10%"> 等级 </td>
			<td width="10%"> 时间 </td>
		</tr>
		<c:choose>
			<c:when test="${not empty list.records }">
				<c:forEach items="${list.records}" var="roleLevelUpgrade" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"> ${roleLevelUpgrade.userName}</td>			
						<td class="center"> ${roleLevelUpgrade.userRoleId}</td> 			
						<td class="center"> ${roleLevelUpgrade.level}</td> 					
						<td class="center"> ${roleLevelUpgrade.logTime}</td>
					</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><font color="red">由于数据量过大，请根据角色名或者指定时间查询</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
                                    
	
</div>
</body>

</html>