package com.youngdream.algorithm.string;

/**
 * @author YangDuan
 * @date 2020/2/11 20:41
 */
public class DayOfYear {
    /**
     * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
     * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
     * <p>
     * 示例 1：
     * 输入：date = "2019-01-09"
     * 输出：9
     * <p>
     * 示例 2：
     * 输入：date = "2019-02-10"
     * 输出：41
     * <p>
     * 示例 3：
     * 输入：date = "2003-03-01"
     * 输出：60
     * <p>
     * 示例 4：
     * 输入：date = "2004-03-01"
     * 输出：61
     * <p>
     * 提示：
     * date.length == 10
     * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
     * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
     */
    public int dayOfYear(String date) {
        int result = 0;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        switch (month) {
            case 12:
                result += 30;
            case 11:
                result += 31;
            case 10:
                result += 30;
            case 9:
                result += 31;
            case 8:
                result += 31;
            case 7:
                result += 30;
            case 6:
                result += 31;
            case 5:
                result += 30;
            case 4:
                result += 31;
            case 3:
                result += 28;
            case 2:
                result += 31;
            case 1:
                result += day;
            default:
        }
        if ((year % 100 == 0 && year % 400 == 0 || year % 4 == 0 && year % 100 != 0) && month > 2) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        String date = "2016-02-29";
        System.out.println(new DayOfYear().dayOfYear(date));
    }
}
