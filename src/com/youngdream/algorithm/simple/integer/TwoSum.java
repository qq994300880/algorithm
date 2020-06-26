package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/6/26 21:56
 */
public class TwoSum {
    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
     * <p>
     * 示例 1:
     * 输入: 1
     * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
     * <p>
     * 示例 2:
     * 输入: 2
     * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
     * <p>
     * 限制：
     * 1 <= n <= 11
     *
     * @param n 个数
     * @return 所有概率的集合
     */
    public double[] twoSum(int n) {
        pre = new double[]{1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            computed(i);
            pre = temp;
        }
        return pre;
    }

    private double[] pre;

    private double[] temp;

    private double unit;

    private void computed(int n) {
        temp = new double[5 * n + 1];
        for (int j = 0; j < pre.length; j++) {
            unit = pre[j] / 6;
            computed2(j);
        }
    }

    private void computed2(int index) {
        for (int x = 0; x < 6; x++) {
            temp[index + x] += unit;
        }
    }
}
