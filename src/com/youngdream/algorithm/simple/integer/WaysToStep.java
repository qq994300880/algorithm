package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/28 21:31
 */
public class WaysToStep {
    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * <p>
     * 示例1:
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * <p>
     * 示例2:
     * 输入：n = 5
     * 输出：13
     * <p>
     * 提示:
     * n范围在[1, 1000000]之间
     *
     * @param n n阶台阶
     * @return 多少种上楼梯的方式
     */
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        /*
         * 发现规律
         * 1 2 3 4  5  6  7   8   9...
         * 1 2 4 7 13 24 44  81 149...
         * C(n)=C(n-1)+C(n-2)+C(n-3)
         */
        int[] counts = new int[n + 1];
        int mod = 1000000007;
        int sum;
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;
        for (int i = 4; i <= n; i++) {
            sum = counts[i - 1] + counts[i - 2];
            //  性能比%要好
            if (sum > mod) {
                sum -= mod;
            }
            sum += counts[i - 3];
            if (sum > mod) {
                sum -= mod;
            }
            counts[i] = sum;
        }
        return counts[n];
    }
}
