package com.yyh.job.config;


import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.config.exception.BindErrorException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.config
 * @author: 昊天
 * @date: 2019-03-27 17:48
 * @since V1.1.0-SNAPSHOT
 */
@Aspect
@Component
@Slf4j
public class AopAspect {

    @Pointcut("execution(public * com.yyh.job.controller.*.*(..))")
    public void log() {

    }

    @Before("log() ")
    public void exBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Object[] args = joinPoint.getArgs();
        log.info("请求url:{}", request.getRequestURL());
        log.info("请求type:{}", request.getMethod());
        log.info("请求method:{}", joinPoint.getSignature());
        log.info("请求参数args:{}", Arrays.toString(args));
        for (Object arg :args){
            if(arg instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) arg;
                APIResult result = this.vaildReuqestParams(bindingResult);
                if(!result.isSuccess()){
                    //如果绑定失败则抛出异常
                    throw new BindErrorException(result.getData().toString());
                }
            }
        }
    }

    @After("log()")
    public void exAfter(JoinPoint joinPoint) {
        log.info("class method:{}.{}执行完毕!", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void exAfterRunning(Object result){
        //log.info("执行返回值:{}",JSON.toJSON(result));
    }

    private APIResult vaildReuqestParams(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            List<String> list = new ArrayList<>();
            for (ObjectError error :allErrors){
                FieldError fieldError = (FieldError) error;
                //错误信息拼接
                list.add(fieldError.getField()+error.getDefaultMessage());
            }
            return APIResult.error(BaseEnum.PARAM_HAS_ERROR,list);
        }
        return APIResult.ok();
    }

}
