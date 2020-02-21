package com.youngdream.algorithm.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/2/21 21:33
 */
public class UniqueOccurrences {
    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     * <p>
     * 示例 1：
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * <p>
     * 示例 2：
     * 输入：arr = [1,2]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * <p>
     * 提示：
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     */
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int[] map = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (map[count] == 0) {
                    map[count] = 1;
                    count = 1;
                } else {
                    return false;
                }
            }
        }
        return map[count] == 0;
    }
}
