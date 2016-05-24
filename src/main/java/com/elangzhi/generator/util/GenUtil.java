package com.elangzhi.generator.util;

/**
 * 生成工具工具类
 * Created by GaoXiang
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

    /**
     * 驼峰式命名转下划线
     * @param param
     * @return
     */
    public static String caseToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
