package com.elangzhi.generator.util;

/**
 * 生成工具工具类
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class GenUtil {

    /**
     * 首字母转大写
     * @param str
     * @return
     */
    public static String UpStr(String str){
        return str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase()) ;
    }


    /**
     * 首字母转小写
     * @param str
     * @return
     */
    public static String LowStr(String str){
        return str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toLowerCase()) ;
    }

}
