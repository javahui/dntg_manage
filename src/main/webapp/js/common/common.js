/**
 * 悬浮文字tips
 * @param id 触发悬浮事件的ID
 * @param text 提示文字
 */
function tipsText(id, text){
	text = replaceLineBreakToBR(text);
	$("#"+id).mouseover(function(e){showText(e, text);})
			 .mouseout(function(e) {$("#tips").css("display","none");});
}
function showText(e, text){
	$("#tips").html(text).css({"top":(e.pageY+5)+"px", "left":(e.pageX+5)+"px", "display":"block"})
			  			 .show("fast");
}
/**
 * 悬浮图片tips
 * @param id 触发悬浮事件的ID
 * @param imgSrc 图片路径
 */
function tipsImg(id, imgSrc){
	$("#"+id).mouseover(function(e){showImg(e, imgSrc);})
	 		 .mouseout(function(e) {$("#tips").css("display","none");});
}
function showImg(e, imgSrc){
	$("#tips").html("<img src='"+imgSrc+"'/>").css({"top":(e.pageY+5)+"px", "left":(e.pageX+5)+"px", "display":"block"})
	.show("fast");
}

/**
 * 批量操作(删除、开启关闭服务器)
 * @param url 请求的url
 * @param itemsName checkbox的Name
 * @param needParamName checkbox要组成的name
 * @param msg 提示msg
 * @param params 额外参数{"key1":"value1","key2":"value2"}
 */
function batchOperate(url, itemsName,needParamName,msg, params){
	if( !confirm(msg) ){
		return;
	}
	//处理选择的checkbox
	var needValue = "";
	$("input[name='"+itemsName+"']").each(function(){
		if( this.checked ){
			needValue += (",'"+$(this).val()+"'");
		}
	});
	if( needValue.length == 0 ){
		alert("未选择任何记录");
		return;
	}
	
	if( url.indexOf("?") == -1 ){
		url += "?";
	}else{
		url += "&";
	}
	url += (needParamName + "="+needValue.substring(1, needValue.length));
	
	//处理传入的参数
	var paramStr = "";
	if( params != null ){
		for( var p in params ){
			paramStr += ("&"+ p + "="+params[p]);
		}
	}
	if( url.indexOf("?") == -1 ){
		url += "?";
	}else{
		url += "&";
	}
	url += paramStr;
	
	//请求
	window.location.href = url;
}
/**
 * 判断字符串是否为空
 */
function isEmpty(str){
	str = $.trim(str);
	if( str == "" || str.length <= 0 ){
		return true;
	}
	return false;
}
/**
 * 获取选取的radio的值
 * @param radioName
 */
function getRadioValue(radioName){
	return $("input[name='"+radioName+"']:checked").val();
}
/**
 * 把换行符替换为<br/>
 * @param text
 * @returns
 */
function replaceLineBreakToBR(text){
	return text.replace(/\r\n/ig,"<br/>");
}
/**
 * ajax分页
 * @param url url带参数(url, pageNo, pageSize)
 */
function ajaxSubmitSplit(url, mark){
	if( mark == 1 ){
		$("#other-title").text("角色背包列表");
	}else if( mark == 2 ){
		$("#other-title").text("角色仓库列表");
	}else if( mark == 3 ){
		$("#other-title").text("角色法宝列表");
	}else if( mark == 4 ){
		$("#other-title").text("角色装备列表");
	}else if( mark == 5 ){
		$("#other-title").text("角色坐骑信息");
	}else if( mark == 6 ){
		$("#other-title").text("角色宝石列表");
	}else if( mark == 7 ){
		$("#other-title").text("角色竞技信息");
	}
	$("#ajaxwait").html( $("#hidden-loading").html() );
	$.get(url, function(data){
		$("#ajaxwait").html(data);
	}, "html");
}

/**
 * 打开选择多选服务器子窗口
 */
function openServerDiglog(){
	var len = arguments.length;
	var targetId = "serverIds";
	var isDisable = false;
	if (len == 1) {
		targetId = arguments[0];
	} else if(len == 2) {
		targetId = arguments[0];
		isDisable= arguments[1];
	}
	var path = (top.frame_content == undefined) ? '.' : '';
	$.dialog({
		lock : true,
		width: '1300px',
	    content: 'url:.' + path + '/gameServer/multiDiaglog.do?targetId=' + targetId + '&isDisable=' + isDisable
	});
}

/**
 * 打开选择单选服务器子窗口
 */
function openSingeChoiceServerDiglog(){
	var len = arguments.length;
	var targetId = "serverId";
	if (len == 1) {
		targetId = arguments[0];
	}
	var path = (top.frame_content == undefined) ? '.' : '';
	$.dialog({
		lock : true,
		width: '1300px',
		content: 'url:.' + path + '/gameServer/singeDiaglog.do?targetId=' + targetId
	});
}

/**
 * 打开游戏用户窗口
 */
function openGameUserDiglog(targetId,serverId){
	var path = (top.frame_content == undefined) ? '.' : '';
	$.dialog({
		lock : true,
		width: '1300px',
		content: 'url:.' + path + '/gameUserInfo/indexDiaglog.do?targetId=' + targetId  + '&serverId=' + serverId
	});
}
/**
 * 打开物品窗口
 */
function openGoodsDiglog(targetId){
	var path = (top.frame_content == undefined) ? '.' : '';
	$.dialog({
	/*	lock : true,
		width: '1300px',*/
	    content: 'url:.' + path + '/systemEmail/goodsQuery.do?targetId=' + targetId
	});
}