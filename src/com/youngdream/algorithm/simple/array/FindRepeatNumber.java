package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/19 22:37
 */
public class FindRepeatNumber {
    /**
     * 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * <p>
     * 限制：
     * 2 <= n <= 100000
     *
     * @param nums 给定数组
     * @return 重复的数字
     */
    public int findRepeatNumber(int[] nums) {
        //  慢 20ms
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return num;
//            } else {
//                set.add(num);
//            }
//        }
        // 还是慢 3ms
//        int[] counts = new int[100000];
//        for (int num : nums) {
//            if (counts[num] > 0) {
//                return num;
//            } else {
//                counts[num]++;
//            }
//        }
        /*
         * 最优解
         * 在原数组上统计，个人忽略了长度为n
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[i] != nums[nums[i]]) {
                    int k = nums[i];
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                } else {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
