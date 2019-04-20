package com.yyh.job.util;

import java.time.Instant;
import java.time.LocalDate;
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
}
