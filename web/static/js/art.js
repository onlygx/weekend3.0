
var art = function(){};

/**
 * 带回调函数的tips
 * @param content 可以写文字和标签
 * @param time	时间（毫秒）
 * @param callback 回调函数。
 * @param type 类型 'info', 'danger', 'success', 'warning'
 */
art.tip = function(content,time,callback,_type){
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
}

/**
 * 弹窗确认操作
 * @param title
 * @param func
 */
art.confirm = function(title,func){
	bootbox.confirm(title, function(result) {
        if(result){
        	func();
        };
     }); 
}

/**
 * 弹窗和回调函数；
 * @param title
 * @param func
 */
art.alert = function(title,func){
	 bootbox.alert(title, func);  
}

/**
 * 输入一个值
 * @param title
 * @param func
 */
art.input = function(title,func){
	bootbox.prompt(title, func);
}

/**
 * 自定义快捷弹窗
 * @param title
 * @param content
 * @param func1
 * @param func2
 */
art.dialog = function(title,content,func1,func2){
	bootbox.dialog({
        message: content,
        title: title,
        locale:"zh_CN",
        buttons: {
          success: {
            label: "取消",
            className: "green",
            callback: func2
          },
          main: {
            label: "确定",
            className: "blue",
            callback: func1
          }
        }
    });
}

/**
 * 自定义按钮的dialog
 */
art.myDialog = function(title,content,param){
	bootbox.dialog({
        message: content,
        title: title,
        locale:"zh_CN",
        buttons: param
    });
}

