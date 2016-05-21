<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="GaoXiang" name="author"/>

<title>Weekend 后台管理</title>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<!-- <link href="/static/metronic/css/login.css" rel="stylesheet" type="text/css"/> -->
<link href="/static/metronic/plugins/select2/select2.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/css/login-soft.css" rel="stylesheet" type="text/css"/>

<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="/static/metronic/css/components-md.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/css/plugins-md.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link href="/static/metronic/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="/static/metronic/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="/images/project/favicon.ico"/>

</head>
<body class="page-md login">

<div class="menu-toggler sidebar-toggler"></div>
<!-- END SIDEBAR TOGGLER BUTTON -->
<!-- BEGIN LOGO -->
<div class="logo">
	<h1 style="font-size: 50px;color: white;">Weekend 后台管理系统</h1>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content ">
	<!-- BEGIN LOGIN FORM -->
	<div id="loginForm">
		<h3 class="form-title">登入系统</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span>
			请输入用户名和密码。 </span>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Username</label>
			<input class="form-control form-control-solid placeholder-no-fix" value="" type="text" autocomplete="off" placeholder="Username" name="userName"/>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<input class="form-control form-control-solid placeholder-no-fix" value="" type="password" autocomplete="off" placeholder="Password" name="password"/>
		</div>
		<div class="form-actions">
			<button type="button" onclick="loginForm();" class="btn btn-success uppercase">登陆</button>
			<label class="rememberme check">
			<input type="checkbox" name="remember" value="1"/>记住我一周</label>
			<!-- <a href="javascript:;" id="forget-password" class="forget-password"  style="margin-left: 90px;">忘记密码 ？</a> -->
		</div>

	</div>
	
	
</div>
<div class="copyright">
	  ©2016 244556979@qq.com  Admin Dashboard.
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="/static/metronic/plugins/respond.min.js"></script>
<script src="/static/metronic/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="/static/metronic/plugins/jquery.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<%-- <script src="/static/metronic/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
 --%>
<script src="/static/metronic/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/backstretch/jquery.backstretch.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/select2/select2.min.js" type="text/javascript"></script>
<script src="/static/metronic/plugins/bootstrap-growl/jquery.bootstrap-growl.min.js"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="/static/metronic/js/metronic.js" type="text/javascript"></script>
<script src="/static/metronic/layout/scripts/layout.js" type="text/javascript"></script>
<script src="/static/metronic/layout/scripts/demo.js" type="text/javascript"></script>
<script src="/static/metronic/js/login-soft.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script src="/static/js/jquery.md5.js"></script>
<script src="/static/js/art.js"></script>
<script src="/static/js/tools.js" type="text/javascript"></script>
<script>

validationCookie();

jQuery(document).ready(function() {     
	Metronic.init(); // init metronic core components
	Layout.init(); // init current layout
	Login.init();
	//Demo.init();
	
	// init background slide images
	$.backstretch([
		 "/static/metronic/img/bg/1.jpg",
		 "/static/metronic/img/bg/2.jpg",
		 "/static/metronic/img/bg/3.jpg",
		 "/static/metronic/img/bg/4.jpg"
		 ], {
		   fade: 800,
		   duration: 2000
		});

});

function loginForm(){
	//获取参数
	var param = tools.formParams("loginForm");

	//验证
	if(param["userName"] == undefined || param["userName"] ==""){
		tools.tip("请输入用户名");
		return false;
	}
	if(param["password"] == undefined || param["password"] ==""){
		tools.tip("请输入密码");
		return false;
	}

	// 保存密码
	try {
		if(param["remember"]=="1"){
            //7天后的这个时候过期
            $.cookie("userName",param["userName"],{path: '/login/loginPage',expires: 7});
			$.cookie("password",param["password"],{path: '/login/loginPage',expires: 7});
		}else{
            $.cookie("userName","",{path: '/login/loginPage'});
            $.cookie("password","",{path: '/login/loginPage'});
        }
		param["remember"] = undefined;
	} catch (e) {
        console.log("保存cookie失败！");
        console.log(e);
	}

	//加密
	param["password"] = $.md5(param["password"] );

	//提交
	$.post("/login/admin",param,function(data){
		if(data.success){
			window.location.href="/";
		}else{
			var _case = {
					1:"没有此用户。",
					2:"密码错误！",
					3:"服务器拒绝登陆！"
			};
			tools.errorTip(_case, data.code);
		}
	},"json");

}

/**
 * 验证是否存有cookie 然后自动赋值
 */
function validationCookie(){

	var username = $.cookie("userName");
	var password = $.cookie("password");

	if(username != "" && password != ""){
		$("#loginForm input[name='userName']").val(username);
		$("#loginForm input[name='password']").val(password);
		$("#loginForm input[name='remember']").attr("checked",true);
        console.log("获取到：cookie");
	}

}

//绑定回车事件
$(document).keydown(function(event){
	if(event.keyCode==13){
		loginForm();
	}
});
</script>
<!-- END JAVASCRIPTS -->

</body>
</html>