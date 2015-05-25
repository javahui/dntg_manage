<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置：服务器管理 >> 查看服务器信息</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			<table class="tbl_edit">
				<tr>
					<td class="td_edit_name" width="200">服务器ID</td>
					<td class="td_edit_value">${record.serverId}</td>
				</tr>
				<tr>
					<td class="td_edit_name">服务器名</td>
					<td class="td_edit_value">${record.serverName}</td>
				</tr>
				<tr>
					<td class="td_edit_name">服务器描述</td>
					<td class="td_edit_value">${record.serverDesc}</td>
				</tr>
				<tr>
					<td class="td_edit_name">是否测试服</td>
					<td class="td_edit_value"><c:if test="${record.isTest==0}">否</c:if><c:if test="${record.isTest==1}">是</c:if></td>
				</tr>
				<tr>
					<td class="td_edit_name">服务器分类</td>
					<td class="td_edit_value">${record.sortName}</td>
				</tr>
				<tr>
					<td class="td_edit_name">排序值</td>
					<td class="td_edit_value">${record.orderNum}</td>
				</tr>
				<tr>
					<td class="td_edit_name">游戏数据库url</td>
					<td class="td_edit_value">${record.gameDbUrl}</td>
				</tr>
				<tr>
					<td class="td_edit_name">日志数据库url</td>
					<td class="td_edit_value">${record.logDbUrl}</td>
				</tr>
				<tr>
					<td class="td_edit_name">游戏入口url</td>
					<td class="td_edit_value">${record.gateUrl}</td>
				</tr>
				<tr>
					<td class="td_edit_name">游戏服务器远程接口url</td>
					<td class="td_edit_value">${record.gameServerRemoteUrl}</td>
				</tr>
				<tr>
					<td class="td_edit_name">服务器状态</td>
					<td class="td_edit_value"><c:if test="${record.serverStatus == 1}">开启</c:if><c:if test="${record.serverStatus == 0}">关闭</c:if></td>
				</tr>
				<tr>
					<td class="td_edit_name"></td>
					<td><button type="button" onclick="window.location='./index.do'">返回</button></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>