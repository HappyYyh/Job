package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.util.FileUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${qiniu.urlPrefix}")
    private String urlPrefix;

    @PostMapping("/upload")
    @ResponseBody
    public APIResult upload(@RequestParam(required = false, value = "file") MultipartFile file){
        return APIResult.create(fileUtil.upLoad(file));
    }

    @GetMapping("/delete")
    @ResponseBody
    public APIResult delete(String url){
        if(StringUtils.isBlank(url) || !url.contains(urlPrefix)){
            return APIResult.error(BaseEnum.URL_ERROR);
        }
        //字符串截取
        String key = url.substring(urlPrefix.length());
        boolean isSuccess = fileUtil.delete(key);
        if(isSuccess) {
            return APIResult.ok();
        }else {
            return APIResult.error();
        }
    }
}
