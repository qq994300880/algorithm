package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/2/26 21:46
 */
public class OddCells {
    public int oddCells(int n, int m, int[][] indices) {
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[m];
        int r;
        int c;
        for (int[] index : indices) {
            r = index[0];
            c = index[1];
            row[r] = !row[r];
            column[c] = !column[c];
        }
        int rNum = 0;
        int cNum = 0;
        for (boolean b : row) {
            if (b) {
                rNum++;
            }
        }
        for (boolean b : column) {
            if (b) {
                cNum++;
            }
        }
        return rNum * m + cNum * n - rNum * cNum * 2;
    }
}
