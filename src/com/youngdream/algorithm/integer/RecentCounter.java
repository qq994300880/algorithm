package com.youngdream.algorithm.integer;

/**
 * @Author YoungDream
 * @Date 2020/1/3 20:57
 */
public class RecentCounter {
    private int[] counts;

    private int start = 0;

    private int end = 0;

    public RecentCounter() {
        counts = new int[10000];
    }

    public int ping(int t) {
        counts[end++] = t;
        while (counts[start] < t - 3000) {
            start++;
        }
        return end - start;
    }
}
