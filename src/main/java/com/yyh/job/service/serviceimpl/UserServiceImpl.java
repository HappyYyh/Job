package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.dto.request.SendSmsRequest;
import com.yyh.job.service.UserService;
import com.yyh.job.util.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-05 16:15
 * @since V1.1.0-SNAPSHOT
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    /**
     *  验证码前缀
     */
    private static final String CHECK_CODE_REGIST = "CHECK_CODE_REGIST:";
    private static final String CHECK_CODE_LOGIN = "CHECK_CODE_LOGIN:";
    private static final String CHECK_CODE_PASSWORD = "CHECK_CODE_PASSWORD:";
    /**
     * 过期时间
     */
    private static final int EXPIR_TIME = 5*60;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发送验证码
     * 验证码类型：0注册验证码 1登陆验证码 2找回密码验证码
     * @param request
     * @return
     */
    @Override
    public APIResult sendCheckCode(SendSmsRequest request) {
        //验证码
        Integer checkCode = getCheckCode();
        //键
        String key = "";
        boolean success = false;
        switch (request.getType()){
            case 0:
                success = SmsUtil.sendRegistMessage(request.getPhone(), checkCode);
                key = CHECK_CODE_REGIST + request.getPhone();
                break;
            case 1:
                success = SmsUtil.sendLoginMessage(request.getPhone(),checkCode);
                key = CHECK_CODE_LOGIN + request.getPhone();
                break;
            case 2:
                success = SmsUtil.sendReSetPasswordMessage(request.getPhone(),checkCode);
                key = CHECK_CODE_PASSWORD + request.getPhone();
                break;
            default:
                break;
        }
        if(success){
            //验证码发送成功后放入redis缓存
            stringRedisTemplate.opsForValue().set(key,String.valueOf(checkCode),EXPIR_TIME, TimeUnit.SECONDS);
            log.info("redis给{}放入验证码:{}",request.getPhone(),checkCode);
            return APIResult.ok();
        }
        return APIResult.error(BaseEnum.SEND_SMS_FAIL);
    }

    /**
     * 获取随机6为验证码
     * @return
     */
    private Integer getCheckCode(){
        return (int)((Math.random()*9+1)*100000);
    }
}
