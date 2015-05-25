<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
 <body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏日志查询 >> 用户登陆日志 </div>
	<div class="div_search">
	<form>
		<ul>
			<li>账号:<input type="text" name="userId" id="userId" value="${paramMap.userId}"></li>
			<li>角色名:<input type="text" name="userName" id="userName" value="${paramMap.userName}"></li>
			<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;
			</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button"  onclick="exportXls()">Excel</button></li>
		</ul>
	</form>
	</div>
	
	<div class="div_list">
    <table class="tbl_list">
	<tr class="tr_list_title">								
		<td width="10%"> 账号</td>
	    <td width="20%"> 角色名 (角色ID)</td>										
		<td width="20%"> 登陆时间</td>										
		<td width="20%"> 登出时间</td>									
		<td width="10%"> 等级</td>
		<td width="20%"> ip地址</td>						
	</tr>
	<c:forEach items="${list.records}" var="item" varStatus="status">
	<tr class="tr_list_data">															
		<td class="center">${item.userId}</td>
		<td class="center">${item.userName} (${item.roleId})</td>															
		<td class="center"><fmt:formatDate value="${item.loginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td class="center"><fmt:formatDate value="${item.logoutTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td class="center">${item.level} </td>
		<td class="center">${item.ip} </td>										
	</tr>
	</c:forEach>
	<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	<c:if test="${list.records == null}">
		<tr class="tr_list_data"><td class="td_page_shift" colspan="6" style="text-align: center;"><font color="red">由于数据量过大,请输入用户信息或者指定时间查询！</font></td></tr>
	</c:if>
	</table>
	</div>
</div>
</body>
</html>
