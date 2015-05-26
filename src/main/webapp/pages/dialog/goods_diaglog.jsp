<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<script type="text/javascript">
var targetId = "${paramMap.targetId}";
var topDocument = (top == undefined) ? top.document : top['mainFrame'].document;
function selectGoods(goodsId, goodsName, maxStack){
 	$("#" + targetId, topDocument).val(goodsName);
 	$("#id" + targetId, topDocument).val(goodsId);
 	var numText = $("#count" + targetId, topDocument);
 	numText.val(1);
 	numText.removeClass();
 	numText.addClass("validate[required,custom[integer],min[1],max[" + maxStack + "]]");
	$("form:first", topDocument).validationEngine();
	frameElement.api.close();
}
</script>
</head>
<body>
<div id="div_right_frame">
	
	<div class="div_search">
		<form action="${ctx}/systemEmail/goodsQuery.do">
			<ul>
				<li>物品名：<input type="text" name="goodsName" class="input_search" value="${paramMap.goodsName}"></li>
				<li><button type="submit">查询</button></li>
			</ul>
			<input type="hidden" name="targetId" value="${paramMap.targetId}">
		</form>
	</div>

	<div class="div_list">
	<table class="tbl_list">
		<tr class="tr_list_title">
			<td>物品名</td>
			<td>最大堆叠数</td>
		</tr>
		<c:forEach items="${list}" var="item" varStatus="status">
		<tr class="tr_list_data">
			<td class="center"><a href="javascript:void(0)" onclick="selectGoods('${item.id}', '${item.name}','${item.maxStack}')">${item.name}</a></td>
			<td class="center">${item.maxStack}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</div>
</body>
</html>