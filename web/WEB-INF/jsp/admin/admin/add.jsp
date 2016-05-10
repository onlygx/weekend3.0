<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">管理员添加</span>
			<span class="caption-helper">添加一个权限为空的管理员（只能看主页），记得手动授权</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="saveForm">
		<div class="form-body">

			<div class="form-group frist">
				<label class="col-md-3 control-label">用户名</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="text" class="form-control" required minlength="5" name="userName" placeholder="用户名">
						<input type="hidden" name="head" value="/images/account/default_head.jpg">
						<input type="hidden" name="id" value="${longId}">
					</div>
				</div>
			</div>

			<div class="form-group ">
				<label class="col-md-3 control-label">请输入密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" required minlength="6"  id="rePassword" placeholder="密码">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">再次输入密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control"  required equalTo="#rePassword" name="password"  placeholder="再次输入密码">
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

<script src="/static/js/jquery.md5.js"></script>
<script>


$("#saveForm").validate();


function save(){

	//加密
	var pwd = $("input[name='password']").eq(0);
	if(pwd.val().trim().length == 0){
		$("#saveForm").valid()
		return;
	}
	var md5 = $.md5(pwd.val());
	pwd.val(md5);
	$("#rePassword").val(md5);

	//提交
    tools.save("admin");

	//清空密码
	$("input[name='password']").val("");
	$("#rePassword").val("");

}

</script>