package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.controller.json.Tip;
import org.aspectj.util.FileUtil;
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
                            ModelMap model,
                            HttpServletRequest request) {


        if (file != null) {
            try {
                String fileName = file.getOriginalFilename();
                String saveName = System.currentTimeMillis() +"_head"+ fileName.substring(fileName.lastIndexOf("."));
                String filePath = "/upload/tempImg/" + saveName;
                String path = request.getServletContext().getRealPath(filePath);
                file.transferTo(new File(path));

                return new Tip(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                return new Tip(2);
            }
        } else {
            return new Tip(1);
        }
    }
}
