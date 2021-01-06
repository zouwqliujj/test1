package com.wenwo.cloud.compounder.prescriptionoutflow.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取指定时间的那天 23:59:59.999 的时间
     */
    public static Date dayEnd(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 计算两个日期之间相差的秒
     *
     * @param one   较小的时间
     * @param other 较大的时间
     * @return 相差天数
     */
    public static int secondBetween(Date one, Date other) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_FULL);
        one = sdf.parse(sdf.format(one));
        other = sdf.parse(sdf.format(other));
        Calendar cal = Calendar.getInstance();
        cal.setTime(one);
        long time1 = cal.getTimeInMillis();
        cal.setTime(other);
        long time2 = cal.getTimeInMillis();
        long between_second = (time2 - time1) / (1000); // 共计秒数

        return Integer.parseInt(String.valueOf(between_second));
    }
}
