package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/28 21:30
 */
public class Exchange {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * <p>
     * 示例：
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *  
     * 提示：
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10000
     *
     * @param nums 给定数组
     * @return 排序后的数组
     */
    public int[] exchange2(int[] nums) {
        //  利用常数空间，双指针，在原数组上修改
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            while (start < nums.length - 1 && (nums[start] & 1) == 1) {
                start++;
            }
            while (end > 0 && (nums[end] & 1) == 0) {
                end--;
            }
            if (start >= end) {
                break;
            }
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
        return nums;
    }

    public int[] exchange(int[] nums) {
        //空间O(n),使用一个新数组记录，遍历一次数组
        int[] result = new int[nums.length];
        int start = 0;
        int end = result.length - 1;
        for (int num : nums) {
            if ((num & 1) == 1) {
                result[start++] = num;
            } else {
                result[end--] = num;
            }
        }
        return result;
    }
}
