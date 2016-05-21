<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="#module=home">
				<%--<img src="/static/metronic/layout/img/logo-light.png" alt="logo" class="logo-default">--%>
				<img src="/images/project/weekend-logo.png" style="width: 180px;height: 50px;margin-top: 10px;" alt="logo" class="logo-default" >
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
							<img alt="" class="img-circle" id="myHeadImg"  src="${admin.head}">
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

					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
							<%--<span class="username username-hide-on-mobile">设置</span>--%>
							<!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
							<img alt="" class="img-circle" src="/images/project/setting.png" style=" ">
						</a>
						<%--<a href="javascript:;" class=" btn dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"  aria-expanded="true" data-close-others="true">
							设置<i class="icon-settings"></i>
						</a>--%>
						<div class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
							<div class="row">
								<div class="col-md-4 col-sm-4 col-xs-12">
									<h3>主题</h3>
									<ul class="theme-colors">
										<li class="theme-color theme-color-default" data-theme="default">
											<span class="theme-color-view"></span>
											<span class="theme-color-name">黑色标题</span>
										</li>
										<li class="theme-color theme-color-light active" data-theme="light">
											<span class="theme-color-view"></span>
											<span class="theme-color-name">白色标题</span>
										</li>
                                       <%-- <li class="theme-color theme-color-light " data-theme="lisht2">
                                            <span class="theme-color-view"></span>
                                            <span class="theme-color-name">蓝色标题</span>
                                        </li>--%>
									</ul>
								</div>
								<div class="col-md-8 col-sm-8 col-xs-12 seperator">
									<h3>布局</h3>
									<ul class="theme-settings">
										<li>
											主题样式
											<select class="layout-style-option form-control input-small input-sm">
												<option value="square">方角</option>
												<option value="rounded" selected="selected">圆角</option>
											</select>
										</li>
										<li>
											布局
											<select class="layout-option form-control input-small input-sm">
												<option value="fluid" selected="selected">全屏</option>
												<option value="boxed">居中</option>
											</select>
										</li>
										<li>
											顶部导航
											<select class="page-header-option form-control input-small input-sm">
												<option value="fixed" selected="selected">静止</option>
												<option value="default">滚动</option>
											</select>
										</li>
										<li>
											顶部菜单
											<select class="page-header-top-dropdown-style-option form-control input-small input-sm">
												<option value="light">白色</option>
												<option value="dark" selected="selected">黑色</option>
											</select>
										</li>
										<li>
											侧边栏菜单模式
											<select class="sidebar-option form-control input-small input-sm">
												<option value="fixed">静止</option>
												<option value="default" selected="selected">滚动</option>
											</select>
										</li>
										<li>
											侧边栏菜单
											<select class="sidebar-menu-option form-control input-small input-sm">
												<option value="accordion" selected="selected">下拉展开</option>
												<option value="hover">右侧展开</option>
											</select>
										</li>
										<li>
											侧边栏位置
											<select class="sidebar-pos-option form-control input-small input-sm">
												<option value="left" selected="selected">左边</option>
												<option value="right">右边</option>
											</select>
										</li>
										<li>
											底部
											<select class="page-footer-option form-control input-small input-sm">
												<option value="fixed">静止</option>
												<option value="default" selected="selected">滚动</option>
											</select>
										</li>
									</ul>
								</div>
							</div>
						</div>
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
                    window.location.href = "/login/";
                })
			}
		})
	}
</script>
