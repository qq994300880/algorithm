package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/6/30 21:56
 */
public class LastRemaining {
    /**
     * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
     * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
     * <p>
     * 示例 1：
     * 输入: n = 5, m = 3
     * 输出: 3
     * <p>
     * 示例 2：
     * 输入: n = 10, m = 17
     * 输出: 2
     * <p>
     * 限制：
     * 1 <= n <= 10^5
     * 1 <= m <= 10^6
     *
     * @param n 数字的个数
     * @param m 第m个
     * @return 最后剩下的数字
     */
    public int lastRemaining(int n, int m) {
        //f(n,m) = [f(n-1, m) + m]%n
        // 最终活下来那个人的初始位置
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            // 每次循环右移
            pos = (pos + m) % i;
        }
        return pos;
    }
}
