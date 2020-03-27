package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/27 22:01
 */
public class IsUnique {
    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * <p>
     * 示例 1：
     * 输入: s = "leetcode"
     * 输出: false
     * <p>
     * 示例 2：
     * 输入: s = "abc"
     * 输出: true
     * <p>
     * 限制：
     * 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。
     *
     * @param astr 给定字符串
     * @return 字符是否唯一
     */
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
