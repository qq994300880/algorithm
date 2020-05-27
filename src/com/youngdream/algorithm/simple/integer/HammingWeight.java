package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/27 14:31
 */
public class HammingWeight {
    // you need to treat n as an unsigned value

    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * <p>
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * <p>
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * <p>
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     * @param n 给定数字
     * @return 二进制1的个数
     */
    public int hammingWeight(int n) {
        //  快
//        return Integer.bitCount(n);
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
