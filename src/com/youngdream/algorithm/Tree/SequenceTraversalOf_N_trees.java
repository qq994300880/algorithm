package com.youngdream.algorithm.Tree;

import java.util.*;

/**
 * @Author YoungDream
 * @Date 2019/8/21 11:45
 */
public class SequenceTraversalOf_N_trees {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * <p>
     * [[1],[3,2,4],[5,6]]
     * <p>
     * 说明:
     * 树的深度不会超过 1000。
     * 树的节点总数不会超过 5000。
     */
    //方法一：使用队列，相对于递归效率要低一些,时间多消耗在出队列和入队列
    public List<List<Integer>> levelOrder(Node root) {
        //创建结果集
        List<List<Integer>> result = new ArrayList<>();
        //如果根节点为null直接返回
        if (null == root) return result;
        //使用ArrayDeque,性能相对于Quque要好一些
        ArrayDeque<Node> queue = new ArrayDeque<>();
        //首先将root节点加入队列尾部,因为ArrayDeque的offer()方法调用的就是offerLast(T)
        queue.offerLast(root);
        //如果队列不为空，说明没有完全遍历
        while (!queue.isEmpty()) {
            int count = queue.size();
            //创建当前层的数组
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                //依次从队列中拿到节点
                Node cur = queue.pollFirst();
                //将节点值加入当前层数组
                list.add(cur.val);
                for (Node child : cur.children) {
                    //如果子节点存在就加入队列尾部
                    if (child != null) {
                        queue.offerLast(child);
                    }
                }
                count--;
            }
            //将当前层的数组加入到结果集中
            result.add(list);
        }
        return result;
    }

    //方法二：使用递归
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        //调用递归方法
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int level, List<List<Integer>> res) {
        //如果级别高于结果集长度说明是新的一层,加入当前层的节点值数组
        if (res.size() < level + 1) res.add(new ArrayList<>());
        //将节点值加入当前层节点值数组中
        res.get(level).add(root.val);
        //依次对子节点进行处理
        for (Node node : root.children) {
            helper(node, level + 1, res);
        }
    }
}

class Node {
    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
