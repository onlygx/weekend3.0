package com.elangzhi.generator.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据模型创建工具类
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class DataModuleBuild {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * 创建基本数据模板
     * @param moduleName
     * @param clazz
     * @return
     */
    public static Map createBaseDataModle(String moduleName,Class clazz) {
        String className = clazz.getSimpleName();

        //生成需要的参数
        String lower = GenUtil.LowStr(className);
        String upper = GenUtil.UpStr(className);

        Map root = new HashMap();
        root.put("dateTime", sdf.format(new Date()));
        root.put("modelName", moduleName);
        root.put("lower", lower);
        root.put("upper", upper);
        root.put("modelPackage", Path.modelImport + upper);
        root.put("servicePackage", Path.servicesImport + upper + "Service");
        root.put("daoPackage", Path.daoImport + upper + "Dao");
        return root;
    }

    /**
     * 创建Mapper数据模板
     * @param moduleName
     * @param clazz
     * @return
     */
    public static Map createMapperDataModle(String moduleName,Class clazz) {
        String className = clazz.getSimpleName();

        //生成需要的参数
        String lower = GenUtil.LowStr(className);
        String upper = GenUtil.UpStr(className);

        Map root = new HashMap();
        root.put("dateTime", sdf.format(new Date()));
        root.put("modelName", moduleName);
        root.put("lower", lower);
        root.put("upper", upper);
        root.put("modelPackage", Path.modelImport + upper);
        root.put("servicePackage", Path.servicesImport + upper + "Service");
        root.put("daoPackage", Path.daoImport + upper + "Dao");
        return root;
    }


}
