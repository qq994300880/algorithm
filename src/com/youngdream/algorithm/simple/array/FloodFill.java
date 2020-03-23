package com.youngdream.algorithm.simple.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author YoungDream
 * @Date 2019/11/13 20:13
 */
public class FloodFill {
    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     * 最后返回经过上色渲染后的图像。
     * <p>
     * 示例 1:
     * 输入:
     * image = [[1,1,1],[1,1,0],[1,0,1]]
     * sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析:
     * 在图像的正中间，(坐标(sr,sc)=(1,1)),
     * 在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，
     * 因为它不是在上下左右四个方向上与初始点相连的像素点。
     * <p>
     * 注意:
     * image 和 image[0] 的长度在范围 [1, 50] 内。
     * 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
     * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    //深度优先
    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        /*
        depth-first search模板
        1.dfs出口，不满足条件就退出
        2.操作
        3.递归，接着进一步DFS
         */
        int height = image.length;
        int width = image[0].length;
        // 1.dfs出口
        if (sr < 0 || sr >= height) return;
        if (sc < 0 || sc >= width) return;
        if (image[sr][sc] != oldColor) return;
        if (image[sr][sc] == newColor) return;
        // 2.操作
        image[sr][sc] = newColor;
        // 3.递归
        dfs(image, sr - 1, sc, oldColor, newColor);
        dfs(image, sr + 1, sc, oldColor, newColor);
        dfs(image, sr, sc - 1, oldColor, newColor);
        dfs(image, sr, sc + 1, oldColor, newColor);
    }

    //广度优先
    private void bfs(int[][] image, int sr, int sc, int newColor) {
        /*
        breadth-frist search模板
        1.条件判断（边界判断，其他要求的判断）
        2.创建队列
        3.在队列中加入第一个满足条件的元素
        4.while(队列不为空) {
            取出队列头部元素
            操作
            根据头部元素，往队列中再次加入满足条件的元素
          }
         */
        // 1.条件判断（边界判断，其他要求的判断）
        //if (image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor) return;
        if (image[sr][sc] == newColor) return;
        int m = image.length, n = image[0].length;
        // 2.创建队列
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        // 3.在队列中加入第一个满足条件的元素
        queue.add(new int[]{sr, sc});
        // 4.循环
        while (!queue.isEmpty()) {
            // 取出队列头部元素
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            // 操作
            image[i][j] = newColor;
            // 根据头部元素，往队列中再次加入满足条件的元素
            if (i - 1 >= 0 && image[i - 1][j] == oldColor) queue.add(new int[]{i - 1, j});
            if (i + 1 < m && image[i + 1][j] == oldColor) queue.add(new int[]{i + 1, j});
            if (j - 1 >= 0 && image[i][j - 1] == oldColor) queue.add(new int[]{i, j - 1});
            if (j + 1 < n && image[i][j + 1] == oldColor) queue.add(new int[]{i, j + 1});
        }
    }
}
