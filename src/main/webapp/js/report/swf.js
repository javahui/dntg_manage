var recordDataStr="";
/**
 * 拼装报表数据
 * @param str
 * @return
 */
function spellRecordDataStr(xContent, yContent){
//	var str = "<set label='"+xContent+"' value='"+yContent+"'  />";
//	var str = xContent + "-" + yContent;
	var color = "CFB3D9";//区域颜色
	recordDataStr+="<set color='" +color+ "' label='"+xContent+"' value='"+yContent+"'  />";
}


/**
 * flash区域性报表(一张)
 * @param caption 标题
 * @param subcaption 子标题
 * @param xAxisName x轴名字
 * @param yAxisName y轴名字
 * @param labelDisplay x轴字体排列方式(Rotate:竖,Stagger:横,)
 * @return
 */
function displaySingleArea(area2DSetData, caption, subcaption, xAxisName, yAxisName, labelDisplay){
	var tmpStr = "<chart caption='"+caption+"' subcaption='"+subcaption+"' xAxisName='"+xAxisName
						+"' baseFontSize='12' yAxisName='"+yAxisName
						+"' labelDisplay='"+ labelDisplay 
						+"' yAxisMinValue='15000' staggerLines='1' slantLabels='1' numberPrefix='' showValues='0' alternateHGridColor='FFFFFF' " +
						"alternateHGridAlpha='20' divLineColor='FF000' divLineAlpha='50' " +
						"canvasBorderColor='666666' baseFontColor='666666' lineColor='FF000'>";
	tmpStr+=area2DSetData;
	
	tmpStr +="<styles>"
	+"<definition>"
		+"<style name='Anim1' type='animation' param='_xscale' start='0' duration='1' />"
		+"<style name='Anim2' type='animation' param='_alpha' start='0' duration='0.6' />"
		+"<style name='DataShadow' type='Shadow' alpha='40'/>"
	+"</definition>"
	+"<application>"
		+"<apply toObject='DIVLINES' styles='Anim1' />"
		+"<apply toObject='HGRID' styles='Anim2' />"
		+"<apply toObject='DATALABELS' styles='DataShadow,Anim2' />"
	+"</application>"	
	+"</styles>"
	+"</chart>";
	var myChart = new FusionCharts("././swf/report/Area2D.swf", "myChartId", "100%", "450", "0", "0");
	myChart.setDataXML(tmpStr);
	
	myChart.render("chartdiv");
}


/**
 * flash区域性报表(多张)
 * @param caption 标题
 * @param subcaption 子标题
 * @param xAxisName x轴名字
 * @param yAxisName y轴名字
 * @return
 */
function displayMultiArea(recordDataStr, caption, xAxisName, yAxisName){
	var tmpStr = "<chart bgColor='E9E9E9' outCnvBaseFontColor='666666' " +
						 "caption='"+caption+"' xAxisName='"+xAxisName+
						 "' yAxisName='"+yAxisName+
						 "' showNames='1' showValues='0' " +
						 " labelDisplay='Rotate' slantLabels='1'> ";
	tmpStr+=recordDataStr;
	
	tmpStr += "</chart>";
	var myChart = new FusionCharts("././swf/report/MSArea.swf", "myChartId", "100%", "450", "0", "0");
	myChart.setDataXML(tmpStr);
	myChart.render("chartdiv");
}