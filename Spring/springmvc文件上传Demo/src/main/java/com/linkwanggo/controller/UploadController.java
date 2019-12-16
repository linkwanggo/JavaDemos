package com.linkwanggo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("uploadFile") MultipartFile uploadFile,
                             HttpServletRequest request) {
        if (uploadFile.isEmpty()) {
            return "fail";
        }
        try {

            // 1.获取上传路径
            String dirPath = request.getSession().getServletContext().getRealPath("/uploads/");
            // 2.判断路径是否存在
            File dirFile = new File(dirPath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            // 3.获取文件名
            String filename = uploadFile.getOriginalFilename();
            // 4.文件名+uuid
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            filename = uuid + "_" + filename;
            // 5.transferTo方法
            uploadFile.transferTo(new File(dirPath, filename));
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
