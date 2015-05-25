<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：GM工具 >> 超级会员面板配置 >> 新增</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do" method="post">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">QQ:</td>
						<td class="td_edit_value">
							<input type="text" name="qq" class="input_edit_value validate[required,custom[integer],maxSize[20]]" maxlength="20"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">图片:</td>
						<td class="td_edit_value">
							<input type="text" name="pic" class="input_edit_value validate[required]"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">最小充值需求:</td>
						<td class="td_edit_value">
							<input type="text" name="minRecharge" class="input_edit_value validate[required,custom[integer],maxSize[20]]" maxlength="20"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">适用服务器</td>
						<td class="td_edit_value">
							<button type="button" onclick="openServerDiglog()">点击选择服务器</button>
							<input  type="text" name="serverIds" id="serverIds" class="validate[required]" readonly="readonly" >${record.serverIds}</input>
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