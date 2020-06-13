package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/13 14:10
 */
public class Search2 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * <p>
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: 0
     * <p>
     * 限制：
     * 0 <= 数组长度 <= 50000
     * <p>
     * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * @param nums   给定数组
     * @param target 目标数字
     * @return 个数
     */
    public int search2(int[] nums, int target) {
        //无序解法
        int result = 0;
        for (int num : nums) {
            if (num == target) {
                result++;
            }
        }
        return result;
    }

    public int search(int[] nums, int target) {
        //有序解法
        int index = getIndex(nums, target);
        if (index == -1) {
            return 0;
        }
        int result = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            result++;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            result++;
        }
        return result;
    }

    private int getIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            //防止整形溢出
            int middle = start + (end - start) / 2;
            int val = nums[middle];
            if (val == target) {
                return middle;
            } else if (val < target) {
                start = middle + 1;
            } else if (val > target) {
                end = middle - 1;
            }
        }
        return -1;
    }
}
