package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @author YoungDream
 * @date 2020/1/17 1:53
 */
public class SortedSquares {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     * <p>
     * 示例 1：
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * <p>
     * 示例 2：
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *  
     * 提示：
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A 已按非递减顺序排序。
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares1(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int p = 0;
        // res的指针，第一个正数的索引
        int j = 0;
        while (j < len && A[j] < 0) {
            j++;
        }
        // 最后一个负数的索引
        int i = j - 1;
        while (i >= 0 && j < len) {
            res[p++] = A[i] + A[j] > 0 ? A[i] * A[i--] : A[j] * A[j++];
        }

        while (i >= 0) {
            res[p++] = A[i] * A[i--];
        }
        while (j < len) {
            res[p++] = A[j] * A[j++];
        }
        return res;
    }

    public int[] sortedSquares2(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        int[] res = new int[len];
        int p = len - 1;
        while (left <= right) {
            if (A[left] < 0 && A[right] > 0) {
                if (A[right] + A[left] > 0) {
                    res[p--] = A[right] * A[right];
                    right--;
                } else {
                    res[p--] = A[left] * A[left];
                    left++;
                }
            } else {
                res[p--] = A[left] < 0 ? A[left] * A[left++] : A[right] * A[right--];
            }
        }
        return res;
    }
}
