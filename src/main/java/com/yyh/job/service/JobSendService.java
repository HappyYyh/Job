package com.yyh.job.service;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dto.request.job.CommonJobSendRequest;
import com.yyh.job.dto.request.job.SeekerSendListRequest;
import com.yyh.job.dto.request.job.UpdateSendStatusRequest;

import java.util.Map;

/**
 * @Package com.yyh.job.service
 * @author: 昊天
 * @date: 2019-04-28 20:48
 * @since V1.1.0-SNAPSHOT
 */
public interface JobSendService {

    /**
     * 新增投递记录
     * @param request
     * @return
     */
    APIResult addSend(CommonJobSendRequest request);

    /**
     * 判断是否已经投递过
     * @param request
     * @return
     */
    APIResult isSend(CommonJobSendRequest request);

    /**
     * 求职者查看自己的投递记录
     * @param request
     * @return
     */
    APIResult seekerSendList(SeekerSendListRequest request);

    /**
     * 招聘者查看自己发布职位的职位投递情况
     * @param recruiterId
     * @return
     */
    APIResult recruiterGotList(Integer recruiterId);

    /**
     * 修改投递状态
     * @param request
     * @return
     */
    APIResult updateSendStatus(UpdateSendStatusRequest request);
}
