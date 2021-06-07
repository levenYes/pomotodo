package cn.liwenye.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liwenye on 2018/01/02
 */
public class DateUtil {
    public static Date convertDate(String strDate){
        try {
            strDate = strDate.substring(0,19);
            strDate = strDate.replace("T"," ");
            //为什么这个地方的HH要大写，不能用hh？
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSomeDayBefore(int howManyDays) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.add(Calendar.DATE, -howManyDays);
        String threeDaysAgo = sdf.format(calendar.getTime());
        return threeDaysAgo;
    }

    /**
     *TODO
     *
     * 添加一个获取当前日期字符串的方法
     *
     */
}
