package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/27 21:29
 */
public class ExchangeBits {
    /**
     * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
     * <p>
     * 示例1:
     * 输入：num = 2（或者0b10）
     * 输出 1 (或者 0b01)
     * <p>
     * 示例2:
     * 输入：num = 3
     * 输出：3
     * <p>
     * 提示:
     * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
     *
     * @param num 给定整数
     * @return 交换后的数
     */
    public int exchangeBits1(int num) {
        int unit = 1;
        int temp = num;
        while (temp > 0) {
            int one = temp & 1;
            temp >>= 1;
            if (one != (temp & 1)) {
                if ((temp & 1) == 1) {
                    num -= unit;
                } else {
                    num += unit;
                }
            }
            temp >>= 1;
            unit <<= 2;
        }
        return num;
    }

    public int exchangeBits(int num) {
        int single = 0x55555555;
        int dou = 0xaaaaaaaa;
        int singleResult = (num & single) << 1;
        int douResult = (num & dou) >> 1;
        return singleResult | douResult;
    }
}
