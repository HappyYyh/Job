package com.yyh.job.config.view;

import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dao.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.config.view
 * @author: 昊天
 * @date: 2019-04-04 18:50
 * @since V1.1.0-SNAPSHOT
 */
@Configuration
@Slf4j
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是是方法级
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AuthToken authToken = handlerMethod.getMethodAnnotation(AuthToken.class);
            //如果没有注解，则放行
            if(null == authToken){
                return true;
            }
            //获取token
            String token = request.getHeader("token");
            if(StringUtils.isNotBlank(token)){
                User user = (User) redisTemplate.opsForValue().get(token);
                if(user != null){
                    return true;
                }
                response.sendError(401);
                return false;
            }
            response.sendError(401);
            return false;
        }
        return true;
    }

    public TokenInterceptor() {
        super();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
