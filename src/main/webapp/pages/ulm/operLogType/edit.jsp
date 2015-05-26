<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户日志管理 >> 日志类型管理 >> 修改</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">类名</td>
						<td class="td_edit_value">
							<input name="className" class="input_edit_value validate[required]" value="${record.className}" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">方法名</td>
						<td class="td_edit_value">
							<input name="methodName" class="input_edit_value validate[required]" value="${record.methodName}" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">类型</td>
						<td class="td_edit_value" style="border-top:0px">
							<input name="type" class="input_edit_value" value=${record.type } />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">描述</td>
						<td class="td_edit_value" style="border-top:0px">
							<textarea rows="10" cols="5" name="description">${record.description}</textarea><br />
							描述中占位符的格式为:{参数index:对象属性名} 如第一个参数的loginName属性为:{0:loginName}
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>