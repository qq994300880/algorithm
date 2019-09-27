package com.youngdream.algorithm.tree;

import java.util.ArrayDeque;

/**
 * @Author YoungDream
 * @Date 2019/9/10 14:06
 */
public class ConvertBST {
    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * <p>
     * 例如：
     * 输入: 二叉搜索树:
     * 5
     * /   \
     * 2     13
     * <p>
     * 输出: 转换为累加树:
     * 18
     * /   \
     * 20     13
     */
    private int preNum = 0;

    //方法一:递归写法
    public TreeNode convertBST1(TreeNode root) {
        unPreOrder(root);
        return root;
    }

    private void unPreOrder(TreeNode root) {
        if (root == null) return;
        //处理柚子树
        unPreOrder(root.right);
        root.val += preNum;//当前节点加上所有大于它节点值之和
        preNum = root.val;//记录变化后当前节点的值
        unPreOrder(root.left);
    }

    //方法二：栈
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        //stack.add(root);
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.offerLast(node);
                node = node.right;
            }
            node = stack.pollLast();
            assert node != null;
            node.val += preNum;
            preNum = node.val;
            if (node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }
}