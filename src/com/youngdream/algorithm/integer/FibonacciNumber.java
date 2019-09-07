package com.youngdream.algorithm.integer;

/**
 * @Author YoungDream
 * @Date 2019/8/21 11:37
 */
public class FibonacciNumber {
    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     */
    //方法一：位运算
    public int fib(int N) {
        if (N < 2) return N;
        int one = 0;
        int two = 1;
        int index = 2;
        while (index != N) {
            one = one ^ two;
            two = one ^ two;
            one = one ^ two;
            two += one;
            index++;
        }
        return one + two;
    }

    //方法二：创建数组存储值,占用空间比方法一多
    public int fib2(int N) {
        if (N < 2) return N;
        int[] res = new int[N + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[N];
    }
}
