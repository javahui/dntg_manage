<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head></head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏日志 >> GM聊天记录</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>角色名:<input type="text" name="roleName" value="${paramMap.roleName}"/></li>
			<li>私聊对象:<input type="text" name="toRoleName" value="${paramMap.toRoleName}"/></li>
			<li>聊天类型：
				<select name="type">
					<option value="">全部</option>
					<c:forEach items="${typeMap}" var="entry">
						<option value="${entry.key}" <c:if test="${paramMap.type==entry.key}">selected="selected"</c:if> >${entry.value}</option>
					</c:forEach>
				</select>
			</li>
			<li>查询时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
				<td width="10%">时间</td>	
				<td width="10%">频道</td>
				<td width="10%">说话人</td>
				<td width="10%">对象</td>
				<td width="60%">记录</td>	
		</tr>
		<c:choose>
			<c:when test="${not empty list.records }">
				<c:forEach items="${list.records}" var="gmChat" varStatus="status">
				<tr class="tr_list_data">
					<td class="center"><fmt:formatDate value="${gmChat.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td class="center">${typeMap[gmChat.type]}</td>
					<td class="center">${gmChat.roleName}</td>
					<td class="center">${gmChat.toRoleName }</td>
					<td class="left">${gmChat.msg}</td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="7"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="7"><font color="red">由于数据量过大，请根据角色名或指定时间段查询</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
                                    
</div>
</body>
</html>