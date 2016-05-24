<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
User: GaoXiang
Version: 1.0
--%>
<!-- BEGIN PAGE HEADER-->
<div class="page-head">
    <!-- BEGIN PAGE TITLE -->
    <div class="page-title">
        <h1>标签<small> 列表</small></h1>
    </div>
    <!-- END PAGE TITLE -->
</div>
<!-- END PAGE HEADER-->

<!-- BEGIN PAGE TOOLS-->
<!--查询条件示例
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
            <button class="btn btn-primary btn-circle btn-default btn-sm" onclick="tableSearch();"><i class="icon-magnifier"></i> 搜索 </button>
            <a href="javascript:;" class="btn btn-circle btn-default btn-icon-only fullscreen" data-original-title="" title=""></a>
        </div>

    </div>

    <div class="portlet-body">
        <div class="form-inline margin-bottom-40" role="form" id="tableParams">

            <div class="form-group form-md-line-input has-success">
                <input type="text" class="form-control" name="name" value="${name}" autofocus placeholder="名称">
                <div class="form-control-focus"></div>
            </div>

        </div>
    </div>
</div>
-->
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
    <div class="table-toolbar">
        <div class="row">
            <div class="col-md-6">

                <div class="btn-group">
                    <a href="javascript:void(0);" class="btn blue" onclick="history.go(-1);">
                        <i class="fa  fa-refresh fa-spin "></i>返回
                    </a>
                    <a href="#module=label/add" class="btn green">
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
                <th>列：id</th>
                <th>列：name</th>
                <th>列：type</th>
                <th>列：intro</th>
                <th>列：status</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="data" items="${pageInfo.list}" varStatus="status">
                <tr>
                    <td class="center"><input type="checkbox" class="checkboxes" value="${data.id}"/></td>
                    <td>${data.id}</td>
                    <td>${data.name}</td>
                    <td>${data.type}</td>
                    <td>${data.intro}</td>
                    <td>${data.status}</td>
                    <td>
                        <a href="javascript:void(0);" onclick="deleteById('${data.id}')">删除</a>
                        <a href="#module=label/edit&id=${data.id}">查看\编辑</a>
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

    //此参数不可删掉 当前module
    var module = "label";

    //此参数不可删掉 分页插件参数
    var pageParam = {
        url: module + "/list",
        pageSize: ${pageInfo.pageSize},       //每页显示行数 默认10
        currentPage: ${pageInfo.pageNum},     //当前页数
        totalPages: ${pageInfo.pages},        //总页数
        //numberOfPages: 5,                         //显示的页数
    };

    //此参数不可删掉 条件查询参数 有条件查询时添加
    var formParam = {
        /*name: "${name}"*/
    };


    $(document).ready(function () {

        initList();

    });

</script>
<!-- END PAGE JAVASCRIPT-->