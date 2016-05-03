<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!-- BEGIN HEADER -->
<div class="page-header md-shadow-z-1-i navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<!-- <a href="index.html">
			<img src="/admin/css/metronic/layout/img/logo.png" alt="logo" class="logo-default"/>
			</a> -->
			<h3 style="color: white;margin-top: 10px;">后台管理系统</h3>
			<!-- <img alt="" src="/admin/image/logo1.png" style="height: 35px;margin-top: 5px;"> -->
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"></a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu" style="margin-top: 2px;">
			<ul class="nav navbar-nav pull-right">
			
				<!-- BEGIN NOTIFICATION DROPDOWN -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
			<!-- 	<li class="dropdown dropdown-extended dropdown-notification" id="header_notification_bar">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i> <span class="badge badge-default"> 6 </span>
					</a>
					<ul class="dropdown-menu">
						<li class="external">
							<h3><span class="bold">7 待处理</span> 通知</h3>
							<a href="extra_profile.html">查看全部</a>
						</li>
						<li>
							<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-success">
									<i class="fa fa-plus"></i>
									</span>
									新用户注册</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>
									服务器报错</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-warning">
									<i class="fa fa-bell-o"></i>
									</span>
									用户建议</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-info">
									<i class="fa fa-bullhorn"></i>
									</span>
									我的消息</span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>
									新任务 </span>
									</a>
								</li>
								<li>
									<a href="javascript:;">
									<span class="time">4/28</span>
									<span class="details">
									<span class="label label-sm label-icon label-danger">
									<i class="fa fa-bolt"></i>
									</span>
									系统通知 </span>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li> -->
				<!-- END NOTIFICATION DROPDOWN -->
				
				
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
				<li class="dropdown dropdown-user">
					<a href="javascript:;" style="padding-top:12px;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<img alt="" class="img-circle" id="myHeadImg" src="${admin.head}"/>
						<span class="username username-hide-on-mobile"> ${admin.name} </span>
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li>
							<a href="#module=admin/edit&action=find_admin&id=${admin.id} ">
							<i class="icon-user"></i> 我的资料 </a>
						</li>
						<li>
							<a href="#module=admin/headimg">
							<i class="icon-picture"></i> 我的头像 </a>
						</li>
						
						<li class="divider"> </li>
						<li>
							<a href="javascript:logout();">
							<i class="icon-key"></i> 退出 </a>
						</li>
					</ul>
				</li>
				<!-- END USER LOGIN DROPDOWN -->

			</ul>
		</div>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix"></div>
<script>
	function logout() {
		tools.post("/login/logout",null,function(data){
			if(data.success){
                art.tip("退出成功！",500,function(){
                    window.location.href = "/login/loginPage";
                })
			}
		})
	}
</script>