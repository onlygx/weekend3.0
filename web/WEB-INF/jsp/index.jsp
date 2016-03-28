<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2015/9/16 0016
  Time: 下午 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<html>
<head>
    <title>框架测试</title>
</head>
<body>
<h2>测试地址</h2>
<a href="http://localhost/power/login_insert?name=powerTest&url=www.baidu.com">
    http://localhost/power/login_insert?name=powerTest&url=www.baidu.com
</a>
<br>
<a href="http://localhost/power/login_select?id=13765">http://localhost/power/login_select?id=13765</a>
<br>
<a href="http://localhost/power/login_delete?id=11111111111">http://localhost/power/login_delete?id=11111111111</a>
<br>
<a href="http://localhost/power/login_list/0/10">http://localhost/power/login_list/0/10</a>
<br>
<h2>返回值</h2>
<h4> 状态： ${status}</h4>
<h4> 返回值： ${id}</h4>
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
                <a href="javascript:void(0);" onclick="delPpwer('${item.id}')">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
