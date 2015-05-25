<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/jquery_plugin/jquery.validate.min.js"> </script>
<script type="text/javascript">
$().ready(function(){
	//弹出遮罩层
	$("#selectServers").click(function(){
		$.blockUI({message:$("#server-sort-class")});
	});
	$("#sure_choose").click( function(){
		var sids = "";
		$(".game-server-list-ul :checkbox").each(function(){
			$(this).val();
			if(this.checked){
				sids+=( ","+$(this).val() );
			}
		});
		$("#serverIds").val(sids.substring(1));
		$.unblockUI();
	} );
	$("#quxiao").click( $.unblockUI );
	

	//响应点击事件
	$(".game-server-sort-name").click(function(){
		var id =$(this).parent().next("ul").attr("id");
		if(this.checked){
			$("#"+id+" :checkbox").each(function(){ $(this).attr("checked",true); });
		}else{
			$("#"+id+" :checkbox").each(function(){ $(this).attr("checked",false); });
		}
	});
	$(".role-server-checkbox").click(function(){
		if(this.checked){
		}else{
			$("#checkallornot").attr("checked",false);
		}
	});
	
		
		$("#gameConfigFileUploadForm").validate({
				rules: {
					pic: 	{required: true},
					qq:  {required: true},
					minRecharge:  {required: true, digits: true, min: 1, max: 999999999}
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
		<div id="div_position_nav"><span>当前位置</span>：游戏配置文件管理 >> 配置文件修改</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post" id="gameConfigFileUploadForm" enctype="multipart/form-data">
				<input type="hidden" name="action" value="submit">
				<input type="hidden" name="id" value="${record.id }">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">QQ:</td>
						<td class="td_edit_value">
							<input type="text" name="qq" class="input_edit_value validate[required,custom[integer],maxSize[10]]" maxlength="20" value="${record.qq }"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">图片:</td>
						<td class="td_edit_value">
							<input type="text" name="pic" class="input_edit_value validate[required,ajax[ajaxPic]]" value="${record.pic }"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">最小充值需求:</td>
						<td class="td_edit_value">
							<input type="text" name="minRecharge" class="input_edit_value validate[required,custom[integer],maxSize[10]]" maxlength="20" value="${record.minRecharge}"/>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
						<button type="submit" >提交</button>&nbsp;&nbsp;
						<button type="button" id="return" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
						</td>
					</tr>
				</table>
				<div class="server-sort-class" id="server-sort-class" style="display: none;">			
					<div class="server-sort-tb left"><input type="checkbox" name="ids" id="checkallornot">全部选择</div>
					<c:forEach items="${serverSorts }" var="serverSort" varStatus="status">
					<div class="server-sort-tb">	
						<div class="game-server-sort-name-div left"><input type="checkbox" name="ids" class="game-server-sort-name"/>${serverSort.sortName}</div>
						<ul id="game-server-list-ul${status.index}" class="game-server-list-ul"><c:forEach items="${serverSort.gameServers}" var="gameServer" varStatus="status"><li><input class="role-server-checkbox checkbox" type="checkbox" name="ids" value="${gameServer.serverId}" <c:if test="${gameServer.inRole}">checked="checked"</c:if>/>${gameServer.serverName }</li></c:forEach></ul>
					</div>
					</c:forEach>
					<div class="server-sort-botton"><button type="submit" id="sure_choose">确定</button>&nbsp;&nbsp;<button type="button" id="quxiao">取消</button></div>	
				</div>
			</form>
		</div>
	</div>
</body>
</html>