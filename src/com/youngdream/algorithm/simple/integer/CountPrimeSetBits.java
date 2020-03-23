package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2019/11/16 16:24
 */
public class CountPrimeSetBits {
    /**
     * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
     * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     * <p>
     * 示例 1:
     * 输入: L = 6, R = 10
     * 输出: 4
     * 解释:
     * 6 -> 110 (2 个计算置位，2 是质数)
     * 7 -> 111 (3 个计算置位，3 是质数)
     * 9 -> 1001 (2 个计算置位，2 是质数)
     * 10-> 1010 (2 个计算置位，2 是质数)
     * <p>
     * 示例 2:
     * 输入: L = 10, R = 15
     * 输出: 5
     * 解释:
     * 10 -> 1010 (2 个计算置位, 2 是质数)
     * 11 -> 1011 (3 个计算置位, 3 是质数)
     * 12 -> 1100 (2 个计算置位, 2 是质数)
     * 13 -> 1101 (3 个计算置位, 3 是质数)
     * 14 -> 1110 (3 个计算置位, 3 是质数)
     * 15 -> 1111 (4 个计算置位, 4 不是质数)
     * <p>
     * 注意:
     * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
     * R - L 的最大值为 10000。
     */
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            if (isTrue(i)) result++;
        }
        return result;
    }

    private boolean isTrue(int num) {
//        int count = 0;
        //统计计算置位个数
//        while (num != 0) {
//            if ((num & 1) == 1) count++;
//            num >>= 1;
//        }
        //该方法更好
        int count = Integer.bitCount(num);
        //判断个数是不是质数(10^6最多为20位)
        switch (count) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 11:
            case 13:
            case 17:
            case 19:
                return true;
            default:
                return false;
        }
    }
}
