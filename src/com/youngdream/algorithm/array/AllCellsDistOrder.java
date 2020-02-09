package com.youngdream.algorithm.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/2/9 20:23
 */
public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[index][0] = i;
                res[index++][1] = j;
            }
        }
        Arrays.sort(res, (o1, o2) -> {
            int dis1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int dis2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return dis1 - dis2;
        });
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new AllCellsDistOrder().allCellsDistOrder(3, 3, 0, 2)));
    }
}
