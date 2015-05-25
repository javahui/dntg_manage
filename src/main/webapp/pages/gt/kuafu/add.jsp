<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
/**
 * 打开选择多选服务器子窗口
 */
function openServerDiglog(){
	var path = (top.frame_content == undefined) ? '.' : '';
	$.dialog({
		lock : true,
		width: '1300px',
	    content: 'url:.' + path + '/kuafu/serverDiaglog.do?targetId=serverIds'
	});
}
</script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: 超级管理 >> 游戏服务器管理 >> 跨服赛区分布 >> 新增</div>
	<div class="div_edit">
		
		<div class="content-box-header"></div>
		<form action="save.do" method="post">
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name">跨服服务器ID</td>
					<td class="td_edit_value">
						<input type="text" name="serverid" class="input_edit_value validate[required]">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">赛区名</td>
					<td class="td_edit_value">
						<input type="text" name="name" class="input_edit_value validate[required]">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">ip</td>
					<td class="td_edit_value">
						<input type="text" name="ip" class="input_edit_value validate[required,custom[ipv4]]">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">端口</td>
					<td class="td_edit_value">
						<input type="text" name="port" class="input_edit_value validate[required,custom[integer]]">
						<span class="error">*</span>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name">加入跨服的服务器</td>
					<td class="td_edit_value">
						<input name="serverIds" id="serverIds" class="input_edit_value validate[required]" readonly="readonly">
						<button type="button" onclick="openServerDiglog()">选择服务器</button>
						<span class="error">*</span>
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