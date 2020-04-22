package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/22 21:32
 */
public class InsertBits {
    /**
     * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
     * <p>
     * 示例1:
     * 输入：N = 10000000000, M = 10011, i = 2, j = 6
     * 输出：N = 10001001100
     * <p>
     * 示例2:
     * 输入： N = 0, M = 11111, i = 0, j = 4
     * 输出：N = 11111
     *
     * @param N 整数1
     * @param M 整数2
     * @param i 比特位结束位置
     * @param j 比特位开始位置
     * @return 新数字
     */
    public int insertBits(int N, int M, int i, int j) {
        // 将N比特位的i-j清空(变0)
        // N & [j]00000[i]11111[0]
        // N & ~([j]11111[i]00000[0])
        // N & ~(([j-i]11111[0])<<i)
        // N & ~(([j-i+1]100000[0]-1)<<i)
        // N & ~(((1<<(j-i+1))-1)<<i)
        N &= ~(((1 << (j - i + 1)) - 1) << i);
        return N | (M << i);
    }
}
