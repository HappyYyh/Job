package com.yyh.job.config.view;

import com.yyh.job.common.base.AuthToken;
import com.yyh.job.dao.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
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
            //获取cookie
            String token = "";
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for (Cookie cookie : cookies){
                    //获取token
                    if("token".equals(cookie.getName())){
                        token = cookie.getValue();
                    }
                }
                //获取登陆时放入的用户信息
                User user = (User) redisTemplate.opsForValue().get(token);
                if(null != user){
                    return true;
                }
                //用户信息存在则重定向
                response.addHeader("redirect","301");
                return false;
            }
            //没有cookie让其重定向
            response.addHeader("redirect","301");
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
