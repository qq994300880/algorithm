package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/11/24 19:35
 */
public class MinDiffInBST {
    /**
     * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
     * <p>
     * 示例：
     * 输入: root = [4,2,6,1,3,null,null]
     * 输出: 1
     * 解释:
     * 注意，root是树结点对象(TreeNode object)，而不是数组。
     * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
     * <p>
     * 4
     * /   \
     * 2      6
     * / \
     * 1   3
     * <p>
     * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
     * <p>
     * 注意：
     * 二叉树的大小范围在 2 到 100。
     * 二叉树总是有效的，每个节点的值都是整数，且不重复。
     */
    //优先级队列
//    public int minDiffInBST(TreeNode root) {
//        queue = new PriorityQueue<>(100);
//        dfs(root);
//        int minValue = Integer.MAX_VALUE;
//        int one = queue.poll();
//        while (!queue.isEmpty()) {
//            int temp = queue.poll();
//            minValue = Math.min(minValue, Math.abs(one - temp));
//            one = temp;
//        }
//        return minValue;
//    }
//
//    private PriorityQueue<Integer> queue;
//
//    private void dfs(TreeNode node) {
//        if (node == null) return;
//        dfs(node.left);
//        queue.offer(node.val);
//        dfs(node.right);
//    }

    //中序遍历
    public int minDiffInBST(TreeNode root) {
        size = 0;
        nums = new int[100];
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size - 1; i++) {
            min = Math.min(min, nums[i + 1] - nums[i]);
        }
        return min;
    }

    private int[] nums;

    private int size;

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        nums[size++] = node.val;
        dfs(node.right);
    }
}
