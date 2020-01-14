package com.youngdream.algorithm.integer;

import java.util.*;

/**
 * @author YoungDream
 * @date 2020/1/14 22:58
 */
public class PowerfulIntegers {
    /**
     * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
     * 返回值小于或等于 bound 的所有强整数组成的列表。
     * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
     * <p>
     * 示例 1：
     * 输入：x = 2, y = 3, bound = 10
     * 输出：[2,3,4,5,7,9,10]
     * 解释：
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     * <p>
     * 示例 2：
     * 输入：x = 3, y = 5, bound = 15
     * 输出：[2,4,6,8,10,14]
     * <p>
     * 提示：
     * 1 <= x <= 100
     * 1 <= y <= 100
     * 0 <= bound <= 10^6
     */
    public List<Integer> powerfulIntegers1(int x, int y, int bound) {
        Set<Integer> set = new TreeSet<>();
        int[] xArray = new int[computerCount(x, bound)];
        int[] yArray = new int[computerCount(y, bound)];
        fillArray(x, xArray);
        fillArray(y, yArray);
        for (int i : xArray) {
            for (int j : yArray) {
                int sum = i + j;
                if (sum > bound) {
                    break;
                }
                set.add(sum);
            }
        }
        return new ArrayList<>(set);
    }

    private int computerCount(int num, int bound) {
        if (num == 1) {
            return 1;
        }
        int r = 1;
        int count = 0;
        while (r <= bound) {
            r *= num;
            count++;
        }
        return count;
    }

    private void fillArray(int num, int[] array) {
        int n = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = n;
            n *= num;
        }
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();

        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        return new ArrayList<>(set);
    }
}
