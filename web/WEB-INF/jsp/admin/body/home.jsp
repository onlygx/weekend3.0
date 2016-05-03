<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- BEGIN PAGE HEADER-->
<h3 class="page-title">
系统 <small> 状态</small>
</h3>

<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="javascript:void(0);">主页</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">日志</a>
		</li>
	</ul>
</div>
<!-- END PAGE HEADER-->
<div class="alert alert-success">
	<strong>欢迎登陆！</strong> <a href="/druid" target="_blank" style="color: white;"> 点此查看系统日志</a>
</div>

<div>
	<ul>
		<li>session-admin：${session.admin}</li>
		<li>昵称：${session.admin.name}</li>
		<li>头像地址：${session.admin.head}</li>
	</ul>
</div>
<div class="clearfix"> </div>

<script type="text/javascript">

</script>
