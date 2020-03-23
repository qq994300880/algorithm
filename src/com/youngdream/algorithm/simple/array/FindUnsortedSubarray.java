package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @Author YoungDream
 * @Date 2019/9/28 11:05
 */
public class FindUnsortedSubarray {
    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 示例 1:
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * <p>
     * 说明 :
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     */
    //时间复杂度O(nlogn+2n)
    public int findUnsortedSubarray(int[] nums) {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);
        Arrays.sort(result);
        int start = 0;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (result[i] != nums[i]) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (result[i] != nums[i]) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }

    //135ms 太慢了
    public int findUnsortedSubarray2(int[] nums) {
        int start = 0;
        int end = -1;
        one:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    start = i;
                    break one;
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    end = i;
                    return end - start + 1;
                }
            }
        }
        return end - start + 1;
    }

    //2ms   时间最大O(3n) 空间O(5)
    public int findUnsortedSubarray3(int[] nums) {
        //提前判断
        if (nums.length < 2) return 0;
        //最小有问题数
        int probMin = Integer.MAX_VALUE;
        //最大有问题数
        int probMax = Integer.MIN_VALUE;
        //已遍历中的最大数
        int max = nums[0];
        for (int num : nums) {
            //当前数比目前最大数小，说明有问题
            if (num < max) {
                //记录有问题数的最大值与最小值
                if (num > probMax) probMax = num;
                if (num < probMin) probMin = num;
            } else {
                //记录目前最大的数
                max = num;
            }
        }
        //如果没有 有问题的数 说明已经排好序了
        if (probMin == Integer.MAX_VALUE || probMax == Integer.MIN_VALUE) {
            return 0;  // 单调递增
        }
        //找到最小有问题数的下一个数的坐标(排除=)
        int first = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > probMin) {
                first = i;
                break;
            }
        }
        //找到最大有问题数的坐标
        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] <= probMax) {
                last = i;
                break;
            }
        }
        return last - first + 1;
    }
}
