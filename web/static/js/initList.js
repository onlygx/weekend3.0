

function initList(){

    // 初始化分页插件
    initPaginator();



    $(".group-checkable").click(function(){
        var group = $(this);
        $('#table').find(".checkboxes").each(function(){
            var isCheck = group.is(":checked");
            $(this).prop('checked',isCheck);
            isCheck ? $(this).parents('tr').addClass("active") : $(this).parents('tr').removeClass("active");
        });
    });

    $(".checkboxes").click(function(){
        var isCheck = $(this).is(":checked");
        isCheck ? $(this).parents('tr').addClass("active") : $(this).parents('tr').removeClass("active");
    });

    $("#table tr").click(function(){
        var checkbox = $(this).find(".checkboxes").eq(0);
        var isCheck = checkbox.is(":checked");
        if(isCheck){
            checkbox.prop('checked',false);
            $(this).removeClass("active");
        }else{
            checkbox.prop('checked',true);
            $(this).addClass("active");
        }

    });
}


function initPaginator(){

    var option = getPaginatorOption(pageParam,formParam);

    $('#paginator').bootstrapPaginator(option);;

}


function getPaginatorOption(_param,_formParam){

    var pageSize = _param.pageSize == undefined ? 10 : _param.pageSize;                     //每页显示行数 默认10
    var currentPage = _param.currentPage == undefined ? 1 : _param.currentPage;             //当前页数 默认1
    var totalPages = _param.totalPages == undefined ? 1 : _param.totalPages;                //总页数 默认1
    var numberOfPages = _param.numberOfPages == undefined ? 10 : _param.numberOfPages;      //显示的页数 默认10

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

            for(var paramKey in _formParam){
                url += "&" + paramKey;
                url += "=" + _formParam[paramKey];
            }

            window.location.hash = "#module="+url;
        }
    };
    return options;
}
