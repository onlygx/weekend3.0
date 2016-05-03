<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- BEGIN PAGE HEADER-->
<h3 class="page-title">
系统用户列表
</h3>

<div class="page-bar">
	<ul class="page-breadcrumb">
		<li>
			<i class="fa fa-home"></i>
			<a href="javascript:void(0);">主页</a>
			<i class="fa fa-angle-right"></i>
		</li>
		<li>
			<a href="#">用户管理</a>
		</li>
	</ul>
</div>
<!-- END PAGE HEADER-->
<div class="table-toolbar">
	<div class="row">
		<div class="col-md-6">

			<div class="btn-group">
				<a href="javascript:void(0);" class="btn blue" onclick="history.go(-1);">
					<i class="fa  fa-refresh fa-spin "></i>返回
				</a>
				<a href="#module=admin/add" class="btn green">
					添加  <i class="fa fa-plus"></i>
				</a>
			</div>
		</div>
		<div class="col-md-6">
			<div class="btn-group pull-right">
				<button class="btn btn-danger" onclick="deleteAll();" > 批量删除 <i class="fa fa-times"></i></button>
			</div>
		</div>
	</div>
</div>
<table class="table table-striped table-bordered table-hover" id="dataTable">
<thead>
<tr>
	<th class="table-checkbox">
		<input type="checkbox" class="group-checkable" />
	</th>
	<th>
		 编号
	</th>
	<th >
		 用户名
	</th>
	<th >
		 姓名
	</th>
	<th>
		 联系方式
	</th>
	<th>
		 授权
	</th>
	<th>
		 查看/编辑
	</th>
</tr>
</thead>
<tbody>
<s:iterator value="list">
	<tr class="odd gradeX">
		<td class="center"><input type="checkbox" class="checkboxes" value="${id }"/></td>
		<td class="center"><s:property value="id"/></td>
		<td class="center">
		<s:property value="username"/>
		</td>
		<td class="center">
		<a  style="color: blue;" href="javascript:void(0);"><s:property value="name"/></a>
		</td>
		<td class="center">${phone } </td>
		<td class="center">
			<a style="color: green;"  href="javascript:changeRole('${account.id}');"> 授权</a>
		</td>
		<td class="center">
			<a style="color: green;"  href="#module=admin/edit&action=find_admin&id=${id }">查看/编辑</a>
		</td>
	</tr>
</s:iterator>

</tbody>
</table>
<script src="/admin/js/listMethod.js"></script>
<script type="text/javascript">


function changeRole(id){

	var div = $("<div style=\"height:450px;overflow: scroll;\">").load("/admin/findAll_role?id="+id+"&path=/admin/admin/chooseRole.jsp");

	art.dialog("选择此用户拥有的角色 (请打钩并确定)",div,function(){
		return saveSelected();
	});
}

function deleteAll(){
	var ids = "";
	$('#dataTable').find(".checkboxes").each(function(){
		var isCheck = $(this).is(":checked");
		if(isCheck){
			ids+=","+$(this).val();
		}
	});
	ids = ids.substring(1);
	art.confirm("确定删除选中信息么？",function(){
		tools.action("/admin/deleteByIds_admin",{"ids":ids},function(data){
			if(data.success){
				tools.tip("删除成功。",null,function(){
					loadHash();
				});
			} 
		});
	});
}
</script>
