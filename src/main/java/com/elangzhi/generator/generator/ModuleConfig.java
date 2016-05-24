package com.elangzhi.generator.generator;

import com.elangzhi.generator.util.DataModuleBuild;
import com.elangzhi.generator.util.GenUtil;
import com.elangzhi.generator.util.Path;
import freemarker.template.*;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.Map;

/**
 *  模板生成配置
 * Created by GaoXiang
 */
class ModuleConfig {

    /* 创建一个合适的configuration */
    private Configuration cfg = new Configuration(new Version("2.3.23"));

    /**
     * 预备生成模块
     */
    private String moduleName;          //模块中文名
    private Class clazz;                //模块Bean类

    @SuppressWarnings("unused")
    public ModuleConfig(){

        try {
            // 设置模板加载的方式
            cfg.setDirectoryForTemplateLoading( new File(Path.ftlPath));
        } catch (IOException e) {
            System.out.println("模板目录加载失败！");
            //e.printStackTrace();
        }
    }

    ModuleConfig(String moduleName,Class module){
        this.moduleName = moduleName;
        this.clazz = module;

        try {
            // 设置模板加载的方式
            cfg.setDirectoryForTemplateLoading( new File(Path.ftlPath));
        } catch (IOException e) {
            System.out.println("模板目录加载失败！");
            //e.printStackTrace();
        }
    }


    /**
     * 新建生成项(同头构造方法)
     * @param moduleName 模块名
     * @param module 模块Been类
     */
    @SuppressWarnings("unused")
    public void createModule(String moduleName,Class module){
        this.moduleName = moduleName;
        this.clazz = module;
    }


    /**
     * 开始生成
     */
    void startGenerator(){

        if(moduleName != null && clazz != null){

            //首字母小写生成模块名称
            Path.defaultModule = GenUtil.LowStr(clazz.getSimpleName());

            createController();
            createAppController();
            createServices();
            createDao();
            createMapper();

            createAddJsp();
            createListJsp();
            createEditJsp();
        }else{

            System.out.println("请首先设置模块名称和Bean类，使用 createModule 方法或者构造方法。");
        }

    }

    /**
     * 获取一个模板
     * @param templateName 模板名称
     * @return 模板对象
     */
    private Template getTemplate(String templateName){
        Template temp;
        try {
            temp = cfg.getTemplate(templateName);
            return temp;
        } catch (IOException e) {
            System.out.println("创建模板失败！");
        }
        return null;
    }



    /**
     * 生成 edit.jsp
     */
    private void createEditJsp(){

        String fileName = "edit.jsp";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.editJspFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createJspDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getJspPkg(),fileName);

    }

    /**
     * 生成 list.jsp
     */
    private void createListJsp(){

        String fileName = "list.jsp";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.listJspFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createJspDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getJspPkg(),fileName);

    }

    /**
     * 生成 add.jsp
     */
    private void createAddJsp(){

        String fileName = "add.jsp";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.addJspFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createJspDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getJspPkg(),fileName);

    }

    /**
     * 生成 mapper
     */
    private void createMapper(){

        String fileName = clazz.getSimpleName() + "Mapper.xml";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.mapperFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createMapperDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getMapperPkg(),fileName);

    }


    /**
     * 生成 dao
     */
    private void createServices(){

        String fileName = clazz.getSimpleName() + "Service.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.servicesFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getServicesPkg(),fileName);

    }


    /**
     * 生成 dao
     */
    private void createDao(){

        String fileName = clazz.getSimpleName() + "Dao.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.daoFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getDaoPkg(),fileName);

    }

    /**
     * 生成 客户端 controller
     */
    private void createAppController(){

        String fileName = "App" + clazz.getSimpleName() + "Controller.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.appControllerFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getAppControllerPkg(),fileName);

    }

    /**
     * 生成 controller
     */
    private void createController(){

        String fileName = clazz.getSimpleName() + "Controller.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.controllerFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.getControllerPkg(),fileName);

    }

    /**
     * 生成文件到硬盘
     * @param temp 模板
     * @param root 数据模型
     * @param dir 生成路径
     * @param fileName 生成文件名
     */
    private void generatorSource(Template temp,Map root, String dir,String fileName) {

        try {
            /* 输出文件夹 */
            File fileDir = new File(dir);

            //验证文件夹是否存在，不存在则创建。
            FileUtils.forceMkdir(fileDir);

            // 指定生成输出的文件
            File output = new File(fileDir + "/" + fileName);
            Writer writer = new FileWriter(output);
            temp.process(root, writer);
            writer.close();

            System.out.println("生成：" + fileName + " 成功，地址：" + output);
        } catch (IOException e) {
            System.out.println("生成文件夹初始化错误！");
            //e.printStackTrace();
        } catch (TemplateException e) {
            System.out.println("生成模板错误！");
            //e.printStackTrace();
        }
    }

    /**
     * 控制台打印模板
     * @param temp 模板
     * @param root 数据模型
     */
    @SuppressWarnings("unused")
    private void printToConsole(Template temp, Map root) {

        /* 合并数据模型和模版，控制台打印*/
        try {
            Writer out = new OutputStreamWriter(System.out);
            temp.process(root, out);
            out.flush();
        } catch (TemplateException e) {
            System.out.println("模板控制台打印错误！");
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("模板控制台打印文件流错误！");
            //e.printStackTrace();
        }
    }


    @SuppressWarnings("unused")
    public String getModuleName() {
        return moduleName;
    }

    @SuppressWarnings("unused")
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @SuppressWarnings("unused")
    public Class getClazz() {
        return clazz;
    }

    @SuppressWarnings("unused")
    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
