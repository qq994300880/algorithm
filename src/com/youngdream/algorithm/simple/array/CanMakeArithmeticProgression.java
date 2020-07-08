package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @email 994300880@qq.com
 * @date 2020/7/8 11:15
 */
public class CanMakeArithmeticProgression {
    /**
     * 给你一个数字数组 arr 。
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：arr = [3,5,1]
     * 输出：true
     * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
     * <p>
     * 示例 2：
     * 输入：arr = [1,2,4]
     * 输出：false
     * 解释：无法通过重新排序得到等差数列。
     * <p>
     * 提示：
     * 2 <= arr.length <= 1000
     * -10^6 <= arr[i] <= 10^6
     *
     * @param arr 给定数字数组
     * @return 是否能形成等差数列
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        //暴力法???
        Arrays.sort(arr);
        int num = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != num) {
                return false;
            }
        }
        return true;
    }
}
