package com.elangzhi.generator.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 数据模型创建工具类
 * Created by GaoXiang
 */
public class DataModuleBuild {

    /**
     * 创建基本数据模板
     * @param moduleName 模块名字
     * @param clazz 模块类
     * @return Map数据模板
     */
    public static Map createBaseDataModle(String moduleName,Class clazz) {
        String className = clazz.getSimpleName();

        //生成需要的参数
        String lower = GenUtil.LowStr(className);
        String upper = GenUtil.UpStr(className);

        Map<String,Object> root = new HashMap<>();
        root.put("modelName", moduleName);
        root.put("lower", lower);
        root.put("upper", upper);
        root.put("modelPackage", Path.modelImport + upper);
        root.put("servicePackage", Path.getServicesImport() + upper + "Service");
        root.put("daoPackage", Path.getDaoImport() + upper + "Dao");
        return root;
    }

    /**
     * 创建Mapper数据模板
     * @param moduleName 模块名字
     * @param clazz 模块类
     * @return Map数据模板
     */
    public static Map createMapperDataModle(String moduleName,Class clazz) {

        Field[] fields = clazz.getDeclaredFields();

        String className = clazz.getSimpleName();

        //生成需要的参数
        //String lower = GenUtil.LowStr(className);
        String upper = GenUtil.UpStr(className);

        Map<String,Object> root = new HashMap<>();
        root.put("modelName", moduleName);
        root.put("tableName", "t"+GenUtil.caseToUnderline(upper));
        root.put("upper", upper);
        root.put("modelPackage", Path.modelImport + upper);

        //加载所有列
        List<ModelField> fieldList = new ArrayList<>();
        ModelField modelField;
        for(Field field : fields){
            modelField = new ModelField();
            modelField.setName(field.getName());
            modelField.setNameParam("#{" + field.getName() + "}");
            modelField.setUnder(GenUtil.caseToUnderline(field.getName()));
            fieldList.add(modelField);
        }
        root.put("fieldList", fieldList);
        return root;
    }

    /**
     * 创建Jsp数据模板
     * @param moduleName 模块名字
     * @param clazz 模块类
     * @return Map数据模板
     */
    public static Map createJspDataModle(String moduleName,Class clazz) {

        Field[] fields = clazz.getDeclaredFields();

        String className = clazz.getSimpleName();

        //生成需要的参数
        String lower = GenUtil.LowStr(className);
        String upper = GenUtil.UpStr(className);

        Map<String,Object> root = new HashMap<>();
        root.put("modelName", moduleName);
        root.put("lower", lower);
        root.put("upper", upper);

        //加载所有列
        List<ModelField> fieldList = new ArrayList<>();
        ModelField modelField;
        for(Field field : fields){
            modelField = new ModelField();
            modelField.setName(field.getName());
            modelField.setNameParam("${data." + field.getName() + "}");
            fieldList.add(modelField);
        }
        root.put("fieldList", fieldList);
        return root;
    }

}
