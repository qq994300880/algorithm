package com.youngdream.algorithm.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/12/17 2:03
 */
public class LeafSimilar {
    /**
     * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * 3
     * /\
     * 51
     * /\ /\
     * 62 98
     * /\
     * 74
     * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
     * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * <p>
     * 提示：
     * 给定的两颗树可能会有 1 到 100 个结点。
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        dfs1(root1);
        dfs2(root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> list1;
    private List<Integer> list2;

    private void dfs1(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs1(node.left);
        if (node.left == null && node.right == null) {
            list1.add(node.val);
        }
        dfs1(node.right);
    }

    private void dfs2(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs2(node.left);
        if (node.left == null && node.right == null) {
            list2.add(node.val);
        }
        dfs2(node.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);

        System.out.println(new LeafSimilar().leafSimilar(root1, root2));
    }
}
