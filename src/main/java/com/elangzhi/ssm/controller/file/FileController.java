package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.controller.json.Tip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * 文件上传、管理
 * Created by GaoXiang on 2015/12/28 0028.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/uploadTempImage")
    @ResponseBody
    public Tip uploadTempImage(
                            @RequestParam(value = "file") MultipartFile file,
                            @RequestParam(value = "filename") String filename,
                            ModelMap model,
                            HttpServletRequest request) {

        if (file != null) {
            try {
                //上传地址
                String url = "/upload/tempImg/"
                            + System.currentTimeMillis()
                            + "_headImg_"
                        + (Math.abs(new Random().nextInt())%32000+10000)
                        + filename.substring(filename.lastIndexOf("."));

                String path = request.getServletContext().getRealPath(url);

                file.transferTo(new File(path));

                return new Tip(url);
            } catch (IOException e) {
                e.printStackTrace();
                return new Tip(2);
            }
        } else {
            return new Tip(1);
        }
    }
}
