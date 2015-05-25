<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>仙灵运维管理系统</title>
</head>
<FRAMESET border="0" frameSpacing="0" rows="70,*, 20" frameBorder="0">
	<FRAME name="banner" id="banner" src="<%=request.getContextPath()%>/top.do" noResize="true" scrolling="no"/>
	<FRAMESET border="0" cols="200,2,*"  id="fid">
		<frame src="<%=request.getContextPath()%>/left.do" name="leftFrame" style="BORDER-RIGHT: #6D91B5 0px solid" />
		<frame src="<%=request.getContextPath()%>/pages/frame/center.jsp" name="centerFrame" scrolling="no" noResize="true"/>
		<frame src="<%=request.getContextPath()%>/pages/frame/main.jsp" name="mainFrame"/>
	</FRAMESET>
	<FRAME name="banner" src="<%=request.getContextPath()%>/pages/frame/bottom.jsp" noResize="true" scrolling="no"/>
</FRAMESET>
<noframes>
<body>
</body>
</noframes>
</html>