package com.yyh.job.common.base;

/**
 * All rights Reserved, Designed By 863044052@qq.com
 *
 * @Package com.cjs.question.common.base
 * @author: 昊天
 * @date: 2019-03-06 13:38
 * @since V1.1.0-SNAPSHOT
 */
public class BaseQuery {

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 每页个数
     */
    private Integer pageSize;

    /**
     * 偏移量
     */
    private Integer offset;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        countOffSet();
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 计算偏移量
     * @return
     */
    public Integer countOffSet(){
        if (null == pageNo || null == pageSize) {
            return null;
        }
        offset = (pageNo - 1) * pageSize;
        return offset;
    }
}
