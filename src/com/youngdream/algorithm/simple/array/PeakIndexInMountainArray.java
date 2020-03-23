package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/11 23:25
 */
public class PeakIndexInMountainArray {
    /**
     * 我们把符合下列属性的数组 A 称作山脉：
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     * <p>
     * 示例 1：
     * 输入：[0,1,0]
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：[0,2,1,0]
     * 输出：1
     * <p>
     * 提示：
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A 是如上定义的山脉
     */
    //  遍历排查
    public int peakIndexInMountainArray1(int[] A) {
        int result = 0;
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (num > max) {
                max = num;
                result = i;
            }
        }
        return result;
    }

    //  二分递归
    private int[] temp;

    public int peakIndexInMountainArray(int[] A) {
        temp = A;
        return get(0, A.length - 1);
    }

    private int get(int start, int end) {
        int middle = (start + end) / 2;
        int now = temp[middle];
        int pre = temp[middle - 1];
        int next = temp[middle + 1];
        if (now < pre) {
            return get(start, middle - 1);
        } else if (now < next) {
            return get(middle + 1, end);
        }
        return middle;
    }
}
