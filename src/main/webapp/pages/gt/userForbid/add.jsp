<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<script type="text/javascript">
function openServer(){
	$("#serverId").val("");
	$("#receiverNames").val("");
	openSingeChoiceServerDiglog('serverId');
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
	openGameUserDiglog("receiverNames", $("#serverId").val());
}

</script>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置</span>：GM工具 >> 账号封停 >> 封号/禁言</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="save.do" method="post" name="chargeForm" id="chargeForm">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name" width="200">选择服务器：</td>
						<td class="td_edit_value">
							<input type="text" name="serverId" id="serverId" class="input_edit_value validate[required]" readonly="readonly">
							<button type="button" onclick="openServer()">选择服务器</button>
						</td>
					</tr>
					<tr>
						<td class="right"  style="background-color: #DBE3FF"> 选择用户：</td>
						<td>
							<button type="button" onclick="openGameUser()">选择用户</button><br>
							<textarea id="receiverNames" name="receiverNames" readonly="readonly" class="validate[required]"></textarea>
							<span style="color:#FF003A;"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">操作类型：</td>
						<td class="td_edit_value">
							<select name="forbidType" id="forbidType" >
									<option value="fengHao" <c:if test="${paramMap.status == 'fengHao'}"> selected=selected</c:if> >封号</option>
									<option value="jinYan"  <c:if test="${paramMap.status == 'jinYan'}"> selected=selected</c:if> >禁言</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">备注：</td>
						<td class="td_edit_value">
							<textarea name="addMsg" id="addMsg" ></textarea>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name form-submit"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>&nbsp;&nbsp;
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="server-sort-class" id="server-sort-class" style="display: none;">			
		<div class="server-sort-tb left">全部服务器</div>
		<c:forEach items="${serverSorts }" var="serverSort" varStatus="status">
		<div class="server-sort-tb">	
			<div class="game-server-sort-name-div left">${serverSort.sortName}</div>
			<ul id="game-server-list-ul${status.index}" class="game-server-list-ul">
				<c:forEach items="${serverSort.gameServers}" var="gameServer" varStatus="status"><li><a href="#" onclick="setServerId('${gameServer.serverId}','${gameServer.serverName}')" title="点击查看服务器的运行状态">${gameServer.serverName }</a></li></c:forEach>
			</ul>
		</div>
		</c:forEach>
		<div class="server-sort-botton"><button type="button" id="quxiao">关闭</button></div>	
	</div>
</body>
</html>