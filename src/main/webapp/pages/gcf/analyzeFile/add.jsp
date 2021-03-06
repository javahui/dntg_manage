<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏配置文件管理 >> 配置文件 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="save.do" method="post" enctype="multipart/form-data">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">上传文件</td>
						<td class="td_edit_value">
							<input type="file" name="file" class="input_file_value validate[required]">
							<span class="error">*</span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">配置文件名</td>
						<td class="td_edit_value">
							<select name="fileMapName">
								<c:forEach items="${fileMap}" var="map" varStatus="status">
									<option value="${map.key}">${map.value}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">文件描述</td>
						<td class="td_edit_value">
							<textarea  name="fileDesc" id="fileDesc" class="validate[required,maxSize[240]]">${record.fileDesc}</textarea>
							<span class="error">*</span>
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