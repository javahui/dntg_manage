<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/includes.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script type="text/javascript" src="component/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="component/highstock/highstock.js"></script>
<script type="text/javascript" src="component/highstock/modules/exporting.js"></script>  
<script type="text/javascript">
  var usdeur = ${test};
$(function() {

	$("#chartDiv").toggle();
	var chart = new Highcharts.StockChart({
	    chart: {
	        renderTo: 'container'//指向的div的id属性
	    },
	    exporting: {  
            enabled: true //是否能导出趋势图图片
        }, 
		title : {
				text : '在线统计(小时)'//图表标题
			},
	    xAxis: {
	    	tickPixelInterval: 200,//x轴上的间隔
		//	title :{
		//		text:"title"
		//	},
			type: 'datetime', //定义x轴上日期的显示格式
			labels: {
			formatter: function() {
				var header = Highcharts.dateFormat('%Y-%m-%e %l %P', this.value);
				//alert(this.value);
				return header;
			},
			align: 'center'
		}
	    },
	    credits:{  
            enabled: false,  
            href: "http://www.baidu.com/",  
            text: '百度'  
        },  
	    yAxis : {  
                  
              title: {  
                  text: '人数'  //y轴上的标题
              }  
         },  
		tooltip: {
            xDateFormat: '%Y-%m-%d %l %P, %A'//鼠标移动到趋势线上时显示的日期格式
        },
	    rangeSelector: {
			buttons: [{//定义一组buttons,下标从0开始
			type: 'week',
			count: 1,
			text: '一周'
		},{
			type: 'month',
			count: 1,
			text: '一月'
		}, {
			type: 'month',
			count: 3,
			text: '三月'
		}, {
			type: 'month',
			count: 6,
			text: '六月'
		}, {
			type: 'ytd',
			text: '今年'
		}, {
			type: 'year',
			count: 1,
			text: '一年'
		}, {
			type: 'all',
			text: '所有'
		}],
			selected: 1//表示以上定义button的index,从0开始
	    },
	    
	    series: [{
	        name: '人数',//鼠标移到趋势线上时显示的属性名
	        data: usdeur//属性值
			//marker : {
			//		enabled : true,
			//		radius : 3
			//	},
			//shadow : true
	    }]
	});
});

function charts(){
	var btvar=$("#bt").text();
	
	if(btvar=="显示图表"){
		$("#bt").text("显示表格");
		$("#tableDiv").toggle("normal");
		$("#chartDiv").toggle("normal");
	}else{
		$("#bt").text("显示图表");
		$("#tableDiv").toggle("normal");
		$("#chartDiv").toggle("normal");
	}
}
</script>
</head>
<body>
<div id="div_right_frame">
	<div id="div_position_nav"><span>当前位置</span>：游戏数据统计 >> 在线人数</div>
		<div class="div_search">
		<form name="searchForm" method="get" action="" >
		<ul>
			<li>创建时间:<input type="text" name="startTime" class="input_search" size="10" readonly="readonly" maxlength="20" value="${paramMap.startTime}" id="startDatePicker" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDatePicker\')}'})">
				-&nbsp;<input type="text" name="endTime"   class="input_search" size="10" readonly="readonly" value="${paramMap.endTime}"   id="endDatePicker" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'startDatePicker\')}'})">&nbsp;&nbsp;</li>
			<li><button type="submit">查询</button></li>
			<li><button type="button"  onclick="charts()"  id="bt">显示图表</button></li>
		</ul>
		</form>
	</div>

	<div class="div_list" id="tableDiv" >
	<table class="tbl_list"   >
		<tr class="tr_list_title">
			<td width="25%"> 人数</td>
			<td width="25%"> 时间</td>
			<td></td>
		</tr>
		<c:choose>
			<c:when test="${not empty list.records }">
				<c:forEach items="${list.records}" var="item" varStatus="status">
				<tr id="recordTr${status.index}" class="tr_list_data">
					 <td class="center"> ${item.count}</td> 					
					 <td class="center">  <fmt:formatDate value="${item.logTime}" pattern="yyyy-MM-dd HH"/>时</td> 		
					 <td></td>
				</tr>
				</c:forEach>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="3"><base:pageSplit url="index.do" count="${list.totalRecordsCount}" pageNo="${list.curPage}" pageSize="${list.pagesize}"/></td></tr>
			</c:when>
			<c:otherwise>
				<tr class="tr_list_data"><td class="td_page_shift" colspan="3"><font color="red">当前查询条件下无数据</font></td></tr>
			</c:otherwise>
		</c:choose>
	</table>
	</div>

	<div id="chartDiv">
	&nbsp;
         <div id="container" style="width: 98%">
        </div>
    </div>
</div>
</body>
</html>