package com.elangzhi.ssm.controller.file;

import com.elangzhi.ssm.controller.json.Tip;
import com.elangzhi.ssm.tools.UUIDFactory;
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
import java.util.UUID;

/**
 * 文件上传、管理
 * Created by GaoXiang on 2015/12/28 0028.
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private String DISK_SANEPATH = "C:/langzhi/tempImg/";

    @RequestMapping("/uploadTempImage")
    @ResponseBody
    public Tip uploadTempImage(
                            @RequestParam(value = "file") MultipartFile file,
                            ModelMap model,
                            HttpServletRequest request) {

        initDir();
        if (file != null) {
            try {
                String fileName = file.getOriginalFilename();
                String saveName = UUIDFactory.getLongId() + fileName.substring(fileName.lastIndexOf("."));
                String filePath = DISK_SANEPATH + saveName;
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


    public void initDir(){
        File file =new File(DISK_SANEPATH);
        //如果文件夹不存在则创建
        if  (!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        }
    }
}
