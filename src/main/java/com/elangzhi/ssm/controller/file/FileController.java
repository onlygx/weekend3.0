package com.elangzhi.ssm.controller.file;

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

/**
 * Created by GaoXiang on 2015/12/28 0028.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/image")
    @ResponseBody
    public ModelMap fileUpload(@RequestParam(value = "file") MultipartFile file,
                          @RequestParam(value = "name") String name,
                          ModelMap model,
                          HttpServletRequest request) {

        if (file != null) {
            try {
                //上传地址
                String path = request.getSession().getServletContext().getRealPath("/upload/headimg/");
                String fileName = file.getOriginalFilename();
                file.transferTo(new File(path, fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }

        model.put("fileName", file.getOriginalFilename());
        model.put("name", name);
        model.put("date", new Date());
        return model;
    }
}
