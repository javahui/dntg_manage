<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$.validationEngineLanguage.allRules.checkUserName={
	"url": "checkUserName.do",
	"extraDataDynamic": ['#serverId'],
	"alertTextOk": "√",
	"alertText": "不存在的角色名",
	"alertTextLoad": "loading..."
};
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：GM工具 >> GM与指导员账号设置 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="save.do" method="post" name="chargeForm" id="chargeForm">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">选择服务器：</td>
						<td class="td_edit_value">
							<input type="text" name="serverId" id="serverId" class="input_edit_value validate[required]" readonly="readonly">
							<button type="button" onclick="$('#userId').val('');openSingeChoiceServerDiglog()">选择服务器</button>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">角色名：</td>
						<td class="td_edit_value">
							<input name="userId" class="validate[required,ajax[checkUserName]] input_edit_value" id="userId" maxlength="200">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">账号类型：</td>
						<td class="td_edit_value">
							<select name="roleType" >
								<option value=1 <c:if test="${paramMap.roleType == 1}">selected='selected'</c:if> >指导员</option>
								<option value=2 <c:if test="${paramMap.roleType == 2}">selected='selected'</c:if> >GM</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name form-submit"></td>
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