package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.tools.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 图片获取
 * Created by GaoXiang on 2016/5/3 0003.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    /**
     * 输出文件流，输出本地绝对路径图片
     * @param response
     * @param request
     * @param src 绝对路径 例如 d:/elangzhi/tempImg/head.jpg
     * @throws IOException
     */
    @RequestMapping("/showTempImg")
    public void showTempImg(HttpServletResponse response, HttpServletRequest request,@RequestParam String src) throws IOException {

        if(!"".equals(src)){
            File file  = new File(src);
            //如果文件存在
            if(file.exists()){
                InputStream in = new FileInputStream(file);
                outputStream(response,in);
            }
        }
    }


    /**
     * 输出图片文件流，选择项目路径内部文件
     * @param response
     * @param request
     * @param src 项目根路径，例如：/images/headimg/head.jpg
     * @throws IOException
     */
    @RequestMapping("/showImg")
    public void showImg(HttpServletResponse response, HttpServletRequest request,@RequestParam String src) throws IOException {

        if(!"".equals(src)){
            String realPath = request.getServletContext().getRealPath(src);
            File file  = new File(realPath);
            if(file.exists()){
                InputStream in = new FileInputStream(file);
                outputStream(response,in);
            }
        }
    }

    /**
     * 输出文件流
     * @param response
     * @param in
     * @throws IOException
     */
    public void outputStream(HttpServletResponse response,InputStream in) throws IOException {
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[1024];
        while( in.read(b)!= -1){
            os.write(b);
        }
        in.close();
        os.flush();
        os.close();
    }

}
