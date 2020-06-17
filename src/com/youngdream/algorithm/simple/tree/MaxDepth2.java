package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/6/17 21:35
 */
public class MaxDepth2 {
    /**
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     * <p>
     * 提示：
     * 节点总数 <= 10000
     * 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * @param root 给定根节点
     * @return 树的深度
     */
    public int maxDepth(TreeNode root) {
        result = 0;
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private int result;

    private void dfs(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        deep++;
        if (deep > result) {
            result = deep;
        }
        dfs(node.left, deep);
        dfs(node.right, deep);
    }


}
