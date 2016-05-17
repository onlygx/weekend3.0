<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!-- BEGIN SIDEBAR -->
<div class="page-sidebar-wrapper">
	<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
	<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
	<div class="page-sidebar navbar-collapse collapse">
		<!-- BEGIN SIDEBAR MENU -->
		<!-- DOC: Apply "page-sidebar-menu-light" class right after "page-sidebar-menu" to enable light sidebar menu style(without borders) -->
		<!-- DOC: Apply "page-sidebar-menu-hover-submenu" class right after "page-sidebar-menu" to enable hoverable(hover vs accordion) sub menu mode -->
		<!-- DOC: Apply "page-sidebar-menu-closed" class right after "page-sidebar-menu" to collapse("page-sidebar-closed" class must be applied to the body element) the sidebar sub menu mode -->
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Set data-keep-expand="true" to keep the submenues expanded -->
		<!-- DOC: Set data-auto-speed="200" to adjust the sub menu slide up/down speed -->

		<ul class="page-sidebar-menu "  data-keep-expanded="false" data-auto-scroll="true"  data-slide-speed="200">

			<li class="start " >
				<a href="#module=home">
				<i class="icon-home"></i>
				<span class="title">主页</span>
				<span class="selected"></span>
				<!-- <span class="arrow open"></span> -->
				</a>
			</li>
			<c:if test="${account.userName == 'admin'}">
                <li>
                    <a href="#module=power/all&parentId=0">
                        <i class="fa fa-cogs "></i>
                        <span class="title">权限管理</span>
                    </a>
                </li>
            </c:if>


			<c:forEach var="item" items="${powerList}" varStatus="status">
				<li>
					<a href="#module=${item.url }">
					<i class="${item.icon }"></i>
					<span class="title" title="${item.intro }">${item.name }</span>
					<c:if test="${item.powers.size() > 0}">
						<span class="arrow "></span>
					</c:if>
					</a>
					<c:if test="${item.powers.size() > 0}">
						<ul class="sub-menu">
							<c:forEach var="item2" items="${item.powers}" varStatus="status2">
								<li>
									<a href="#module=${item2.url }">
									<i class="${item2.icon }"></i>
									<span class="title" title="${item2.intro }">${item2.name }</span>
									<c:if test="${item2.powers.size() > 0}">
										<span class="arrow "></span>
									</c:if>
									</a>
									<c:if test="${item2.powers.size() > 0}">
										<ul class="sub-menu">
											<c:forEach var="item3" items="${item2.powers}" varStatus="status3" >
												<li>
													<a href="#module=${item3.url }">
													<i class="${item3.icon }"></i>
													<span class="title" title="${item3.intro }">${item3.name }</span>
													</a>
												</li>
											</c:forEach>
										</ul>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</c:if>
				</li>
			</c:forEach>
			
			<li class="open">
				<a href="javascript:;">
				<i class="icon-cup"></i>
				<span class="title">hash 传参测试</span>
				<span class="arrow "></span>
				</a>
				<ul class="sub-menu" style="display: block;">
					<li>
						<div style="width: 100%;background-color: gainsboro;padding: 20px;">
							<textarea placeholder="#module=power-list&action=list_power" class="form-control" rows="" cols=""
                                      style="width: 100%;height: 100px;">#module=home</textarea>
							<br>
							<button class="btn btn-info" onclick="window.location.hash=$(this).parent().find('textarea').eq(0).val();">加载页面</button>
							<button class="btn btn-info pull-right" onclick="loadHash();">重载页面</button>
						</div>
					</li>
				</ul>
			</li>
			
		</ul>

		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->