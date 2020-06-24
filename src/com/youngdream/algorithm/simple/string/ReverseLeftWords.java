package com.youngdream.algorithm.simple.string;

/**
 * @author YangDuan
 * @date 2020/6/24 21:49
 */
public class ReverseLeftWords {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     * <p>
     * 示例 1：
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * <p>
     * 示例 2：
     * 输入: s = "lrloseumgh", k = 6
     * 输出: "umghlrlose"
     * <p>
     * 限制：
     * 1 <= k < s.length <= 10000
     *
     * @param s 给定字符串
     * @param n 前n个字符
     * @return 旋转后的字符串
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
