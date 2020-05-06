package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/6 21:31
 */
public class TrailingZeroes {
    /**
     * 设计一个算法，算出 n 阶乘有多少个尾随零。
     * <p>
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * 说明: 你算法的时间复杂度应为 O(log n) 。
     *
     * @param n n阶乘
     * @return 多少个尾随零
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
