<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置:用户帐户管理 >> 用户管理 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do" method="post">
				<input type="hidden" name="dirId" value="${param.id}" >
				<input type="hidden" name="isDir" value="0" >
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">菜单名:</td>
						<td class="td_edit_value">
							<input type="text" name="actionName" class="input_edit_value validate[required]" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">菜单路径:</td>
						<td class="td_edit_value">
							<input type="text" name="action" class="input_edit_value" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">描述:</td>
						<td class="td_edit_value" style="border-top:0px">
							<input name="actionDesc" class="input_edit_value validate[required]" maxlength="20"/>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">值:</td>
						<td class="td_edit_value" style="border-top:0px">
							<input name="typeValue" class="input_edit_value validate[required,custom[integer]]" maxlength="20"/>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">排序值:</td>
						<td class="td_edit_value" style="border-top:0px">
							<input name="orderValue" class="input_edit_value validate[required,custom[integer]]" maxlength="20"/>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" style="border-top:0px">是否只有管理员权限才能分配这个节点:</td>
						<td class="td_edit_value" style="border-top:0px">
							<input name="actionLevel" type="radio" value="1" checked="checked">否
							<input name="actionLevel" type="radio" value="0" >是
						</td>
					</tr>
					<tr>
						<td class="td_edit_name form-submit"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>
							<button type="button" onclick="window.location='./indexNode.do?id=${param.id}'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</div>
</body>
</html>