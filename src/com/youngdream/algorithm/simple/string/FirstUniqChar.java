package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/6/12 0:36
 */
public class FirstUniqChar {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     * <p>
     * 示例:
     * s = "abaccdeff"
     * 返回 "b"
     * <p>
     * s = ""
     * 返回 " "
     * <p>
     * 限制：
     * 0 <= s 的长度 <= 50000
     *
     * @param s 给定字符串
     * @return 第一次只出现一次的字符
     */
    public char firstUniqChar(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        //是否有结果
        boolean have = false;
        //结果
        int result = Integer.MAX_VALUE;
        //结果的排名
        int resultSort = Integer.MAX_VALUE;
        //排名
        int count = 1;
        //计算的索引
        int index;
        //记录名次
        int[] sorts = new int[26];
        //记录出现次数
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (sorts[index] == 0) {
                sorts[index] = count;
                count++;
            }
            counts[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1) {
                have = true;
                count = sorts[i];
                if (count > 0 && count < resultSort) {
                    result = i;
                    resultSort = sorts[result];
                }
            }
        }
        if (have) {
            return (char) (result + 'a');
        }
        return ' ';
    }
}
