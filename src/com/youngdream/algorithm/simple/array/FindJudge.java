package com.youngdream.algorithm.simple.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YangDuan
 * @date 2020/1/29 14:59
 */
public class FindJudge {
    /**
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
     * 如果小镇的法官真的存在，那么：
     * 小镇的法官不相信任何人。
     * 每个人（除了小镇法官外）都信任小镇的法官。
     * 只有一个人同时满足属性 1 和属性 2 。
     * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
     * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
     * <p>
     * 示例 1：
     * 输入：N = 2, trust = [[1,2]]
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：N = 3, trust = [[1,3],[2,3]]
     * 输出：3
     * <p>
     * 示例 3：
     * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
     * 输出：-1
     * <p>
     * 示例 4：
     * 输入：N = 3, trust = [[1,2],[2,3]]
     * 输出：-1
     * <p>
     * 示例 5：
     * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * 输出：3
     * <p>
     * 提示：
     * 1 <= N <= 1000
     * trust.length <= 10000
     * trust[i] 是完全不同的
     * trust[i][0] != trust[i][1]
     * 1 <= trust[i][0], trust[i][1] <= N
     */
    public int findJudge1(int N, int[][] trust) {
        int[] trusts = new int[N];
        int temp = -1;
        Set<Integer> set = new HashSet<>(N);
        for (int[] ints : trust) {
            trusts[ints[0] - 1] = 1;
        }
        for (int i = 0; i < trusts.length; i++) {
            if (trusts[i] == 0) {
                temp = i + 1;
                set.add(temp);
                break;
            }
        }
        for (int[] ints : trust) {
            if (ints[1] == temp) {
                set.add(ints[0]);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                return -1;
            }
        }
        return temp;
    }

    //  最优解
    public int findJudge(int N, int[][] trust) {
        int[] a = new int[N + 1];
        int[] b = new int[N + 1];
        for (int[] ints : trust) {
            a[ints[0]] = 1;
            b[ints[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (a[i] == 0 && b[i] >= N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 2;
        int[][] trust = new int[][]{{1, 2}};
        System.out.println(new FindJudge().findJudge(N, trust));
    }
}
