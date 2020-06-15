package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/15 15:20
 */
public class RunningSum {
    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
     * <p>
     * 示例 2：
     * 输入：nums = [1,1,1,1,1]
     * 输出：[1,2,3,4,5]
     * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
     * <p>
     * 示例 3：
     * 输入：nums = [3,1,2,10,1]
     * 输出：[3,4,6,16,17]
     * <p>
     * 提示：
     * 1 <= nums.length <= 1000
     * -10^6 <= nums[i] <= 10^6
     *
     * @param nums 给定数组
     * @return 动态和
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }
        return result;
    }
}
