<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${ctx}/css/skin1/left.css"/>
<script type="text/javascript">
	$(document).ready(
	function(){
		$(".left-menu-title a.nav-top-a").click(function(){
			$(this).parent().siblings().find("ul").slideUp("normal");
			$(this).next().slideToggle("fast");
		});
		$("#main-nav li .nav-top-a").hover(
			function(){$(this).stop().animate({paddingRight:"35px"},200);},
			function(){$(this).stop().animate({paddingRight:"25px"},200);}
		);
	});
</script>
</head>
<body>
<div id="leftContainer">
	<div class="left-top">灵娱网络</div>
	<ul id="main-nav">
		<c:if test="${not empty actionInfoList}">
		<c:forEach items="${actionInfoList}" var="item" varStatus="status">
			<li class="left-menu-title"><a href="#" class="nav-top-a">${item.actionName}</a>
				<c:if test="${not empty item.actionInfoList}">
				<ul class="left-menu-content" style="display: none;">
					<c:forEach items="${item.actionInfoList}" var="childAction">
						<li class="child-li"><a style="margin-right: 20px" href="${childAction.action}" target="mainFrame">${childAction.actionName}</a></li>
					</c:forEach>
				</ul>
				</c:if>
			</li>
		</c:forEach>
		</c:if>
	</ul>
</div>
</body>
</html>