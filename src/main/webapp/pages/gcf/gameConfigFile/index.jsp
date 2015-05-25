<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏配置文件管理 >> 配置文件 >> 列表</div>

		<div class="div_search">
			<form>
				<ul>
					<li>文件描述：<input type="text" name="fileDesc" class="input_search" maxlength="20" value="${paramMap.fileDesc}"/></li>
					<li>文件名：
						<select name="fileMapName">
							<option value="">全部</option>
							<c:forEach items="${gameFileMap}" var="map">
								<option value="${map.key}" <c:if test="${paramMap.fileMapName == map.key}">selected="selected"</c:if> >${map.value}</option>
							</c:forEach>
						</select>
					</li>
					<li>
						时间:<input type="text" name="startTime" class="input_search" size="15" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
						  -&nbsp;<input type="text" name="endTime" class="input_search" size="15" maxlength="20" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
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
			<form id="tableForm" action="">
				<table class="tbl_list">
					<tr class="tr_list_title">
						<td width="3%" class="center"><input id="checkallornot" name="checkallornot" type="checkbox"/></td>
						<td>原文件名</td>
						<td>配置文件名</td>
						<td>文件描述</td>
						<td>适用服务器</td>
						<td>上传时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${list.records}" var="item" varStatus="status">
						<tr class="tr_list_data">
							<td class="center"><input type="checkbox" name="recordIds" value="${item.id}" ></td>
							<td class="center">${item.oldName}</td>
							<td class="center">${item.fileMapName}</td>
							<td class="center">${item.fileDesc}</td>
							<td class="center">
								<c:if test="${item.global == 1}">全部</c:if>
								<c:if test="${item.global != 1}">
									<input id="f${status.index}" onclick="openServerDiglog('f${status.index}',true)" value="${item.serverIds}" readonly="readonly" title="点击详情" style="border:0px;cursor:pointer">
								</c:if>
							</td>
							<td class="center">${item.uploadTime}</td>
							<td class="center"> <a href="edit.do?id=${item.id}&fileMapName=${item.fileMapName}">修改</a> </td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>

		<table class="tbl_list">
			<tr class="tr_list_data"><td class="td_page_shift" colspan="20"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		</table>
	</div>
</body>
</html>