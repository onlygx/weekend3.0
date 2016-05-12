<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="/static/metronic/plugins/respond.min.js"></script>
<script src="/static/metronic/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="/static/js/jquery-1.12.3.js"></script>
<script src="/static/bootstrap/bootstrap.min.js"></script>
<script src="/static/metronic/plugins/jquery-migrate.min.js"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="/static/metronic/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="/static/metronic/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>
<script src="/static/metronic/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/metronic/plugins/jquery.blockui.min.js"></script>
<script src="/static/metronic/plugins/jquery.cokie.min.js"></script>
<script src="/static/metronic/plugins/uniform/jquery.uniform.min.js"></script>
<script src="/static/metronic/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="/static/metronic/plugins/bootbox/bootbox.min.js" ></script>
<script src="/static/metronic/plugins/bootstrap-growl/jquery.bootstrap-growl.min.js"></script>
<script src="/static/metronic/plugins/select2/select2.min.js"></script>
<script src="/static/metronic/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="/static/metronic/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script src="/static/metronic/plugins/icheck/icheck.min.js"></script>
<script src="/static/metronic/plugins/jstree/dist/jstree.min.js"></script>
<script src="/static/metronic/plugins/jcrop/js/jquery.color.js"></script>
<script src="/static/metronic/plugins/jcrop/js/jquery.Jcrop.min.js"></script>
<script src="/static/metronic/plugins/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
<script src="/static/metronic/plugins/jquery-file-upload/js/jquery.iframe-transport.js"></script>
<script src="/static/metronic/plugins/jquery-file-upload/js/jquery.fileupload.js"></script>
<script src="/static/metronic/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>

<script src="/static/bootstrap-paginator/bootstrap-paginator.js"></script>
<script src="/static/js/jquery-validate/jquery.validate.js"></script>
<script src="/static/js/jquery-validate/messages_zh.js"></script>

<script src="/static/metronic/js/metronic.js"></script>
<script src="/static/metronic/layout/scripts/layout.js"></script>
<script src="/static/metronic/layout/scripts/demo.js"></script>

<%--<script src="/static/metronic/layout/scripts/quick-sidebar.js"></script>--%>

<script src="/static/js/art.js"></script>
<script src="/static/js/tools.js"></script>
<script src="/static/js/initHash.js"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<%--
<script src="http://api.map.baidu.com/api?v=1.5&ak=gUGWEoHlmaYzbQWTY83hhD8t" type="text/javascript"></script>--%>
<script>
$(document).ready(function() {    
	
	initPage();

});

function initPage(){
    Metronic.init(); // init metronic core componets
    Layout.init(); // init layout
    Demo.init();
/*    QuickSidebar.init(); // init quick sidebar
    Demo.init(); // init demo features*/

}
</script>
<!-- END JAVASCRIPTS -->
