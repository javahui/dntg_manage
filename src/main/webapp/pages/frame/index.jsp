<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/component/jquery/jquery-1.7.1.min.js"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/component/artDialog4.1.6/jquery.artDialog.js?skin=default"> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/component/artDialog4.1.6/plugins/iframeTools.js"> </script>
<link href="<%=request.getContextPath()%>/component/jquery_plugin/thickbox/thickbox.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/skin1/top.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function changeServer(serverId, serverName){
		var params={};
		params["serverId"] = serverId;
		$.post("selectServer.do",params,function(data){
			if(data=='ok'){
				$("#curServer").text(serverName);
				$(document.getElementById("frame_content").contentWindow.document.getElementById("banner").contentWindow.document).find("#curServer").text(serverName);
				tb_remove();
			}
		}, "text");
	}
	
	function hideAll(){//隐藏所有
		var list = art.dialog.list;
		for (var i in list) {
	    	list[i].hide(); 
		}
	}
</script>
<style type="text/css">
html,body{height: 100%; width: 100%;}
iframe{
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
<iframe id="frame_content" name="frame_content" src="<%=request.getContextPath()%>//pages/frame/mainIndex.jsp" scrolling="no" frameborder="0"></iframe>
</body>
</html>