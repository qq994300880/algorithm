package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2020/1/5 22:17
 */
public class RangeSumBST {
    /**
     * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
     * 二叉搜索树保证具有唯一的值。
     * <p>
     * 示例 1：
     * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
     * 输出：32
     * <p>
     * 示例 2：
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
     * 输出：23
     * <p>
     * 提示：
     * 树中的结点数量最多为 10000 个。
     * 最终的答案保证小于 2^31。
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        result = 0;
        leftPoint = L;
        rightPoint = R;
        dfs(root);
        return result;
    }

    private int result;

    private int leftPoint;

    private int rightPoint;

    private void dfs(TreeNode node) {
        if (node != null) {
            int val = node.val;
            if (leftPoint <= val && val <= rightPoint) {
                result += val;
            }
            if (leftPoint < val) {
                dfs(node.left);
            }
            if (node.val < rightPoint) {
                dfs(node.right);
            }
        }
    }
}
