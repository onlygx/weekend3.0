<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">管理员添加</span>
			<span class="caption-helper">用户名称和密码是必填项</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="saveForm">
		<div class="form-body">

			<div class="form-group frist">
				<label class="col-md-3 control-label">用户姓名</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="text" class="form-control" name="name" placeholder="用户姓名">
						<input type="hidden" name="head" value="/images/account/defaultHead.jpg">
						<input type="hidden" name="id" value="${longId}">
						<input type="hidden" name="account.id" value="${longId+1}">
					</div>
				</div>
			</div>
			
			<div class="form-group last">
				<label class="col-md-3 control-label">用户账号</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" name="userName"  placeholder="用户账号">
					</div>
				</div>
			</div>
			
			<div class="form-group last">
				<label class="col-md-3 control-label">用户密码</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" name="password"  placeholder="用户密码">
					</div>
				</div>
			</div>
						
			<div class="form-group last">
				<label class="col-md-3 control-label">用户邮箱</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-hdd-o"></i>
						<input type="text" class="form-control" name="email"  placeholder="邮箱">
					</div>
				</div>
			</div>
									
			<div class="form-group last">
				<label class="col-md-3 control-label">用户电话</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-mobile-phone "></i>
						<input type="text" class="form-control" name="phone"  placeholder="电话">
					</div>
				</div>
			</div>
									
			<div class="form-group last">
				<label class="col-md-3 control-label">用户地址</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-home"></i>
						<input type="text" class="form-control" name="address"  placeholder="地址">
					</div>
				</div>
			</div>
													
			<div class="form-group last">
				<label class="col-md-3 control-label">用户身份证</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-smile-o"></i>
						<input type="text" class="form-control" name="idCard"  placeholder="身份证">
					</div>
				</div>
			</div>
								
			<div class="form-group last">
				<label class="col-md-3 control-label">用户性别</label>
				<div class="col-md-4">
					<div class="radio-list">
						<div class="icheck-inline">
							<label>
							<input type="radio" value="1" name="sex" checked class="icheck" data-radio="iradio_flat-green"> 男 </label>
							<label>
							<input type="radio" value="0" name="sex"  class="icheck" data-radio="iradio_flat-green"> 女 </label>
						</div>
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
function save(){
	var param = tools.formParams("saveForm");

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

    tools.save("admin");

    $("input[name='password']").val("");
}

$(document).ready(function(){
	$(".icheck").iCheck({
        checkboxClass: "icheckbox_minimal",
        radioClass: "iradio_flat-green"
    });
});

</script>