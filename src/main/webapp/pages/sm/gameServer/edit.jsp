<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：服务器管理 >> 服务器管理 >> 修改服务器信息</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="update.do" method="post" id="updateServerForm">
				<input type="hidden" name="action" value="submit">
				<input type="hidden" name="id" value="${record.id}">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">服务器ID</td>
						<td class="td_edit_value">
							<input type="text" name="serverId" id="serverId" class="input_edit_value validate[required]" value="${record.serverId}" maxlength="30" readonly="readonly"/>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">服务器名：</td>
						<td class="td_edit_value">
							<input type="text" size = "50" maxlength="50" name="serverName" class="validate[required]" value="${record.serverName}">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">服务器描述：</td>
						<td class="td_edit_value">
							<textarea name="serverDesc" class="validate[required]">${record.serverDesc}</textarea>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">是否测试服：</td>
						<td class="td_edit_value">
							<select name="isTest">
								<option value="0"<c:if test="${record.isTest == '0'}"> selected=selected</c:if> >否</option>
								<option value="1"<c:if test="${record.isTest == '1'}"> selected=selected</c:if> >是</option>
							</select>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">排序值：</td>
						<td class="td_edit_value">
							<input type="text" name="orderNum" class="validate[required,custom[integer]]" maxlength="3" value="${record.orderNum}">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏数据库url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required]" type="text" maxlength="200" name="gameDbUrl" value="${record.gameDbUrl}">
							<span class="error"> *(格式:192.168.1.1:3306/dbName;username;passwd) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">日志数据库url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required]" type="text" maxlength="200" name="logDbUrl" value="${record.logDbUrl}">
							<span class="error"> *(格式:192.168.1.1:3306/dbName;username;passwd) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏入口url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required,custom[url]]" type="text" maxlength="200" name="gateUrl" value="${record.gateUrl}">
							<span class="error"> *(例:http://192.168.1.111:8080/gateServlet) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏服务器远程接口url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required,custom[url]]" type="text" maxlength="200" name="gameServerRemoteUrl" value="${record.gameServerRemoteUrl}">
							<span class="error"> *(例:http://192.168.1.111:9999) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">所属分类：</td>
						<td class="td_edit_value">
							<select name="sortId">
								<c:forEach items="${serverSort}" var="serverSort"> 
									<option value="${serverSort.id }" <c:if test="${record.sortId eq serverSort.id }">selected=selected</c:if>>${serverSort.sortName}</option> 
								</c:forEach>
							</select>
							<span class="error"> * </span>
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