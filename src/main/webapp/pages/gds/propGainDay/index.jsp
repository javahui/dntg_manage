<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$().ready(function(){
$("#checkallType").click( 
		function(){ 
		if(this.checked){ 
		$("input[name='eventTypes']").each(function(){this.checked=true;}); 
		}else{ 
		$("input[name='eventTypes']").each(function(){this.checked=false;}); 
		} 
		} 
);
});
 
 
</script>
</head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 道具获取</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="" >
		类型：<!-- <input id="checkallType"   type="checkbox"  onclick="selectAllType()"/> 全选&nbsp; -->
				<c:if test="${not empty eventTypeMap2}">
					<c:forEach items="${eventTypeMap2}" var="typeMap" varStatus="status">
						<c:choose>
							<c:when test="${!(typeMap.eventGroup eq group ) || status.first }"></li></ul><ul><li>${typeMap.eventGroup }</c:when>
							<c:otherwise><li></c:otherwise>
						</c:choose>
						<c:choose>
						<c:when test="${ fn:contains(eventTypesList,typeMap.key) }"><input type="checkbox" name="eventTypes" value="${typeMap.key}"  checked='checked'>${typeMap.value}&nbsp;</c:when>
						<c:otherwise><input type="checkbox" name="eventTypes" value="${typeMap.key}" >${typeMap.value}&nbsp;</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${status.last}"></li></ul></c:when>
							<c:otherwise></li></c:otherwise>
						</c:choose>
						<c:set var="group"  value="${typeMap.eventGroup}" />
					</c:forEach>
				</c:if>
				<br/>
		<ul>
			<li>物品名:<input type="text" name="goodsNameMoHu" value="${paramMap.goodsNameMoHu}"/></li>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="15%"> 事件 </td>
			<td width="15%"> 事件触发次数 </td>
			<td width="15%"> 道具名称 </td>
			<td width="15%"> 获取总数量 </td>
			<td width="25%"> 时间 </td>
		</tr>
		<c:choose>
			<c:when test="${not empty list.records }">
				<c:forEach items="${list.records}" var="propGain" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">					
										 <td class="center"> ${eventTypeMap[propGain.eventType]}</td> 					
										 <td class="center"> ${propGain.times}</td> 						
										 <td class="center"> ${propGain.goodsName}</td> 					
										 <td class="center"> ${propGain.count}</td> 					
										 <td class="center"> <fmt:formatDate value="${propGain.logDay}" pattern="yyyy-MM-dd"/></td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><font color="red">由于数据量过大，请指定事件进行查询</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>
</div>
</body>
</html>