<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<h3 class="page-title">
    系统 <small> Error</small>
</h3>

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="javascript:void(0);">主页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="#">错误</a>
        </li>
    </ul>
</div>
<% Exception ex = (Exception)request.getAttribute("exception"); %>

<div class="note note-danger">
    <p style="font-size: 16px;">
        系统发生错误：<%= ex.getMessage()%>
    </p>
</div>

<div class="portlet box green-haze">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa   fa-smile-o"></i>详细错误信息：
        </div>
        <div class="tools">
            <a href="javascript:;" class="expand " data-original-title="" title=""></a>
        </div>
    </div>
    <div class="portlet-body" style="display: block;">
        <% ex.printStackTrace(new java.io.PrintWriter(out)); %>
    </div>
</div>

