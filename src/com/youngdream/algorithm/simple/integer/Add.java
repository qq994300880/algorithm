package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/5/12 21:25
 */
public class Add {
    /**
     * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
     * <p>
     * 示例:
     * 输入: a = 1, b = 1
     * 输出: 2
     * <p>
     * 提示：
     * a, b 均可能是负数或 0
     * 结果不会溢出 32 位整数
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return 和
     */
    public int add(int a, int b) {
        // 进位为0，返回a
        if (b == 0) {
            return a;
        }
        // 异或：未进位的结果
        // 与<<1：进位的结果
        return add(a ^ b, (a & b) << 1);
    }
}
