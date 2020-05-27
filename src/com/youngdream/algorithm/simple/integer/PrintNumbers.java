package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/27 14:42
 */
public class PrintNumbers {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     * <p>
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * @param n 给定数字
     * @return 输出的数组
     */
    public int[] printNumbers(int n) {
        //  不算题...
        if (n < 1) {
            return new int[]{};
        }
        int count = 1;
        while (n-- > 0) {
            count *= 10;
        }
        int[] result = new int[count - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
