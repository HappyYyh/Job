package com.yyh.job.service.serviceimpl;

import com.yyh.job.common.base.APIResult;
import com.yyh.job.dao.mapper.JobSubScribeMapper;
import com.yyh.job.dao.model.JobSubScribe;
import com.yyh.job.dto.request.job.CommonJobSubScribeRequest;
import com.yyh.job.service.JobSubScribeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Package com.yyh.job.service.serviceimpl
 * @author: 昊天
 * @date: 2019-04-30 22:41
 * @since V1.1.0-SNAPSHOT
 */
@Service
public class JobSubScribeServiceImpl implements JobSubScribeService {

    @Autowired
    private JobSubScribeMapper jobSubScribeMapper;

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult add(CommonJobSubScribeRequest request) {
        JobSubScribe jobSubScribe = new JobSubScribe();
        jobSubScribe.setJobCategory(request.getJobCategory());
        jobSubScribe.setWorkCity(request.getWorkCity());
        jobSubScribe.setUserId(request.getUserId());
        jobSubScribe.setGmtCreate(new Date());
        jobSubScribe.setGmtUpdate(new Date());
        jobSubScribeMapper.insert(jobSubScribe);
        return APIResult.ok();
    }

    /**
     * 查询我的订阅
     *
     * @param userId
     * @return
     */
    @Override
    public APIResult getMySubScribe(Integer userId) {
        JobSubScribe jobSubScribe = jobSubScribeMapper.selectByUserId(userId);
        return APIResult.create(jobSubScribe);
    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult update(CommonJobSubScribeRequest request) {
        JobSubScribe jobSubScribe = new JobSubScribe();
        BeanUtils.copyProperties(request,jobSubScribe);
        jobSubScribeMapper.updateByPrimaryKeySelective(jobSubScribe);
        return APIResult.ok();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public APIResult delete(Integer id) {
        jobSubScribeMapper.deleteByPrimaryKey(id);
        return APIResult.ok();
    }

    /**
     * 查询订阅者的id
     *
     * @param category
     * @return
     */
    @Override
    public List<Integer> getByCategory(String category) {
        return jobSubScribeMapper.selectByCategory(category);
    }

}
