package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/10/14 11:08
 */
public class LongestUnivaluePath {
    /**
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     * <p>
     * 示例 1:
     * 输入:
     * <p>
     * 5
     * / \
     * 4   5
     * / \   \
     * 1   1   5
     * 输出:
     * 2
     * <p>
     * 示例 2:
     * 输入:
     * <p>
     * 1
     * / \
     * 4   5
     * / \   \
     * 4   4   5
     * 输出:
     * 2
     * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
     */
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        maxLength(root);
        return res;
    }

    //返回左右子树中相等节点距离最长的值
    private int maxLength(TreeNode root) {
        if (root == null) return 0;
        //递归压栈
        int left = maxLength(root.left);
        int right = maxLength(root.right);
        //叶子节点进行处理
        int leftLength = 0;
        int rightLength = 0;
        //左子树 与根节点相同再加入
        if (root.left != null && root.left.val == root.val) {
            leftLength = left + 1;
        }
        //右子树 与根节点相同再加入
        if (root.right != null && root.right.val == root.val) {
            rightLength = right + 1;
        }
        //判断当前的相等的最长的节点长度
        res = Math.max(res, rightLength + leftLength);
        //返回左右子树中最大的那个子树
        return Math.max(leftLength, rightLength);
    }
}
