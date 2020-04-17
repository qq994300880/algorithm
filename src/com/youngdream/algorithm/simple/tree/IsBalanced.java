package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/4/17 1:17
 */
public class IsBalanced {
    /**
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     * <p>
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true 。
     * <p>
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false 。
     *
     * @param root 根节点
     * @return 是否平衡
     */
    public boolean isBalanced(TreeNode root) {
        return dfs(root);
    }

    //  深度优先，遍历方式三种都可以(这里使用中序遍历)
    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getDepth(node.left) - getDepth(node.right)) < 2 && dfs(node.left) && dfs(node.right);
    }

    //  求深度
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return Math.max(left, right) + 1;
    }
}
