<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$.validationEngineLanguage.allRules.checkUserIds={
		"url": "${ctx}/recharge/checkUserIds.do",
		"alertTextOk": "√",
		"alertText": "有不存在的角色名",
		"alertTextLoad": "loading..."
	};
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：GM工具 >> 装备发放 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do">
			<table class="tbl_list">
				<tr id="recordTr3" class="tr_list_data" >
					<td class="right"  style="background-color: #DBE3FF"> 用户名：</td>
					<td id="td1">
						<input type="text" name="userName" class="validate[required,ajax[checkUserIds]]"/>
					</td>
				</tr>
				<tr id="recordTr3" class="tr_list_data" >
					<td class="right"  style="background-color: #DBE3FF"> 物品：</td>
					<td id="td1">
						<textarea name="equipName" id="content" class="validate[required]"></textarea>
					</td>
				</tr>
				
				<tr id="recordTr4" class="tr_list_data">
					<td class="right" style="background-color: #DBE3FF"> 标题：</td>
					<td><input type="text" name="title" class="validate[required]" /></td>
				</tr>
				
				<tr id="recordTr5" class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF"> 内容：</td>
					<td><textarea name="content" id="content" class="validate[required]"></textarea></td>
				</tr>
			
				<tr>
					<td class="td_edit_name form-submit"></td>
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