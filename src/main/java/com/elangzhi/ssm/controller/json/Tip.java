package com.elangzhi.ssm.controller.json;

public class Tip {

    /**
     * 状态：
     * true or false
     */
	Boolean success;

    /**
     * 处理状态标识
     * -1 服务器拒绝访问/未登录
     * 0 暂未定义
     * 1 错误1
     * 2 错误2
     * ...
     */
    Integer code;

    /**
     * 需要返回的数据，可以是任何对象
     */
    Object data;

    /**
     * 默认为 true
     */
    public Tip(){
        this.success = true;
    }

    /**
     * 操作成功，并携带一段数据
     */
    public Tip(Object data){
        this.success = true;
        this.data = data;
    }

    /**
     * 返回错误，并标识错误代码
     * @param code
     */
    public Tip(Integer code){
        this.success = false;
        this.code = code;
    }

    /**
     * 返回指定标识错误，并携带一段数据；
     * @param code
     * @param data
     */
    public Tip(Integer code,Object data){
        this.success = false;
        this.code = code;
        this.data = data;
    }
}
