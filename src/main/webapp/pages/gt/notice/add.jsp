<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: GM工具 >> 游戏公告 >> 新增</div>
	<div class="div_edit">
		<div class="content-box-header"></div>
		
		<form action="save.do" method="post">
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name">公告内容</td>
					<td class="td_edit_value">
						<textarea name="content" id="myEditor"> 这里我可以写一些输入提示</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">开始时间</td>
					<td class="td_edit_value">
						<input type="text" name="startTime" class="input_edit_value validate[required]" id="startDatePicker" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" readonly="readonly">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">结束时间</td>
					<td class="td_edit_value">
					<input type="text" name="finishTime" class="input_edit_value validate[required]" id="endDatePicker" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'startDatePicker\')}'})" readonly="readonly">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">间隔时间</td>
					<td class="td_edit_value">
						<input type="text" name="stepTime" class="input_edit_value validate[required,custom[integer]]" id="step_time">
						<span class="error">*(分钟)</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">公告类型</td>
					<td class="td_edit_value">
						<select name="noticeType" >
							<option value="0">系统公告</option>
							<option value="1">世界公告</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">适用服务器</td>
					<td class="td_edit_value">
						<c:if test="${sessionScope.curUser.allServer == true}">
							<input type="radio" name="global" value="1" checked="checked" onclick="$('#selectServerDiv').hide()">所有服务器
							<input type="radio" name="global" value="0" onclick="$('#selectServerDiv').show()">指定服务器 
							<div id="selectServerDiv" style="display:none;">
								<input name="serverIds" id="serverIds" class="input_edit_value validate[required]" readonly="readonly" >
								<button type="button" onclick="openServerDiglog()">选择服务器</button>
							</div>
						</c:if>
						<c:if test="${sessionScope.curUser.allServer == false}">
							<input type="hidden" name="global" value="0">
							<input name="serverIds" id="serverIds" class="input_edit_value validate[required]" readonly="readonly">
							<button type="button" onclick="openServerDiglog()">选择服务器</button>
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name"></td>
					<td class="td_edit_value">
						<button type="submit" >提交</button> <button type="button" onclick="window.location='./index.do'">返回</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>