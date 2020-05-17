package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/5/17 21:59
 */
public class MaxPower {
    /**
     * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
     * 请你返回字符串的能量。
     * <p>
     * 示例 1：
     * 输入：s = "leetcode"
     * 输出：2
     * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
     * <p>
     * 示例 2：
     * 输入：s = "abbcccddddeeeeedcba"
     * 输出：5
     * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
     * <p>
     * 示例 3：
     * 输入：s = "triplepillooooow"
     * 输出：5
     * <p>
     * 示例 4：
     * 输入：s = "hooraaaaaaaaaaay"
     * 输出：11
     * <p>
     * 示例 5：
     * 输入：s = "tourist"
     * 输出：1
     * <p>
     * 提示：
     * 1 <= s.length <= 500
     * s 只包含小写英文字母。
     *
     * @param s 给定字符串
     * @return 字符串的能量
     */
    public int maxPower(String s) {
        // s.length()>=1，结果最小为1
        int result = 1;
        // 记录字符相同的次数
        int count = 1;
        // 连续的字符
        char temp = s.charAt(0);
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == temp) {
                // 相同次数+1
                count++;
            } else {
                // 判断连续次数是否result
                if (count > result) {
                    result = count;
                }
                //  更新temp和count
                temp = s.charAt(i);
                count = 1;
            }
        }
        //  兜底结尾一直连续
        if (count > result) {
            result = count;
        }
        return result;
    }
}
