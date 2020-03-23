package com.youngdream.algorithm.simple.tree;

/**
 * @author YoungDream
 * @date 2020/1/14 0:43
 */
public class IsUnivalTree {
    /**
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     * <p>
     * 示例 1：
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：[2,2,2,5,2]
     * 输出：false
     * <p>
     * 提示：
     * 给定树的节点数范围是 [1, 100]。
     * 每个节点的值都是整数，范围为 [0, 99] 。
     */
    public boolean isUnivalTree(TreeNode root) {
        standard = root.val;
        dfs(root);
        return result;
    }

    private int standard;

    private boolean result = true;

    private void dfs(TreeNode node) {
        if (node == null || !result) {
            return;
        }
        dfs(node.left);
        if (node.val != standard) {
            result = false;
        }
        dfs(node.right);
    }
}
