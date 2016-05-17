<%--
  列表
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
<div class="page-head">
    <!-- BEGIN PAGE TITLE -->
    <div class="page-title">
        <h1>城市 <small> 列表</small></h1>
    </div>
    <!-- END PAGE TITLE -->
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN PAGE TOOLS-->
<div class="portlet light">
    <div class="portlet-title">
        <div class="caption">
            <i class="icon-paper-plane font-green-haze"></i>
            <span class="caption-subject bold font-green-haze uppercase">搜索</span>
            <span class="caption-helper">点击键盘回车按钮或者右侧搜索按钮开始检索</span>
        </div>
        <div class="tools">
            <a href="" class="collapse" data-original-title="" title=""> </a>
        </div>
        <div class="actions">
            <button class="btn btn-primary btn-circle btn-default btn-sm" onclick="tableSearch();"><i class="icon-magnifier"></i> 搜索
            </button>
            <a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title=""
               title=""></a>
        </div>

    </div>
    <div class="portlet-body">

        <div class="form-inline margin-bottom-40" role="form" id="tableParams">
            <input type="hidden" value="module">
            <div class="form-group form-md-line-input has-success">
                <input type="text" class="form-control" name="name" value="${name}" autofocus placeholder="名称">
                <div class="form-control-focus"></div>
            </div>
        </div>

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
            <a class="btn btn-circle btn-icon-only btn-default " href="javascript:loadHash();" title="刷新"><i
                    class="fa fa-refresh"></i></a>
            <a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title=""
               title="全屏"></a>
        </div>
        <div id="paginator" style="padding-right: 20px;"></div>
    </div>
    <div class="table-toolbar">
        <div class="row">
            <div class="col-md-6">

                <div class="btn-group">
                    <a href="javascript:void(0);" class="btn blue" onclick="history.go(-1);">
                        <i class="fa  fa-refresh fa-spin "></i>返回
                    </a>
                    <a href="#module=city/add" class="btn green">
                        添加 <i class="fa fa-plus"></i>
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="btn-group pull-right">
                    <button class="btn btn-danger" onclick="deleteByIds();"> 批量删除 <i
                            class="fa fa-times"></i></button>
                </div>
            </div>
        </div>
    </div>
    <div class="portlet-body table-responsive">

        <table style="width: 100%;" class="table table-striped table-bordered" id="table">
            <thead>
            <tr>
                <th class="table-checkbox">
                    <input type="checkbox" class="group-checkable"/>
                </th>
                <th>ID</th>
                <th>名称</th>
                <th>父级编号</th>
                <th>拼音</th>
                <th>编码</th>
                <th>类型</th>
                <th>特别</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${pageInfo.list}" varStatus="status">
                <tr>
                    <td class="center"><input type="checkbox" class="checkboxes" value="${item.id}"/></td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.parentId}</td>
                    <td>${item.py}</td>
                    <td>${item.code}</td>
                    <td>${item.type}</td>
                    <td>${item.special}</td>
                    <td>
                        <a href="javascript:void(0);" onclick="deleteById('${item.id}')">删除</a>
                        <a href="#module=/city/edit&id=${item.id}">查看\编辑</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- END PAGE TABLE-->

<!-- BEGIN PAGE JAVASCRIPT-->
<script src="/static/js/initList.js"></script>
<script>

    // 当前module
    var module = "city";

    // 分页插件参数
    var pageParam = {
        url: module + "/list",
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

</script>
<!-- END PAGE JAVASCRIPT-->