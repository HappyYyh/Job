package com.yyh.job.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.file.enums
 * @author: 昊天
 * @date: 2019-03-27 14:02
 * @since V1.1.0-SNAPSHOT
 */
@AllArgsConstructor
public enum FileEnum {
    /**
     * 文件后缀类型
     */
    BMP("bmp"),
    GIF("gif"),
    JPEG("jpeg"),
    JPG("jpg"),
    PNG("png"),
    HTML("html"),
    TXT("txt"),
    PDF("pdf"),
    VSD("vsd"),
    PPTX("pptx"),
    PPT("ppt"),
    DOCX("docx"),
    DOC("doc"),
    XML("xml"),
    MARKDOWN("md"),
    OTHER("other"),
    ;

    @Getter
    private String name;

    /**
     * 根据名称获取枚举对象
     * @param name
     * @return
     */
    public static FileEnum getByName(String name){
        if(null == name || "".equals(name)){
            return null;
        }
        for (FileEnum fileEnum : FileEnum.values()){
            if(fileEnum.getName().equals(name)){
                return fileEnum;
            }
        }
        return OTHER;
    }
}
