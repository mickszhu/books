package com.mickszhu.demo.utiles;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTools {

    /**
     * 获取当前时间
     * @return
     */
    public static Date getDate() {
        try {
            LocalDate df = LocalDate.now();
            //new SimpleDateFormat("yyyy-MM-dd");
            return Date.from(df.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }
    public static LocalDate getLocalDate(Date date){
        if(date ==null){
            return null;
        }
        return  date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
