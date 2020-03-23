package com.youngdream.algorithm.simple.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YoungDream
 * @date 2020/1/12 23:31
 */
public class RepeatedNTimes {
    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,3]
     * 输出：3
     * <p>
     * 示例 2：
     * 输入：[2,1,2,5,3,2]
     * 输出：2
     * <p>
     * 示例 3：
     * 输入：[5,1,5,2,5,3,5,4]
     * 输出：5
     * <p>
     * 提示：
     * 4 <= A.length <= 10000
     * 0 <= A[i] < 10000
     * A.length 为偶数
     */
    public int repeatedNTimes1(int[] A) {
        //  其他元素都只出现了1次
        boolean[] b = new boolean[10001];
        for (int i : A) {
            if (!b[i]) {
                b[i] = true;
            } else {
                return i;
            }
        }
        return -1;
    }

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>(A.length / 2 + 1);
        for (int i : A) {
            if(set.contains(i)){
                return i;
            }else{
                set.add(i);
            }
        }
        return -1;
    }
}
