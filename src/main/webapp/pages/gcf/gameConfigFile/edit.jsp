<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏配置文件管理 >> 配置文件 >> 修改</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="update.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${record.id}">
				<input type="hidden" name="newName" value="${record.newName}">
				<input type="hidden" name="filepath" value="${record.filepath}">
				<input type="hidden" name="global" value="${record.global}">
				<input type="hidden" name="oldServerIds" value="${record.serverIds}">
				<input type="hidden" name="fileMapName" value="${record.fileMapName}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">上传文件</td>
						<td class="td_edit_value">
							<input type="file" name="file" class="input_file_value">
							<span class="error">(不选择即为不修改)</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">文件描述</td>
						<td class="td_edit_value">
							<input type="text" name="fileDesc" class="input_edit_value validate[required]" value="${record.fileDesc}">
							<span class="error">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">配置文件名</td>
						<td class="td_edit_value">
								<input class="input_edit_value" value="${param.fileMapName}" disabled="disabled"  />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">适用服务器</td>
						<td class="td_edit_value">
							<c:if test="${record.global == 1}">
								全部服务器
							</c:if>
							<c:if test="${record.global == 0}">
								指定服务器
								<button type="button" onclick="openServerDiglog()">点击选择服务器</button><br>
								<textarea  name="serverIds" id="serverIds" class="validate[required]" readonly="readonly" >${record.serverIds}</textarea>
							</c:if>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
							<button type="submit" >提交</button>
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>