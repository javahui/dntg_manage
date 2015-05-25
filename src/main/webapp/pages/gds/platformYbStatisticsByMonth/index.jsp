<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏数据统计 >> 平台每月元宝充值统计</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>平台：
				<select name="sortId">
					<c:forEach items="${sortMap}" var="sortEntry"><option value="${sortEntry.id}" <c:if test="${paramMap.sortId==sortEntry.id}">selected="selected"</c:if>>${sortEntry.sortName}</option></c:forEach>
			    </select>
			</li>
			<li>
				月份:<input name="startMonth" class="validate[required]" readonly="readonly" value="${paramMap.startMonth}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})">
				      -<input name="endMonth" class="validate[required]" readonly="readonly" value="${paramMap.endMonth}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list"  id="tableDiv" >
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="25%"> 时间 </td>
			<td width="25%"> 元宝 </td>
		</tr>
		<c:forEach items="${map}" var="map" varStatus="status">
		<tr class="tr_list_data">
			<td class="center">${map.key}</td> 
			<td class="center"><fmt:formatNumber value="${map.value}" pattern="#,#00"/></td> 
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>