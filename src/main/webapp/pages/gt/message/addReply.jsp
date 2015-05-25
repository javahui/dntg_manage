<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置 : gm工具 >> 玩家反馈信息查询 >> 回复</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="saveReply.do" >
			<table class="tbl_list">
				<tr id="recordTr3" class="tr_list_data" >
					<td class="right"  style="background-color: #DBE3FF"> 用户名：</td>
					<td id="td1">
						<input type="text" name="receiverNames" value="${paramMap.userName}" readonly="readonly"/>
					</td>
				</tr>
				
				<tr id="recordTr4" class="tr_list_data">
					<td class="right" style="background-color: #DBE3FF"> 标题：</td>
					<td><input type="text" size="43" name="title" class="validate[required]" id="title"></td>
				</tr>
				
				<tr id="recordTr5" class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF"> 内容：</td>
					<td><textarea name="content" id="content" class="validate[required]"></textarea></td>
				</tr>
			
				<tr>
					<td class="td_edit_name form-submit"></td>
					<td class="td_edit_value">
						<input name="userId" value="${paramMap.userId}" type="hidden">
						<button type="submit" >提交</button> <button type="button" onclick="window.location='./index.do'">返回</button>
					</td>
				</tr>

			</table>
			</form>
		</div>
	</div>
</body>
</html>