<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<html>
<head>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav">当前位置：辅助功能</div>
	<div class="div_search">
		<form method="post">
		<ul>
			<li><button type="button" onclick="window.location='./serverRealTimeTotalDataJob.do'">实时分服总数据</button></li>
			<li><button type="button" onclick="window.location='./allServerStatisticsJob.do'">所有服务器统计信息</button></li>
			<li><button type="button" onclick="window.location='./noticeJob.do'">公告</button></li>
			<li><button type="button" onclick="window.location='./zhandouliRankJob.do'">战斗力排行</button></li>
			<li><button type="button" onclick="window.location='./topOneThousandStatisticsJob.do'">前一千名统计</button></li>
			<li><button type="button" onclick="window.location='./serversIntegrationReportJob.do'">全服关键信息整合</button></li>
		</ul>
		</form>
	</div>
</div>
</body>
</html>