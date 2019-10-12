package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/10/12 11:12
 */
public class FindLengthOfLCIS {
    /**
     * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
     * <p>
     * 示例 1:
     * 输入: [1,3,5,4,7]
     * 输出: 3
     * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
     * <p>
     * 示例 2:
     * 输入: [2,2,2,2,2]
     * 输出: 1
     * 解释: 最长连续递增序列是 [2], 长度为1。
     * 注意：数组长度不会超过10000。
     */
    public int findLengthOfLCIS(int[] nums) {
        //空判断
        if (nums == null || nums.length == 0) return 0;
        //记录结果长度
        int result = 1;
        //记录最大连续长度
        int max = 1;
        //计算
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                max++;
                result = Math.max(max, result);
            } else {
                max = 1;
            }
        }
        return result;
    }
}
