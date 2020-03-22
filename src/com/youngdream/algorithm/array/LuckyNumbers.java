package com.youngdream.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/3/22 21:34
 */
public class LuckyNumbers {
    /**
     * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
     * 幸运数是指矩阵中满足同时下列两个条件的元素：
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最大
     * <p>
     * 示例 1：
     * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
     * 输出：[15]
     * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
     * 输出：[12]
     * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
     * <p>
     * 示例 3：
     * 输入：matrix = [[7,8],[1,2]]
     * 输出：[7]
     * <p>
     * 提示：
     * m == mat.length
     * n == mat[i].length
     * 1 <= n, m <= 50
     * 1 <= matrix[i][j] <= 10^5
     * 矩阵中的所有元素都是不同的
     *
     * @param matrix 给定矩阵
     * @return 幸运数列表
     */
    public List<Integer> luckyNumbers1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        m = matrix.length;
        rows = new int[m];
        columns = new int[matrix[0].length];
        Arrays.fill(rows, Integer.MAX_VALUE);
        for (int i = 0; i < rows.length; i++) {
            getMin(i, matrix);
        }
        for (int i = 0; i < columns.length; i++) {
            getMax(i, matrix);
        }
        for (int row : rows) {
            for (int column : columns) {
                if (row == column) {
                    result.add(row);
                    break;
                }
            }
        }
        return result;
    }

    private int m;
    private int[] rows;
    private int[] columns;

    private void getMin(int rowNum, int[][] matrix) {
        int[] ints = matrix[rowNum];
        for (int i : ints) {
            if (i < rows[rowNum]) {
                rows[rowNum] = i;
            }
        }
    }

    private void getMax(int columnNum, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            if (columns[columnNum] < matrix[i][columnNum]) {
                columns[columnNum] = matrix[i][columnNum];
            }
        }
    }

    //  优化
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int min;
        int index = 0;
        for (int[] ints : matrix) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] < min) {
                    min = ints[i];
                    index = i;
                }
            }
            if (isMax(min, index, matrix)) {
                result.add(min);
            }
        }
        return result;
    }

    private boolean isMax(int min, int index, int[][] matrix) {
        for (int[] ints : matrix) {
            if (ints[index] > min) {
                return false;
            }
        }
        return true;
    }
}
