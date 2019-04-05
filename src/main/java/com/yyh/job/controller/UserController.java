package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.SendSmsRequest;
import com.yyh.job.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.controller
 * @author: 昊天
 * @date: 2019-04-05 16:08
 * @since V1.1.0-SNAPSHOT
 */
@RestController
@Api(value = "UserController",description = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public APIResult register(){
        return null;
    }

    /**
     * 发送验证码
     * @param request
     * @return
     */
    @PostMapping("/sendCheckCode")
    public APIResult sendCheckCode(@RequestBody @Valid SendSmsRequest request, BindingResult bindingResult){
        return userService.sendCheckCode(request);
    }
}
