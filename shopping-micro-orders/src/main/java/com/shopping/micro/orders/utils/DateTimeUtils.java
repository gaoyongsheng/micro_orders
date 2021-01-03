package com.shopping.micro.orders.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Author Gao
 * @Date 2020/11/22 15:54
 * @Version 1.0
 */
public class DateTimeUtils {

    private static final Logger LOG = LoggerFactory.getLogger(DateTimeUtils.class);

    private static final String date_format = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    private static Long stringToLong(String str){ return Long.parseLong(str); }

    public static DateFormat getDateFormat() {
        DateFormat df = threadLocal.get();
        if(df==null){
            df = new SimpleDateFormat(date_format);
            threadLocal.set(df);
        }
        return df;
    }

    public static String stampToDate(String timeStamp){
        Date date = new Date(stringToLong(timeStamp.trim()));
        return getDateFormat().format(date);
    }

    public static String dateToStamp(String date){
        Date result = null;
        try {
            result = getDateFormat().parse(date.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result.getTime() + "";
    }
    
    public static String getSysCurDate(){
        return getDateFormat().format(new Date(stringToLong(getSysCurTimeStamp())));
    }

    public static String getSysCurTimeStamp(){return System.currentTimeMillis() + "";}

}
