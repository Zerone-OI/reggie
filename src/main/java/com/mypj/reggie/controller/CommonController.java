package com.mypj.reggie.controller;

import com.mypj.reggie.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Peilong
 * @create 2023-02-14 23:39
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;
    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){


        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后临时文件会删除
        //将临时文件转存到指定位置
        try {
            file.transferTo(new File("D:\\hello.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
