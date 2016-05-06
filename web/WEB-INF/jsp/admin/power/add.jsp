<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/5 0005
  Time: 下午 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="portlet light bg-inverse">
    <div class="portlet-title">
        <div class="caption">
            <span class="caption-subject font-red-sunglo bold uppercase">权限添加</span>
            <span class="caption-helper">请先选择父级权限,默认属于超级管理员角色</span>
        </div>
    </div>
    <div class="portlet-body form">
        <!-- BEGIN FORM-->
        <form action="#" class="form-horizontal" id="saveForm">
            <div class="form-body">
                <div class="form-group last">
                    <label class="col-md-3 control-label">父级权限</label>
                    <div class="col-md-4 ">
                        已选择：<span id="powerNameShow" class="form-control-static" style="color:blue;">顶级权限</span>
                        <input type="hidden" name="parentId" value="0">
                        <a class="btn btn-info  pull-right " href="javascript:chooseParent();">选择父级权限</a>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">权限ID</label>
                    <div class="col-md-4">
                        <label style="margin-top:7px;;">${longId}</label>
                        <input type="hidden" name="id" value="${longId}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限名称</label>
                    <div class="col-md-4">
                        <div class="input-icon">
                            <i class="fa  fa-qq"></i>
                            <input type="text" class="form-control input-large" name="name" placeholder="权限名称">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限图标</label>
                    <div class="col-md-9">
                        <div class="input-icon" >
                            <i class="fa  fa-smile-o "></i>
                            <input type="text" class="form-control input-inline input-large" value="fa fa-file icon-state-info icon-lg " name="icon" placeholder="权限图标">
						<span class="help-inline">
						<a class="btn btn-xs qchange change-picon" data-val="fa fa-list-ul icon-state-success"><i class=" fa fa-list-ul icon-state-success "></i> 列表</a>
						<a class="btn btn-xs qchange change-picon" data-val="fa  fa-plus icon-state-info"><i class=" fa  fa-plus icon-state-info "></i> 添加</a>
						<a class="btn btn-xs qchange change-picon" data-val="fa  fa-edit icon-state-warning"><i class=" fa  fa-edit icon-state-warning "></i> 编辑</a>
						<a class="btn btn-xs qchange change-picon" data-val="fa  fa-trash-o icon-state-danger"><i class=" fa  fa-trash-o icon-state-danger "></i> 删除</a>

						</span>
                        </div>

                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限URL</label>
                    <div class="col-md-9">
                        <div class="input-icon">
                            <i class="fa fa-anchor"></i>
                            <input type="text" class="form-control input-inline input-large" name="url" value="javascript:void(0);" placeholder="javascript:void(0);">
						<span class="help-inline" >
							<a class="btn btn-xs qchange change-purl" data-val="#module="><i class="fa fa-ra "></i> 模块URL</a>
							<a class="btn btn-xs qchange change-purl" data-val="javascript:void(0);"><i class="fa fa-ban "></i> void</a>
						</span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限排序</label>
                    <div class="col-md-8">
                        <div class="input-icon">
                            <i class="fa fa-arrows-v"></i>
                            <input type="text" class="form-control input-inline input-large" name="sort" value="0"  placeholder="0">
						<span class="help-inline">
							<a class="btn btn-xs qchange change-porder" data-val=""><i class="fa  fa-ge "></i> 获取</a>
						</span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限简介</label>
                    <div class="col-md-4">
                        <div class="input-icon">
                            <i class="fa fa-book"></i>
                            <input type="text" class="form-control input-large" name="intro"  placeholder="权限简介">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">权限类型</label>
                    <div class="col-md-4">
                        <div class="radio-list">
                            <div class="icheck-inline">
                                <label>
                                    <input type="radio" value="0" name="type" checked class="icheck" data-radio="iradio_flat-green"> 菜单权限 </label>
                                <label>
                                    <input type="radio" value="1" name="type"  class="icheck" data-radio="iradio_flat-green"> 操作权限 </label>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="form-actions"  >
                <div class="row">
                    <div class="col-md-offset-3 col-md-4">
                        <button type="button" class="btn green" onclick="tools.save('power');">
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

        $(".qchange").hide();
        $(".qchange").show("slow");

        $(".change-picon").click(function(){
            var data = $(this).attr("data-val");
            $("input[name='icon']").val(data);

        });

        $(".change-purl").click(function(){
            var data = $(this).attr("data-val");
            $("input[name='url']").val(data);

        });

        $(".change-porder").click(function(){
            var parentId = $("input[name='parentId']").eq(0).val();
            var input = $("input[name='sort']");
            tools.post("/power/countByParentId",{"parentId":parentId},function(data){
                input.val(++data);
            });
        });
    });
</script>