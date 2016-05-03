<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div> 
	<s:iterator value="list">
	<img class="img-thumbnail" src="${img }" alt="图片" style="height: 200px;">
	<br><br>
	</s:iterator>
</div>

