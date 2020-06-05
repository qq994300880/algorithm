package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/6/3 21:23
 */
public class MirrorTree {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * <p>
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * <p>
     * 限制：
     * 0 <= 节点个数 <= 1000
     * <p>
     * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
     *
     * @param root 给定根节点
     * @return 镜像根节点
     */
    public TreeNode mirrorTree(TreeNode root) {
        changeNode(root);
        return root;
    }

    /**
     * 可以使用的方法太多，队列，递归，这里就用最简单的递归
     * 思路：
     * 1.从根节点开始，如果两个节点不同时为空，则交换
     * 2.继续对左子树和右子树进行相同操作即可...
     *
     * @param node 需要改变的节点
     */
    private void changeNode(TreeNode node) {
        if (node != null && node.left != null || node.right != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            changeNode(left);
            changeNode(right);
        }
    }
}
