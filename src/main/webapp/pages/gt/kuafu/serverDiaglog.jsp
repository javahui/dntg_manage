<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
var targetId = "serverIds";
var topDocument = (top.frame_content == undefined) ? top.document : top.frame_content['mainFrame'].document;
$(document).ready(function(){
	$(".game-server-sort-name").click(function(){
		var id =$(this).parent().next("ul").attr("id");
		if(this.checked){
			$("#"+id+" :checkbox").each(function(){ $(this).attr("checked",true); });
		}else{
			$("#"+id+" :checkbox").each(function(){ $(this).attr("checked",false); });
		}
	});
	
	var ids = $("#" + targetId, topDocument).val();
	if(ids == null || ids == ""){
		return;
	}
	var idsArray = ids.split(",");
	for (var i = 0 ; i < idsArray.length ; i++ ){
		var id = jQuery.trim(idsArray[i]);
		$("#"+id).attr("checked",true);
    }
});

function sure(){
	var sids = "";
	$(".game-server-list-ul :checkbox").each(function(){
		$(this).val();
		if(this.checked){
			sids+=( ","+$(this).val() );
		}
	});
	$("#" + targetId, topDocument).val(sids.substring(1));
	frameElement.api.close();
}
function selectedServer(){	
	var sortName = $("#sortName").val();
	var start = parseInt($("#serverStart").val());
	var end = parseInt($("#serverEnd").val());
	for ( var i = start; i <= end; i++) {
		$("#"+sortName+" :checkbox").each(function(){
			var n = $(this).attr("name");
			if (n == (i+"")) {
				$(this).attr("checked",true);
			}
		});
	}
}
</script>
</head>
<body>
	<div style="width:100%; height:900px;overflow:auto">
		<div class="div_search">
			<ul>
				<li>
					<select id="sortName">
						<c:forEach items="${gameServerMap}" var="map" varStatus="status">
							<option value="game-server-list-ul${status.index}">${map.key}</option>
						</c:forEach>
					</select>
					<input size="1" id="serverStart">到<input size="1" id="serverEnd">服务器
				</li>
				<li><button type="submit" onclick="selectedServer()">选择</button></li>
			</ul>
			<input type="hidden" name="targetId" value="${paramMap.targetId}">
		</div>
			
		<div class="server-sort-botton">
			<button type="button" onclick="sure()">确定</button>&nbsp;&nbsp;<button type="button" onclick="frameElement.api.close()">取消</button>
		</div>
		
		<div class="server-sort-tb left"> <input type="checkbox" name="ids" id="checkallornot">全部选择 </div>

		<c:forEach items="${gameServerMap}" var="map" varStatus="status">
			<div class="server-sort-tb">
				<div class="game-server-sort-name-div">
					<input type="checkbox" name="ids" class="game-server-sort-name">${map.key}
				</div>
				<ul id="game-server-list-ul${status.index}" class="game-server-list-ul">
					<c:forEach items="${map.value}" var="item" varStatus="status">
						<li name="${item.serverName}">
							<input type="checkbox" name="${item.serverName}" value="${item.serverId}" id="${item.serverId}" >${item.serverName}
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
		
		<div class="server-sort-botton">
			<button type="button" onclick="sure()">确定</button>&nbsp;&nbsp;<button type="button" onclick="frameElement.api.close()">取消</button>
		</div>
	</div>
</body>
</html>