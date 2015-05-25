<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：GM工具 >>  超级会员 >> 列表</div>
	
	<div class="div_search">
		<form>
		<ul>
			<li>
				角色名:<input type="text" name="playerName" class="input_search" value="${paramMap.playerName}"></li>
			</li>
			<li>
				修改时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime" class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='add.do'">新增</li>
			<li class="li_operate" onclick="window.location='addInner.do'">添加内部人员名单</li>
		</ul>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td>用户名</td>
			<td>QQ号码</td>
			<td>修改时间</td>
			<td>操作人</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center">${item.playerName}</td>
			<td class="center">${item.qq} </td>
			<td class="center">${item.logUpdateTime} </td>
			<td class="center"> ${item.userName} </td>
			<td class="center">
				<a href="edit.do?id=${item.id}">修改</a>
				<a href="${ctx}/systemEmail/addRoleQqList.do?receiverNames=${item.userRoleName}">发送邮件</a> 
			</td>
		</tr>
		</c:forEach>
		
		<tr class="tr_list_data"><td class="td_page_shift" colspan="12"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		
	</table>
	</div>
</div>
</body>
</html>