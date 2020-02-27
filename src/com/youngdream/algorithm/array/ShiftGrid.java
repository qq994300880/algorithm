package com.youngdream.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/2/27 21:39
 */
public class ShiftGrid {
    /**
     * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
     * 每次「迁移」操作将会引发下述活动：
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 请你返回 k 次迁移操作后最终得到的 二维网格。
     * <p>
     * 示例 1：
     * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
     * 输出：[[9,1,2],[3,4,5],[6,7,8]]
     * <p>
     * 示例 2：
     * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
     * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
     * <p>
     * 示例 3：
     * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
     * 输出：[[1,2,3],[4,5,6],[7,8,9]]
     * <p>
     * 提示：
     * 1 <= grid.length <= 50
     * 1 <= grid[i].length <= 50
     * -1000 <= grid[i][j] <= 1000
     * 0 <= k <= 100
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int column = grid[0].length;
        List<List<Integer>> result = new ArrayList<>(row);
        k %= row * column;
        if (k != 0) {
            k = row * column - k;
        }
        int quotient = k / column;
        k %= column;
        List<Integer> list = new ArrayList<>(column);
        for (int i = k; i < column; i++) {
            list.add(grid[quotient][i]);
            if (list.size() == column) {
                result.add(list);
                list = new ArrayList<>(column);
            }
        }
        for (int i = quotient + 1; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(grid[i][j]);
                if (list.size() == column) {
                    result.add(list);
                    list = new ArrayList<>(column);
                }
            }
        }
        for (int i = 0; i < quotient; i++) {
            for (int j = 0; j < column; j++) {
                list.add(grid[i][j]);
                if (list.size() == column) {
                    result.add(list);
                    list = new ArrayList<>(column);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(grid[quotient][i]);
            if (list.size() == column) {
                result.add(list);
                list = new ArrayList<>(column);
            }
        }
        return result;
    }
}
