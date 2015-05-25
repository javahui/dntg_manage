<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 宝石等级分布</div>
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="33%"> 宝石等级区间 </td>
			<td width="33%"> 人数 </td>
			<td width="33%"> 升阶到该阶级人数百分比 </td>
		</tr>
		<tr class="tr_list_data"><td colspan="3">服务器升级宝石总人数:${allCount}</td></tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${list}" var="baoshiMap" varStatus="status">
					<tr id="recordTr${status.index}" class="tr_list_data">		
						<td class="center"><c:choose><c:when test="${baoshiMap['alevel'] == 30}">300</c:when><c:otherwise>${baoshiMap["alevel"]*10} - ${(baoshiMap["alevel"]+1)*10}</c:otherwise> </c:choose></td> 
						<td class="center"> ${baoshiMap["totalCount"]} </td>
						<td class="center"> <fmt:formatNumber pattern="##.##" value="${baoshiMap.rate}"></fmt:formatNumber>  </td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="2"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
</div>
</body>
</html>