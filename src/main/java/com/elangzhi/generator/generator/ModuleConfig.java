package com.elangzhi.generator.generator;

import com.elangzhi.generator.util.DataModuleBuild;
import com.elangzhi.generator.util.Path;
import freemarker.template.*;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.Map;

/**
 * Created by GaoXiang on 2016/5/17 0017.
 */
public class ModuleConfig {

    /* 创建一个合适的configuration */
    private Configuration cfg = new Configuration(new Version("2.3.23"));

    /**
     * 预备生成模块
     */
    private String moduleName;          //模块中文名
    private Class clazz;                //模块Bean类


    public ModuleConfig(){

        try {
            // 设置模板加载的方式
            cfg.setDirectoryForTemplateLoading( new File(Path.ftlPath));
        } catch (IOException e) {
            System.out.println("模板目录加载失败！");
            //e.printStackTrace();
        }
    }

    public ModuleConfig(String moduleName,Class module){
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
    public void createModule(String moduleName,Class module){
        this.moduleName = moduleName;
        this.clazz = module;
    }


    /**
     * 开始生成
     */
    public void startGenerator(){

        if(moduleName != null && clazz != null){
            createController();
            createServices();
            createDao();
            createMapper();


        }else{

            System.out.println("请首先设置模块名称和Bean类，使用 createModule 方法或者构造方法。");
        }

    }

    /**
     * 创建一个模板
     * @param templateName
     * @return
     */
    public Template getTemplate(String templateName){
        Template temp = null;
        try {
            temp = cfg.getTemplate(templateName);
            return temp;
        } catch (IOException e) {
            System.out.println("创建模板失败！");
            return temp;
            //e.printStackTrace();
        }
    }



    /**
     * 生成 mapper
     */
    public void createMapper(){

        String fileName = clazz.getSimpleName() + "Mapper.xml";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.mapperFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createMapperDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.mapperPkg,fileName);

    }


    /**
     * 生成 dao
     */
    public void createServices(){

        String fileName = clazz.getSimpleName() + "Service.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.servicesFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.servicesPkg,fileName);

    }


    /**
     * 生成 dao
     */
    public void createDao(){

        String fileName = clazz.getSimpleName() + "Dao.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.daoFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.daoPkg,fileName);

    }

    /**
     * 生成 controller
     */
    public void createController(){

        String fileName = clazz.getSimpleName() + "Controller.java";

        /*获取或创建一个模版*/
        Template temp = getTemplate(Path.controllerFtl);

        /*创建一个数据模型 Create a data model */
        Map root = DataModuleBuild.createBaseDataModle(moduleName,clazz);

        /* 控制台打印 */
        //printToConsole(temp,root);

        /* 生成文件 */
        generatorSource(temp,root,Path.controllerPkg,fileName);

    }

    /**
     * 生成文件到硬盘
     * @param temp
     * @param root
     * @param dir
     * @param fileName
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

            System.out.println(output);
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
     * @param temp
     * @param root
     */
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



    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
