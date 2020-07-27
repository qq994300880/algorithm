package com.youngdream.algorithm.medium.string;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/27 15:26
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s 给定字符串
     * @return 最长子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int result = 0;
        boolean[] counts = new boolean[128];
        int start = 0;
        int end = 1;
        counts[s.charAt(start)] = true;
        while (end < len) {
            if (counts[s.charAt(end)]) {
                counts[s.charAt(start)] = false;
                start++;
            } else {
                counts[s.charAt(end)] = true;
                end++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }
}
