<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计&nbsp;&gt;&gt;&nbsp;玩家保有率统计</div>
		
		<div class="div_search">
		<form name="searchForm" method="get" action="./index.do" >
		<ul>
			<li>角色创建时间:<input type="text"  name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
		<div class="div_list">
		<table class="tbl_list">
			<tr class="tr_list_title">
				<td width="20%">时间</td>
				<td width="10%">注册数</td>
				<td width="10%">次日保有%</td>
				<td width="10%">三日保有%</td>
				<td width="10%">四日保有%</td>
				<td width="10%">五日保有%</td>
				<td width="10%">六日保有%</td>
				<td width="10%">七日保有%</td>
				<td width="10%">八日保有%</td>
			</tr>
		<c:choose>
			<c:when test="${not empty list }">
				<c:forEach items="${ list.records}" var="plist" varStatus="status">
				
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center"><fmt:formatDate pattern="yyyy-MM-dd"  value="${plist.create_time}"></fmt:formatDate></td>
					<td class="center">${plist.create_count}</td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count1}"> <fmt:formatNumber pattern="#.##">${plist.keep_count1/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count2}"> <fmt:formatNumber pattern="#.##">${plist.keep_count2/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count3}"> <fmt:formatNumber pattern="#.##">${plist.keep_count3/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count4}"> <fmt:formatNumber pattern="#.##">${plist.keep_count4/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count5}"> <fmt:formatNumber pattern="#.##">${plist.keep_count5/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count6}"> <fmt:formatNumber pattern="#.##">${plist.keep_count6/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
					<td class="right" ><c:choose ><c:when test="${not empty plist.keep_count7}"> <fmt:formatNumber pattern="#.##">${plist.keep_count7/plist.create_count*100}</fmt:formatNumber> </c:when><c:otherwise>0</c:otherwise></c:choose></td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="10"><base:pageSplit url="./index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="10"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
		</table>
	</div>
</div>
</body>
</html>