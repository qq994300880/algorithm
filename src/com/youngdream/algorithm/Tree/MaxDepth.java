package com.youngdream.algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author YoungDream
 * @Date 2019/9/23 15:29
 */
public class MaxDepth {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * <p>
     * 说明:
     * 树的深度不会超过 1000。
     * 树的节点总不会超过 5000。
     */
    public int maxDepth(Node root) {
        return have(root);
    }

    //递归
    private int have(Node node) {
        if (node == null) return 0;
        int result = 0;
        for (Node child : node.children) {
            result = Math.max(result, maxDepth(child));
        }
        return ++result;
    }

    //迭代：层序遍历 BFS
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            maxDepth++;
            while (count > 0) {
                count--;
                Node cur = queue.poll();
                assert cur != null;
                for (Node node : cur.children) {
                    if (node != null) queue.add(node);
                }
            }
        }
        return maxDepth;
    }

    //DFS
}
