package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/3/31 21:50
 */
public class CanPermutePalindrome {
    /**
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     * 回文串不一定是字典当中的单词。
     * <p>
     * 示例1：
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     *
     * @param s 给定字符串
     * @return 是否为回文排列
     */
    public boolean canPermutePalindrome(String s) {
        // 122为调试过的数值,如需扩大可自行更改
        int[] counts = new int[122];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        int odd = 0;
        for (int count : counts) {
            odd += (count & 1);
            if (odd > 1) {
                return false;
            }
        }
        return true;
    }
}
