package com.youngdream.algorithm.simple.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author YoungDream
 * @Date 2019/9/9 22:38
 */
public class FindPairs {
    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     * <p>
     * 示例 1:
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * <p>
     * 示例 2:
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * <p>
     * 示例 3:
     * 输入: [1, 3, 1, 5, 4], k = 0
     * 输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     * <p>
     * 注意:
     * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
     * 数组的长度不超过10,000。
     * 所有输入的整数的范围在 [-1e7, 1e7]。
     */
    //方式一：自己想出来的鬼方法，主要在处理k>=1时没有好的方案
    public int findPairs1(int[] nums, int k) {
        int result = 0;
        //处理k==0
        if (k == 0) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        if (!set.contains(nums[i])) {
                            result++;
                            set.add(nums[i]);
                        }
                    }
                }
            }
            //处理其他
        } else {
            Arrays.sort(nums);
            int tempa = Integer.MIN_VALUE;
            int tempb = Integer.MIN_VALUE;
            //差异在这里时间复杂度O(n*n)
            for (int i = 0; i < nums.length; i++) {
                if (tempa == nums[i]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (tempb == nums[j]) continue;
                    if (nums[j] - nums[i] == k) result++;
                    tempb = nums[j];
                }
                tempb = Integer.MIN_VALUE;
                tempa = nums[i];
            }
        }
        return result;
    }

    //方式二：优化
    public int findPairs(int[] nums, int k) {
        //如果数组为空、k为负数、数组长度小于2则直接返回0
        if (nums == null || k < 0 || nums.length <= 1) return 0;
        //对数组进行排序
        Arrays.sort(nums);

        //处理k=0
        if (k == 0) {
            int i = 0;
            int count = 0;
            while (i < nums.length - 1) {
                //如果前一项=后一项，则++
                if (nums[i] == nums[i + 1]) {
                    count++;
                    //过滤相同的项
                    i = next(nums, i);
                } else i++;
            }
            return count;
        }

        //处理k >= 1
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < nums.length) {
            //类似滑动窗口？
            if (nums[j] - nums[i] == k) {
                count++;
                //跳过相同项,j和i一样
                j = next(nums, j);
                i = next(nums, i);
            } else if (nums[j] - nums[i] < k) {
                //小于绝对值，说明nums[j]小了,跳过j相同项
                j = next(nums, j);
            } else if (nums[j] - nums[i] > k) {
                //同上,跳过i相同项
                i = next(nums, i);
            }
        }
        return count;
    }

    private int next(int[] nums, int index) {
        int j = index + 1;
        while (j < nums.length && nums[j] == nums[index])
            j++;
        return j;
    }
}
