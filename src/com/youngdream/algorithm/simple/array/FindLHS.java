package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @Author YoungDream
 * @Date 2019/9/29 13:26
 */
public class FindLHS {
    /**
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
     * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
     * <p>
     * 示例 1:
     * 输入: [1,3,2,2,5,2,3,7]
     * 输出: 5
     * 原因: 最长的和谐数组是：[3,2,2,2,3].
     * <p>
     * 说明: 输入的数组长度最大不超过20,000.
     * <p>
     * 执行用时 :20 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 40.9 MB, 在所有 Java 提交中击败了 94.12% 的用户
     */
    public int findLHS(int[] nums) {
        //数组为null或者长度为0
        if (nums == null || nums.length == 0) return 0;
        //排序O(nlogn)
        Arrays.sort(nums);
        //1 2 2 2 3 3 5 7
        int result = 0;//结果
        int now = nums[0];//当前数
        int preCount = 0;//上一个差为0或者1的数的个数
        int nowCount = 0;//当前数的个数
        //O(n)
        for (int num : nums) {
            //统计当前数的数量
            if (num == now) nowCount++;
            else {
                //数变了,同时两数差值为1
                //否则上一个数的次数置0
                preCount = num == now + 1 ? nowCount : 0;
                //当前数变化
                now = num;
                //当前数个数重置为1
                nowCount = 1;
            }
            //如果有一方次数为0，说明只有一个元素,不符合题目要求
            if (preCount != 0 && nowCount != 0) result = Math.max(result, preCount + nowCount);
        }
        return result;
    }
}
