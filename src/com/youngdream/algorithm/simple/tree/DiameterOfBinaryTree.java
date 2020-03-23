package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/9/15 14:26
 */
public class DiameterOfBinaryTree {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
     * <p>
     * 示例 :
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * <p>
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     */
    private int max = 0;

    //1ms   修改了树的数据,不太好
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        zhongxu(root);
        return max;
    }

    private void zhongxu(TreeNode node) {
        if (node == null) return;
        node.val = 0;
        int left = -1;
        int right = -1;
        zhongxu(node.left);
        if (node.left != null) {
            left = node.left.val;
            node.val = left + 1;
        }
        zhongxu(node.right);
        if (node.right != null) {
            right = node.right.val;
            node.val = Math.max(node.val, right + 1);
        }
        max = Math.max(max, left + right + 2);
    }

    //1ms 只需记录深度回调即可
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }
}
