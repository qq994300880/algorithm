package com.youngdream.algorithm.Tree;

/**
 * @Author YoungDream
 * @Date 2019/9/25 2:54
 */
public class FindTilt {
    private int result = 0;

    /**
     * 给定一个二叉树，计算整个树的坡度。
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     * 整个树的坡度就是其所有节点的坡度之和。
     * <p>
     * 示例:
     * 输入:
     * 1
     * /   \
     * 2     3
     * 输出: 1
     * 解释:
     * 结点的坡度 2 : 0
     * 结点的坡度 3 : 0
     * 结点的坡度 1 : |2-3| = 1
     * 树的坡度 : 0 + 0 + 1 = 1
     * <p>
     * 注意:
     * 任何子树的结点的和不会超过32位整数的范围。
     * 坡度的值不会超过32位整数的范围。
     */
    public int findTilt(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        result += Math.abs(left - right);
        return left + right + node.val;
    }
}
