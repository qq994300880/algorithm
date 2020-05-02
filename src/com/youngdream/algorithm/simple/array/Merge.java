package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/5/2 21:49
 */
public class Merge {
    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * <p>
     * 示例:
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     * 说明:
     * A.length == n + m
     *
     * @param A 数组A
     * @param m 数组A数量
     * @param B 数组B
     * @param n 数组B数量
     */
    public void merge1(int[] A, int m, int[] B, int n) {
        // 方法清晰，时间复杂度O(n+(m+n)log(m+n))
        System.arraycopy(B, 0, A, m, A.length - m);
        Arrays.sort(A);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        //  时间复杂度O(m+n)
        int index = m + n;
        while (index > 0) {
            if (m != 0 && n != 0) {
                if (A[m - 1] > B[n - 1]) {
                    A[--index] = A[--m];
                } else {
                    A[--index] = B[--n];
                }
            } else if (m == 0) {
                A[--index] = B[--n];
            } else {
                A[--index] = A[--m];
            }
        }
    }
}
