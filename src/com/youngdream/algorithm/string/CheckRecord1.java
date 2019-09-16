package com.youngdream.algorithm.string;

/**
 * @Author YoungDream
 * @Date 2019/9/16 15:40
 */
public class CheckRecord1 {
    /**
     * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
     * 'A' : Absent，缺勤
     * 'L' : Late，迟到
     * 'P' : Present，到场
     * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
     * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
     * <p>
     * 示例 1:
     * 输入: "PPALLP"
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: "PPALLL"
     * 输出: False
     */
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        //统计缺勤次数
        int a = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                a++;
                //判断是否超过两次缺勤
                if (a > 1) return false;
            }
            //判断是否三次连续迟到
            if (i > 1 && chars[i] == 'L' && chars[i - 1] == 'L' && chars[i - 2] == 'L') return false;
        }
        return true;
    }
}
