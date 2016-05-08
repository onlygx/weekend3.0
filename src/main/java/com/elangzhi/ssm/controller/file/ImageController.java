package com.elangzhi.ssm.controller.file;

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

    @RequestMapping("/showImg")
    public void showImg(HttpServletResponse response, HttpServletRequest request,@RequestParam String src) throws IOException {
        InputStream in;
        if(!"".equals(src)){
            String realPath = request.getServletContext().getRealPath(src);
            in = new java.io.FileInputStream(realPath);

            if ( in != null )
            {
                byte[] b = new byte[1024];
                int len;
                while( (len = in.read(b)) != -1 )
                {
                    response.getOutputStream().write(b);
                }
                in.close();
            }
        }

    }

}
