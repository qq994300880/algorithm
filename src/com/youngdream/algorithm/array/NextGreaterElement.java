package com.youngdream.algorithm.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author YoungDream
 * @Date 2019/9/4 11:30
 */
public class NextGreaterElement {
    /**
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     * <p>
     * 示例 1:
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * <p>
     * 示例 2:
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
     * 对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     * <p>
     * 注意:
     * nums1和nums2中所有元素是唯一的。
     * nums1和nums2 的数组大小都不超过1000。
     */
    //方法一：暴力法，时间:O(N*N)  空间:O(1)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        boolean b = false;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    b = true;
                }
                if (b) {
                    if (nums2[j] > nums1[i]) {
                        result[i] = nums2[j];
                        b = false;
                        break;
                    }
                }
                if (j == nums2.length - 1) {
                    result[i] = -1;
                    b = false;
                }
            }
        }
        return result;
    }

    //方法二：使用Map记录所有元素的结果，获取Map中的结果即可  O(N*logN)  O(N)
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int length = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
                if (j == length - 1) map.put(nums2[i], -1);
            }
            if (i == length - 1) map.put(nums2[i], -1);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    //方法三：使用stack和map
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> hasMap = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int num : nums2) {
            //如果栈不为空且栈内元素(上一个元素)小于当前元素，则加入到Map中
            while (!stack.isEmpty() && stack.peekFirst() < num) {
                hasMap.put(stack.pollFirst(), num);
            }
            stack.addFirst(num);
        }
        //获取map值，没有为-1
        for (int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }

    //方法四(排行第一)：相对方法二是自己实现了一个map数组记录索引位置
    public int[] nextGreaterElement4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return new int[0];

        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1];


        // find the max value and min value in the nums2 array
        //寻找nums2的最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : nums2) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        // create a sortted array mapping the value to the index of nums2 array
        max = Math.max(Math.abs(max), Math.abs(min));
        int length = 0;
        boolean flag = min < 0;
        if (flag)
            //如果最小值为负数，则创建2倍容量
            length = (max << 1) + 1;
        else
            //否则只创建一倍容量
            length = max + 1;
        int[] map = new int[length];


        for (int i = 0; i < length2; i++) {
            if (flag)
                map[nums2[i] + max] = i;
            else
                map[nums2[i]] = i;
        }

        for (int i = 0; i < length1; i++) {
            result[i] = -1;
            //获取对应Map位置
            int position = flag ? nums1[i] + max : nums1[i];
            //获取nums2对应索引
            int index = map[position];
            for (int j = index + 1; j < length2; j++) {
                int num1 = nums1[i];
                if (num1 < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }
}
