/*
 * js 工具类 用于获取参数提交、提醒等。
 */

// ============================================ tools
var tools = function(){};


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
	for(obj in params){
		var temp = params[obj].split("=");
		param[temp[0]] = temp[1];
	}
	return param;
}

/**
 * 带回调函数的tips
 * @param content 可以写文字和标签
 * @param time	时间（毫秒）
 * @param callback 回调函数。
 * @param type 类型 'info', 'danger', 'success', 'warning'
 */
tools.tip = function(content,time,callback,_type){
	try {
		$(".bootstrap-growl").remove();
	} catch (e) {
		// TODO: handle exception
	}
	time = time==undefined?500:time;
	_type = _type==undefined?"info":_type;
	$.bootstrapGrowl(content, {
        ele: 'body', // which element to append to
        type: _type, // (null, 'info', 'danger', 'success', 'warning')
        offset: {
            from: "top",
            amount: 200
        }, // 'top', or 'bottom'
        align: "center", // ('left', 'right', or 'center')
        width: "auto", // (integer, or 'auto')
        delay: time, // Time while the message will be displayed. It's not equivalent to the *demo* timeOut!
        allow_dismiss: false, // If true then will display a cross to close the popup.
        stackup_spacing: 10 // spacing between consecutively stacked growls.
    });
	 if (typeof callback == "function")  
	 {  
		 setTimeout(function(){
			 callback();
		 },time+500);
	 }  
};
//依赖后台的返回值提示。
tools.errorTip = function(_case, _code) {
	
    if(_code == -1) { //超时
    	var session = $("<div>").html("session 超时！");
    	tools.setMain(session);
        return;
    }
    var tip = _case[_code];

    art.tip(tip,null,null,"danger");
};

/**
 * 设置主界面
 * @param data
 */
tools.setMain = function(data){
	$("#main").html(data);
    if(data instanceof Object){
        $("#main").html(JSON.stringify(data,null,"\t"));
    }
};

/**
 * ajax post 提交方法
 * @param url
 * @param param
 * @param success
 */
tools.post = function(_url,_param,_success) {
    var time;
    $.ajax({
        url: _url,
        type: "post",
        data: _param,
        dataType: "json",
        async: true,// false:同步请求 默认true
        success: _success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            tools.setMain(XMLHttpRequest.responseText);
        },
        beforeSend: function (XMLHttpRequest) {
            art.tip("<img src=\"/images/project/loading.gif\" style=\"width: 20px;height: 20px;\"> &nbsp;请求处理中。。。");
            time = new Date().getTime();
        },
        complete: function (XMLHttpRequest, textStatus) {
            var time2 = new Date().getTime();
            console.log("本次ajax操作耗时：" + (time2 - time) + "毫秒；");
        }
    });
};

/**
 * ajax get 提交方法
 * @param url
 * @param param
 * @param success
 */
tools.get = function (_url, _param, _success) {
    var time;
    $.ajax({
        url: _url,
        type: "get",
        data: _param,
        dataType: "json",
        async: true, // 异步请求
        success: _success,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            tools.setMain(XMLHttpRequest.responseText);
        },
        beforeSend: function (XMLHttpRequest) {
            art.tip("<img src=\"/images/project/loading.gif\" style=\"width: 20px;height: 20px;\"> &nbsp;请求处理中。。。");
            time = new Date().getTime();
        },
        complete: function (XMLHttpRequest, textStatus) {
            var time2 = new Date().getTime();
            console.info("本次ajax操作耗时：" + (time2 - time) + "毫秒；");
        }
    });
};

/**
 * 提交修改信息
 * @param _module
 */
tools.edit = function(_module,formId){
    formId = formId == undefined ? "editForm" : formId;
    var state = false;
    var param = tools.formParams(formId);
    if($("#"+formId).valid()) {
        tools.post(_module + "/update", param, function (data) {
            state = data.success;
            if (data.success) {
                tools.tip("修改成功！", null, function () {
                    history.go(-1);
                });
            } else {
                tools.tip("修改失败！错误代号：" + data.code, 1000, null, "danger");

            }
        });
    }
    return state;
};

/**
 * 保存到数据库
 * @param _module
 */
tools.save = function(_module,formId){
    formId = formId == undefined ? "saveForm" : formId;
    var state = false;
    var param = tools.formParams(formId);
    if($("#"+formId).valid()){
        tools.post(_module +"/save",param,function(data){
            state = data.success;
            if(data.success){
                art.tip("提交成功", 500, function () {
                    history.go(-1);
                });
            }else{
                tools.tip("提交失败！错误代号："+data.code,1000,null,"danger");
            }
        });
    }
    return state;
};
