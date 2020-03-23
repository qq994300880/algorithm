package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/12/8 22:38
 */
public class NumMagicSquaresInside {
    /**
     * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
     * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
     * <p>
     * 示例：
     * 输入: [[4,3,8,4],
     * [9,5,1,9],
     * [2,7,6,2]]
     * 输出: 1
     * 解释:
     * 下面的子矩阵是一个 3 x 3 的幻方：
     * 438
     * 951
     * 276
     * 而这一个不是：
     * 384
     * 519
     * 762
     * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
     * <p>
     * 提示:
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * 0 <= grid[i][j] <= 15
     */
    public int numMagicSquaresInside(int[][] grid) {
        //  这道题好无聊啊
        int result = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            int[] ints = grid[i];
            for (int j = 1; j < ints.length - 1; j++) {
                int temp = ints[j];
                //  中心必须为5
                if (temp == 5) {
                    int a11 = grid[i - 1][j - 1];
                    int a12 = grid[i - 1][j];
                    int a13 = grid[i - 1][j + 1];
                    int a21 = grid[i][j - 1];
                    int a23 = grid[i][j + 1];
                    int a31 = grid[i + 1][j - 1];
                    int a32 = grid[i + 1][j];
                    int a33 = grid[i + 1][j + 1];
                    //  数值范围确定
                    if (a11 < 1 || a11 > 9 || a12 < 1 || a12 > 9 || a13 < 1 || a13 > 9 || a21 < 1 || a21 > 9 || a23 < 1 || a23 > 9 || a31 < 1 || a31 > 9 || a32 < 1 || a32 > 9 || a33 < 1 || a33 > 9) {
                        continue;
                    }
                    //  中心点上下
                    if (a12 == 5 || a12 + a32 != 10) {
                        continue;
                    }
                    //  中心点左右
                    if (a21 == 5 || a21 + a23 != 10) {
                        continue;
                    }
                    //  左上-中心点-右下斜线
                    if (a11 == 5 || a11 + a33 != 10) {
                        continue;
                    }
                    //  右上-中心点-左下斜线
                    if (a13 == 5 || a13 + a31 != 10) {
                        continue;
                    }
                    //  最上一条线
                    if (a11 + a12 + a13 != 15) {
                        continue;
                    }
                    //  最左一条线
                    if (a11 + a21 + a31 != 15) {
                        continue;
                    }
                    result++;
                }
            }
        }
        return result;
    }
}
