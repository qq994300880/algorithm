package com.youngdream.algorithm.simple.string;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/17 13:43
 */
public class ReformatDate {
    /**
     * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
     * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
     * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
     * Year 的范围在 ​[1900, 2100] 之间。
     * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
     * YYYY 表示 4 位的年份。
     * MM 表示 2 位的月份。
     * DD 表示 2 位的天数。
     * <p>
     * 示例 1：
     * 输入：date = "20th Oct 2052"
     * 输出："2052-10-20"
     * <p>
     * 示例 2：
     * 输入：date = "6th Jun 1933"
     * 输出："1933-06-06"
     * <p>
     * 示例 3：
     * 输入：date = "26th May 1960"
     * 输出："1960-05-26"
     *  
     * 提示：
     * 给定日期保证是合法的，所以不需要处理异常输入。
     *
     * @param date 给定字符串
     * @return 转变后的字符串
     */
    public String reformatDate(String date) {
        int len = date.length();
        StringBuilder sb = new StringBuilder();
        //添加年
        sb.append(date, len - 4, len);
        sb.append('-');
        //添加月
        sb.append(getNumber(date.substring(len - 8, len - 5)));
        sb.append('-');
        //添加日
        if (len == 12) {
            sb.append('0');
        }
        sb.append(date, 0, len - 11);

        //正则影响性能
//        String[] s = date.split(" ");
//        String day = s[0];
//        if (day.length() == 3) {
//            day = "0" + day.charAt(0);
//        } else {
//            day = day.substring(0, 2);
//        }
//        String month = getNumber(s[1]);
//        String year = s[2];
//        return year + "-" + month + "-" + day;
        return sb.toString();
    }

    String getNumber(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            default:
                return "12";
        }
    }
}
