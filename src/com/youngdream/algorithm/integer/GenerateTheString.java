package com.youngdream.algorithm.integer;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/3/21 13:58
 */
public class GenerateTheString {
    /**
     * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
     * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
     * <p>
     * 示例 1：
     * 输入：n = 4
     * 输出："pppz"
     * 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
     * <p>
     * 示例 2：
     * 输入：n = 2
     * 输出："xy"
     * 解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
     * <p>
     * 示例 3：
     * 输入：n = 7
     * 输出："holasss"
     * <p>
     * 提示：
     * 1 <= n <= 500
     *
     * @param n 给定整数
     * @return 结果字符串
     */
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if ((n & 1) == 0) {
            chars[n - 1] = 'b';
        }
        return new String(chars);
    }
}
