package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/13 21:47
 */
public class MissingNumber {
    /**
     * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
     * 注意：本题相对书上原题稍作改动
     * <p>
     * 示例 1：
     * 输入：[3,0,1]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：[9,6,4,2,3,5,7,0,1]
     * 输出：8
     *
     * @param nums 缺少了一个数字的数组
     * @return 消失的数字
     */
    public int missingNumber(int[] nums) {
        //  高斯算法 (首项+末项)*项数/2 - 已有数总和
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return len * (len + 1) / 2 - sum;
    }

    //排好序的解法
    public int missingNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
