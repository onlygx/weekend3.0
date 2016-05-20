package com.elangzhi.ssm.controller.util;

import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * 自request对象中获取参数
 * @author GaoXiang
 * @version 1.0
 */
public class ParamMap extends ModelMap {

    /**
     * 获取request中的参数
     * @param request 请求对象
     */
    public ParamMap(HttpServletRequest request){

        //获取参数map 值为 String[] 下面转为String
        Map properties = request.getParameterMap();

        //迭代器
        Iterator entries = properties.entrySet().iterator();

        //预备实体
        Map.Entry entry;

        //预备参数
        String name,value;

        //迭代开始
        while (entries.hasNext()) {

            //获取实体
            entry = (Map.Entry) entries.next();

            //获取key
            name = (String) entry.getKey();

            //判断值类型 并转换成String
            value = checkValueObj(entry.getValue());

            //保存值
            put(name, value);
        }
    }

    /**
     * 验证值类型并转换成String返回
     * @param valueObj value值
     * @return String字符串
     */
    private String checkValueObj(Object valueObj){

        String value = "";
        if(null == valueObj){
            value = "";
        }else if(valueObj instanceof String[]){
            String[] values = (String[])valueObj;
            for(String s : values){
                value += s + ",";
            }
            value = value.substring(0, value.length()-1);
        }else{
            value = valueObj.toString();
        }
        return value;
    }
}
