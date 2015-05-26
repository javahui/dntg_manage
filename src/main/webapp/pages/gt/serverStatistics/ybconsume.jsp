<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
    <body>
       <div id="div_right_frame">
          <div id="div_position_nav">当前位置：游戏日志查询  >> 元宝消费 </div>
          <div class="div_search">
			<form>
			<ul>
				<li><select name="sevent">
				<option value ="">类型</option>
				<c:if test="${not empty eventTypeMap2}">
					<c:forEach items="${eventTypeMap2}" var="typeMap" varStatus="status">
						<option value ="${typeMap.key}" <c:if test="${sevent eq typeMap.key}">selected="selected" </c:if>>${typeMap.value }</option>
					</c:forEach>
				</c:if>
				</select></li>
				<li>时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
					-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;
				</li>
				<li><button type="submit">查询</button></li>
				<li><button type="button"  onclick="exportXls()">Excel</button></li>
			</ul>
			</form>
		</div>
		<div class="div_list">
	     <table class="tbl_list">
		<tr class="tr_list_title">								
		    <td width="20%"> 事件</td>										
			<td width="20%"> 总和</td>
			<c:if test="${not empty sevent}">										
				<td width="10%"> 时间</td>
			</c:if>
		</tr>
				<c:forEach items="${list}" var="item" varStatus="status">
				<tr  class="tr_list_data">															
					<td class="center">${item.event}</td>															
					<td class="center"> ${item.sum}</td>
					<c:if test="${not empty sevent}">										
						<td class="center">${item.day}</td>
					</c:if>
				</tr>
				</c:forEach>
	</table>
	</div>
		
     </div>
      
    </body>
                               
</html>
