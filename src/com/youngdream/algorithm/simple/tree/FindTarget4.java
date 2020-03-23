package com.youngdream.algorithm.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/10/8 0:24
 */
public class FindTarget4 {
    /**
     * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     * <p>
     * 案例 1:
     * 输入:
     * 5
     * / \
     * 3   6
     * / \   \
     * 2   4   7
     * Target = 9
     * 输出: True
     * <p>
     * 案例 2:
     * 输入:
     * 5
     * / \
     * 3   6
     * / \   \
     * 2   4   7
     * Target = 28
     * 输出: False
     */
    public boolean findTarget(TreeNode root, int k) {
        inOrderTraversal(root);
//        if (list.size() < 2) return false;
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == k) return true;
            else if (sum < k) start++;
            else end--;
        }
        return false;
    }

    //记录排好序的数组
    private List<Integer> list = new ArrayList<>();

    //中序遍历
    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        list.add(node.val);
        inOrderTraversal(node.right);
    }
}
