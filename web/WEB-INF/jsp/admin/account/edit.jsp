<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">密码修改</span>
			<span class="caption-helper">请谨慎修改</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="editForm">
		<div class="form-body">

			<div class="form-group frist">
				<label class="col-md-3 control-label">用户名</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="hidden" name="id" value="${data.id }">
						<input type="text" class="form-control" disabled name="userName" value="${data.userName }" placeholder="用户名">
					</div>
				</div>
			</div>

			<div class="form-group ">
				<label class="col-md-3 control-label">输入新密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" required minlength="6"  id="rePassword" value="" placeholder="新密码">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">再次输入新密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control"  required equalTo="#rePassword" name="password" value="" placeholder="再次输入新密码">
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
<script src="/static/js/jquery.md5.js"></script>
<script>

	$("#editForm").validate();

function edit(){

	//加密
	var pwd = $("input[name='password']").eq(0);
	if(pwd.val().trim().length == 0){
		$("#editForm").valid()
		return;
	}
	var md5 = $.md5(pwd.val());
	pwd.val(md5);
	$("#rePassword").val(md5);

	var success = tools.edit("account");

	if(success){
		window.location.href="/login/loginPage";
	}

}

</script>