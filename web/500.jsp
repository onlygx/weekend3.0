<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" isErrorPage="true"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<h3 class="page-title">
系统 <small> 500</small>
</h3>


<div class="note note-danger" >
	<p style="font-size: 16px;">
		 服务器：<span style="color:blue;">500错误</span>
	</p>

    ${exception}
</div>
