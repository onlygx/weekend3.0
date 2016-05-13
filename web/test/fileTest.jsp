<%--
  Created by IntelliJ IDEA.
  User: GaoXiang
  Date: 2015/12/21 0021
  Time: 上午 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
    <script src="/static/js/jquery-1.11.3.js"></script>
    <script src="/static/js/jquery-file-upload/js/vendor/jquery.ui.widget.js"></script>
    <script src="/static/js/jquery-file-upload/js/jquery.iframe-transport.js"></script>
    <script src="/static/js/jquery-file-upload/js/jquery.fileupload.js"></script>


</head>
<body>
<button id="fileChoose">文件选择</button>
<input type="file" id="fileupload" name="file" data-url="/admin/file">
<button id="upload">提交测试</button>
<br><br>
提醒：<label id="title">准备完成</label>
<br><br>
进度：<label id="progress"></label>
<br><br>
状态：<label id="show"></label>
</body>
<script >
    $(document).ready(function(){
        $("#resoult").text("准备中。。。");
        $("#fileupload").fileupload({
            autoUpload: true,
            formData:{"name":"gx_test_1"},
            dataType: 'json',
            add: function (e, data) {
                $("#upload").click(function(){
                    $("#show").text("上传中...");
                    data.submit();
                });
            },
            done:function(e,result){

                var data = result.result;
                console.log(data);

            },
            progressall: function (e, data) {//设置上传进度事件的回调函数
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $("#progress").text(progress);
                if(progress == 100){
                    $("#show").text("上传完成");
                }
            }
        });
        $("#resoult").text("准备完毕");
    });
    function save(){

        console.log("upload bigin...");

    }
</script>
</html>
