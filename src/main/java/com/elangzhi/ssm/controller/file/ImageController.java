package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.tools.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 图片获取
 * Created by GaoXiang on 2016/5/3 0003.
 */
@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("/showTempImg")
    public void showTempImg(HttpServletResponse response, HttpServletRequest request,@RequestParam String src) throws IOException {
        InputStream in;
        if(!"".equals(src)){
            in = new java.io.FileInputStream(src);
            outputStream(response,in);
        }
    }



    @RequestMapping("/showImg")
    public void showImg(HttpServletResponse response, HttpServletRequest request,@RequestParam String src) throws IOException {
        InputStream in;
        if(!"".equals(src)){
            String realPath = request.getServletContext().getRealPath(src);
            in = new java.io.FileInputStream(realPath);
            outputStream(response,in);
        }
    }

    /**
     * 输出文件流
     * @param response
     * @param in
     * @throws IOException
     */
    public void outputStream(HttpServletResponse response,InputStream in) throws IOException {
        byte[] b = new byte[in.available()];
        in.read(b);
        response.getOutputStream().write(b);
        response.getOutputStream().flush();
    }

}
