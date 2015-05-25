<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
var targetId = "${paramMap.targetId}";
var serverId = "${paramMap.serverId}";
var topDocument = (top.frame_content == undefined) ? top.document : top.frame_content['mainFrame'].document;
function set(){
	var array = "";
	$(":input[name='recordIds']").each(function(){
		if (this.checked){
			array += ("," + $(this).val());
		}
	});
	if (array == "") {
		alert("未选择任何记录");
		return;
	}
 	$("#" + targetId, topDocument).val(array.substring(1));
	frameElement.api.close();
}
</script>
</head>
<body>
	<div id="div_right_frame">
		
		<div class="div_search">
			
			<form action="${ctx}/gameUserInfo/indexDiaglog.do">
				<ul>
					<li>玩家账号：<input type="text" name="userId" class="input_search" value="${paramMap.userId}"></li>
					<li>角色名：<input type="text" name="name" class="input_search" value="${paramMap.name}"></li>
					<li>等级：<input type="text" name="startLevel" value="${paramMap.startLevel}"> - <input type="text" name="endLevel" value="${paramMap.endLevel}"></li>
					<li>vip等级：<input type="text" name="startVipLevel" value="${paramMap.startVipLevel}"> - <input type="text" name="endVipLevel" value="${paramMap.endVipLevel}"></li>
					<li><button type="submit">查询</button></li>
				</ul>
				<input type="hidden" name="serverId" value="${paramMap.serverId}">
				<input type="hidden" name="targetId" value="${paramMap.targetId}">
			</form>
			<button type="submit" onclick="set()">确定</button>
		</div>
	
		<div class="div_operate">
			<ul>
			</ul>
		</div>
	
		<div class="div_list">
		<form id="tableForm" action="">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="3%"><input id="checkallornot" name="checkallornot"  type="checkbox"/></td>
				<td>玩家账号</td>
				<td>角色名</td>
				<td>等级</td>
				<td>VIP等级</td>
			</tr>
			<c:forEach items="${list}" var="item" varStatus="status">
			<tr class="tr_list_data">
				<td class="center"><input type="checkbox" name="recordIds" value="${item.name}" ></td>
				<td class="center"> ${item.userId}</td>
				<td class="center"> ${item.name}</td>
				<td class="center"> ${item.level}</td>
				<td class="center"> ${item.vipLevel}</td>
			</tr>
			</c:forEach>
		</table>
		</form>
		</div>
		
	</div>
</body>
</html>