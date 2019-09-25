package com.youngdream.algorithm.array;

import java.util.ArrayDeque;

/**
 * @Author YoungDream
 * @Date 2019/9/25 16:23
 */
public class MatrixReshape {
    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     * <p>
     * 示例 1:
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * <p>
     * 示例 2:
     * 输入:
     * nums =
     * [[1,2],
     * [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     * [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * <p>
     * 注意：
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     */
    //用队列
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int count = nums.length * nums[0].length;
        if (count < r * c) return nums;
//        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayDeque<Integer> list = new ArrayDeque<>(count);
        for (int[] num : nums) {
            for (int i : num) {
//                list.addLast(i);
                list.offerLast(i);
            }
        }
        int[][] result = new int[r][c];
        for (int[] ints : result) {
            for (int j = 0; j < ints.length; j++) {
                ints[j] = list.pollFirst();
            }
        }
        return result;
    }

    //直接遍历
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int i = nums.length;
        int j = nums[0].length;
        if (i * j < r * c) return nums;
        int[][] result = new int[r][c];
        int ni = 0;
        int nj = 0;
        int ri = 0;
        int rj = 0;
        while (ri < r) {
            result[ri][rj] = nums[ni][nj];
            if (nj < j - 1) nj++;
            else {
                ni++;
                nj = 0;
            }
            if (rj < c) rj++;
            else {
                ri++;
                rj = 0;
            }
        }
        return result;
    }
}
