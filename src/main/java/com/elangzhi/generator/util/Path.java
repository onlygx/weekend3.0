package com.elangzhi.generator.util;

/**
 * 代码生成路径
 * Created by GaoXiang on 2016/5/19 0019.
 */
public class Path {

    //默认模块
    public static String defaultModule = "ssm";

    //保存路径
    private static final String savePath = "d:/javaSource";

    //项目根路径
    private static final String sysDir = System.getProperty("user.dir");

    //基本路径
    private static final String home = savePath + "/src/main";
    private static final String code = home + "/java/com/elangzhi";
    private static final String resources = home + "/resources";
    private static final String jsp = home + "/web/WEB-INF/jsp/admin";

    //生成java文件和mybatis映射xml文件路径
    private String controllerPkg ;
    private String servicesPkg;
    private String daoPkg;
    private String mapperPkg ;
    private String jspPkg ;

    //模板文件夹路径 需要先获取
    public static final String ftlPath = sysDir + "/src/main/java/com/elangzhi/generator/template";

    //模板路径
    public static final String controllerFtl = "ControllerTemplate.ftl";
    public static final String servicesFtl = "ServicesTemplate.ftl";
    public static final String daoFtl = "DaoTemplate.ftl";
    public static final String mapperFtl = "MapperTemplate.ftl";
    public static final String addJspFtl = "AddJspTemplate.ftl";
    public static final String listJspFtl = "ListJspTemplate.ftl";
    public static final String editJspFtl = "EditJspTemplate.ftl";

    //包路径
    private static final String baseImport = "com.elangzhi.";
    public static final String modelImport = baseImport + "ssm.model.";
    private String daoImport;
    private String servicesImport;


    private static String getDefaultModule() {
        return defaultModule;
    }

    public static String getControllerPkg() {
        return code + "/" + getDefaultModule() + "/controller";
    }

    public static String getServicesPkg() {
        return  code + "/" + getDefaultModule() + "/services";
    }

    public static String getDaoPkg() {
        return  code + "/" + getDefaultModule() + "/dao";
    }

    public static String getMapperPkg() {
        return  resources + "/mapper/" + getDefaultModule() ;
    }

    public static String getJspPkg() {
        return jsp + "/" + getDefaultModule();
    }

    public static String getDaoImport() {
        return baseImport + getDefaultModule() + ".dao.";
    }

    public static String getServicesImport() {
        return baseImport + getDefaultModule() + ".services.";
    }
}
