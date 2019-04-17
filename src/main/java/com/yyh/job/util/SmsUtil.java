package com.yyh.job.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import lombok.extern.slf4j.Slf4j;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.yyh.job.util
 * @author: 昊天
 * @date: 2019-04-04 14:47
 * @since V1.1.0-SNAPSHOT
 */
@Slf4j
public class SmsUtil {

    /**
     * 签名内容
     */
    private static final String SIGN_NAME = "快来吧职业共享家网站";

    private static final String VERSION = "2017-05-25";
    private static final String ACTION = "SendSms";
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     * 阿里云访问权限
     */
    private static final String ACCESS_KEY_ID = "LTAIrsLt9DlDzSnD";
    private static final String ACCESS_KEY_SECRET = "PReiSpagypzfFNEg3xs9qcSHJ2bOKx";

    /**
     * <p> 发送验证码 </p>
     * @param templateCode 模版编号
     * @param phone        手机号
     * @param param        替换内容
     * @return CommonResponse
     * @author 昊天
     * @date
     * @since V1.1.0-SNAPSHOT
     *
     */
    public static CommonResponse  sendMessage(String templateCode,String phone,String param){
        DefaultProfile profile = DefaultProfile.getProfile("default", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        //创建请求对象
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //根据jar包版本指定依赖
        request.setVersion(VERSION);
        request.setDomain(DOMAIN);
        request.setAction(ACTION);
        request.putQueryParameter("SignName", SIGN_NAME);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("TemplateParam", param);
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
            log.info("短信发送结果为:{}",response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * <p> 发送验证码 </p>
     * @param templateCode 模版code
     * @param phone        电话
     * @param code         验证码
     * @return boolean
     * @author 昊天
     * @date
     * @since V1.1.0-SNAPSHOT
     *
     */
    private static boolean sendCheckCode(String templateCode,String phone,Integer code){
        String param = "{\"code\":\"" + code + "\"}";
        CommonResponse commonResponse = sendMessage(templateCode, phone, param);
        return commonResponse.getHttpStatus()==200;
    }

    /**
     * 注册验证码
     * @param phone
     * @param code
     * @return
     */
    public static boolean sendRegistMessage(String phone,Integer code){
        return sendCheckCode("SMS_162731154",phone,code);
    }

    /**
     * 登陆验证码
     * @param phone
     * @param code
     * @return
     */
    public static boolean sendLoginMessage(String phone,Integer code){
        return sendCheckCode("SMS_162731420",phone,code);
    }

    /**
     * 重置验证码
     * @param phone
     * @param code
     * @return
     */
    public static boolean sendReSetPasswordMessage(String phone,Integer code){
        return sendCheckCode("SMS_162731419",phone,code);
    }




}
