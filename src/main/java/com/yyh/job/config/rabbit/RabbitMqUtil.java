package com.yyh.job.config.rabbit;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.yyh.job.common.enums.RoleEnum;
import com.yyh.job.config.webSocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Package com.yyh.job.util
 * @author: 昊天
 * @date: 2019-04-30 19:41
 * @since V1.1.0-SNAPSHOT
 */
@Component
@Slf4j
public class RabbitMqUtil implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback{

    @Value("${job.exchange.seeker}")
    private String seekerExchange;

    @Value("${job.exchange.recruiter}")
    private String recruiterExchange;

    private RabbitTemplate rabbitTemplate;

    private static final Gson gson = new Gson();

    @Autowired
    public RabbitMqUtil(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * <p> 根据身份和路由键发送消息 </p>
     * @param roleEnum    身份枚举类
     * @param routingKey  路由键
     * @param map         消息
     * @return void
     * @author 昊天
     * @date
     * @since V1.1.0-SNAPSHOT
     *
     */
    public void sendMsgToQueue(RoleEnum roleEnum, String routingKey, Map<String,Object> map){
        String exchange;
        if(RoleEnum.SEEKER.equals(roleEnum)){
            exchange = seekerExchange;
        }else {
            exchange = recruiterExchange;
        }
        CorrelationData correlationData = new CorrelationData(String.valueOf(System.currentTimeMillis()));
        rabbitTemplate.convertAndSend(exchange,routingKey,map,correlationData);
    }

    /**
     * 确认消息是否到达exchange中
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            log.info("消息推送成功，编号:{}",correlationData.getId());
        }else {
            log.warn("消息发送失败，id：{},错误信息：{}",correlationData.getId(),s);
        }
    }

    /**
     * 消息没有到达队列会回调此方法
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.warn("消息发送失败---message:{},code:{},text:{},exchange:{},routingKey:{}",message.getBody(),replyCode,replyText,exchange,routingKey);
    }

    @RabbitListener(queues = {"jobSend"})
    public void listenRecruiterMsg(Message message, Channel channel) throws IOException {
        try {
            String msg = new String(message.getBody(),"UTF-8");
            Map map = gson.fromJson(msg, Map.class);
            //大坑，gson反序列化会把int整形反序列化成double类型，
            Integer recruiterId = (int)(double)map.get("recruiterId");
            for (WebSocketServer webSocketServer : WebSocketServer.webSocketSet){
                //如果监听到消息时该招聘者在线，则实时推送
                if(webSocketServer.getId().equals(recruiterId)) {
                    webSocketServer.sendMessage(msg);
                }
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            //出现异常 拒收消息
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = {"jobGet"})
    public void listenSeekerMsg(Message message, Channel channel) throws IOException {
        try {
            String msg = new String(message.getBody(),"UTF-8");
            Map map = gson.fromJson(msg, Map.class);
            Integer userId = (Integer) map.get("userId");
            for (WebSocketServer webSocketServer : WebSocketServer.webSocketSet){
                //如果监听到消息时该用户在线，则实时推送
                webSocketServer.sendMessage(msg);
            }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            //出现异常 拒收消息
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Double d = 11.0;
        System.out.println((int)(double)d);
    }
}
