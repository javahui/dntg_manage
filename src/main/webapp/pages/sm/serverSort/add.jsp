<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$().ready(function() {
	$("#sort-return").click(function(){window.location='${SERVER_SORT_LIST}';});
	$("#roleForm").validate({
			rules: {
				sortName: {
					required: true,
					minlength: 2
				}
			},
			messages:{
				sortName: {
					required: "&nbsp;请输入分类名",
					minlength: "&nbsp;用户名长度不小于 2"
				}
			},
			errorPlacement:function(error, element){
				error.appendTo(element.next("span").next("span"));
			}
		}
	);
})
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置</span>：游戏服务器管理 >> 游戏服务器分类管理 >> 添加分类</div>
		
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do" method="post" id="paramMapForm">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">分类名</td>
						<td class="td_edit_value">
							<input type="text" name="sortName" class="input_edit_value" id="sortName" maxlength="20" value="${paramMap.sortName}">
							<span style="color:red;">*</span>
							<span class="error" id="span_adName"></span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">排序值</td>
						<td class="td_edit_value">
							<input type="text" name="orderNum" class="input_edit_value" id="orderNum" maxlength="3" value="${paramMap.orderNum}">
							<span style="color:red;">*</span>
							<span class="error" id="span_adName"></span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
						<button type="submit" >提交</button>&nbsp;&nbsp;
						<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>