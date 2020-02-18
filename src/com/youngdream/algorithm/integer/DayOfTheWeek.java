package com.youngdream.algorithm.integer;

/**
 * @author YangDuan
 * @date 2020/2/18 23:07
 */
public class DayOfTheWeek {
    /**
     * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
     * 输入为三个整数：day、month 和 year，分别表示日、月、年。
     * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
     * <p>
     * 示例 1：
     * 输入：day = 31, month = 8, year = 2019
     * 输出："Saturday"
     * <p>
     * 示例 2：
     * 输入：day = 18, month = 7, year = 1999
     * 输出："Sunday"
     * <p>
     * 示例 3：
     * 输入：day = 15, month = 8, year = 1993
     * 输出："Sunday"
     * <p>
     * 提示：
     * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
     */
    public String dayOfTheWeek(int day, int month, int year) {
        // 1971-1-1 星期五 得到多出了几个29日
        int quotient = (year - 1969) / 4;
        //  当前年份包含的天数
        int nowYear = 0;
        switch (month) {
            case 12:
                nowYear += 30;
            case 11:
                nowYear += 31;
            case 10:
                nowYear += 30;
            case 9:
                nowYear += 31;
            case 8:
                nowYear += 31;
            case 7:
                nowYear += 30;
            case 6:
                nowYear += 31;
            case 5:
                nowYear += 30;
            case 4:
                nowYear += 31;
            case 3:
                nowYear += 28;
            case 2:
                nowYear += 31;
            case 1:
                nowYear += day;
            default:
        }
        if ((year % 100 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0) && month > 2) {
            nowYear++;
        }
        int count = 365 * (year - 1971) + quotient + nowYear;
        return strs[(count + 4) % 7];
    }

    private static String[] strs = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
}
