package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.CommonUserRequest;
import com.yyh.job.dto.request.SendSmsRequest;
import com.yyh.job.dto.request.UserLoginRequest;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-05 16:13
 * @since V1.1.0-SNAPSHOT
 */
public interface UserService {

    /**
     * 发送验证码
     * @param request
     * @return
     */
    APIResult sendCheckCode(SendSmsRequest request);

    /**
     * 用户注册
     * @param request
     * @return
     */
    APIResult regist(CommonUserRequest request);

    /**
     * 用户登陆
     * @param request
     * @return
     */
    APIResult login(UserLoginRequest request);
}
