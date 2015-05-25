<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：gm工具 >> 游戏账号封停 >> 账号封停状态</div>
	<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>账号:<input type="text" name="userId"  id="userId"  value="${paramMap.userId}"></li>
			<li>
				禁言/封号:<select name="status">
					<option value="">全部</option>
					<option value="fengHao" <c:if test="${paramMap.status == 'fengHao'}"> selected=selected</c:if> >封号</option>
					<option value="jinYan"  <c:if test="${paramMap.status == 'jinYan'}"> selected=selected</c:if> >禁言</option>
				</select>
			</li>
			<li>封停时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">禁言/封号</li>
		</ul>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="10%">服务器</td>
			<td width="10%"> 账号</td>
			<td width="10%"> 是否被封号</td>
			<td width="10%"> 封号/解封</td>
			<td width="10%"> 是否被禁言</td>
			<td width="10%"> 禁言/解禁</td>
			<td width="15%"> 备注信息 </td>
			<td width="10%"> 操作者 </td>
			<td width="15%"> 禁言与封号修改时间</td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"> ${item.serverName}</td>
			<td class="center"> ${item.userId}</td>
			<td class="center">
				<c:choose><c:when test="${item.isCanUse==1}"><font color="red">是</font></c:when>
				<c:otherwise>否</c:otherwise>
				</c:choose>
			</td>
			<td class="center">
				<c:choose>
					<c:when test="${item.isCanUse==1}"><a href="./userforbidUse.do?isCanUse=1&userId=${item.userId}&serverId=${item.serverId}">解封</a></c:when>
					<c:otherwise><a href="./userforbidUse.do?isCanUse=0&userId=${item.userId}&serverId=${item.serverId}">封号</a></c:otherwise>
				</c:choose> 
			</td>
			<td class="center">
			<c:choose><c:when test="${item.isCanSpeak==1}"><font color="red">是</font></c:when>
			<c:otherwise>否</c:otherwise>
			</c:choose> </td> 
			<td class="center"> 
				<c:choose>
					<c:when test="${item.isCanSpeak==1}"><a href="./userforbidSpeak.do?isCanSpeak=1&userId=${item.userId}&serverId=${item.serverId}">解禁</a></c:when>
					<c:otherwise><a href="./userforbidSpeak.do?isCanSpeak=0&userId=${item.userId}&serverId=${item.serverId}">禁言</a></c:otherwise>
				</c:choose> 
			</td>
			<td>
				<div class="word-break" title="${item.addMsg}">${item.addMsg}</div>
			</td>
			<td  class="center"> ${item.userName}</td>
			<td class="center"> 
				<fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="9"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</div>
                                    
</div>
</body>
</html>