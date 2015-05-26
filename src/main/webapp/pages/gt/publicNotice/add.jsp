<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav"><span>当前位置</span>：GM工具 >> 游戏公告 >> 新增维护公告</div>
		
		<div class="div_edit">
			<div class="content-box-header"></div>
			
			<form action="save.do" onsubmit="submitForm()" method="post" name="noticeForm" id="noticeForm">
				<input type="hidden" name="action" value="submit">
				<table class="tbl_edit">
					<tr>
						<td class="td_edit_name">公告内容</td>
						<td class="td_edit_value">
							<textarea name="content" id="myEditor"></textarea>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name">适用服务器</td>
						<td class="td_edit_value">
							<ul>
								<li>服务器：<input id="checkallornot" name="checkallornot"  type="checkbox"/> 全选&nbsp;
									<c:if test="${not empty gameServerMap}">
										<c:forEach items="${gameServerMap}" var="gsMap" varStatus="status">
											<input type="checkbox" name="serverId" value="${gsMap.key}" >${gsMap.value}&nbsp;
										</c:forEach>
									</c:if>
								</li>
						</td>
					</tr>
					<tr>
						<td class="td_edit_name"></td>
						<td class="td_edit_value">
							<button type="submit">提交</button>
							<button type="button" onclick="window.location='./index.do'">返回</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</body>
</html>