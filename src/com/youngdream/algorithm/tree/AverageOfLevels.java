package com.youngdream.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author YoungDream
 * @Date 2019/10/5 13:23
 */
public class AverageOfLevels {
    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
     * <p>
     * 示例 1:
     * 输入:
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 输出: [3, 14.5, 11]
     * 解释:
     * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
     * <p>
     * 注意：
     * 节点值的范围在32位有符号整数范围内。
     */
//    //方法一:利用list记录总和，利用map记录个数
//    public List<Double> averageOfLevels(TreeNode root) {
//        int level = 0;
//        bfs(root, level);
//        for (int i = 0; i < list.size(); i++) {
//            Double d = list.get(i);
//            list.set(i, d / map.get(i));
//        }
//        return list;
//    }
//
//    //记录个数
//    private Map<Integer, Integer> map = new HashMap<>();
//    //记录总和以及返回结果
//    private List<Double> list = new ArrayList<>();
//
//    //map记录当层总个数，list记录当层总和
//    private void bfs(TreeNode node, int level) {
//        if (node == null) return;
//        Integer integer = map.get(level);
//        if (integer == null) map.put(level, 1);
//        else map.put(level, ++integer);
//        if (list.size() < level + 1) list.add((double) node.val);
//        else list.set(level, list.get(level) + node.val);
//        level++;
//        bfs(node.left, level);
//        bfs(node.right, level);
//    }

    //方法二：先计算深度，再创建两个深度长的数组分别记录当层总个数和当层总和
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> list = new ArrayList<Double>();
//        int height = maxDepth(root);
//        long[] a = new long[height];
//        long[] b = new long[height];
//        levels(root, 0, a, b);
//        for (int i = 0; i < b.length; i++) {
//            list.add((double) a[i] / b[i]);
//        }
//        return list;
//    }
//
//    //计算个数与和
//    private void levels(TreeNode root, int height, long[] a, long[] b) {
//        if (root != null) {
//            a[height] += root.val;
//            b[height] += 1;
//            levels(root.left, height + 1, a, b);
//            levels(root.right, height + 1, a, b);
//        }
//    }
//
//    //递归求深度
//    private int maxDepth(TreeNode root) {
//        int sum = 0;
//        if (root == null) return sum;
//        sum++;
//        sum += Math.max(maxDepth(root.left), maxDepth(root.right));
//        return sum;
//    }

    //方法三：BFS广度优先搜索算法
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = size;
            double sum = 0;
            while (i-- > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(sum / size);
        }
        return list;
    }
}
