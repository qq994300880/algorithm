package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/25 0:24
 */
public class MaxSlidingWindow {
    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     * <p>
     * 示例:
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * <p>
     * 提示：
     * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
     * <p>
     * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
     *
     * @param nums 给定数组
     * @param k    窗口大小
     * @return 最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        //结果数组
        int[] result = new int[nums.length - k + 1];
        //结果数组的索引
        int index = 0;
        //记录滑动窗口的第一个数的索引
        int one;
        //记录最大值
        int max = nums[0];
        //计算第一个滑动窗口的最大值
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        result[index++] = max;
        //开始滑动
        for (int i = k; i < nums.length; i++) {
            //如果下一个数大于之前最大值，则替换最大值
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i - k] == max) {
                //下一个数不大于之前的最大值且上一个滑动窗口的第一个数为最大值，则重新计算当前窗口的最大值
                one = i - k + 1;
                max = nums[one];
                for (int j = 1; j < k; j++) {
                    if (nums[one + j] > max) {
                        max = nums[one + j];
                    }
                }
            }
            //记录当前滑动窗口的最大值
            result[index++] = max;
        }
        return result;
    }
}
