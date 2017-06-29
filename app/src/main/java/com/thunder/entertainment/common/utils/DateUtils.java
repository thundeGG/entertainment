package com.thunder.entertainment.common.utils;

/**
 * Created by beibeizhu on 17/6/22.
 */

public class DateUtils {
    public static String formatTime2(long showTime){
        StringBuilder sb = new StringBuilder();
        long min = showTime / 60;
        long second = showTime % 60;
        sb.append(min < 10?"0"+min:min)
                .append("'")
                .append(second < 10?"0"+second:second)
                .append("\"");
        return sb.toString();
    }
}
