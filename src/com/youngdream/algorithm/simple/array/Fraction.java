package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/3/26 22:10
 */
public class Fraction {
    /**
     * 有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
     * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
     * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
     * <p>
     * 示例 1：
     * 输入：cont = [3, 2, 0, 2]
     * 输出：[13, 4]
     * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
     * <p>
     * 示例 2：
     * 输入：cont = [0, 0, 3]
     * 输出：[3, 1]
     * 解释：如果答案是整数，令分母为1即可。
     * <p>
     * 限制：
     * cont[i] >= 0
     * 1 <= cont的长度 <= 10
     * cont最后一个元素不等于0
     * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
     *
     * @param cont 分式值数组
     * @return 最简分数的分子和分母
     */
    public int[] fraction(int[] cont) {
        int[] result = new int[2];
        //  分母
        result[0] = 1;
        //  分子
        result[1] = cont[cont.length - 1];
        //  计算分子
        for (int i = cont.length - 2; i >= 0; i--) {
            result[0] = result[0] + result[1] * cont[i];
            //  颠倒位置
            result[0] = result[0] ^ result[1];
            result[1] = result[0] ^ result[1];
            result[0] = result[0] ^ result[1];
        }
        //  A0多颠倒了一次
        result[0] = result[0] ^ result[1];
        result[1] = result[0] ^ result[1];
        result[0] = result[0] ^ result[1];
        return result;
    }
}
