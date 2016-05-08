<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">角色添加</span>
			<span class="caption-helper">不要给普通角色过分授权</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="saveForm">
		<div class="form-body">

			<div class="form-group frist">
				<label class="col-md-3 control-label">角色名称</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="text" class="form-control" name="name" placeholder="角色名称">
						<input type="hidden" name="id" value="${longId}">
					</div>
				</div>
			</div>
			
			<div class="form-group last">
				<label class="col-md-3 control-label">角色备注</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" name="intro"  placeholder="角色备注">
					</div>
				</div>
			</div>


		</div>

		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-3 col-md-4">
					<button type="button" class="btn green" onclick="save();">
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
function save(){
	var param = tools.formParams("saveForm");

	if(param["name"] == "" || param["name"] == null){
		tools.tip("请输入名称");
		return null;
	}

    tools.save("role");
}

</script>