package com.rul.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @author: Luoru
 *  @Date: 2019/10/14 15:27
 *  @Description: 工具类，返回系统当前时间的字符串表示
 */
public class LocalTime {
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentTime);
    }
}
