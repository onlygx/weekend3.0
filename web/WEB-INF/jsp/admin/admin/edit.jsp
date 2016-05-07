<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">用户编辑</span>
			<span class="caption-helper">用户名称和密码是必填项</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="editForm">
		<div class="form-body">
			
			<div class="form-group frist">
				<label class="col-md-3 control-label">用户姓名</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="hidden" name="id" value="${data.id }">
						<input type="hidden" name="head" value="${data.head }">
						<input type="text" class="form-control" name="name" value="${data.name }" placeholder="用户姓名">
					</div>
				</div>
			</div>
			
			<div class="form-group last">
				<label class="col-md-3 control-label">用户账号</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="hidden" name="account.id" value="${account.id }">
						<input type="text" class="form-control" name="account.username" value="${account.username }"  placeholder="用户账号">
					</div>
				</div>
			</div>
			
			<div class="form-group last">
				<label class="col-md-3 control-label">用户密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" name="account.password" value="${account.password }"  placeholder="用户密码">
					</div>
				</div>
			</div>
						
			<div class="form-group last">
				<label class="col-md-3 control-label">用户邮箱</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-hdd-o"></i>
						<input type="text" class="form-control" name="email" value="${data.email }"  placeholder="邮箱">
					</div>
				</div>
			</div>
									
			<div class="form-group last">
				<label class="col-md-3 control-label">用户电话</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-mobile-phone "></i>
						<input type="text" class="form-control" name="phone" value="${data.phone }"  placeholder="电话">
					</div>
				</div>
			</div>
									
			<div class="form-group last">
				<label class="col-md-3 control-label">用户地址</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-home"></i>
						<input type="text" class="form-control" name="address" value="${data.address }"  placeholder="用户地址">
					</div>
				</div>
			</div>
													
			<div class="form-group last">
				<label class="col-md-3 control-label">用户身份证</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-smile-o"></i>
						<input type="text" class="form-control" name="idCard" value="${data.idCard }"  placeholder="身份证">
					</div>
				</div>
			</div>
							
			<div class="form-group last">
				<label class="col-md-3 control-label">用户性别</label>
				<div class="col-md-4">
					<div class="radio-list"> 
						<div class="icheck-inline">
							<label>
							<input type="radio" value="1" name="sex" ${data.sex==1?"checked":"" }  class="icheck" data-radio="iradio_flat-green"> 男 </label>
							<label>
							<input type="radio" value="0" name="sex" ${data.sex==0?"checked":"" }  class="icheck" data-radio="iradio_flat-green"> 女 </label>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-3 col-md-5">
					<button type="button" class="btn green" onclick="edit();">
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
function edit(){

	var param = tools.formParams("editForm");

	if(param["name"] == "" || param["name"] == null){
		tools.tip("请输入姓名");
		return null;
	}
	if(param["userName"] == "" || param["userName"] == null){
		tools.tip("请输入用户名");
		return null;
	}
	if(param["password"] == "" || param["password"] == null){
		tools.tip("请输入密码");
		return null;
	}

	$("input[name='password']").val($.md5(param["password"]));
	tools.edit("admin");
	var param = tools.formParams("editForm");
}

$(document).ready(function(){
	$(".icheck").iCheck({
        checkboxClass: "icheckbox_minimal",
        radioClass: "iradio_flat-green"
    });
});
</script>