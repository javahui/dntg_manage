<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
	<div id="div_right_frame">
		<div id="div_position_nav">当前位置: 游戏数据查询 >> 角色信息 >> 详细信息</div>
		
		<div class="div_operate">
			<ul>
				<li class="li_operate" onclick="window.location='./index.do'">返回</li>
				<li class="li_operate" onclick="window.location='./rolebags.do?id=${record.id}'">背包</li>
			</ul>
		</div>
			
		<div class="div_edit">
			<div class="content-box-header font-12">角色信息</div>
				<table class="tbl_edit">
				<tr>
					<td class="td_edit_name width-15-point">玩家账号</td>
					<td class="td_edit_value">${record.userId}</td>
					<td class="td_edit_name width-15-point">等级</td>
					<td class="td_edit_value">${record.level}</td>
				</tr>
				<tr>
					<td class="td_edit_name width-15-point">角色名</td>
					<td class="td_edit_value">${record.name}</td>
					<td class="td_edit_name width-15-point">角色创建时间</td>
					<td class="td_edit_value"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td class="td_edit_name width-15-point">职业</td>
					<td class="td_edit_value">${record.job}</td>
					<td class="td_edit_name width-15-point">最后登录时间</td>
					<td class="td_edit_value"><date:format value="${record.onlineTime }"/> </td>
				</tr>
				<tr>
					<td class="td_edit_name width-15-point">性别</td>
					<td class="td_edit_value">${record.sex}</td>
					<td class="td_edit_name width-15-point">最后离线时间</td>
					<td class="td_edit_value"><date:format value="${record.offlineTime }"/></td>
				</tr>
				<tr>	
					<td class="td_edit_name width-15-point">元宝</td>
					<td class="td_edit_value">${record.lingshi}</td>
					<td class="td_edit_name width-15-point">金币</td>
					<td class="td_edit_value">${record.tongqian}</td>
				</tr>
				<tr>	
					<td class="td_edit_name width-15-point">绑定元宝</td>
					<td class="td_edit_value">${record.bindLingshi}</td>
				</tr>
			</table>
		</div>

		<div class="div_edit">
			<div class="content-box-header font-12">角色好友列表</div>
			<table class="tbl_list">
				<tr class="tr_list_title">
				<td width="3%"></td>
				<td width="10%">用户账号</td>
				<td width="10%">角色名</td>
				<td width="5%">职业</td>
				<td width="5%">性别</td>
				<td width="5%">等级</td>
				<td width="5%">当前经验</td>
				<td width="10%">在线时间</td>
				<td width="10%">最后离线时间</td>
				<td width="10%">角色创建时间</td>
				<td width="17%">操作</td>
			</tr>
		<c:choose>
			<c:when test="${not empty friend }">
				<c:forEach items="${friend}" var="friend" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					<td class="center"><input type="checkbox" name="recordId" value="${friend.id}" onclick="changeTrColorBySelect('${status.index}')"></td>
					<td class="center"> ${friend.userId}</td>
					<td class="center"> ${friend.name}</td>
					<td class="center"> ${friend.job}</td>
					<td class="center"> ${friend.sex==1?"女":"男"}</td>
					<td class="right"> ${friend.level}</td>
					<td class="right"> ${friend.exp}</td>
					<td class="center"> <date:format value="${friend.onlineTime }"/> </td>
					<td class="center"> <date:format value="${friend.offlineTime }"/></td>
					<td class="center"> <fmt:formatDate value="${friend.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td class="center"> <a href="./show.do?id=${friend.id}">详细信息</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="11"><font color="red">当前角色尚无好友</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>

		<div class="div_edit">
			<div class="content-box-header font-12">角色仇人列表</div>
			<table class="tbl_list">
				<tr class="tr_list_title">
				<td width="3%"></td>
				<td width="10%">用户账号</td>
				<td width="10%">角色名</td>
				<td width="5%">职业</td>
				<td width="5%">性别</td>
				<td width="5%">等级</td>
				<td width="5%">当前经验</td>
				<td width="10%">在线时间</td>
				<td width="10%">最后离线时间</td>
				<td width="10%">角色创建时间</td>
				<td width="17%">操作</td>
			</tr>
			<c:choose>
				<c:when test="${not empty foe }">
					<c:forEach items="${foe}" var="foe" varStatus="status">
					<tr id="recordTr${status.index}" class="tr_list_data">
						<td class="center"><input type="checkbox" name="recordId" value="${foe.id}" onclick="changeTrColorBySelect('${status.index}')"></td>
						<td class="center"> ${foe.userId}</td>
						<td class="center"> ${foe.name}</td>
						<td class="center"> ${foe.job}</td>
						<td class="center"> ${foe.sex==1?"女":"男"}</td>
						<td class="right"> ${foe.level}</td>
						<td class="right"> ${foe.exp}</td>
						<td class="center"> <date:format value="${foe.onlineTime }"/> </td>
						<td class="center"> <date:format value="${foe.offlineTime }"/></td>
						<td class="center"> <fmt:formatDate value="${foe.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td class="center"> <a href="./show.do?id=${foe.id}">详细信息</a></td>
					</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr class="tr_list_data"><td class="td_page_shift" colspan="11"><font color="red">当前角色尚无仇人</font></td></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	
		<div class="div_edit">
		<table class="tbl_list">
		<tr class="tr_list_title">
			<td width="10%">部位</td>
			<td width="10%">装备名</td>
			<td width="10%">是否绑定</td>
			<td width="10%">等级</td>
			<td width="10%">稀有等级</td>
			<td width="20%">过期时间</td>
		</tr>
		<c:choose>
			<c:when test="${not empty roleEquipSlot }">
				<c:forEach items="${roleEquipSlot}" var="equip" varStatus="status">
				<tr class="tr_list_data">
					<td class="center">${equipMap[equip.slotNum]}</td>
					<td class="center">${equip.goodsName}</td>
					<td class="center">${equip.bind==1?"绑定":"未绑定"}</td>
					<td class="right"> ${equip.itemLevel}</td>
					<td class="right"> ${equip.rareLevel}</td>
					<td class="center">
						<c:choose>
							<c:when test="${equip.expireTime > 0 }"><date:format value="${equip.expireTime}"/></c:when>
							<c:otherwise>永久</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="10"><font color="red">当前角色尚无装备</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>

		<div class="div_edit">		
			<table class="tbl_edit">
				<tr>	
					<td class="td_edit_name">当前最大阶层坐骑</td>
					<td class="td_edit_value" align="center">${roleZuoqi.rank}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">当前所骑的坐骑等级</td>
					<td class="td_edit_value" align="center">${roleZuoqi.curRank}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">今日坐骑升阶失败次数</td>
					<td class="td_edit_value" align="center">${roleZuoqi.failCount}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">历史坐骑升阶失败最大次数</td>
					<td class="td_edit_value" align="center">${roleZuoqi.historyCount}</td>
				</tr>
				<tr>
					<td class="td_edit_name">当前幸运值</td>
					<td class="td_edit_value" align="center">${roleZuoqi.luckyValue}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">历史最大幸运值</td>
					<td class="td_edit_value" align="center">${roleZuoqi.historyLucky}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">当日已分享经验</td>
					<td class="td_edit_value" align="center">${roleZuoqi.totalExp}</td>
				</tr>
				<tr>	
					<td class="td_edit_name">更新时间</td>
					<td class="td_edit_value" align="center">${roleZuoqi.updateTime}</td>
				</tr>
			</table>
			</div>
			
		<div class="div_edit">
			<table class="tbl_list">
				<tr class="tr_list_title">
					<td width="10%"> 身上部位</td>
					<td width="10%"> 格子</td>
					<td width="10%"> 宝石等级</td>
					<td width="10%"> 升级失败次数</td>
					<td width="10%"> 宝石升级经验</td>
					<td width="10%"> 更新时间</td>
				</tr>
				<c:choose>
					<c:when test="${not empty roleBaoshi }">
						<c:forEach items="${roleBaoshi}" var="xlRoleBaoshi" varStatus="status">
						<tr class="tr_list_data">			
							 <td class="center"> ${equipMap[-xlRoleBaoshi.part]}</td> 					
							 <td class="center"> ${xlRoleBaoshi.grid}</td> 					
							 <td class="center"> ${xlRoleBaoshi.level}</td> 					
							 <td class="center"> ${xlRoleBaoshi.failCount}</td> 					
							 <td class="center"> ${xlRoleBaoshi.exp}</td> 					
							 <td class="center"> ${xlRoleBaoshi.updateTime}</td> 							
						</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr class="tr_list_data"><td class="td_page_shift" colspan="9"><font color="red">当前角色尚无宝石</font></td></tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>