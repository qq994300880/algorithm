package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/9/30 23:00
 */
public class MergeTrees {
    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 示例 1:
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //空节点判断
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        merge(t1, t2);
        return t1;
    }

    private void merge(TreeNode t1, TreeNode t2) {
        //第一次已经判断过都不为空，以后每次在下面进行判断
        t1.val = t1.val + t2.val;
        TreeNode left1 = t1.left;
        TreeNode left2 = t2.left;
        //如果都不为null，则对左子树进行递归
        if (left1 != null && left2 != null) merge(left1, left2);
        //否则如果t1上没有的节点直接吧t2上的节点挂载过去即可
        else if (left1 == null && left2 != null) t1.left = left2;
        TreeNode right1 = t1.right;
        TreeNode right2 = t2.right;
        //柚子树同理
        if (right1 != null && right2 != null) merge(right1, right2);
        else if (right1 == null && right2 != null) t1.right = right2;
    }
}
