package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2020/1/7 0:18
 */
public class ValidMountainArray {
    /**
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[B.length - 1]
     * <p>
     * 示例 1：
     * 输入：[2,1]
     * 输出：false
     * <p>
     * 示例 2：
     * 输入：[3,5,5]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：[0,3,2,1]
     * 输出：true
     * <p>
     * 提示：
     * 0 <= A.length <= 10000
     * 0 <= A[i] <= 10000 
     */
    public boolean validMountainArray1(int[] A) {
        if (A.length < 3) {
            return false;
        }
        //  排除单调递减
        if (A[0] > A[1]) {
            return false;
        }
        boolean isIncrea = true;
        for (int i = 1; i < A.length; i++) {
            int pre = A[i - 1];
            int now = A[i];
            if (isIncrea) {
                if (pre == now) {
                    return false;
                } else if (pre > now) {
                    isIncrea = false;
                }
            } else {
                if (pre <= now) {
                    return false;
                }
            }
        }
        //  是否为单调递增
        return !isIncrea;
    }

    public boolean validMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start < end && A[start] < A[start + 1]) {
            start++;
        }
        while (0 < end && A[end] < A[end - 1]) {
            end--;
        }
        if (start != end) {
            return false;
        }
        if (start == 0) {
            return false;
        }
        return end != A.length - 1;
    }
}
