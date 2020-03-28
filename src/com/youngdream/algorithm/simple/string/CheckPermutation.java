package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/28 21:59
 */
public class CheckPermutation {
    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <p>
     * 示例 1：
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * <p>
     * 示例 2：
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     * <p>
     * 说明：
     * 0 <= len(s1) <= 100
     * 0 <= len(s2) <= 100
     *
     * @param s1 第一个字符串
     * @param s2 第二个字符串
     * @return 是否互为字符重排
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i - 'a')]--;
        }
        for (int i : counts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
