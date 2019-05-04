package com.yyh.job.util;

import com.yyh.job.common.enums.RoleEnum;
import com.yyh.job.config.rabbit.RabbitMqUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Package com.yyh.job.util
 * @author: 昊天
 * @date: 2019-04-30 20:04
 * @since V1.1.0-SNAPSHOT
 */
@Slf4j
@Component
public class SendMsgUtil {

    @Autowired
    private RabbitMqUtil rabbitMqUtil;

    private static final String SEEKER_JOB_GET = "seeker.jobGet";
    private static final String RECRUITER_JOB_SEND = "recruiter.jobSend";

    public void sendMsgToRabbit(RoleEnum roleEnum, Map map){
        String routingKey = RoleEnum.SEEKER.equals(roleEnum) ? SEEKER_JOB_GET : RECRUITER_JOB_SEND;
        rabbitMqUtil.sendMsgToQueue(roleEnum,routingKey,map);
    }
}
