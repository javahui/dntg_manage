<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
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
<body>

<div id="div_right_frame">
	<div id="div_position_nav">当前位置: 游戏日志 >> 道具获取详细日志</div>
		<div class="div_search">
		<form>
		类型：<input id="checkallType"   type="checkbox"  onclick="selectAllType()"/> 全选&nbsp;
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
			<li>角色名:<input type="text" name="userName" value="${paramMap.userName}"/></li>
			<li>物品名:<input type="text" name="goodName" value="${paramMap.goodName}"/></li>
			<li>
				月份:<input name="month" class="validate[required]" readonly="readonly" value="${paramMap.month}" onfocus="WdatePicker({dateFmt:'yyyy_M'})">
				时间:
				<input name="startTime" readonly="readonly" value="${paramMap.startTime}" onfocus="WdatePicker({dateFmt:'dd HH:mm'})">
				 - <input name="endTime" readonly="readonly" value="${paramMap.endTime}" onfocus="WdatePicker({dateFmt:'dd HH:mm'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		<input type="hidden" name="eventTypes" value=" ">
		</form>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="15%">角色名</td>										
			<td width="15%"> 事件 </td>						
			<td width="15%"> 道具名称</td>										
			<td width="15%"> 获取总数量</td>					
			<td width="25%"> 时间 </td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">	
			<td class="center">${item.userName}</td>
			<td class="center"> ${eventTypeMap[item.eventType]}</td> 					
			<td class="center"> ${item.goodsName}</td>						
			<td class="center"> ${item.count}</td> 					
			<td class="center"><fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><base:pageSplit url="./indexDetail.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
		<c:if test="list.records == null">
			<tr class="tr_list_data"><td class="td_page_shift" colspan="6"><font color="red">由于数据量过大，请根据角色名或者指定时间查询</font></td></tr>
		</c:if>
	</table>
	</div>
	
</div>
</body>
</html>