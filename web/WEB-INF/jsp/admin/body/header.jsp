<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="#module=home">
				<%--<img src="/static/metronic/layout/img/logo-light.png" alt="logo" class="logo-default">--%>
				<img src="/images/project/xiushe-logo.png" style="width: 130px;height: 60px;margin-top: 5px;" alt="logo" class="logo-default" >
			</a>
			<%--<a  alt="logo" class="logo-default" href="#module=home" style="margin-top: 23px;font-size: 20px;">后台管理系统</a>--%>
			<div class="menu-toggler sidebar-toggler">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse">
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<img src="/images/project/admin-gif.jpg" style="width: 60px;height: 60px;margin-top: 5px;" alt="logo" class="logo-default" >

		<!-- BEGIN PAGE TOP -->
		<div class="page-top">

			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">

					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="username username-hide-on-mobile">${admin.name}</span>
							<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
							<img alt="" class="img-circle" src="${admin.head}">
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
                            <li>
                                <a href="#module=/admin/edit&id=${admin.id} ">
                                    <i class="icon-user"></i> 我的资料 </a>
                            </li>

                            <li>
                                <a href="#module=admin/headimg&id=${admin.id}">
                                    <i class="icon-picture"></i> 我的头像 </a>
                            </li>

							<li>
								<a href="#module=account/edit&id=${account.id}">
									<i class="icon-lock"></i> 密码修改 </a>
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
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>

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
