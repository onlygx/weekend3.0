<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" isErrorPage="true"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<h3 class="page-title">
    系统 <small> 404</small>
</h3>

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="javascript:void(0);">主页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="#">404</a>
        </li>
    </ul>
</div>

<div class="note note-danger" >
    <p style="font-size: 16px;">
        服务器：<span style="color:blue;">没有找到您要访问的页面(404错误)</span>
    </p>
</div>

