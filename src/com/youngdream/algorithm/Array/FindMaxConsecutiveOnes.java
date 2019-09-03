package com.youngdream.algorithm.Array;

/**
 * @Author YoungDream
 * @Date 2019/9/3 17:36
 */
public class FindMaxConsecutiveOnes {
    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * <p>
     * 示例 1:
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * <p>
     * 注意：
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     */
    //方法一：暴力执法
    public int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0;
        int result = 0;
        for (int i : nums) {
            if (i == 1) count++;
            else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        //处理最后一次
        result = Math.max(count, result);
        return result;
    }
}
