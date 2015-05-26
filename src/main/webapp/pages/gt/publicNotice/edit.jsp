<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置：</span>GM工具 >> 游戏公告 >> 维护公告修改</div>
		
		<form action="update.do" method="post" name="analyzeFileForm" id="analyzeFileForm">
		<input type="hidden" name="action" value="submit">
		<input type="hidden" name="id" value="${record.id}">
		<input type="hidden" name="serverId" value="${record.serverId}">
		<div class="div_edit">
			<div class="content-box-header"></div>
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name">公告内容</td>
					<td class="td_edit_value">
					<textarea name="content" id="myEditor" >${record.content}</textarea>
					</td>
				</tr>
				<tr>
					<td class="td_edit_name"></td>
					<td>
							<button type="submit">提交</button>&nbsp;&nbsp;
							<button type="button" onclick="window.location='./index.do'">返回</button>
					</td>
			</table>
		</div>	
		<div id="show_apply_div"></div>
	</div>
</body>
</html>