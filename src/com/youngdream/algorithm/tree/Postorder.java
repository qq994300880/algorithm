package com.youngdream.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/9/28 12:29
 */
public class Postorder {
    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     * 例如，给定一个 3叉树 :
     * 返回其后序遍历: [5,6,3,2,4,1].
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     */
    public List<Integer> postorder(Node root) {
        postDfs(root);
        return result;
    }

    private List<Integer> result = new ArrayList<>();

    private void postDfs(Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            postDfs(child);
        }
        result.add(node.val);
    }
}
