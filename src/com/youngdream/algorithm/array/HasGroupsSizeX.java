package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/12/28 23:13
 */
public class HasGroupsSizeX {
    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * <p>
     * 示例 2：
     * 输入：[1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 示例 3：
     * 输入：[1]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 示例 4：
     * 输入：[1,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]
     * <p>
     * 示例 5：
     * 输入：[1,1,2,2,2,2]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] t = new int[1000];
        for (int i : deck) {
            t[i]++;
        }
        int g = -1;
        for (int i = 0; i < 1000; i++) {
            if (t[i] > 0) {
                if (g == -1) {
                    g = t[i];
                } else {
                    g = gcd(g, t[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return y;
        } else {
            return gcd(y % x, x);
        }
    }
}
