package com.yyh.job.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yyh.job.common.base.APIResult;
import com.yyh.job.common.base.BaseResponse;
import com.yyh.job.common.enums.BaseEnum;
import com.yyh.job.common.enums.CommonEnum;
import com.yyh.job.dao.mapper.JobSendMapper;
import com.yyh.job.dao.mapper.ResumeBaseMapper;
import com.yyh.job.dao.mapper.UserMapper;
import com.yyh.job.dao.model.JobSend;
import com.yyh.job.dao.model.ResumeBase;
import com.yyh.job.dao.model.User;
import com.yyh.job.dto.request.job.CommonJobSendRequest;
import com.yyh.job.dto.request.job.SeekerSendListRequest;
import com.yyh.job.dto.request.job.UpdateSendStatusRequest;
import com.yyh.job.dto.response.job.RecruiterGotListResponse;
import com.yyh.job.dto.response.job.SeekerSendListResponse;
import com.yyh.job.dto.response.resume.ResumeBaseResponse;
import com.yyh.job.service.JobSendService;
import com.yyh.job.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private ResumeBaseMapper resumeBaseMapper;


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
        //判断是否已经创建简历
        ResumeBaseResponse hasResume = resumeBaseMapper.selectByUserId(user.getId());
        if(null == hasResume){
            return APIResult.error(BaseEnum.HAVE_NOT_RESUME);
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

    /**
     * 求职者查看自己的投递记录
     *
     * @param request
     * @return
     */
    @Override
    public APIResult seekerSendList(SeekerSendListRequest request) {
        Page page = PageHelper.startPage(request.getPageNo(),request.getPageSize());
        List<SeekerSendListResponse> responseList = jobSendMapper.selectByUserIdAndStatus(request.getUserId(),request.getType());
        responseList.forEach(response -> {
            if(StringUtils.isNotBlank(response.getWorkPlace())){
                //将 浙江省/杭州市/下城区以/分割
                String[] places = response.getWorkPlace().split("/");
                response.setCity(places[1]);
            }
            LocalDateTime localDateTime = DateUtil.dateToLocalDateTime(response.getSendTime());
            //返回发布时间
            String time = localDateTime.getMonthValue()+"月"+localDateTime.getDayOfMonth()+"日"+localDateTime.getHour()+"时"+localDateTime.getMinute()+"分";
            response.setShowTime(time);
        });
        return APIResult.create(BaseResponse.create(page.getTotal(),responseList));
    }

    /**
     * 招聘者查看自己发布职位的职位投递情况
     *
     * @param recruiterId
     * @return
     */
    @Override
    public APIResult recruiterGotList(Integer recruiterId) {
        List<RecruiterGotListResponse> responseList = jobSendMapper.selectByRecruiterId(recruiterId);
        return APIResult.create(responseList);
    }

    /**
     * 修改投递状态
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult updateSendStatus(UpdateSendStatusRequest request) {
        jobSendMapper.updateByJobIdAndUserId(request.getJobId(),request.getUserId(),request.getType());
        return APIResult.ok();
    }
}
