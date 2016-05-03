<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="tree_1" class="tree-demo">
	<ul>
		<li data-jstree='{ "opened" : true ,"icon" : "fa fa-asterisk fa-spin icon-state-info"}' data-id="0" data-name="顶级目录">
			 顶级目录（Root）
			 <ul>
			 	 <s:iterator value="list" var="p1">
			 	 	<li  data-id="${id}" data-name="${name}">
						<a href="#" class="${accountId != null ? 'jstree-clicked' : '' }" title="${intro }">  
                            ${name}
                        </a>  
					</li>
			 	 </s:iterator>
			</ul>
			 
		</li>
	</ul>
</div>

<!-- <ul>
				<li data-jstree='{ "selected" : true ,"icon" : "fa fa-file icon-state-info icon-lg " }'>
					<a href="javascript:;">
						Initially selected
					</a>
				</li>
				<li data-jstree='{ "icon" : "fa fa-briefcase icon-state-info " }'>
					 custom icon URL
				</li>
				<li data-jstree='{ "opened" : true ,"type" : "file" }'>
					 initially open
					<ul>
						<li data-jstree='{ "disabled" : true }'>
							 Disabled Node
						</li>
						<li data-jstree='{ "type" : "file" }' data-id="1234" data-name="哈哈哈">
							 Another node
						</li>
					</ul>
				</li>
				<li data-jstree='{ "icon" : "fa fa-warning icon-state-danger" }'>
					 Custom icon class (bootstrap)
				</li>
			</ul> -->

<script>
$('#tree_1').jstree({
    "core" : {
        "themes" : {
            "responsive": false
        }            
    },
    'plugins': ["checkbox"] 
});


/**
 * 保存选择的信息
 */
function saveSelected(){
	var cate_ids = [];

	//保存选中的
	$("#tree_1 .jstree-clicked").each(function(){  
        var $this = $(this).parent("li");  
        cate_ids.push($this.attr("data-id"));  
    });
	
	tools.action("/admin/changeRole_accountRole",{"id":"${id}","ids":cate_ids.join(",")},function(data){
		if(data.success){
			tools.tip("修改成功！");
		}else{
			var _case = {1:"修改失败，请联系管理员。"};
			tools.errorTip(_case, data.code);
		}
	});
	
}
</script>