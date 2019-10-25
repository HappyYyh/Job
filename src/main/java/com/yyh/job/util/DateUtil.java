package com.yyh.job.util;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

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

    /**
     * 计算一个日期距今多少天
     * @param from
     * @return
     */
    public static String calculateDifDays(String from){
        //解析日期
        LocalDate start;
        try {
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
            start = LocalDate.parse(from, formatter);
        } catch (DateTimeParseException e) {
            return "请输入正确的日期格式，格式为：yyyy-MM-dd";
        }
        LocalDate now = LocalDate.now();
        if(start.isAfter(now)){
            return  "输入日期不能大于现在！";
        }
        long between = ChronoUnit.DAYS.between(start, now);
        StringBuilder sb = new StringBuilder();
        sb.append("从").append(start.getYear()).append("年").append(start.getMonthValue()).append("月")
          .append(start.getDayOfMonth()).append("日");
        sb.append("距今已经").append(between).append("天了！");
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println("请输入需要计算的日期，以“exit”结束：");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"exit".equals(input = scanner.nextLine())){
            String result = calculateDifDays(input);
            System.out.println(result);
        }
    }


}
