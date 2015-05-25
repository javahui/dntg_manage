<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
/**
 * 全服发送打开多选服务器窗口，否则为单选服务器窗口
 */
function openServer(){
	$("#serverId").val("");
	$("#receiverNames").val("");
	if ($("#globalSend").val() == "1") {
		openServerDiglog('serverId');
	} else {
		openSingeChoiceServerDiglog('serverId');
	}
}
/**
 * 打开选择用户子窗口
 */
function openGameUser(){
	var serverId =$("#serverId").val();
	if (serverId == "") {
		alert("请先选择服务器");
		return;
	}
	openGameUserDiglog("receiverNames", serverId);
}
/**
 * 显示或者隐藏选择用户TR
 */
function toggleTrReceiverNames(){
	if ($("#globalSend").val() == "1") {
		$('#trReceiverNames').hide();
		$('#receiverNames').val("");
	} else {
		$('#trReceiverNames').show();
	}
	$("#serverId").val("");
}
</script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: gm工具 >> 系统邮件 >> 申请发放 </div>
	<div class="div_edit">
		<div class="content-box-header"></div>
		<form action="save.do"  method="post" >
			<table class="tbl_list">
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">发放方式：</td>
					<td>
						<select id="globalSend" name="globalSend" onchange="toggleTrReceiverNames()">
							<option value="1">全服发送</option>
							<option value="0">指定用户发送</option>
						</select>
					</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right" style="background-color: #DBE3FF"> 选择服务器：</td>
					<td>
						<input type="text" name="serverId" id="serverId" class="input_edit_value validate[required]">
						<button type="button" onclick="openServer()">选择服务器</button>
					</td>
				</tr>
				
				<tr class="tr_list_data" id="trReceiverNames" style="display: none;">
					<td class="right"  style="background-color: #DBE3FF"> 选择用户：</td>
					<td>
						<button type="button" onclick="openGameUser()">选择用户</button><br>
						<textarea id="receiverNames" name="receiverNames" class="validate[required]"></textarea>
						<span style="color:#FF003A;"> * </span>
					</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">标题：</td>
					<td><input type="text" size="43" name="title" id="title" class="validate[required]"><span style="color:#FF003A;"> * </span></td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">内容：</td>
					<td><textarea name="content" id="content" class="validate[required]"></textarea><span style="color:#FF003A;"> * </span></td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">附加金币数量:</td>
					<td><input type="text" name="jb" class="validate[required,custom[integer],min[0],max[900000000]]" value="0">(上限9亿)</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">附加元宝数量:</td>
					<td><input type="text" name="yb" class="validate[required,custom[integer],min[0],max[900000000]]" value="0">(上限9亿)</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">延迟发送小时:</td>
					<td><input type="text" name="delayHours" class="validate[required,custom[integer],min[0]]" value="0"></td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">附加物品列表：</td>
					<td>
						<input onclick="openGoodsDiglog(0)" id="0" readonly="readonly"> <input type="hidden" name="goodsList[0].id" id="id0">
						<select name="goodsList[0].binding" >
							<option value="1" >绑定</option>
							<option value="0" >不绑定</option>
						</select>  
						数量:<input name="goodsList[0].count" id="count0"> (可选)<br/>
						
						<input onclick="openGoodsDiglog(1)" id="1" readonly="readonly"> <input type="hidden" name="goodsList[1].id" id="id1">
						<select name="goodsList[1].binding" >
							<option value="1" >绑定</option>
							<option value="0" >不绑定</option>
						</select>  
						数量:<input name="goodsList[1].count" id="count1"> (可选)<br/>
						
						<input onclick="openGoodsDiglog(2)" id="2" readonly="readonly"> <input type="hidden" name="goodsList[2].id" id="id2">
						<select name="goodsList[2].binding" >
							<option value="1" >绑定</option>
							<option value="0" >不绑定</option>
						</select>  
						数量:<input name="goodsList[2].count" id="count2"> (可选)<br/>
						
						<input onclick="openGoodsDiglog(3)" id="3" readonly="readonly"> <input type="hidden" name="goodsList[3].id" id="id3">
						<select name="goodsList[3].binding" >
							<option value="1" >绑定</option>
							<option value="0" >不绑定</option>
						</select>  
						数量:<input name="goodsList[3].count" id="count3"> (可选)<br/>
						
						<input onclick="openGoodsDiglog(4)" id="4" readonly="readonly"> <input type="hidden" name="goodsList[4].id" id="id4">
						<select name="goodsList[4].binding" >
							<option value="1" >绑定</option>
							<option value="0" >不绑定</option>
						</select>  
						数量:<input name="goodsList[4].count" id="count4"> (可选)<br/>
					</td>
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