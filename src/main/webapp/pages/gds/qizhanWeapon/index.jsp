<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 骑战兵器分布</div>

	<div class="div_list">

	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="33%"> 阶层 </td>
			<td width="33%"> 人数 </td>
			<td width="33%"> 升阶到该阶级人数百分比 </td>
		</tr>
		<tr class="tr_list_data"><td colspan="3">服务器领取总人数:${allCount}</td></tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${list}" var="qizhanbinqiMap" varStatus="status">
					<tr id="recordTr${status.index}" class="tr_list_data">		
						<td class="center"> ${qizhanbinqiMap.bingqiLevel}</td> 
						<td class="center"> ${qizhanbinqiMap.scount} </td>
						<td class="center"> <fmt:formatNumber pattern="##.##"  value="${qizhanbinqiMap.rate}"></fmt:formatNumber>  </td>
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