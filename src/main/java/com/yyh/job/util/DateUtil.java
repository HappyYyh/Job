package com.yyh.job.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Package com.yyh.job.util
 * @author: 昊天
 * @date: 2019-04-20 14:57
 * @since V1.1.0-SNAPSHOT
 */
public class DateUtil {

    /**
     * date转localDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date){
        if(null == date){
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * date转LocalDateTime
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        if(null == date){
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant,zoneId);
    }


    /**
     * 获取string类型的datetime
     * @return
     */
    public static String getStringDateTime(){
        LocalDateTime now = LocalDateTime.now();
        return now.getMonthValue()+"月"+now.getDayOfMonth()+"日"+now.getHour()+"时"+now.getMinute()+"分";
    }

    /**
     * 获取string类型的日期
     * @return
     */
    public static String getStringDate(){
        LocalDate now = LocalDate.now();
        return now.getDayOfMonth()+"月"+now.getDayOfMonth()+"日";
    }


}
