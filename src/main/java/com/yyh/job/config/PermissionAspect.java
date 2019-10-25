package com.yyh.job.config;

import com.yyh.job.common.base.Permission;
import com.yyh.job.common.enums.RoleEnum;
import com.yyh.job.config.exception.PermissionException;
import com.yyh.job.dao.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * All rights Reserved, Designed By yyh
 *
 * @Package com.yyh.job.config
 * @author: yyh
 * @date: 2019/7/17 16:03
 * @since V1.1.0-SNAPSHOT
 */
@Aspect
@Component
@Slf4j
public class PermissionAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut(value = "execution(public * com.yyh.job.controller.*.*(..))")
    public void cutPermission(){

    }

    /**
     * 校验权限
     * @param permission
     */
    @Before(value = "cutPermission() && @annotation(permission)")
    public void checkPermission(Permission permission){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //获取到方法上需要的权限名称
        String[] values = permission.value();
        //获取token
        String token = request.getHeader("token");
        if(StringUtils.isBlank(token)){
            throw new PermissionException("暂未登录");
        }
        User user = (User) redisTemplate.opsForValue().get(token);
        if(null == user || null == user.getRole()){
            throw new PermissionException("暂未登录");
        }
        //权限检查
        String roleName = RoleEnum.getMsgByType(user.getRole());
        if(!Arrays.asList(values).contains(roleName)){
            throw new PermissionException("暂无访问权限");
        }

    }
}
