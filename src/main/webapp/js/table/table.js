$(document).ready(function(){
	//绑定复选框(全选、取消全选)事件
	$("#checkallornot").click(function(){
		var checked = this.checked;
		 $(":checkbox[disabled!='disabled']").each(function(){ 
			 $(this).attr("checked",checked);
		 });
	});
	
	//绑定点击复选框，则更改tr背景颜色的事件
	$(":checkbox[name='recordIds']").each(function(i){
	   $(this).click(function(){
			var currentTR = $(this).parents("tr");
			currentTR.css("background-color", this.checked ? "#F0F0F0" : "#FFF");
		});
	});
});

//用表单的方式提交选中的recordIds
function submitCheckedRecordIds(actionUrl){
	var isChecked = false;
	$("input[name='recordIds']").each(function(){
		if (this.checked){
			isChecked = true;
		}
	});
	if (isChecked == false) {
		alert("未选择任何记录");
		return;
	}
	if (confirm("确定操作吗?")  ) {
		var form = $("#tableForm");
		form.attr('action', actionUrl);
		form.submit();
	}
}
//导出xls文件
function exportXls(url){
	if (url == null || url == "") {
		url = "xls.do";
	}
	$("form:first").attr("action", url);
	$("form:first").submit();
	$("form:first").removeAttr("action");
}
//change tr bgcolor onmouseover
function chgTrColor(listr) {
	if(listr.className == "tr_list_title") {
		listr.style.backgroundImage = "url(common/images/li.gif)";
	}else {
		var temp = listr.getElementsByTagName("input");
		listr.bgColor = (listr.bgColor != "#bbcbe0")?"#bbcbe0":"#d5e4e8";
		if(temp.length > 0) {
			if(temp[0].getAttribute("type") == "checkbox")
			if(temp[0].getAttribute("checked") == "checked" || temp[0].getAttribute("checked") == true)
				listr.bgColor = "#F1FFD9";
			temp[0].onclick = function() {
				if(this.getAttribute("checked") != true && this.getAttribute("checked") != false) {
					if(this.getAttribute("checked") != "checked")this.setAttribute("checked","checked");
					else this.setAttribute("checked","false");
				}
			};
		}
	}
}

//select & diselect all checkboxs in the same list table
function checkAll(check,inputName) {
	var checkl,ischecked;
	var checks = check.parentNode.parentNode.parentNode.parentNode.getElementsByTagName("input");
	if(check.getAttribute("checked") != true && check.getAttribute("checked") != false) {
		if(check.getAttribute("checked") != "checked")
			check.setAttribute("checked","checked");
		else check.setAttribute("checked","false");
	}
	if((check.getAttribute("checked") == true) || (check.getAttribute("checked") == "checked")) {
		for(checkl=0;checkl<checks.length;checkl++) {
		ischecked = checks[checkl].getAttribute("checked");
		if(checks[checkl].getAttribute("type") == "checkbox" && checks[checkl] != check)
			if(ischecked != true && ischecked != false) {
				if(null!=inputName){
				    if(checks[checkl].getAttribute("name")==inputName){
				        checks[checkl].setAttribute("checked","checked");
				        checks[checkl].parentNode.parentNode.bgColor = "#edf6ff";
				        checks[checkl].checked = true;
				    }
				}else{
				    checks[checkl].setAttribute("checked","checked");
				    checks[checkl].parentNode.parentNode.bgColor = "#edf6ff";
				    checks[checkl].checked = true;
				}
				
			}
			else {
			    if(null!=inputName){
			        if(checks[checkl].getAttribute("name")==inputName){
			            checks[checkl].setAttribute("checked",true);
				        checks[checkl].parentNode.parentNode.bgColor = "#edf6ff";
				        checks[checkl].checked = true;
			        }
			    }else{
			        checks[checkl].setAttribute("checked",true);
				    checks[checkl].parentNode.parentNode.bgColor = "#edf6ff";
				    checks[checkl].checked = true;
			    }
				
			}
		}
	}
	else {
		for(checkl=0;checkl<checks.length;checkl++) {
		ischecked = checks[checkl].getAttribute("checked");
		if(checks[checkl].getAttribute("type") == "checkbox" && checks[checkl] != check)
			if(ischecked != true && ischecked != false) {
				if(null!=inputName){
				    if(checks[checkl].getAttribute("name")==inputName){
				       checks[checkl].setAttribute("checked","false");
				       checks[checkl].parentNode.parentNode.bgColor = "#ffffff";
				       checks[checkl].checked = false;
				    }
				}else{
				    checks[checkl].setAttribute("checked","false");
				    checks[checkl].parentNode.parentNode.bgColor = "#ffffff";
				    checks[checkl].checked = false;
				}
				
			}
			else {
			    if(null!=inputName){
			        if(checks[checkl].getAttribute("name")==inputName){
			            checks[checkl].setAttribute("checked",false);
				        checks[checkl].parentNode.parentNode.bgColor = "#ffffff";
				        checks[checkl].checked = false;
			        }
			    }else{
			        checks[checkl].setAttribute("checked",false);
				    checks[checkl].parentNode.parentNode.bgColor = "#ffffff";
				    checks[checkl].checked = false;
			    }
				
			}
		}
	}
}

/*
*@param url 需要链接地址
*@param name 传入controller对应的接收name
*@param id 输入框的id
*@param numFlag 是否为数字验证
*/
function editInput(url, name, id, numFlag,msg) {
	var inputObject = document.getElementById(id);
	var flag = "0";
	if (numFlag == "Y") {
		var reg = /^\d+$/;
		if (!reg.test(inputObject.value) || inputObject.value == "0" ) {
			flag = "1";
		}
	}else{
		if(inputObject.value==""){
			flag = "1";
		}
	}
	if (flag == "1") {
		alert(msg);
		return false;
	} else {
		if (confirm("确定提交？")) {
			realUrl = url + "&" + name + "=" + encodeURIComponent(inputObject.value);
			document.location.href = realUrl;	
		} else {
			return false;
		}
	}
}


//批量操作,url是重定向的链接，itemsName是一个checkbox数组，needParamName是所要跟的参数名称
function batchOperation(url,itemsName,needParamName,msg){

	if(msg==null||msg==''){
		msg="删除之后,信息永久无法恢复,是否确定删除？";
	}
	var items = document.getElementsByName(itemsName);
	var param="";
	var flag=0;
	var chooseFlag=0;
		if(null!=items){
		if (items.type == "checkbox" && !items.disabled) { //列表中只有一条记录
			param = "'"+items.value+"'";
			chooseFlag=1;
		}else{
			var len = items.length;
			if(len>0){
				for (var i = 0; i < len; i++) {
					if(items[i].checked){
						if(flag==0){
							param = "'"+items[i].value+"'";
							flag=1;
						}else{
							param = param+",'"+items[i].value+"'";
						}
						chooseFlag=1;
					}  	
	    		}
			}
		}
		if(chooseFlag==0){
			alert("没有选择记录");
			return false;
		}else{
		if(confirm(msg))
	    {	
			if(url.indexOf('?')>0){
				url = url + "&" +needParamName+"="+param;
			}else{
				url = url + "?" +needParamName+"="+param;
			}
			window.location = url;
		}
		}
	}
}
//批量操作,url是重定向的链接，itemsName是一个checkbox数组，needParamName是所要跟的参数名称
function batchOperation2(url,itemsName,needParamName,msg){
	var items = document.getElementsByName(itemsName);
	if(msg==null||msg=='')return false;
	if(items==null)return false;
	
	var chooseFlag=0;
	var flag=0;
	if (items.type == "checkbox" && !items.disabled) { //列表中只有一条记录
		param = "'"+items.value+"'";
		chooseFlag=1;
	}else{
		var len = items.length;
		if(len>0){
			for (var i = 0; i < len; i++) {
				if(items[i].checked){
					if(flag==0){
						param = items[i].value;
						flag=1;
					}else{
						param = param+","+items[i].value;
					}
					chooseFlag=1;
				}  	
    		}
		}
	}
	if(chooseFlag==0){
		alert("没有选择记录");
		return false;
	}
	
	if(confirm(msg)){	
		if(url.indexOf('?')>0){
			url = url + "&" +needParamName+"="+param;
		}else{
			url = url + "?" +needParamName+"="+param;
		}
		window.location.href = url;
	}
}

function batchOperationInteger(url,itemsName,needParamName,msg){

if(msg==null||msg==''){
msg="删除之后,信息永久无法恢复,是否确定删除？";
}
var items = document.getElementsByName(itemsName);
var param="";
var flag=0;
var chooseFlag=0;
if(null!=items){
	if (items.type == "checkbox" && !items.disabled) { //列表中只有一条记录
		param = items.value;
		chooseFlag=1;
	}else{
		var len = items.length;
		if(len>0){
			for (var i = 0; i < len; i++) {
				if(items[i].checked){
					if(flag==0){
						param = items[i].value;
						flag=1;
					}else{
						param = param+","+items[i].value;
					}
					chooseFlag=1;
				}  	
    		}
		}
	}
	if(chooseFlag==0){
		alert("没有选择记录");
		return false;
	}else{
	if(confirm(msg))
    {	
		if(url.indexOf('?')>0){
			url = url + "&" +needParamName+"="+param;
		}else{
			url = url + "?" +needParamName+"="+param;
		}
		window.location = url;
	}
	}

}
}

//树形选择列表
function selectTree(checkBoxObj) {
    var arr = eval("document.all." + checkBoxObj.name);
    var selValue = getSufStr(checkBoxObj.value);
    if (arr.type != "checkbox") {
        var len = arr.length;
        var noChecked = true;
        for (var i = len - 1; i >= 0; i--) {
            if (getSufStr(arr[i].value).substr(0, selValue.length) == selValue) {
                arr[i].checked = checkBoxObj.checked;
            } else {
                if (checkBoxObj.checked) {
                    if (selValue.substr(0, getSufStr(arr[i].value).length) == getSufStr(arr[i].value)) {
                        arr[i].checked = checkBoxObj.checked;
                    }
                } else {
                    var leng = getSufStr(arr[i].value).length;
                    if (selValue.length == leng && selValue.substr(0, leng - 3) == getSufStr(arr[i].value).substr(0, leng - 3) && arr[i].checked) {
                        noChecked = false;
                    }
                }
            }
        }
    }
}

//得到特定符号后的值
function getSufStr(str, sign) {
    return getPreOrSufStr(str, 1, sign);
}

//去掉制定符号前或者后面的值(此方法最好不用,由以下的getPreStr(str, sign),getSufStr(str, sign)代替)
function getPreOrSufStr(str, action, sign) {
    if (sign == null || sign == "") {
        sign = "^";
    }
    var index;
    if ((index = str.indexOf(sign)) != -1) {
        if (action == 0) {
            return str.substr(0, index);
        } else {
            return str.substr(index + 1);
        }
    }
    return str;
}
