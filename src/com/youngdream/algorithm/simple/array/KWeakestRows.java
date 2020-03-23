package com.youngdream.algorithm.simple.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/3/13 21:23
 */
public class KWeakestRows {
    /**
     * 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 0 和 1 表示。
     * 请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
     * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
     * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
     * <p>
     * 示例 1：
     * 输入：mat =
     * [[1,1,0,0,0],
     * [1,1,1,1,0],
     * [1,0,0,0,0],
     * [1,1,0,0,0],
     * [1,1,1,1,1]],
     * k = 3
     * 输出：[2,0,3]
     * 解释：
     * 每行中的军人数目：
     * 行 0 -> 2
     * 行 1 -> 4
     * 行 2 -> 1
     * 行 3 -> 2
     * 行 4 -> 5
     * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
     * <p>
     * 示例 2：
     * 输入：mat =
     * [[1,0,0,0],
     *  [1,1,1,1],
     *  [1,0,0,0],
     *  [1,0,0,0]],
     * k = 2
     * 输出：[0,2]
     * 解释：
     * 每行中的军人数目：
     * 行 0 -> 1
     * 行 1 -> 4
     * 行 2 -> 1
     * 行 3 -> 1
     * 从最弱到最强对这些行排序后得到 [0,2,3,1]
     * <p>
     * 提示：
     * m == mat.length
     * n == mat[i].length
     * 2 <= n, m <= 100
     * 1 <= k <= m
     * matrix[i][j] 不是 0 就是 1
     *
     * @param mat 方阵
     * @param k   几行
     * @return 结果索引
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        Node[] nodes = new Node[mat.length];
        for (int i = 0; i < mat.length; i++) {
            nodes[i] = new Node(getCount(mat[i]), i);
        }
        //  战斗力排序
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.value > o2.value) {
                return 1;
            } else if (o1.value < o2.value) {
                return -1;
            }
            return o1.index - o2.index;
        });
        //  记录前K个结果
        for (int i = 0; i < result.length; i++) {
            result[i] = nodes[i].index;
        }
        return result;
    }

    /**
     * 统计该行战斗力
     *
     * @param ints 当前列
     * @return 战斗力
     */
    private int getCount(int[] ints) {
        int count = 0;
        for (int i : ints) {
            count += i;
        }
        return count;
    }

    /**
     * 行战斗力单位
     */
    private static class Node {
        //  战斗力
        int value;
        //  索引
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
