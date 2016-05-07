<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2016/5/6 0006
  Time: 下午 12:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
    <div class="portlet-title">
        <div class="caption">
            <span class="caption-subject font-red-sunglo bold uppercase">权限编辑</span>
            <span class="caption-helper">不要乱选父级权限</span>
        </div>
    </div>
    <div class="portlet-body form">
        <!-- BEGIN FORM-->
        <form action="#" class="form-horizontal" id="editForm">
            <div class="form-body">
                <div class="form-group last">
                    <label class="col-md-3 control-label">父级权限</label>
                    <div class="col-md-5">
                        已选择：<span id="powerNameShow" class="form-control-static" style="color:blue;">隐藏(编号：${data.parentId })</span>
                        <input type="hidden" name="parentId" value="${data.parentId }">
                        <a class="btn btn-info  pull-right" href="javascript:chooseParent();">选择父级权限</a>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限ID</label>
                    <div class="col-md-4">
                        <label style="margin-top:7px;;">${data.id }</label>
                        <input type="hidden" name="id" value="${data.id }">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限名称</label>
                    <div class="col-md-5">
                        <div class="input-icon">
                            <i class="fa  fa-qq"></i>
                            <input type="text" class="form-control" value="${data.name }" name="name" placeholder="权限名称">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限图标</label>
                    <div class="col-md-5">
                        <div class="input-icon">
                            <i class="fa  fa-smile-o "></i>
                            <input type="text" class="form-control" value="${data.icon }"  name="icon" placeholder="权限图标">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限URL</label>
                    <div class="col-md-5">
                        <div class="input-icon">
                            <i class="fa fa-anchor"></i>
                            <input type="text" class="form-control" value="${data.url }"  name="url"  placeholder="javascript:void(0);">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限排序</label>
                    <div class="col-md-5">
                        <div class="input-icon">
                            <i class="fa fa-arrows-v"></i>
                            <input type="text" class="form-control" value="${data.sort }"  name="sort"  placeholder="0">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限简介</label>
                    <div class="col-md-5">
                        <div class="input-icon">
                            <i class="fa fa-book"></i>
                            <input type="text" class="form-control" value="${data.intro }"  name="intro"  placeholder="权限简介">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限类型</label>
                    <div class="col-md-5">
                        <div class="radio-list">
                            <div class="icheck-inline">
                                <label>
                                    <input type="radio" value="0" name="type" ${data.type==0?"checked":"" } class="icheck" data-radio="iradio_flat-green"> 菜单权限 </label>
                                <label>
                                    <input type="radio" value="1" name="type" ${data.type==1?"checked":"" } class="icheck" data-radio="iradio_flat-green"> 操作权限 </label>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="form-actions">
                <div class="row">
                    <div class="col-md-offset-3 col-md-5">
                        <button type="button" class="btn green" onclick="tools.edit('power');">
                            <i class="fa  fa-cog fa-spin "></i>提交</button>
                        <button type="button" class="btn default" onclick="history.go(-1);">
                            <i class="fa  fa-refresh fa-spin "></i>返回</button>
                    </div>
                </div>
            </div>
        </form>
        <!-- END FORM-->
    </div>
</div>
<script>


    /**
     * 选择父级权限
     */
    function chooseParent(){
        var div = $("<div style=\"height:450px;overflow: scroll;\">").load("/power/listAll?parentId=0");
        art.dialog("选择父级分类 (请选择)",div,function(){
            return changeParent();
        });
    }

    $(document).ready(function(){

        $(".icheck").iCheck({
            checkboxClass: "icheckbox_minimal",
            radioClass: "iradio_flat-green"
        });
    });
</script>
