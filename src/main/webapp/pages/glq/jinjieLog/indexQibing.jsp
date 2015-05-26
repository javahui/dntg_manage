<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：游戏日志 >> 骑兵进阶</div>
	<div class="div_search">
		<form>
		<ul>
			<li>角色名:<input type="text" name="roleName" class="validate[required]" value="${paramMap.roleName}"/></li>
			<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				- <input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}" id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">
			</li>
			<li><button type="submit">查询</button></li>
		</ul>
		</form>
	</div>
	
	<div class="div_operate">
		<ul>
			<li class="li_operate" onclick="window.location='indexZuoqi.do'">坐骑进阶</li>
			<li class="li_operate" onclick="window.location='indexQibing.do'">骑兵进阶</li>
			<li class="li_operate" onclick="window.location='indexGuangyi.do'">光翼进阶</li>
		</ul>
	</div>
	
	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">												
			<td> 角色名 </td>
			<td> 道具名 </td>
			<td> 触发次数 </td>
			<td> 道具消耗数 </td>
			<td> 元宝消耗数 </td>
			<td> 事件前等级 </td>
			<td> 事件后等级 </td>
			<td> 最后时间 </td>
		</tr>
		<c:forEach items="${list.records}" var="item" varStatus="status">
		<tr class="tr_list_data">
			 <td class="center"> ${item.roleName}</td>
			 <td class="center"> ${item.goodsName}</td>
			 <td class="center"> ${item.eventCount}</td>
			 <td class="center"> <c:if test="${item.goodsCount != 0}">${item.goodsCount}</c:if></td>
			 <td class="center"> ${item.costYb}</td>
			 <td class="center"> ${item.beforeRank}</td>
			 <td class="center"> ${item.afterRank}</td>
			 <td class="center"> <fmt:formatDate value="${item.lastTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>							
		</tr>
		</c:forEach>
		<tr class="tr_list_data"><td class="td_page_shift" colspan="11"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
	</table>
	</div>
</div>
</body>
</html>