package com.yyh.job.util;

import com.google.gson.Gson;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.yyh.job.common.enums.FileEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.util
 * @author: 昊天
 * @date: 2019-03-27 11:15
 * @since V1.1.0-SNAPSHOT
 */
@Slf4j
@Component
public class FileUtil {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${qiniu.urlPrefix}")
    private String urlPrefix;

    /**
     * 获取token
     * @return
     */
    private String getUpToken(){
        Auth auth = Auth.create(accessKey,secretKey);
        return auth.uploadToken(bucket);
    }

    /**
     * <p> 文件上传到七牛云 </p>
     * @param file
     * @return String
     * @author 昊天
     * @date
     * @since V1.1.0-SNAPSHOT
     *
     */
    public String upLoad(MultipartFile file){
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        String key = getKey(file);
        try {
            Response response = uploadManager.put(file.getInputStream(), key, getUpToken(),null,null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            log.info("putRet.key:{}",putRet.key);
            log.info("putRet.hash:{}",putRet.hash);
        } catch (QiniuException e) {
            Response r = e.response;
            log.error("上传失败:{}",r.toString());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlPrefix + key;
    }

    public boolean delete(String key){
        Configuration cfg = new Configuration(Zone.zone2());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            log.error("删除文件失败code:{},info:{}",ex.code(),ex.response.toString());
            return false;
        }
        return true;
    }

    /**
     * 获取当前时间
     * @return
     */
    private static String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    /**
     * 获取上传的路径
     * @param file
     * @return
     */
    private static String getKey(MultipartFile file){
        //获取原始的名称
        String originalFilename = file.getOriginalFilename();
        //获取后缀（转小写）eg:.jpg
        String fileNameExtension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        //获取后缀
        String keyPrefix = getKeyPrefix(fileNameExtension.substring(1));
        Random random = new Random();
        return keyPrefix + System.currentTimeMillis() + random.nextInt(10000) +fileNameExtension;
    }

    /**
     * <p> 根据后缀上传到不同的目录下 </p>
     * @param fileNameExtension
     * @return String
     * @author 昊天 
     * @date
     * @since V1.1.0-SNAPSHOT
     *
     */
    private static String getKeyPrefix(String fileNameExtension){
        String keyPreFix;
        switch (FileEnum.getByName(fileNameExtension)){
            case BMP:
                keyPreFix = "images/bmp/";
                break;
            case GIF:
                keyPreFix = "images/gif/";
                break;
            case JPEG:
                keyPreFix = "images/jpg/";
                break;
            case JPG:
                keyPreFix = "images/jpg/";
                break;
            case PNG:
                keyPreFix = "images/png/";
                break;
            case TXT:
                keyPreFix = "file/text/";
                break;
            case MARKDOWN:
                keyPreFix = "file/md/";
                break;
            case PDF:
                keyPreFix = "file/pdf/";
                break;
            default:
                keyPreFix = "file/other/";
                break;
        }
        return keyPreFix;
    }

}
