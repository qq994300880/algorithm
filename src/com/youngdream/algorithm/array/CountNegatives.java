package com.youngdream.algorithm.array;

/**
 * @author YangDuan
 * @date 2020/3/16 22:09
 */
public class CountNegatives {
    /**
     * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
     * 请你统计并返回 grid 中 负数 的数目。
     * <p>
     * 示例 1：
     * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
     * 输出：8
     * 解释：矩阵中共有 8 个负数。
     * <p>
     * 示例 2：
     * 输入：grid = [[3,2],[1,0]]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：grid = [[1,-1],[-1,-1]]
     * 输出：3
     * <p>
     * 示例 4：
     * 输入：grid = [[-1]]
     * 输出：1
     * <p>
     * 提示：
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * -100 <= grid[i][j] <= 100
     *
     * @param grid 给定数组
     * @return 负数的个数
     */
    public int countNegatives(int[][] grid) {
        result = 0;
        for (int[] ints : grid) {
            count(ints);
        }
        return result;
    }
    //  说实话，我也不知道为什么这么快...
    private void count(int[] ints) {
        for (int i = ints.length - 1; i >= 0; i--) {
            if (ints[i] >= 0) {
                return;
            }
            result++;
        }
    }

    private int result;
}
