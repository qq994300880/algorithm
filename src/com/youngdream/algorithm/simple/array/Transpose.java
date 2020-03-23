package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/14 23:15
 */
public class Transpose {
    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * <p>
     * 示例 1：
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * <p>
     * 示例 2：
     * 输入：[[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     * <p>
     * 提示：
     * 1 <= A.length <= 1000
     * 1 <= A[0].length <= 1000
     */
    public int[][] transpose(int[][] A) {
        int hight = A.length;
        int width = A[0].length;
        int[][] result = new int[width][hight];
        for (int i = 0; i < A.length; i++) {
            int[] ints = A[i];
            for (int j = 0; j < ints.length; j++) {
                result[j][i] = ints[j];
            }
        }
        return result;
    }
}
