package com.youngdream.algorithm.tree;

/**
 * @Author YoungDream
 * @Date 2019/10/11 13:26
 */
public class TrimBST {
    /**
     * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * 1
     * / \
     * 0   2
     * <p>
     * L = 1
     * R = 2
     * <p>
     * 输出:
     * 1
     * \
     * 2
     * 示例 2:
     * <p>
     * 输入:
     * 3
     * / \
     * 0   4
     * \
     * 2
     * /
     * 1
     * <p>
     * L = 1
     * R = 3
     * <p>
     * 输出:
     * 3
     * /
     * 2
     * /
     * 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        //空判断
        if (root == null) return root;
        //根节点大于最大值，修剪所有柚子树节点，继续查找左子树根节点
        if (root.val > R) return trimBST(root.left, L, R);
        //根节点小于最小值，修剪所有左子树节点，继续查找右子树根节点
        if (root.val < L) return trimBST(root.right, L, R);
        //根节点位于L与R之间，对左右子树进行修剪
        //开始递归修剪左子树
        root.left = trimBST(root.left, L, R);
        //开始递归修剪柚子树
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
