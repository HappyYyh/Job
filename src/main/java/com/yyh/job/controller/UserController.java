package com.yyh.job.controller;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.CommonUserRequest;
import com.yyh.job.dto.request.SendSmsRequest;
import com.yyh.job.dto.request.UpdateUserRequest;
import com.yyh.job.dto.request.UserLoginRequest;
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

    /**
     * 登陆
     * @param request
     * @return
     */
    @PostMapping("/login")
    public APIResult login(@RequestBody UserLoginRequest request){
        return userService.login(request);
    }

    /**
     * 注册
     * @param request
     * @param bindingResult
     * @return
     */
    @PostMapping("/register")
    public APIResult register(@RequestBody @Valid CommonUserRequest request, BindingResult bindingResult){
        return userService.regist(request);
    }

    /**
     * 登出
     * @param token
     * @return
     */
    @GetMapping("/logout")
    public APIResult logout(String token){
        return userService.logout(token);
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

    @PostMapping("/user/updateInfo")
    public APIResult updateInfo(@RequestBody @Valid UpdateUserRequest request, BindingResult bindingResult){
        return userService.updateUser(request);
    }
}
