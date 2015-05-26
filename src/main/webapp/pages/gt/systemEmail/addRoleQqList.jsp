<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
/**
 * 选择物品列表,把最大堆叠数给数量输入框
 */
function changeAttchments(obj){
	var v = $(obj).find("option:selected").text().split(":")[1];
	$(obj).next().next().val(v);
}
function checkattachmentCount(obj){
	var seltext = $(obj).prev().prev().find("option:selected").text();
	if( $(obj).prev().prev().val() != ""){
		if (parseInt(obj.value) > parseInt(seltext.split(":")[1])){
			obj.value = seltext.split(":")[1];
		}
	}
	else{
		obj.value =  "";
	}
}
</script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置: gm工具 >>  超级会员 >> 发送邮件 </div>
	<div class="div_edit">
		<div class="content-box-header"></div>
		<form action="save.do"  method="post">
			<input type="hidden" name="globalSend" value="0">
			<input type="hidden" name="serverId" value="${sessionScope.curServerId}">
			<table class="tbl_list">
				<tr class="tr_list_data">
					<td class="right" style="background-color: #DBE3FF"> 用户：</td>
					<td>
						<input name="receiverNames" class="input_edit_value" readonly="readonly" value="${param.receiverNames}">
					</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">标题：</td>
					<td><input type="text" size="43" name="title" id="title" class="validate[required]" value="超级会员特别奖励"><span style="color:#FF003A;"> * </span></td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right" style="background-color: #DBE3FF">内容：</td>
					<td><textarea name="content" class="validate[required]">亲爱的玩家,这是我们为您额外发送的超级会员特别奖励</textarea><span style="color:#FF003A;"> * </span></td>
				</tr>
				
					<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">附加金币数量:</td>
					<td><input type="text" size="43" name="jb" class="validate[required,custom[integer],min[0],max[900000000]]" value="0">(上限9亿)</td>
				</tr>
				
				<tr class="tr_list_data">
					<td class="right"  style="background-color: #DBE3FF">附加元宝数量:</td>
					<td><input type="text" size="43" name="yb" class="validate[required,custom[integer],min[0],max[900000000]]" value="0">(上限9亿)</td>
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
						<button type="button" onclick="window.location='${ctx}/roleQqList/index.do'">返回</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>