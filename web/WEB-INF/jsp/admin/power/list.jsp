<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/3 0003
  Time: 下午 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<h4> 分页信息： ${pageInfo.toString()}</h4>

<table style="width: 100%;" class="table table-striped table-bordered">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>url</th>
        <th>操作</th>
    </tr>

    <c:forEach var="item" items="${pageInfo.list}" varStatus="status" >
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.url}</td>
            <td>
                <a href="javascript:void(0);" onclick="tools.del('power','${item.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

<script>

</script>
