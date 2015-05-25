<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$.validationEngineLanguage.allRules.ajaxUserRolerNames={
	"url": "checkUserRoleNames.do",
	"alertTextOk": "√",
	"alertText": "有不存在的角色名",
	"alertTextLoad": "loading..."
};
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: GM工具 >> 超级会员 >> 添加内部人员名单</div>
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="saveInner.do" method="post">
				<table class="tbl_edit">
				<tr>
					<td class="td_edit_name">角色名（多个使用换行分隔）：</td>
					<td class="td_edit_value">
						<textarea type="text" name="playerNames" maxlength="200" class="validate[required,ajax[ajaxUserRolerNames]]"></textarea>
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