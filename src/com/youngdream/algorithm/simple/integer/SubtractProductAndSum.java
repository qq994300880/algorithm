package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/3/1 22:04
 */
public class SubtractProductAndSum {
    /**
     * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
     * <p>
     * 示例 1：
     * 输入：n = 234
     * 输出：15
     * 解释：
     * 各位数之积 = 2 * 3 * 4 = 24
     * 各位数之和 = 2 + 3 + 4 = 9
     * 结果 = 24 - 9 = 15
     * <p>
     * 示例 2：
     * 输入：n = 4421
     * 输出：21
     * 解释：
     * 各位数之积 = 4 * 4 * 2 * 1 = 32
     * 各位数之和 = 4 + 4 + 2 + 1 = 11
     * 结果 = 32 - 11 = 21
     * <p>
     * 提示：
     * 1 <= n <= 10^5
     */
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int temp;
        while (n > 0) {
            temp = n % 10;
            product *= temp;
            sum += temp;
            n /= 10;
        }
        return product - sum;
    }
}
