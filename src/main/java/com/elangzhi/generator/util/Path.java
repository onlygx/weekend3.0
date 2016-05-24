package com.elangzhi.generator.util;

/**
 * 代码生成路径
 * Created by GaoXiang
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
    private static final String code = home + "/java/com/elangzhi/modules";
    private static final String resources = home + "/resources";
    private static final String jsp = savePath + "/web/WEB-INF/jsp";

    //生成java文件和mybatis映射xml文件路径
    static String controllerPkg = "/controller";
    static String appControllerPkg = "/app";
    static String servicesPkg = "/services";
    static String daoPkg = "/dao";
    static String mapperPkg = "/mapper";
    static String jspPkg = "/admin";

    //模板文件夹路径 需要先获取
    public static final String ftlPath = sysDir + "/src/main/java/com/elangzhi/generator/template";

    //模板路径
    public static final String controllerFtl = "ControllerTemplate.ftl";
    public static final String appControllerFtl = "AppControllerTemplate.ftl";
    public static final String servicesFtl = "ServicesTemplate.ftl";
    public static final String daoFtl = "DaoTemplate.ftl";
    public static final String mapperFtl = "MapperTemplate.ftl";
    public static final String addJspFtl = "AddJspTemplate.ftl";
    public static final String listJspFtl = "ListJspTemplate.ftl";
    public static final String editJspFtl = "EditJspTemplate.ftl";

    //包路径
    private static final String baseImport = "com.elangzhi.";
    static final String modelImport = "com.elangzhi.ssm.model.";
    private static String daoImport = ".dao.";
    private static String servicesImport = ".services.";


    private static String getDefaultModule() {
        return defaultModule;
    }

    public static String getControllerPkg() {
        return code + "/" + getDefaultModule() + controllerPkg;
    }

    public static String getAppControllerPkg() {
        return code + "/" + getDefaultModule() + appControllerPkg;
    }

    public static String getServicesPkg() {
        return  code + "/" + getDefaultModule() + servicesPkg;
    }

    public static String getDaoPkg() {
        return  code + "/" + getDefaultModule() + daoPkg;
    }

    public static String getMapperPkg() {
        return  resources + mapperPkg + "/" + getDefaultModule() ;
    }

    public static String getJspPkg() {
        return jsp + jspPkg + "/" + getDefaultModule();
    }

    public static String getDaoImport() {
        return baseImport + "modules." + getDefaultModule() + daoImport;
    }

    public static String getServicesImport() {
        return baseImport + "modules." + getDefaultModule() + servicesImport;
    }
}
