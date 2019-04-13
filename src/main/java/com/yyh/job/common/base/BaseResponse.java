package com.yyh.job.common.base;


import java.io.Serializable;

/**
 * @Package com.yyh.job.common.base
 * @author: 昊天
 * @date: 2019-04-13 15:35
 * @since V1.1.0-SNAPSHOT
 */
public class BaseResponse<E>{

    /**
     * 总记录数量
     */
    private long total;

    /**
     * 数据
     */
    private E list;

    public BaseResponse() {
    }

    public BaseResponse(long total, E list) {
        this.total = total;
        this.list = list;
    }

    public static <E> BaseResponse<E> create(long total,E list){
        return new BaseResponse<>(total,list);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public E getList() {
        return list;
    }

    public void setList(E list) {
        this.list = list;
    }
}
