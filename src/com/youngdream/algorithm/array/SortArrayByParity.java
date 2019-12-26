package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/12/26 23:34
 */
public class SortArrayByParity {
    /**
     * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
     * 你可以返回满足此条件的任何数组作为答案。
     * <p>
     * 示例：
     * 输入：[3,1,2,4]
     * 输出：[2,4,3,1]
     * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
     * <p>
     * 提示：
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     */
    public int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int s = A[start];
            int e = A[end];
            if ((s & 1) == 1 && (e & 1) == 0) {
                A[start] = e;
                A[end] = s;
                start++;
                end--;
            } else {
                if ((s & 1) == 0) {
                    start++;
                }
                if ((e & 1) == 1) {
                    end--;
                }
            }
        }
        return A;
    }
}
