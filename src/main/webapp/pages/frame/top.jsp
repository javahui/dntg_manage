<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<base target="mainFrame">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/skin1/top.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/component/jquery/jquery-1.7.1.min.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/component/artDialog4.1.6/jquery.artDialog.js?skin=default"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/component/artDialog4.1.6/plugins/iframeTools.js"> </script>
<style type="text/css">
	a:link {
		color: #00f;
		text-decoration: none;
	}
	a:visited {
		color: #00f;
		text-decoration: none;
	}
	a:hover {
		color: #f00;
		text-decoration: none;
	}
</style>
<script type="text/javascript">
$().ready(function(){
	var throughBox = art.dialog.through;
	throughBox({
	    content: document.getElementById('top-servers'),
	    title:'请选择要查询的游戏服务器',
	    lock: true, //开启锁屏。中断用户对话框之外的交互
	    init: function(){ //初始化函数
	    	this.hide(); //调用隐藏方法
	    },
	    close: function(){
	    	this.hide(); //当关闭时阻止关闭，而是进行隐藏
	    	return false;
	    },
	    resize: false,	 //是否允许用户调节尺寸
	    drag:false, //是否允许用户拖动位置
	    esc: true //是否允许用户按Esc键关闭对话框
	});
});

function openit(){
	var list = art.dialog.list;
	for (var i in list) {
    	list[i].show(); 
	}
}
</script>
</head>
<body>
<div class="top-all">
	<div class="left-nav">
		<ul id="nav">
			<li><a href="logout.do" target="_top">安全退出</a></li>
			<li><a href="<%=request.getContextPath()%>/user/editPwd.do" target="mainFrame">重置密码</a></li>
			<li>
				<span class="huise">当前选择
				【<span id="curServer">${defaultServerId }</span>】</span>
			</li>
			<li><input onclick="openit()" type="button" class="thickbox" value="选择服务器" /></li>
		</ul>
	</div>
	<div id="right-logo"><img alt="LOGO" src="<%=request.getContextPath()%>/css/skin1/img/lingyu-logo.jpg"> </div>
</div>

<div id="top-servers"  style="font-size: 12px">
	<c:forEach items="${gameServerMap}" var="map" varStatus="status">
		<div class="server-sort-tb">	
			<div class="game-server-sort-name-div">${map.key}</div>
			<ul id="game-server-list-ul${status.index}" class="game-server-list-ul">
			<c:forEach items="${map.value}" var="item" varStatus="status">
				<li><a href="#" onclick="changeServer('${item.serverId}','${item.serverName}'); hideAll()">${item.serverName}</a></li>
			</c:forEach>
			</ul>
		</div>
	</c:forEach>
</div>

</body>
</html>

