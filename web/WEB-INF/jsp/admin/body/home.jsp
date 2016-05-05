<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- BEGIN PAGE HEADER-->
<%--
<h3 class="page-title">
	主页
</h3>
--%>

<!-- END PAGE HEADER-->
<div class="alert alert-success">
	<strong>欢迎登陆！</strong> <a href="/druid" target="_blank" style="color: white;"> 点此查看 druid 监控数据</a>
</div>

<div class="note note-info">
	<h4 class="block">Session Admin</h4>
	<ul>
		<li>ID：${admin.id}</li>
		<li>昵称：${admin.name}</li>
		<li>头像地址：${admin.head}</li>
	</ul>

	<h4 class="block">Session Account</h4>
	<ul>
		<li>ID：${account.id}</li>
		<li>用户名：${account.userName} </li>
		<li>密码：${account.password}</li>
		<li>类型：${account.type}</li>
		<li>状态：${account.status}</li>
	</ul>
</div>


<div class="clearfix"> </div>

<script type="text/javascript">

</script>
