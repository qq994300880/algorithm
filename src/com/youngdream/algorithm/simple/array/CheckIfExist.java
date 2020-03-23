package com.youngdream.algorithm.simple.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YangDuan
 * @date 2020/3/15 22:08
 */
public class CheckIfExist {
    /**
     * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
     * 更正式地，检查是否存在两个下标 i 和 j 满足：
     * <p>
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     * <p>
     * 示例 1：
     * 输入：arr = [10,2,5,3]
     * 输出：true
     * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
     * <p>
     * 示例 2：
     * 输入：arr = [7,1,14,11]
     * 输出：true
     * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
     * <p>
     * 示例 3：
     * 输入：arr = [3,1,7,11]
     * 输出：false
     * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
     * <p>
     * 提示：
     * 2 <= arr.length <= 500
     * -10^3 <= arr[i] <= 10^3
     *
     * @param arr 给定数组
     * @return 是否存在
     */
    public boolean checkIfExist1(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        int zeroCount = 0;
        for (int i : arr) {
            if (i == 0) {
                zeroCount++;
                continue;
            }
            set.add(i);
        }
        if (zeroCount > 1) {
            return true;
        }
        for (int i : arr) {
            if (set.contains(i * 2)) {
                return true;
            }
        }
        return false;
    }

    //  最优解
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) % 2 == 1) {
                continue;
            }
            if (find(arr, arr[i] >> 1, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean find(int[] arr, int number, int index) {
        for (int a = 0; a < arr.length; a++) {
            if (number == arr[a] && index != a) {
                return true;
            }
        }
        return false;
    }
}
