package com.linkwanggo.controller;

import com.linkwanggo.utils.DownloadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@RestController
public class FileController {

    @Value("${file.winUploadFolder}")
    private String winUploadFolder;

    @PostMapping("/upload")
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) {
        if (uploadFile.isEmpty()) {
            return "isEmpty";
        }
        String fileName = uploadFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + "_" + fileName;
        try {
            uploadFile.transferTo(new File(fileName));
            // TODO: 2019/10/31 存入数据库
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @GetMapping("/download/{fileName}")
    public String downLoad(HttpServletRequest request,
                           HttpServletResponse response,
                           @PathVariable("fileName") String fileName) {
        // TODO: 2019/10/31 数据库查询文件是否存在
        // 模拟文件下载
        File downloadFile = new File(winUploadFolder, fileName);
        if (!downloadFile.exists()) {
            return "文件不存在";
        }
        try {
            FileInputStream fis = new FileInputStream(downloadFile);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            String userAgent = request.getHeader("User-Agent");
            response.addHeader("Content-disposition", "attachment;fileName=" + DownloadUtils.getFileName(userAgent, fileName));
            OutputStream os = response.getOutputStream();
            // 常规操作
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = fis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
