package com.youngdream.algorithm.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YangDuan
 * @date 2020/1/28 23:19
 */
public class OrangesRotting {
    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     * <p>
     * 示例 1：
     * 输入：[[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * <p>
     * 示例 2：
     * 输入：[[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
     * <p>
     * 示例 3：
     * 输入：[[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     *  
     * 提示：
     * 1 <= grid.length <= 10
     * 1 <= grid[0].length <= 10
     * grid[i][j] 仅为 0、1 或 2
     */
    public int orangesRotting(int[][] grid) {
        int hight = grid.length;
        int length = grid[0].length;
        int total = 0;
        int min = 0;
        int x;
        int y;
        int[][] poll;
        int[][] count;
        int index;
        Queue<int[][]> queue = new LinkedList<>();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[][]{{i, j}});
                }
            }
        }
        while (!queue.isEmpty()) {
            count = new int[queue.size()][2];
            index = 0;
            while (!queue.isEmpty()) {
                poll = queue.poll();
                count[index][0] = poll[0][0];
                count[index][1] = poll[0][1];
                index++;
            }
            for (int[] ints : count) {
                x = ints[0];
                y = ints[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    total--;
                    grid[x - 1][y] = 2;
                    queue.offer(new int[][]{{x - 1, y}});
                }
                if (x < hight - 1 && grid[x + 1][y] == 1) {
                    total--;
                    grid[x + 1][y] = 2;
                    queue.offer(new int[][]{{x + 1, y}});
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    total--;
                    grid[x][y - 1] = 2;
                    queue.offer(new int[][]{{x, y - 1}});
                }
                if (y < length - 1 && grid[x][y + 1] == 1) {
                    total--;
                    grid[x][y + 1] = 2;
                    queue.offer(new int[][]{{x, y + 1}});
                }
            }
            min++;
        }
        if (total != 0) {
            return -1;
        }
        if (min > 0) {
            return min - 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new OrangesRotting().orangesRotting(grid));
    }
}
