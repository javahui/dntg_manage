<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: GM工具 >> 游戏公告 >> 列表</div>
	
	<div class="div_search">
		<form>
		<ul>
			<li>内容：<input type="text" name="content" class="input_search" value="${paramMap.content}"></li>
			<li>状态：
				<select name="noticeStatus">
					<option value="">全部</option>
					<c:forEach items="${noticeStatusMap}" var="map">
						<option value="${map.key}" <c:if test="${map.key==paramMap.noticeStatus }">selected="selected"</c:if> >${map.value}</option>
					</c:forEach>
				</select>
			</li>
			<li>间隔时间：<input type="text" name="stepTime" class="input_search" size="2" value="${paramMap.stepTime}"></li>
			<li>
				创建时间:
				<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"  id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">新增</li>
			<li class="li_operate" onclick="submitCheckedRecordIds('delete.do')">删除</li>
		</ul>
	</div>
	
	<div class="div_list">
		<form id="tableForm">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td width="3%"><input id="checkallornot" name="checkallornot"  type="checkbox"/></td>
					<td>公告内容</td>
					<td width="4%">公告类型</td>
					<td width="10%">适用服务器</td>
					<td width="4%">已循环次数</td>
					<td width="4%">总循环次数</td>
					<td width="4%">间隔时间</td>
					<td width="7%">开始结束时间 </td>
					<td width="8%">创建时间</td>
					<td width="5%">状态</td>
					<td width="5%">创建人</td>
					<td width="4%">操作</td>
				</tr>
				<c:forEach items="${list.records}" var="item" varStatus="status">
					<tr class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordIds" value="${item.id}"></td>
						<td class="left"> ${item.content}</td>
						<td class="center">
							<c:if test="${item.global == 1}">世界公告</c:if>
							<c:if test="${item.global != 1}">系统公告</c:if>
						</td>
						<td class="center">
							<c:if test="${item.global == 1 }">所有服务器</c:if>
							<c:if test="${item.global != 1 }"><div class="word-break" title="${item.serverIds}">${item.serverIds}</div></c:if>
						</td>
						<td class="center">${item.repeatCount}</td>
						<td class="center">${item.finishedCount}</td>
						<td class="center">${item.stepTime}分钟</td>
						<td class="center"><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm"/><br><fmt:formatDate value="${item.finishTime}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td class="center"><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td class="center">${noticeStatusMap[item.noticeStatus]} </td>
						<td class="center">${item.createName} </td>
						<td class="center">
							<c:if test="${item.noticeStatus==0}"> <a href="publish.do?id=${item.id}">发布</a></c:if>
							<c:if test="${item.noticeStatus==1 || item.noticeStatus==2}"> <a href="cancel.do?id=${item.id}">取消</a></c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>		
	
	<table class="tbl_list">
		<tr class="tr_list_data"><td class="td_page_shift" colspan="15"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	<div class="information"><span>状态说明：1、未发布，指新增加的公告；2、已发布，加入任务列表，准备向服务器推送公告；3、进行中，指已经开始向服务器推送公告；4、正常结束，向指定服务器推送完指定次数；5、已取消，用户手动取消的公告</span></div>
</div>
</body>
</html>