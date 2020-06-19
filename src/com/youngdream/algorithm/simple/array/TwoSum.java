package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/19 23:39
 */
public class TwoSum {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     * <p>
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * <p>
     * 示例 2：
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     * <p>
     * 限制：
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     *
     * @param nums   递增数组
     * @param target 目标和
     * @return 任意一对数字
     */
    public int[] twoSum(int[] nums, int target) {
        int t = target / 2;
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == t) {
                break;
            }
            if (nums[mid] < t) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = mid;
        r = mid;
        while (l >= 0 && r < nums.length) {
            if ((nums[l] + nums[r]) == target && l != r) {
                return new int[]{nums[l], nums[r]};
            }
            if ((nums[l] + nums[r]) > target) {
                l--;
            } else {
                r++;
            }
        }
        return null;
    }
}
