package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.JobSendMapper;
import com.yyh.job.dao.mapper.UserMapper;
import com.yyh.job.dao.model.JobSend;
import com.yyh.job.dao.model.User;
import com.yyh.job.dto.request.job.CommonJobSendRequest;
import com.yyh.job.service.JobSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-28 20:48
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class JobSendServiceImpl implements JobSendService {

    @Autowired
    private JobSendMapper jobSendMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 投递前需进行身份校验
     * 新增投递记录
     *
     * @param request
     * @return
     */
    @Override
    public APIResult addSend(CommonJobSendRequest request) {
        //首先判断是否存在用户
        User user = userMapper.selectByPrimaryKey(request.getUserId());
        if(null == user){
            return APIResult.error(BaseEnum.USER_NOT_LOGIN);
        }
        //验证是否是求职者
        if(CommonEnum.ONE.getCode().equals(user.getRole())){
            return APIResult.error(BaseEnum.RECRUITER_CANNOT_SEND);
        }
        //判断是否已经对该职位投递过
        JobSend isSend = jobSendMapper.selectByJobIdAndUserId(request.getUserId(),request.getJobId());
        if(isSend !=null){
            return APIResult.error(BaseEnum.YOU_HAVE_SEND);
        }
        JobSend jobSend = new JobSend();
        jobSend.setJobId(request.getJobId());
        jobSend.setUserId(request.getUserId());
        jobSend.setSendTime(new Date());
        jobSend.setSendStatus(0);
        jobSendMapper.insert(jobSend);
        return APIResult.ok();
    }

    /**
     * 判断是否已经投递过
     *
     * @param request
     * @return
     */
    @Override
    public APIResult isSend(CommonJobSendRequest request) {
        //判断是否已经对该职位投递过
        JobSend isSend = jobSendMapper.selectByJobIdAndUserId(request.getUserId(),request.getJobId());
        //投递过返回1，未投递返回0
        return isSend==null?APIResult.create(0):APIResult.create(1);
    }
}
