package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/6/4 22:03
 */
public class IsSymmetric {
    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * <p>
     * 示例 1：
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * <p>
     * 限制：
     * 0 <= 节点个数 <= 1000
     * <p>
     * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
     *
     * @param root 根节点
     * @return 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            } else {
                return compare(left.left, right.right) && compare(left.right, right.left);
            }
        } else {
            return left == null && right == null;
        }
    }
}
