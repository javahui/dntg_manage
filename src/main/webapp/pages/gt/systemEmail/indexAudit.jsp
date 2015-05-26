<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: gm工具 >> 系统邮件审批 >> 列表</div>
	
	<div class="div_search">
		<form>
			<ul>
				<li>
					状态:
					<select name="state" >
						<option value="">全部</option>
						<option value="1" <c:if test="${paramMap.state == 1}">selected='selected'</c:if> >待审批</option>
						<option value="2" <c:if test="${paramMap.state == 2}">selected='selected'</c:if> >取消发送</option>
					</select>
				</li>
				<li>标题:<input type="text" name="title"  id="title"  value="${paramMap.title}"></li>
				<li>
					发送方式:
					<select name="globalSend">
						<option value="">全部</option>
						<option value="1" <c:if test="${paramMap.globalSend == 1}">selected='selected'</c:if>>全服发送</option>
						<option value="0" <c:if test="${paramMap.globalSend == 0}">selected='selected'</c:if>>指定用户发送</option>
					</select>
				</li>
				<li>时间:<input name="startTime" class="input_search" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})" >
					- <input name="endTime" class="input_search" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})" >
				</li>
				<li><button type="submit">查询</button></li>
			</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
				<li class="li_operate" onclick="submitCheckedRecordIds('todo.do')">确认发送</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('undo.do')">取消</li>
				<li class="li_operate" onclick="submitCheckedRecordIds('redo.do')">恢复</li>
		</ul>
	</div>
	
	<div class="div_list">
	<form id="tableForm" action="">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="3%"><input id="checkallornot" name="checkallornot" type="checkbox"></td>
			<td width="9%"> 标题 </td>
			<td width="8%"> 内容 </td>
			<td width="5%"> 发送方式 </td>
			<td width="6%"> 附加物品列表 </td>
			<td width="4%"> 附加金币 </td>
			<td width="4%"> 附加元宝 </td>
			<td width="4%"> 延迟小时 </td>
			<td width="8%"> 发送的服务器 </td>
			<td width="15%"> 发送的用户列表</td>
			<td width="5%"> 申请者 </td>
			<td width="8%"> 时间 </td>
			<td width="4%">  状态 </td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
			<td> <div class="word-break" title="${item.title}">${item.title}</div> </td>
			<td> <div class="word-break" title="${item.content}">${item.content}</div> </td>
			<td>
				<c:if test="${item.globalSend==1}">全服发送</c:if>
				<c:if test="${item.globalSend==0}">指定用户</c:if>
			</td>
			<td> <div class="word-break" title="${item.attachments}">${item.attachments}</div> </td>
			<td class="center">${item.jb}</td>
			<td class="center">${item.yb}</td>
			<td class="center">${item.delayHours} </td> 
			<td class="left"> <div class="word-break" style="width:140px" title="${item.serverId}">${item.serverId}</div> </td>
			<td class="left"> <div class="word-break" style="width:400px" title="${item.receiverNames}">${item.receiverNames}</div> </td>
			<td class="center"> ${item.userName}</td>
			<td class="center"> <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td class="center"> 
				<c:if test="${item.state==1}">待审批 </c:if>
				<c:if test="${item.state==2}">已取消发送 </c:if>
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