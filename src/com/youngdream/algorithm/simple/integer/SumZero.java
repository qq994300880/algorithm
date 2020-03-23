package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/3/6 22:18
 */
public class SumZero {
    /**
     * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
     * <p>
     * 示例 1：
     * 输入：n = 5
     * 输出：[-7,-1,1,3,4]
     * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
     * <p>
     * 示例 2：
     * 输入：n = 3
     * 输出：[-1,0,1]
     * <p>
     * 示例 3：
     * 输入：n = 1
     * 输出：[0]
     * <p>
     * 提示：
     * 1 <= n <= 1000
     *
     * @param n 个数
     * @return 不重复的数组
     */
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int len = n / 2;
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        for (int i = 0; i < len; i++) {
            result[i] = i - len;
        }
        for (int i = result.length - 1; i >= len; i--) {
            result[i] = n - i;
        }
        if ((n & 1) == 1) {
            result[len + 1] = 0;
        }
        return result;
    }
}
