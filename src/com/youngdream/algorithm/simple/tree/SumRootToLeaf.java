package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/2/7 21:00
 */
public class SumRootToLeaf {
    /**
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 以 10^9 + 7 为模，返回这些数字之和。
     * <p>
     * 示例：
     * 输入：[1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * <p>
     * 提示：
     * 树中的结点数介于 1 和 1000 之间。
     * node.val 为 0 或 1 。
     */
    public int sumRootToLeaf(TreeNode root) {
        result = 0;
        temp = 0;
        dfs(root);
        return result;
    }

    private int result;

    private int temp;

    private void dfs(TreeNode node) {
        temp <<= 1;
        temp += node.val;
        if (node.left == null && node.right == null) {
            result += temp;
            temp >>= 1;
            return;
        }
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
        temp >>= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.left.right = new TreeNode(1);
        root.right.left.right.right = new TreeNode(1);
        System.out.println(new SumRootToLeaf().sumRootToLeaf(root));
    }
}
