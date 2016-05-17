/**
 * 初始化一些全局变量
 */
var map;//百度地图

/**
 * 根据浏览器地址hash值来加载页面
 * @author GaoXiang
 */
$(document).ready(function (){
	
	 setInterval(checkHash, 100);

	 console.info("欢迎进入后台管理系统...");
	
});

/**
 * 获取hash值 并分解成参数去服务器获取页面
 */
function checkHash() {
	
	var newHash = window.location.hash;
	
	if(hashIsChange(newHash)){
		loadHash();
	}
   
}

/**
 * 验证hash码是否改变过
 * @param newHash
 * @returns {Boolean}
 */
function hashIsChange(newHash){

    if(newHash == undefined || newHash == "") {

    	newHash = "#module=home";

    }

    if(newHash == window.currentHash){
    	return false;
    }
    
    window.currentHash = newHash;
    return true;
}

/**
 * 解析hash 分解成action和参数并执行
 * @param newHash
 */
function loadHash(){

    var params = delToParam(window.currentHash);
    var _url = params["module"];
    params["module"] = undefined;
    params["_t"] = new Date().getTime();

    tools.post(_url, params, function(data){
    	tools.setMain(data);
    });
}

/**
 * 分解hash字符串 组成Param对象
 * @param hash
 */
function delToParam(hash){
	var paramsString = hash.substring(1);
    var paramsArray = paramsString.split("&");
    var params = {};
    for(var i = 0; i < paramsArray.length; i++) {
        var tempArray = paramsArray[i].split("=");
        params[tempArray[0]] = tempArray[1];
    }
    return params;
}
