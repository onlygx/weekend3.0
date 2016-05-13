<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<!-- BEGIN PAGE HEADER-->
<div class="page-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="page-title">
		<h1>SSM <small>系统 &amp; 主页</small></h1>
	</div>
	<!-- END PAGE TITLE -->
</div>
<!-- END PAGE HEADER-->
<div class="note note-info">
	<strong>欢迎登陆！</strong> <a href="/druid" target="_blank" > 点此查看 druid 监控数据</a>
</div>

<div class="note note-success">
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


<div class="note note-danger">
	<h4 class="block">Session powerList</h4>
    <ul>
        <li>权限个数：${powerList.size()}</li>
        <c:forEach var="item" items="${powerList}" varStatus="status">
            <li>${item.name}(${item.powers.size()})</li>
        </c:forEach>
    </ul>
</div>


<div class="clearfix"> </div>

<script type="text/javascript">

</script>
