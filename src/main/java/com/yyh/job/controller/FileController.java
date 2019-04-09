package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.util.FileUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-09 13:56
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "FileController",description = "文件上传/下载")
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileUtil fileUtil;

    @PostMapping("/upload")
    @ResponseBody
    public APIResult upload(@RequestParam(required = false, value = "file") MultipartFile file){
        return APIResult.create(fileUtil.upLoad(file));
    }
}
