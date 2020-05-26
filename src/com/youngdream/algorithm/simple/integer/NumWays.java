package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/26 21:50
 */
public class NumWays {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：n = 7
     * 输出：21
     * <p>
     * 提示：
     * 0 <= n <= 100
     * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
     *
     * @param n 台阶数
     * @return 多少种跳法
     */
    public int numWays(int n) {
        return counts[n];
    }

    private static int[] counts = new int[101];

    static {
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i < counts.length; i++) {
            counts[i] = (counts[i - 1] + counts[i - 2]) % 1000000007;
        }
    }
}
