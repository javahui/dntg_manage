<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 坐骑升阶分布</div>
	<div class="div_list">
		<div class="div_search">		
			<form name="searchForm" method="get" action="" >
				<ul>
					<li><button type="button"  onclick="exportXls()">Excel</button></li>
				</ul>
			</form>
		</div>

		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="33%"> 等级 </td>
				<td width="33%"> 人数 </td>
				<td width="33%"> 升阶到该阶级人数百分比 </td>
			</tr>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach items="${list}" var="equipfMap" varStatus="status">
					<c:if test="${status.index==0}">
					<tr id="recordTr${status.index+10000}" class="tr_list_data">		
						<td class="center" > 服务器领取坐骑总人数 </td> 
						<td class="center"> ${equipfMap.allCnt} </td>
						<td class="center" > - </td>
					</tr>
					</c:if>
					<tr id="recordTr${status.index}" class="tr_list_data">		
						<td class="center"> ${equipfMap.rank}</td> 
						<td class="center"> ${equipfMap.cnt} </td>
						<td class="center"> <fmt:formatNumber pattern="0.0000"  value="${equipfMap.cnt/equipfMap.allCnt*100}"></fmt:formatNumber>  </td>
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