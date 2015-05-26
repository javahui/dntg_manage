<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
	<div id="div_position_nav">当前位置: gm工具 >> 系统邮件 >> 批量补偿 </div>
	<div class="div_edit">
		<div class="content-box-header"></div>
		<form action="saveBatch.do" method="post" enctype="multipart/form-data">
			<table class="tbl_list">
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
					<td class="td_edit_name">上传文件</td>
					<td class="td_edit_value">
						<input type="file" name="file" class="input_file_value validate[required]">
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