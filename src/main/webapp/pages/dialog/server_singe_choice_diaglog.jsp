<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
var targetId = "${param.targetId}";
var topDocument = (top.frame_content == undefined) ? top.document : top.frame_content['mainFrame'].document;
function setServerId(serverId){
	$("#" + targetId, topDocument).val(serverId);
	frameElement.api.close();
}
</script>
</head>
<body>

	<div style="width:100%; height:900px;overflow:auto">
		<div class="server-sort-botton">
			<button type="button" onclick="frameElement.api.close()">取消</button>
		</div>
		
		<c:forEach items="${gameServerMap}" var="map" varStatus="status">
			<div class="server-sort-tb">
				<div class="game-server-sort-name-div left">
					${map.key}
				</div>
				<ul id="game-server-list-ul${status.index}" class="game-server-list-ul">
					<c:forEach items="${map.value}" var="item" varStatus="status">
						<li><a href="#" onclick="setServerId('${item.serverId}')">${item.serverName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
		
		<div class="server-sort-botton">
			<button type="button" onclick="frameElement.api.close()">取消</button>
		</div>
	</div>
</body>
</html>