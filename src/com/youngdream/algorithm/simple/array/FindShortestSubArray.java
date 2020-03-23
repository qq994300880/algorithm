package com.youngdream.algorithm.simple.array;

import java.util.Collections;
import java.util.HashMap;

/**
 * @Author YoungDream
 * @Date 2019/11/8 19:01
 */
public class FindShortestSubArray {
    /**
     * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
     * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     * <p>
     * 示例 1:
     * 输入: [1, 2, 2, 3, 1]
     * 输出: 2
     * 解释:
     * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
     * 连续子数组里面拥有相同度的有如下所示:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组[2, 2]的长度为2，所以返回2.
     * <p>
     * 示例 2:
     * 输入: [1,2,2,3,1,4,2]
     * 输出: 6
     * <p>
     * 注意:
     * nums.length 在1到50,000区间范围内。
     * nums[i] 是一个在0到49,999范围内的整数。
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> rigth = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            //操作计数
            count.merge(temp, 1, Integer::sum);
            left.putIfAbsent(temp, i);
            //保存数最后出现的坐标
            rigth.put(temp, i);
        }
        //结果默认为数组长度
        int result = nums.length;
        //获得最大的度
        int degree = Collections.max(count.values());
        for (Integer x : count.keySet()) {
            if (count.get(x) == degree) {
                result = Math.min(result, rigth.get(x) - left.get(x) + 1);
            }
        }
        return result;
    }

    public int findShortestSubArray2(int[] nums) {
        //使用Array代替Map
        //统计每个数的度
        int[] counts = new int[50000];
        //统计每个数开始的索引坐标
        int[] indexs = new int[50000];
        //初始化索引坐标为-1
        for (int i = 0; i < 50000; i++) {
            indexs[i] = -1;
        }
        //记录最大的度
        int maxCount = 0;
        //记录最大度的数
        int maxCountNum = 0;
        //记录最大度数结束索引
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            counts[num] += 1;
            //记录开始索引
            if (indexs[num] == -1) {
                indexs[num] = i;
            }
            //记录最大的度和最大度数的结束索引
            if (maxCount < counts[num]) {
                maxCount = counts[num];
                endIndex = i;
                maxCountNum = num;
            } else if (maxCount == counts[num]) {//如果度相等
                //判断长度的最小值
                if (i - indexs[num] < endIndex - indexs[maxCountNum]) {
                    endIndex = i;
                    maxCountNum = num;
                }
            }
        }
        return endIndex - indexs[maxCountNum] + 1;
    }
}
