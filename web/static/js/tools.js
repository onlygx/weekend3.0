/*
 * js 工具类 用于获取参数提交、提醒等。
 */

// ============================================ tools
var tools = function(){}


tools.formParams = function(_formId) {

    var nodes = $("#" + _formId).find("input[type='text'],input[type='password']" +
    		",input[type='hidden'],input[type='radio']:checked," +
        	"input[type='checkbox']:checked,textarea,select");
    var params = {};
    
    for (var i = 0; i < nodes.length; i++) {
    	
        var e = $(nodes[i]);
        var name = e.attr("name");
        if(name != undefined){
            if (params[name] == undefined) {
                params[name] = e.val();
            } else {
                params[name] += "," + e.val();
            }
        }

    }
    return params;
};

/**
 * 表单字符串转 JavaScript Object对象
 * @param paramStr 使用JQuery 的serialize() 获取的表单字符串
 */
tools.parseParam = function(paramStr){
	var params = paramStr.split("&");
	var param = {};
	for(var obj in params){
		var temp = params[obj].split("=");
		param[temp[0]] = temp[1];
	}
	return param;
}


//依赖后台的返回值提示。
tools.errorTip = function(_case, _code) {
	
    if(_code == -1) { //超时
    	alert("连接失效");
        return;
    }
    var tip = _case[_code];

	alert(tip);
};

tools.tip = function(_data,_case) {

    if(_data.success) { //超时
        alert("操作成功");
    }else{
        try{
            tools.errorTip(_case,_data.code);
        }catch (e){
            console.log(e);
        }
    }
};

/**
 * ajax 提交方法
 * @param url
 * @param param
 * @param success
 */
tools.action = function(_url,_param,_success){
	var time;
	$.ajax({url:_url, 
		type:"post", 
		data: _param, 
		dataType:"json",
		//async:false,
    	success: _success,
    	error: function(XMLHttpRequest, textStatus, errorThrown){
    		console.log(XMLHttpRequest.responseText);
         },
        beforeSend:function(XMLHttpRequest){
        	console.log(_url+" 请求开始...");
        	time = new Date().getTime();
        },
        complete:function(XMLHttpRequest, textStatus){
        	var time2 = new Date().getTime();
        	console.log("本次ajax操作耗时："+(time2-time)+"毫秒；");
        	
        }
    });
}
