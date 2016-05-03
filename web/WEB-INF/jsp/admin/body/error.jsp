<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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

<div class="note note-danger">
	<p style="font-size: 16px;">
		 系统发生错误：<s:property value="exception.message"/>
	</p>
</div>

<div class="portlet box green-haze">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa   fa-smile-o"></i>详细错误信息，点击右侧展开
		</div>
		<div class="tools">
			<a href="javascript:;" class="expand " data-original-title="" title=""></a>
		</div>
	</div>
	<div class="portlet-body" style="display: none;">
		<s:property value="exceptionStack"/>
	</div>
</div>

