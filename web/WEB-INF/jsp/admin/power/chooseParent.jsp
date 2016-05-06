<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/5 0005
  Time: 下午 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<div id="tree_1" class="tree-demo">
	<ul>
		<li data-jstree='{ "opened" : true ,"icon" : "fa fa-asterisk fa-spin icon-state-info"}' data-id="0" data-name="顶级目录">
			 顶级目录（Root）
			 <ul>
                    <c:forEach var="item" items="${powerList}" varStatus="status">

			 	 	<li data-jstree='{ "icon" : "${item.icon}" }' data-id="${item.id}" data-name="${item.name}">
						${item.name}
						<c:if test="${item.powers.size()>0}">
							<ul>
                                <c:forEach var="item2" items="${item.powers}" varStatus="status2">
									<li data-jstree='{ "icon" : "${item2.icon}" }' data-id="${item2.id}" data-name="${item2.name}">
										${item2.name}
										<c:if test="${item2.powers.size()>0}">
											<ul>
                                                <c:forEach var="item3" items="${item.powers}" varStatus="status3">
													<li data-jstree='{ "icon" : "${item3.icon}" }' data-id="${item3.id}" data-name="${item3.name}">
														${item3.name}
													</li>
                                                </c:forEach>
											</ul>
										</c:if>
									</li>
                                </c:forEach>
							</ul>
						</c:if>
					</li>
                    </c:forEach>
			</ul>
			 
		</li>
	</ul>
</div>

<div>
	<input type="hidden" id="powerDataId">
	<input type="hidden" id="powerDataName">
</div>

<script>
$('#tree_1').jstree({
    "core" : {
        "themes" : {
            "responsive": false
        }            
    },
    "types" : {
        "default" : {
            "icon" : "fa fa-folder icon-state-warning icon-lg"
        },
        "file" : {
            "icon" : "fa fa-file icon-state-warning icon-lg"
        }
    },
    "plugins": ["types"]
});

// handle link clicks in tree nodes(support target="_blank" as well)
$('#tree_1').on('select_node.jstree', function(e,data) { 
    var li = $('#' + data.selected);
    $("#powerDataId").val(li.attr("data-id")) ;
    $("#powerDataName").val(li.attr("data-name")) ;
});

/**
 * 将选择的分类添加到页面
 */
function changeParent(){
	var id = $("#powerDataId").val();
	var name = $("#powerDataName").val();
	if(id != "" && name != ""){
		$("#powerNameShow").html(name);
		$("input[name='parentId']").val(id);
		return true;
	}else{
		tools.tip("您的选择有误，请重新选择；");
		return false;
	}
}
</script>