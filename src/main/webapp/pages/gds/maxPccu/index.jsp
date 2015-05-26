<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 服务器日峰值在线统计</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>分类：
				<select name="sortId">
					<c:forEach items="${sortMap}" var="sortEntry"><option value="${sortEntry.id}" <c:if test="${paramMap.sortId==sortEntry.id}">selected="selected"</c:if>>${sortEntry.sortName}</option></c:forEach>
			    </select>
			</li>
			<li>
				月份:<input name="month" class="validate[required]" readonly="readonly" value="${paramMap.month}" onfocus="WdatePicker({dateFmt:'yyyy_MM'})">
			</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button" onclick="exportXls()">Excel</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list"  id="tableDiv" >
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="25%"> 平台 </td>
			<td width="25%"> 时间 </td>
			<td width="25%"> 服务器 </td>
			<td width="25%"> 最高在线数 </td>
		</tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${list}" var="item" varStatus="status">
				<tr class="tr_list_data">
					 <td class="center">${item.sortName}</td>
					 <td class="center">${item.logDay}</td> 	
					 <td class="center">${item.serverName}</td>
				 	 <td class="center">${item.pccu} </td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="4"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
</div>
</body>
</html>