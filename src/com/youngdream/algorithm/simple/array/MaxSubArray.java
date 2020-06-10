package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/12 0:44
 */
public class MaxSubArray {
    /**
     * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
     * <p>
     * 示例：
     * 输入： [-2,1,-3,4,-1,2,1,-5,4]
     * 输出： 6
     * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * <p>
     * 进阶：
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @param nums 整数数组
     * @return 最大的总和
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            // sum+num<num
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
