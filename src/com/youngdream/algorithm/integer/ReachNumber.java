package com.youngdream.algorithm.integer;

/**
 * @Author YoungDream
 * @Date 2019/11/16 18:05
 */
public class ReachNumber {
    /**
     * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
     * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
     * 返回到达终点需要的最小移动次数。
     * <p>
     * 示例 1:
     * 输入: target = 3
     * 输出: 2
     * 解释:
     * 第一次移动，从 0 到 1 。
     * 第二次移动，从 1 到 3 。
     * <p>
     * 示例 2:
     * 输入: target = 2
     * 输出: 3
     * 解释:
     * 第一次移动，从 0 到 1 。
     * 第二次移动，从 1 到 -1 。
     * 第三次移动，从 -1 到 2 。
     * <p>
     * 注意:
     * target是在[-10^9, 10^9]范围中的非零整数。
     */
    public int reachNumber1(int target) {
        if (target < 0) target = -target;//左右方向结果一致
        //步数
        int i = 0;
        //当前位置坐标
        int index = 0;
        while (index < target) {
            index += ++i;
        }
        return (index - target) % 2 == 0 ? i : i + 1 + i % 2;
    }

    /**
     * 可以将此问题看做是以下问题：
     * 给定一个数组为1,2,3,4,5.......i，为数组元素添加正负号（正号表示向右跳，负号表示向左跳），使得其和为target的最小数组长度
     * 记录数组添加正号数字之和为p, 添加负号数字之和为n，数组之和为s
     * p + n = s
     * p - n = target
     * 两式相减有：
     * s - target = 2 * n
     * 因此s - target一定为偶数，且s - target = 2 * n >= 0
     * 而s = i *(i + 1) /2
     * 因此就是求最小的i， 使得 i *(i + 1) /2 - target为偶数且大于等于0
     */
    public int reachNumber2(int target) {
        if (target < 0) target = -target;
        int i = 1;
        while (true) {
            int s = i * i + i;
            if (s >= target * 2 && (s - target * 2) % 4 == 0) return i;
            i++;
        }
    }

    public int reachNumber3(int target) {
        if (target < 0) target = -target;
        int a = (int) Math.sqrt(target * 2);
        int b = a * (a + 1) / 2;
        int c = (a + 1) * (a + 2) / 2;
        int d = (a + 2) * (a + 3) / 2;
        if (b == target) return a;
        else if (b > target) {
            if ((b - target) % 2 == 0) {
                return a;
            } else if ((c - target) % 2 == 0) {
                return a + 1;
            } else {
                return a + 2;
            }
        } else if ((c - target) % 2 == 0) return a + 1;
        else if ((d - target) % 2 == 0) return a + 2;
        else return a + 3;
    }
}
