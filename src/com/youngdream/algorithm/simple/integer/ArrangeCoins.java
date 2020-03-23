package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2019/8/21 1:39
 */
public class ArrangeCoins {
    /**
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
     * 给定一个数字 n，找出可形成完整阶梯行的总行数。
     * n 是一个非负整数，并且在32位有符号整型的范围内。
     *
     * @param n 硬币数
     * @return 行数
     */
    //方法一：超时
    private static int arrangeCoins(int n) {
        int result = 0;
        while (n >= (1 + result) * result / 2) {
            result++;
        }
        return result - 1;
    }

    //方法二：没超时，但是效率不高
    private static int arrangeCoins2(int n) {
        int result = 1;
        while (n > 0) {
            n -= result;
            result++;
        }
        if (n != 0) result--;
        return --result;
    }

    //方法三：简化公式
    //   (1+r)*r/2 <=  n  <  (2+r)*(1+r)/2
    //                 ↓
    //     r*r+r   <=  2n <  r*r+3*r+2
    //                 ↓
    //      r*r+r+0.25 <=  2n+0.25
    //                 ↓
    // (r+0.5)*(r+0.5) <= 2n+0.25
    //                 ↓
    //   r+0.5  <= Math.sqrt(2n+0.25)
    //                 ↓
    //   r <= Math.sqrt(2n+0.25)-0.5
    private static int arrangeCoins3(int n) {
        return (int) (Math.sqrt(n * 2.0 + 0.25) - 0.5);
    }
}
