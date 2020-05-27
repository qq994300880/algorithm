package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/27 14:27
 */
public class MinArray {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * <p>
     * 示例 1：
     * 输入：[3,4,5,1,2]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：[2,2,2,0,1]
     * 输出：0
     * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     *
     * @param numbers 给定数组
     * @return 最小元素
     */
    public int minArray(int[] numbers) {
        //  这个不算题目吧???
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
