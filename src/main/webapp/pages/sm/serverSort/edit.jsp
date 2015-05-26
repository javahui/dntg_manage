<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/jquery_plugin/jquery.validate.min.js"> </script>
<script type="text/javascript">
$().ready(function() {
	$("#sort-return").click(function(){window.location='${SERVER_SORT_record}';});
	$("#recordForm").validate({
			rules: {
				sortName: {
					required: true,
					minlength: 2
				}
			},
			messages:{
				sortName: {
					required: "&nbsp;请输入角色名",
					minlength: "&nbsp;用户名长度不小于 2"
				}
			},
			errorPlacement:function(error, element){
				error.appendTo(element.next("span").next("span"));
			}
		}
	);
});
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置</span>：游戏服务器管理 >> 游戏服务器分类管理 >> 修改信息</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post" id="recordForm">
				<input type="hidden" name="id" value="${record.id}">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<c:if test="${not empty errorCode }">
					<tr><td colspan="2" align="center"><div style="color:red;">${errorCode }</div></td></tr>
					</c:if>
					<tr>
						<td class="td_edit_name" width="200">分类名</td>
						<td class="td_edit_value">
							<input type="text" name="sortName" class="input_edit_value validate[required,maxSize[20]]" maxlength="20" value="${record.sortName}"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name" width="200">排序值</td>
						<td class="td_edit_value">
							<input type="text" name="orderNum" class="input_edit_value validate[required,custom[integer],maxSize[20]]" maxlength="20" value="${record.orderNum}"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
						<button type="submit">提交</button>&nbsp;&nbsp;
						<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>