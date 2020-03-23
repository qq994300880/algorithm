package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/18 22:14
 */
public class DaysBetweenDates {
    /**
     * 请你编写一个程序来计算两个日期之间隔了多少天。
     * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
     * <p>
     * 示例 1：
     * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
     * 输出：15
     * <p>
     * 提示：
     * 给定的日期是 1971 年到 2100 年之间的有效日期。
     *
     * @param date1 第一个日期字符串
     * @param date2 第二个日期字符串
     * @return 间隔的天数
     */
    public int daysBetweenDates(String date1, String date2) {
        int result = 0;
        int year1;
        int month1;
        int day1;
        int year2;
        int month2;
        int day2;
        year1 = Integer.parseInt(date1.substring(0, 4));
        month1 = Integer.parseInt(date1.substring(5, 7));
        day1 = Integer.parseInt(date1.substring(8, 10));
        year2 = Integer.parseInt(date2.substring(0, 4));
        month2 = Integer.parseInt(date2.substring(5, 7));
        day2 = Integer.parseInt(date2.substring(8, 10));
        //  大日期放前面
        if ((year1 < year2)
                || ((year1 == year2) && (month1 < month2))
                || ((year1 == year2) && (month1 == month2) && (day1 < day2))) {
            year1 = year1 ^ year2;
            year2 = year1 ^ year2;
            year1 = year1 ^ year2;
            month1 = month1 ^ month2;
            month2 = month1 ^ month2;
            month1 = month1 ^ month2;
            day1 = day1 ^ day2;
            day2 = day1 ^ day2;
            day1 = day1 ^ day2;
        }
        //  年月相同
        if (year1 == year2 && month1 == month2) {
            return day1 - day2;
            //  年相同
        } else if (year1 == year2) {
            //  通过月份计算之间间隔
            for (int i = month2; i < month1; i++) {
                result += MONTHS[i];
            }
            if (month2 < 3 && month1 > 2) {
                if (isLeapYear(year1)) {
                    result++;
                }
            }
            result -= day2;
            result += day1;
        } else {
            for (int i = year2; i < year1; i++) {
                if (isLeapYear(i)) {
                    result += 366;
                } else {
                    result += 365;
                }
            }
            result -= getDays(year2, month2, day2);
            result += getDays(year1, month1, day1);
        }
        return result;
    }

    private static final int[] MONTHS = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

    private boolean isLeapYear(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 400 == 0);
    }

    private int getDays(int year, int month, int day) {
        int r = 0;
        for (int i = 0; i < month; i++) {
            r += MONTHS[i];
        }
        if (month > 2 && isLeapYear(year)) {
            r++;
        }
        r += day;
        return r;
    }
}
