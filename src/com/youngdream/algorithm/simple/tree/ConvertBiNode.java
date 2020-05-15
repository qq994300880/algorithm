package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/5/15 21:39
 */
public class ConvertBiNode {
    /**
     * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
     * 返回转换后的单向链表的头节点。
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例：
     * 输入： [4,2,5,1,3,null,6,0]
     * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
     * <p>
     * 提示：
     * 节点数量不会超过 100000。
     *
     * @param root 根节点
     * @return 单链表根节点
     */
    public TreeNode convertBiNode(TreeNode root) {
        //  所谓旁观者清...
        temp = new TreeNode(Integer.MIN_VALUE);
        TreeNode result = temp;
        inOrderTraversal(root);
        return result.right;
    }

    private TreeNode temp;

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        temp.right = node;
        node.left = null;
        temp = temp.right;
        inOrderTraversal(node.right);
    }
}
