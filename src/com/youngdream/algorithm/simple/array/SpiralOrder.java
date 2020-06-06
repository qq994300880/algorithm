package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/6 21:47
 */
public class SpiralOrder {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * 限制：
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
     *
     * @param matrix 给定矩阵
     * @return 回旋打印的结果
     */
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        //  数组长度为0
        if (n == 0) {
            return new int[]{};
        }
        int m = matrix[0].length;
        int[] result = new int[n * m];
        int index = 0;

        // 行的下限边界索引
        int nStart = 0;
        // 行的上限边界索引
        int nEnd = n - 1;
        // 列的下限边界索引
        int mStart = 0;
        // 列的上限边界索引
        int mEnd = m - 1;

        int i;

        while (true) {
            for (i = mStart; i <= mEnd; i++) {
                result[index++] = matrix[nStart][i];
            }
            nStart++;
            if (nEnd < nStart) {
                break;
            }
            for (i = nStart; i <= nEnd; i++) {
                result[index++] = matrix[i][mEnd];
            }
            mEnd--;
            if (mEnd < mStart) {
                break;
            }
            for (i = mEnd; i >= mStart; i--) {
                result[index++] = matrix[nEnd][i];
            }
            nEnd--;
            if (nEnd < nStart) {
                break;
            }
            for (i = nEnd; i >= nStart; i--) {
                result[index++] = matrix[i][mStart];
            }
            mStart++;
            if (mEnd < mStart) {
                break;
            }
        }
        return result;
    }
}
