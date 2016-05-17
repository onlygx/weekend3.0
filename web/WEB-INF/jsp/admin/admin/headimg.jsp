<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!-- BEGIN FORM-->
<div class="portlet light bg-inverse">
    <div class="portlet-title">
        <div class="caption">
            <span class="caption-subject font-red-sunglo bold uppercase">头像修改</span>
            <span class="caption-helper">必须选取截取范围才能保存头像</span>
        </div>
    </div>
    <div class="portlet-body form">
        <form action="#" class="form-horizontal" id="editForm">
            <div class="form-body">
                <div class="form-group frist">
                    <div class="col-md-4">
                        <h2 style="color:gray;">当前头像</h2>
                        <label style="color:gray;font-size: 12px;">
                            您当前正在使用的头像。
                        </label>
                        <img class="img-thumbnail" id="headImg" alt="我的头像" src="${data.head }"
                             style="width: 200px;height: 200px;">

                    </div>
                    <div class="col-md-6">
                        <h2 style="color:gray;">设置新头像</h2>
                        <label style="color:gray;font-size: 12px;">
                            支持的格式有：jpg;文件最大为3MB;
                        </label>
                        <div>
                            <label>
                                <input type="file" id="fileupload" name="file" class="hide"
                                       style="max-width: 300px;display: inline;">
                                <a href="javascript:void(0)" class="btn btn-primary btn-xsmall" onclick="startUp();">选择文件</a>
                            </label>
                        </div>

                        <img class="img-responsive" id="editImg" alt="预备头像" src="/images/account/no-img.jpg">

                        <br>
                        <div class="row">
                            <div class=" col-md-5">
                                <button type="button" class="btn green" onclick="changeHead();">
                                    <i class="fa  fa-cog fa-spin "></i>提交
                                </button>
                                <button type="button" class="btn default" onclick="history.go(-1);">
                                    <i class="fa  fa-refresh fa-spin "></i>返回
                                </button>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-2 hide" id="cParam">
                        <table>
                            <tr>
                                <td style="text-align: right;">id：</td>
                                <td><input type="text" id="id" name="id" value="${data.id}" class="input-xsmall"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">src：</td>
                                <td><input type="text" id="src" name="src" class="input-xsmall"></td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">x1：</td>
                                <td><input class="imgCutParam" type="text" id="x1" name="x1" class="input-xsmall">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">y1：</td>
                                <td><input class="imgCutParam" type="text" id="y1" name="y1" class="input-xsmall">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">x2：</td>
                                <td><input class="imgCutParam" type="text" id="x2" name="x2" class="input-xsmall">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">y2：</td>
                                <td><input class="imgCutParam" type="text" id="y2" name="y2" class="input-xsmall">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">w：</td>
                                <td><input class="imgCutParam" type="text" id="w" name="w" class="input-xsmall">
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right;">h：</td>
                                <td><input class="imgCutParam" type="text" id="h" name="h" class="input-xsmall">
                                </td>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script>

    var jcrop_api;

    $(document).ready(function () {
        initFileupload();
        setJcrop();
    });

    function setJcrop() {
        $('#editImg').Jcrop({
            aspectRatio: 1 / 1,
            onChange: showCoords,
            onSelect: showCoords,
            onRelease: clearCoords,
            boxWidth: 500
        }, function () {
            // Store the API in the jcrop_api variable
            jcrop_api = this;
            jcrop_api.disable();
        });

        //console.log("图片选择器",jcrop_api);
    }

    /**
     * 设置默认选框
     */
    function setSelected() {
        jcrop_api.setSelect([0, 0, 100, 100]);
    }

    function showCoords(c) {

        $('#x1').val(parseInt(c.x));
        $('#y1').val(parseInt(c.y));
        $('#x2').val(parseInt(c.x2));
        $('#y2').val(parseInt(c.y2));
        $('#w').val(parseInt(c.w));
        $('#h').val(parseInt(c.h));
    }
    ;

    function clearCoords() {
        $('input .imgCutParam').val('');
    }
    ;

    function removeJcrop() {
        jcrop_api.destroy();
        jcrop_api = undefined;
    }

    /**
     * 初始化文件控件
     */
    function initFileupload() {
        //console.log("开始上传");
        $('#fileupload').fileupload({
            url: '/file/uploadTempImage',
            formData: {},//如果需要额外添加参数可以在这里添加
            dataType: 'json',
            addClass: "img-thumbnail",
            done: function (e, result) {
                //done方法就是上传完毕的回调函数，其他回调函数可以自行查看api
                //注意result要和jquery的ajax的data参数区分，这个对象包含了整个请求信息
                //返回的数据在result.result中
                var data = result.result;
                if (data.success) {
                    $("#src").val(data.data);
                    imgUrl = "/image/showTempImg?src=" + data.data;
                    jcrop_api.setImage(imgUrl);
                    jcrop_api.enable();
                    //设置默认选框
                    setSelected();
                } else {
                    var _case = {
                        1: "请选择图片！",
                        2: "仅支持\".jpg\"格式的图片！",
                        3: "文件大小超过限制！"
                    };
                    tools.errorTip(_case, data.code);
                }

            }
        });
    }

    function changeHead() {

        if ($('#w').val() == "" || $('#h').val() == "") {
            tools.tip("请选择截取范围！");
            return;
        }

        var param = tools.formParams("cParam");

        tools.post("/admin/changeHead", param, function (data) {
            if (data.success) {
                try {
                    $("#headImg").attr("src","/image/showImg?src=" + data.data);
                    $("#myHeadImg").attr("src","/image/showImg?src=" + data.data);
                }catch (e){

                }

                tools.tip("修改成功！");
                jcrop_api.release();
            } else {
                var _case = {
                    1: "请选择图片！",
                    2: "请选择截取范围！",
                    3: "剪裁失败！请检查文件格式！",
                    4: "修改失败！"
                };
                tools.errorTip(_case, data.code);
            }
        })

    }


    function startUp() {
        fileupload.click();
    }
</script>



	
	