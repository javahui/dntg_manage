<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
$().ready(function(){
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
});
</script>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 用户帐户管理 >> 角色管理 >> 服务器权限管理</div>
		
		<div class="div_edit role-server">
			<div class="content-box-header role-server-header">角色[<span id="role-server-red">${param.roleName }</span>]拥有的服务器权限</div>
			
			<form action="updateServer.do" method="post">
				<input type="hidden" name="id" value="${param.id}">
				<div>
					<div class="server-sort-tb">
						<input type="checkbox" name="checkallornot" id="checkallornot" />全部选择
					</div>
					<c:forEach items="${gameServerMap}" var="map" varStatus="status">
						<div class="server-sort-tb">
							<div class="game-server-sort-name-div left">
								<input type="checkbox" name="ids" class="game-server-sort-name" <c:if test="${param.isDisable == true}">disabled="disabled"</c:if> >${map.key}
							</div>
							<ul id="game-server-list-ul${status.index}" class="game-server-list-ul">
								<c:forEach items="${map.value}" var="item" varStatus="status">
									<li>
										<input type="checkbox" name="recordIds" value="${item.id}" <c:if test="${item.gameServerId != null}"> checked="checked" </c:if> >${item.serverName}
									</li>
								</c:forEach>
							</ul>
						</div>
					</c:forEach>
					<div class="server-sort-botton">
						<button type="submit">提交</button> <button type="button" onclick="window.location='./index.do'">返回</button>
					</div>	
				</div>
			</form>
		</div>
	</div>
</body>
</html>