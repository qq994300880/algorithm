package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/10/6 13:13
 */
public class FindMaxAverage {
    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * 示例 1:
     * 输入: [1,12,-5,-6,50,3], k = 4
     * 输出: 12.75
     * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * <p>
     * 注意:
     * 1 <= k <= n <= 30,000。
     * 所给数据范围 [-10,000，10,000]。
     */
    //暴力法
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        //遍历数组
        for (int i = k - 1; i < nums.length; i++) {
            int sum = 0;
            //计算长度为k的连续数组的和
            for (int j = 0; j < k; j++) {
                sum += nums[i - j];
            }
            //记录最大和
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }

    //思考：重复计算的项可以省略，利用长度为k的滑动窗口
    public double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        //计算第一次和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        //开始滑动
        for (int i = k; i < nums.length; i++) {
            //减去k长度数组的第一个数
            sum -= nums[i - k];
            //加上k长度数组的后一个数
            sum += nums[i];
            //记录最大值
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}
