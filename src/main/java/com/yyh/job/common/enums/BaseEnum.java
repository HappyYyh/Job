package com.yyh.job.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.file.enums
 * @author: 昊天
 * @date: 2019-03-05 17:04
 * @since V1.1.0-SNAPSHOT
 */
@AllArgsConstructor
public enum BaseEnum {

    /**
     *  基础的枚举
     */
    SUCCESS(200,""),
    ERROR(500,"Internal Server Error"),
    PARAM_HAS_ERROR(501,"参数错误!"),


    SEND_SMS_FAIL(502,"验证码发送失败!"),
    PLEASE_SEND_CHECK_CODE(503,"验证码不存在,请重新获取!"),
    SMS_ERROR(503,"验证码错误"),
    USER_REGIST_ERROR(504,"用户注册失败"),
    USER_ALREADY_EXIST(505,"用户已存在,请直接登陆"),
    USER_NOT_EXIST(506,"账号不存在?去注册一个吧!"),
    PASSWORD_ERROR(507,"密码错误!"),

    ADD_COMPANY_ERROR(510,"企业认证失败,请重试"),

    ALREADY_BIND_COMPANY(520,"您已经绑定企业了,请耐心等待审核!"),

    URL_ERROR(530,"url不合法!")
    ;

    @Getter
    private Integer code;
    @Getter
    private String msg;
}
