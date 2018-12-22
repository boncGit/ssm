package com.watchme.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static void main(String[] args){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String beginTime = dateFormat.format(date);
        System.out.println(beginTime);

        int a = 0;
        long afterTime=(date.getTime()/1000)+a;
        date.setTime(afterTime*1000);
        String endTime = dateFormat.format(date);
        System.out.println(endTime);

        try {
            dateFormat.parse(beginTime).getTime();
            dateFormat.parse(endTime).getTime();
            System.out.println(dateFormat.parse(beginTime).getTime() >= dateFormat.parse(endTime).getTime());

            Date date2 = new Timestamp(System.currentTimeMillis());
            System.out.println(date2.getTime() >= dateFormat.parse(endTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
