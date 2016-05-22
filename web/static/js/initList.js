

function initList(){

    // 初始化分页插件
    initPaginator();

    //全选
    $(".group-checkable").click(function(){
        var group = $(this);
        $('#table').find(".checkboxes").each(function(){
            var isCheck = group.is(":checked");
            $(this).prop('checked',isCheck);
            isCheck ? $(this).parents('tr').addClass("active") : $(this).parents('tr').removeClass("active");
        });
    });

    //选择一行
    $(".checkboxes").click(function(){
        var isCheck = $(this).is(":checked");
        isCheck ? $(this).parents('tr').addClass("active") : $(this).parents('tr').removeClass("active");
    });

    //点击每一行空白处
    $("#table tbody tr").click(function(e){

        var targetElement = e.srcElement.nodeName;
        var isInput = targetElement == "INPUT";
        //如果是checkbook标签 则不执行以下内容（和自身点击事件冲突）
        if(!isInput){
            var checkbox = $(this).find(".checkboxes").eq(0);
            var isCheck = checkbox.is(":checked");
            if(isCheck){
                checkbox.prop('checked',false);
                $(this).removeClass("active");
            }else{
                checkbox.prop('checked',true);
                $(this).addClass("active");
            }
        }

    });
}

/**
 * 初始化分页插件
 */
function initPaginator(){

    var option = getPaginatorOption(pageParam,formParam);

    $('#paginator').bootstrapPaginator(option);

}

/**
 * 获取分页插件参数
 * @param _param
 * @param _formParam
 * @returns
 * {
 *      {
 *      currentPage: *,
 *      totalPages: *,
 *      numberOfPages: *,
 *      itemTexts: options.itemTexts,
 *      onPageClicked: options.onPageClicked
 *      }
 * }
 */
function getPaginatorOption(_param,_formParam){

    var pageSize = _param.pageSize == undefined ? 10 : _param.pageSize;                     //每页显示行数 默认10
    var currentPage = _param.currentPage == undefined ? 1 : _param.currentPage;             //当前页数 默认1
    var totalPages = _param.totalPages == undefined ? 1 : _param.totalPages;                //总页数 默认1
    var numberOfPages = _param.numberOfPages == undefined ? 8 : _param.numberOfPages;      //显示的页数 默认10

    if(currentPage > totalPages){
        totalPages++;
    }

    var options = {
        currentPage: currentPage,
        totalPages: totalPages,
        numberOfPages: numberOfPages,
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        },
        onPageClicked: function (event, originalEvent, type, page) {
            var url = _param.url + "/" + page ;

            if(pageSize != 10){
                url += "/" + pageSize ;
            }

            tools.post(url,_formParam,function(data){
                tools.setMain(data);
            });
        }
    };
    return options;
}

//搜索按钮
function tableSearch() {

    var param = tools.formParams("tableParams");
    var url = module + "/list/1/" + pageParam.pageSize;

    tools.post(url,param,function(data){
        tools.setMain(data);
    });

}



/**
 * 给列表页面绑定回车搜索事件。
 */
$("#tableParams").keydown(function (event) {

    if (event.keyCode == 13) {

        tableSearch();
    }
});

/**
 * 删除单个
 * @param _id 要删除的id
 */
function deleteById(_id){
    var state;
    art.confirm("确定删除么？",function() {
        tools.post(module + "/delete", {"id": _id}, function (data) {
            state = data.success;
            if (data.success) {
                art.tip("删除成功", 500, function () {
                    loadHash();
                });
            }else{
                tools.tip("删除失败！错误代号："+data.code,1000,null,"danger");
            }
        });
    });
    return state;
}

/**
 * 获取勾选了多少
 * @param _tableId
 * @returns {Array}
 */
function getIds(_tableId){
    var checks = $('#'+_tableId).find(".checkboxes:checked");
    var ids = new Array();
    checks.each(function(){
        ids.push($(this).val());
    });
    return ids;
}


/**
 * 批量删除
 */
function deleteByIds(){
    var ids = getIds("table");
    if(ids.length == 0){
        tools.tip("请先选择要删除的条目！",1000,null,"danger");
        return;
    }
    art.confirm("确定删除选中信息么？",function(){
        tools.post(module + "/deleteByIds",{"ids":ids.join(",")},function(data){
            if(data.success){
                tools.tip("批量删除成功。",null,function(){
                    loadHash();
                });
            }else{
                tools.tip("批量删除败！错误代号："+data.code,1000,null,"danger");
            }
        });
    });
}
