package com.elangzhi.generator.util;

/**
 * 代码生成路径
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Path {

    //保存路径
    public static final String savePath = "d:/javaSource";

    //项目根路径
    public static final String sysDir = System.getProperty("user.dir");

    //基本路径
    public static final String home = savePath + "/src/main";
    public static final String code = home + "/java/com/elangzhi/ssm";
    public static final String resources = home + "/resources";
    public static final String jsp = home + "/web/WEB-INF/jsp/admin";

    //生成java文件和mybatis映射xml文件路径
    public static final String controllerPkg = code + "/controller";
    public static final String servicesPkg = code + "/services";
    public static final String daoPkg = code + "/dao";
    public static final String mapperPkg = resources + "/mapper";

    //模板文件夹路径 需要先获取
    public static final String ftlPath = sysDir + "/src/main/java/com/elangzhi/generator/template";

    //模板路径
    public static final String controllerFtl = "ControllerTemplate.ftl";
    public static final String servicesFtl = "ServicesTemplate.ftl";
    public static final String daoFtl = "DaoTemplate.ftl";
    public static final String mapperFtl = "MapperTemplate.ftl";


    //包路径
    public static final String modelImport = "com.elangzhi.ssm.model.";
    public static final String controllerImport = "com.elangzhi.ssm.controller.";
    public static final String daoImport = "com.elangzhi.ssm.dao.";
    public static final String servicesImport = "com.elangzhi.ssm.services.";

}
