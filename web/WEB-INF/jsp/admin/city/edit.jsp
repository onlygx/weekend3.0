<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject font-red-sunglo bold uppercase">城市编辑</span>
			<span class="caption-helper">修改城市信息</span>
		</div>
	</div>
	<div class="portlet-body form">
		<!-- BEGIN FORM-->
	<form action="#" class="form-horizontal" id="editForm">
		<div class="form-body">

			<div class="form-group frist">
				<label class="col-md-3 control-label">城市名称</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa  fa-qq"></i>
						<input type="text" class="form-control" required minlength="2" value="${data.name}"  name="name" placeholder="城市名称">
						<input type="hidden" name="id" value="${data.id}">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">城市上级ID</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" required name="parentId"  value="${data.parentId}"  placeholder="城市上级ID">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">城市拼音全拼</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" required name="py"  value="${data.py}"  placeholder="城市拼音全拼">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">城市编号</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" required name="code" value="${data.code}"   placeholder="城市编号">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">城市类型</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" required name="type" value="${data.type}"   placeholder="0：国，1：省，2：市，3：区">
					</div>
				</div>
			</div>

			<div class="form-group last">
				<label class="col-md-3 control-label">特别行政</label>
				<div class="col-md-4">
					<div class="input-icon">
						<i class="fa fa-male"></i>
						<input type="text" class="form-control" required name="special"  value="${data.special}"  placeholder="0：否，1：是">
					</div>
				</div>
			</div>


		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-3 col-md-5">
					<button type="button" class="btn green" onclick="tools.edit('city');">
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


</script>