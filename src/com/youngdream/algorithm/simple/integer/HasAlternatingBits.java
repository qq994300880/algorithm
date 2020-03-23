package com.youngdream.algorithm.simple.integer;

/**
 * @Author YoungDream
 * @Date 2019/10/14 18:46
 */
public class HasAlternatingBits {
    /**
     * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
     * <p>
     * 示例 1:
     * 输入: 5
     * 输出: True
     * 解释:
     * 5的二进制数是: 101
     * <p>
     * 示例 2:
     * 输入: 7
     * 输出: False
     * 解释:
     * 7的二进制数是: 111
     * <p>
     * 示例 3:
     * 输入: 11
     * 输出: False
     * 解释:
     * 11的二进制数是: 1011
     * <p>
     *  示例 4:
     * 输入: 10
     * 输出: True
     * 解释:
     * 10的二进制数是: 1010
     */
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {
            int cru = n & 1;
            int next = (n >> 1) & 1;
            if (cru == next) return false;
            n >>= 1;
        }
        return true;
    }
}
