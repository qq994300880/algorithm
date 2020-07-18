package com.youngdream.algorithm.simple.array;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/18 16:05
 */
public class NumIdenticalPairs {
    /**
     * 给你一个整数数组 nums 。
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     * <p>
     * 示例 1：
     * 输入：nums = [1,2,3,1,1,3]
     * 输出：4
     * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     * <p>
     * 示例 2：
     * 输入：nums = [1,1,1,1]
     * 输出：6
     * 解释：数组中的每组数字都是好数对
     * <p>
     * 示例 3：
     * 输入：nums = [1,2,3]
     * 输出：0
     * <p>
     * 提示：
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     *
     * @param nums 给定数组
     * @return 好数对的数量
     */
    public int numIdenticalPairs2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += getNums(nums[i], i + 1, nums);
        }
        return result;
    }

    //暴力法，利用函数调用提高效率
    private int getNums(int temp, int index, int[] nums) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            }
        }
        return count;
    }

    //优化方案，本题数组长度只有100，大数据量时间差会拉大
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] counts = new int[101];
        for (int num : nums) {
            result += counts[num];
            counts[num]++;
        }
        return result;
    }
}
