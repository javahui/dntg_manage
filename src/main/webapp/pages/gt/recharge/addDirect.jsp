<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$.validationEngineLanguage.allRules.checkUserIds={
	"url": "checkUserIds.do",
	"alertTextOk": "√",
	"alertText": "有不存在的角色名",
	"alertTextLoad": "loading..."
};
function selectServer(){
	$('#playerName').val("");
	openSingeChoiceServerDiglog();
}
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: GM工具 >> 直接充值 >> 充值申请</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="saveDirect.do" method="post">
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name" width="200">选择充值类型：</td>
					<td class="td_edit_value">
						<select id="rechargeType"  name="rechargeType">
							<c:forEach items="${rechargeTypeMap}" var="map">
								<option value="${map.key}"> ${map.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">角色名(多个使用换行分隔)：</td>
					<td class="td_edit_value">
						<textarea type="text" name="playerName" id="playerName" maxlength="200" class="validate[required,ajax[checkUserIds]]"></textarea>
						<span class="error"> * </span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">货币类型：</td>
					<td class="td_edit_value">
						<select name="moneyType" id="moneyType">
							<c:forEach items="${moneyTypeMap}" var="map">
								<option value="${map.key}">${map.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">充值数量：</td>
					<td class="td_edit_value">
						<input type="text" name="moneyNum" class="input_edit_value validate[required,custom[integer],min[1],max[100000]]" id="moneyNum" maxlength="9">
						<span style="color:#FF003A;"> *</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">备注：</td>
					<td class="td_edit_value">
						<textarea type="text" name="content"  id="content" class="validate[required]"></textarea>
						<span style="color:#FF003A;"> *</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name form-submit"></td>
					<td class="td_edit_value">
						<button type="submit">提交</button> <button type="button" onclick="window.location='./indexDirect.do'" >返回</button>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>