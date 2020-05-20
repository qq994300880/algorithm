package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/20 22:17
 */
public class FindNumberIn2DArray {
    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 示例:
     * 现有矩阵 matrix 如下：
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     * <p>
     * 限制：
     * 0 <= n <= 1000
     * 0 <= m <= 1000
     * <p>
     * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
     *
     * @param matrix 给定矩阵
     * @param target 给定整数
     * @return 矩阵中是否含有该整数
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //  原理类似二叉搜索树
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        int temp;
        while (row < n && col > -1) {
            temp = matrix[row][col];
            if (temp < target) {
                row++;
            } else if (temp > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
