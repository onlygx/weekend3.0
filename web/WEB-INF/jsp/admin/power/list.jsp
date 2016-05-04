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

<!-- BEGIN PAGE HEADER-->
<h3 class="page-title">
    系统权限列表
</h3>

<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <i class="fa fa-home"></i>
            <a href="#module=home">主页</a>
            <i class="fa fa-angle-right"></i>
        </li>
        <li>
            <a href="javascript:void(0);">权限管理</a>
        </li>
    </ul>
</div>
<!-- END PAGE HEADER-->

<!-- BEGIN PAGE TOOLS-->
<div class="portlet light bg-inverse">
    <div class="portlet-title">
        <div class="caption">
            <i class="icon-paper-plane font-green-haze"></i>
			<span class="caption-subject bold font-green-haze uppercase">搜索</span>
            <span class="caption-helper">点击键盘回车按钮或者右侧搜索按钮开始检索</span>
        </div>
        <div class="actions">
            <button class="btn btn-circle btn-default btn-sm" onclick="tableSearch();"> <i class="icon-magnifier"></i> 搜索 </button>
            <a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title="" title=""></a>
        </div>
    </div>
    <div class="portlet-body">

        <form class="form-inline margin-bottom-40" role="form" id="tableParams">
            <div class="form-group form-md-line-input has-success">
                <input type="text" class="form-control" name="name" value="${name}" autofocus placeholder="权限名称">
                <div class="form-control-focus"></div>
            </div>

        </form>
    </div>
</div>

<!-- END PAGE TOOLS-->


<!-- BEGIN PAGE TABLE-->
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption">
            <i class="icon-speech  font-blue-hoki"></i>
			<span class="caption-subject font-blue-hoki">数据表</span>
            <span class="caption-helper">点击右侧可以刷新或者全屏</span>
        </div>

        <div class="actions">
            <a class="btn btn-circle btn-icon-only btn-default " href="javascript:loadHash();" title="刷新"><i class="fa fa-refresh"></i></a>
            <a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title="" title="全屏"></a>
        </div>
        <div id="paginator" style="padding-right: 20px;"></div>
    </div>
    <div class="portlet-body">

        <div class="table-toolbar">
            <div class="row">
                <div class="col-md-6">

                    <div class="btn-group">
                        <a href="javascript:void(0);" class="btn blue" onclick="history.go(-1);">
                            <i class="fa  fa-refresh fa-spin "></i>返回
                        </a>
                        <a href="#module=power/add" class="btn green">
                            添加 <i class="fa fa-plus"></i>
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="btn-group pull-right">
                        <button class="btn btn-danger" onclick="deleteAll();"> 批量删除 <i class="fa fa-times"></i></button>
                    </div>
                </div>
            </div>
        </div>
        <table style="width: 100%;" class="table table-striped table-bordered" id="table">
            <tr>
                <th class="table-checkbox">
                    <input type="checkbox" class="group-checkable"/>
                </th>
                <th>id</th>
                <th>name</th>
                <th>url</th>
                <th>操作</th>
            </tr>

            <c:forEach var="item" items="${pageInfo.list}" varStatus="status">
                <tr>
                    <td class="center"><input type="checkbox" class="checkboxes" value="${item.id}"/></td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.url}</td>
                    <td>
                        <a href="javascript:void(0);" onclick="tools.del('power','${item.id}')">删除</a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>
<!-- END PAGE TABLE-->

<!-- BEGIN PAGE JAVASCRIPT-->
<script src="/static/js/initList.js"></script>
<script>

    // 分页插件参数
    var pageParam = {
        url: "/power/list",
        pageSize: ${pageInfo.pageSize},         //每页显示行数 默认10
        currentPage: ${pageInfo.pageNum},   //当前页数
        totalPages: ${pageInfo.pages},      //总页数
        //numberOfPages: 5,                 //显示的页数
    };

    // 条件查询参数
    var formParam = {
        name: "${name}"
    };

    $(document).ready(function () {

        initList();

    });

    function tableSearch(){

        var param = tools.formParams("tableParams");
        var url = "/power/list/1";

        for(var paramKey in param){
            url += "&" + paramKey;
            url += "=" + param[paramKey];
        }

        window.location.hash = "#module="+url;
    };

    //绑定回车事件
    $(document).keydown(function(event){
        if(event.keyCode==13){
            tableSearch()
        }
    });
</script>
<!-- END PAGE JAVASCRIPT-->