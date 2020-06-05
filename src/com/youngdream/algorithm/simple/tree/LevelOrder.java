package com.youngdream.algorithm.simple.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author YangDuan
 * @date 2020/6/5 22:32
 */
public class LevelOrder {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 提示：
     * 节点总数 <= 1000
     * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     *
     * @param root 树根节点
     * @return 打印的列表
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> row = new ArrayList<>(1);
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode poll;
        TreeNode left;
        TreeNode right;
        queue.offer(root);
        //  记录下一深度中不为空的个数
        int count = 0;
        //  当前深度的剩余节点数
        int temp = 1;
        while (!queue.isEmpty()) {
            if (temp == 0) {
                //  当前深度没有剩余节点，则添加显示数组到结果中，初始化各个参数
                result.add(row);
                temp = count;
                count = 0;
                row = new ArrayList<>(temp);
            } else {
                poll = queue.poll();
                row.add(poll.val);
                left = poll.left;
                right = poll.right;
                if (left != null) {
                    queue.offer(left);
                    count++;
                }
                if (right != null) {
                    queue.offer(right);
                    count++;
                }
                //  当前深度剩余节点数--
                temp--;
            }
        }
        if (row.size() > 0) {
            result.add(row);
        }
        return result;
    }
}
