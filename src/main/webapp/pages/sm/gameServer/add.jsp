<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：服务器管理 >> 新增服务器</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<form action="save.do" method="post" id="serverForm">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">服务器ID：</td>
						<td class="td_edit_value">
							<input type="text" name="serverId" class="input_edit_value validate[required]" id="serverId" maxlength="30" value="${paramMap.serverId}">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">服务器名：</td>
						<td class="td_edit_value">
							<input type="text" name="serverName" size="50" maxlength="50" class="validate[required]" value="${paramMap.serverName}">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">服务器描述：</td>
						<td class="td_edit_value">
							<textarea rows="6" cols="50" name="serverDesc" class="validate[required]">${paramMap.serverDesc}</textarea>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">是否测试服：</td>
						<td class="td_edit_value">
							<select name="isTest">
								<option value="0"<c:if test="${paramMap.isTest == '0'}"> selected=selected</c:if> >否</option>
								<option value="1"<c:if test="${paramMap.isTest == '1'}"> selected=selected</c:if> >是</option>
							</select>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">所属分类：</td>
						<td class="td_edit_value">
							<select name="sortId"><c:forEach items="${sortMap}" var="sortEntry"><option value="${sortEntry.id}" >${sortEntry.sortName}</option></c:forEach> </select>
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">排序值：</td>
						<td class="td_edit_value">
							<input type="text" name="orderNum" maxlength="3" class="validate[required,custom[integer]]" value="${paramMap.orderNum}">
							<span class="error"> * </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏数据库url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required]" type="text" name="gameDbUrl" maxlength="200" value="${paramMap.gameDbUrl}">
							<span class="error"> *(格式:192.168.1.1:3306/dbName;username;passwd) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">日志数据库url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required]" type="text" name="logDbUrl" maxlength="200" value="${paramMap.logDbUrl}">
							<span class="error"> *(格式:192.168.1.1:3306/dbName;username;passwd) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏入口url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required,custom[url]]" type="text" name="gateUrl" maxlength="200" value="${paramMap.gateUrl}">
							<span class="error"> *(例:http://192.168.1.111:8080/gateServlet) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">游戏远程接口url：</td>
						<td class="td_edit_value">
							<input class="input_url_value validate[required,custom[url]]" type="text" name="gameServerRemoteUrl" maxlength="200" value="${paramMap.gameServerRemoteUrl}">
							<span class="error"> *(例:http://192.168.1.111:9999) </span>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
						<button type="submit">提交</button>&nbsp;&nbsp;
						<button type="button" onclick="window.location='./index.do	'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>