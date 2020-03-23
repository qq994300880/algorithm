package com.youngdream.algorithm.simple.tree;

import java.util.ArrayList;

/**
 * @Author YoungDream
 * @Date 2019/9/9 13:04
 */
public class GetMinimumDifference {
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
     * <p>
     * 示例 :
     * 输入:
     * 1
     * \
     * 3
     * /
     * 2
     * 输出:
     * 1
     * <p>
     * 解释:
     * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
     * 注意: 树中至少有2个节点。
     */
    //方式一：遍历所有树，将所有值记录成一个有序数组列表 5ms
    public int getMinimumDifference1(TreeNode root) {
        int min = Integer.MAX_VALUE;
        getMin(root);
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    private void getMin(TreeNode node) {
        if (node == null) return;
        getMin(node.left);
        list.add(node.val);
        getMin(node.right);
    }

    //方式二：相较于方式一，减少了一次遍历的时间
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null) {
            //求相邻节点的差值
            res = Math.min(res, Math.abs(root.val - pre.val));
        }
        pre = root;
        helper(root.right);
    }
}