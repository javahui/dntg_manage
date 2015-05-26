<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏数据查询 >> 角色信息 >> 背包</div>
		
		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='./index.do'">返回</li>
			</ul>
		</div>
			
		<div class="div_edit">
			<table class="tbl_list">
			<tr class="tr_list_data"><td class="left" colspan="11">当前已开格位：${roleBagState.bagCapacity }，最后开格位时间：<date:format value="${roleBagState.bagUpdateSlotTime }"/></td></tr>
			<tr class="tr_list_title">
				<td width="10%">ID</td>
				<td width="10%">格位号</td>
				<td width="10%">物品名</td>
				<td width="5%">数量</td>
				<td width="5%">绑定</td>
				<td width="10%">稀有等级</td>
				<td width="10%">物品等级</td>
				<td width="10%">过期时间</td>
			</tr>
			<c:choose>
				<c:when test="${not empty roleBagSlot.records }">
					<c:forEach items="${roleBagSlot.records}" var="roleBagSlot" varStatus="status">
					<tr class="tr_list_data">
						<td class="center">${roleBagSlot.id}</td>
						<td class="center"> ${roleBagSlot.slotNum}</td>
						<td class="center"> ${roleBagSlot.goodsName}</td>
						<td class="right"> ${roleBagSlot.count}</td>
						<td class="center"> ${roleBagSlot.bind == 1 ?"绑定":"未绑定"}</td>
						<td class="right"> ${roleBagSlot.rareLevel}</td>
						<td class="right"> ${roleBagSlot.itemLevel}</td>
						<td class="center">
							<c:choose>
								<c:when test="${roleBagSlot.expireTime > 0 }"><date:format value="${roleBagSlot.expireTime}"/></c:when>
								<c:otherwise>永久</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
					<tr class="tr_list_data"><td class="td_page_shift" colspan="11">
						<base:pageSplit url="rolebags.do" count="${roleBagSlot.totalRecordsCount}" pageNo="${roleBagSlot.curPage}" pageSize="${roleBagSlot.pagesize}"/>
					</td></tr>
				</c:when>
				<c:otherwise>
					<tr class="tr_list_data"><td class="td_page_shift" colspan="11"><font color="red">当前角色背包空</font></td></tr>
				</c:otherwise>
			</c:choose>
		</table>
		</div>
	</div>
</body>
</html>