package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/24 22:14
 */
public class ConvertInteger {
    /**
     * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
     * <p>
     * 示例1:
     * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
     * 输出：2
     * <p>
     * 示例2:
     * 输入：A = 1，B = 2
     * 输出：2
     * <p>
     * 提示:
     * A，B范围在[-2147483648, 2147483647]之间
     *
     * @param A
     * @param B
     * @return
     */
    public int convertInteger(int A, int B) {
        //  异或的用法
        return Integer.bitCount(A ^ B);
    }
}
