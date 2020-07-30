package com.youngdream.algorithm.medium.array;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/30 11:25
 */
public class MaxArea {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * <p>
     * 示例：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * @param height 给定容器边框数组
     * @return 所能容纳的最多的水
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = -1;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int curArea;
            // 移动短的那边，因为移动长的那边只有可能减少
            // 1.总宽度肯定减少
            // 2.长边变得更大也减少，因为短边不变
            // 3.长边变得更小也减少，那就小上加小
            // 移动短边的话，如果短边变得很长还是有可能增大的
            if (left > right) {
                curArea = right * (j - i);
                j--;
            } else {
                curArea = left * (j - i);
                i++;
                if (left == right) {
                    j--;
                }
            }
            if (maxArea < curArea) {
                maxArea = curArea;
            }
        }
        return maxArea;
    }

    //暴力执法
    public int maxArea2(int[] height) {
        int result = 0;
        int temp;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                temp = (j - i) * Math.min(height[i], height[j]);
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
