package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/7 22:22
 */
public class Maximum {
    /**
     * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
     * <p>
     * 示例：
     * 输入： a = 1, b = 2
     * 输出： 2
     *
     * @param a 数字a
     * @param b 数字b
     * @return 最大的数
     */
    public int maximum(int a, int b) {
        //  范围[-2{33},2{33}-1]
        //  防止溢出强转long
        //  获取符号位i(0正a大，1负b大)
        int i = (int) (((long) a - (long) b) >>> 63);
        return (i ^ 1) * a + i * b;
    }
}
