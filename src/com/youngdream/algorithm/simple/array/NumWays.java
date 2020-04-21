package com.youngdream.algorithm.simple.array;

import java.util.*;

/**
 * @author YangDuan
 * @date 2020/4/21 15:27
 */
public class NumWays {
    /**
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     * <p>
     * 示例 1：
     * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
     * 输出：3
     * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
     * <p>
     * 示例 2：
     * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
     * 输出：0
     * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
     * <p>
     * 限制：
     * 2 <= n <= 10
     * 1 <= k <= 5
     * 1 <= relation.length <= 90, 且 relation[i].length == 2
     * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
     *
     * @param n        有 n 名玩家
     * @param relation 按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组
     * @param k        经过 k 轮
     * @return 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0
     */
    public int numWay1(int n, int[][] relation, int k) {
        //  适用于教学,注重过程
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] ints : relation) {
            int num = ints[0];
            int goal = ints[1];
            map.get(num).add(goal);
        }
//        System.out.println(map);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        queue.offer(-1);
        int rounds = 0;
        while (!queue.isEmpty()) {
            int goal = queue.poll();
            if (goal == -1) {
                rounds++;
                if (rounds >= k) {
                    break;
                } else {
                    queue.offer(-1);
                }
            } else {
                Set<Integer> integers = map.get(goal);
                integers.forEach(queue::offer);
//                System.out.println("第 " + (rounds + 1) + " 轮,目标=> " + goal + " 添加=> " + integers);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
//            System.out.println(poll);
            if (poll == n - 1) {
                count++;
            }
        }
        return count;
    }

    //  最快，只关注结果。只需记录第K轮到达第n-1编号的方案
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        // 初始值,表示第0轮到达0只有一种方案
        dp[0][0] = 1;
        // 经过k轮
        for (int i = 0; i < k; i++) {
            //  遍历方案
            for (int[] r : relation) {
                dp[i + 1][r[1]] += dp[i][r[0]];
            }
        }
        return dp[k][n - 1];
    }
}
