package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/12/22 22:40
 */
public class SurfaceArea {
    /**
     * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     * 请你返回最终形体的表面积。
     * <p>
     * 示例 1：
     * 输入：[[2]]
     * 输出：10
     * <p>
     * 示例 2：
     * 输入：[[1,2],[3,4]]
     * 输出：34
     * <p>
     * 示例 3：
     * 输入：[[1,0],[0,2]]
     * 输出：16
     * <p>
     * 示例 4：
     * 输入：[[1,1,1],[1,0,1],[1,1,1]]
     * 输出：32
     * <p>
     * 示例 5：
     * 输入：[[2,2,2],[2,1,2],[2,2,2]]
     * 输出：46
     * <p>
     * 提示：
     * 1 <= N <= 50
     * 0 <= grid[i][j] <= 50
     */
    public int surfaceArea(int[][] grid) {
        temp = grid;
        //  记录立方体个数
        int sum = 0;
        //  记录接触的面数
        int reduceDouble = 0;
        for (int[] ints : temp) {
            int one = ints[0];
            sum += one;
            reduceDouble += Math.max(one - 1, 0);
        }
        int length = temp.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length; j++) {
                int hangNow = temp[i][j];
                sum += hangNow;
                //  上下
                reduceDouble += Math.max(hangNow - 1, 0);
                //  前后
                reduceDouble += Math.min(hangNow, temp[i][j - 1]);
                //  左右
                reduceDouble += Math.min(temp[j][i], temp[j - 1][i]);
            }
        }
        //  一个立方体6个面，接触一个面减少2个单位面积
        return sum * 6 - reduceDouble * 2;
    }

    private int[][] temp;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {0, 2}};
        System.out.println(new SurfaceArea().surfaceArea(grid));
    }
}
