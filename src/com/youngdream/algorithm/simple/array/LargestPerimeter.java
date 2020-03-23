package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @author YoungDream
 * @date 2020/1/15 22:32
 */
public class LargestPerimeter {
    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     * 示例 1：
     * 输入：[2,1,2]
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：[1,2,1]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：[3,2,3,4]
     * 输出：10
     * <p>
     * 示例 4：
     * 输入：[3,6,2,3]
     * 输出：8
     * <p>
     * 提示：
     * 3 <= A.length <= 10000
     * 1 <= A[i] <= 10^6
     */
    public int largestPerimeter1(int[] A) {
        Arrays.sort(A);
        int a = A.length - 3;
        int b = A.length - 2;
        int c = A.length - 1;
        while (a > -1) {
            if (A[c] >= A[a] + A[b] || A[a] <= A[c] - A[b] || A[b] <= A[c] - A[a]) {
                c = c - 1;
                b = b - 1;
                a = a - 1;
            } else {
                return A[a] + A[b] + A[c];
            }
        }
        return 0;
    }

    //  最优解，免了快速排序
    public int largestPerimeter(int[] A) {
        int result = 0;
        int maxA = max(A);
        int maxB = max(A);
        int maxC = max(A);
        while (maxC != 0) {
            if (maxB + maxC > maxA) {
                result = maxA + maxB + maxC;
                break;
            } else {
                maxA = maxB;
                maxB = maxC;
                maxC = max(A);
            }
        }
        return result;
    }

    public int max(int[] A) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }
        if (maxIndex != -1) A[maxIndex] = -1;
        return max;
    }
}
