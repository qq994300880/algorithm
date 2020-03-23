package com.youngdream.algorithm.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/9/28 12:21
 */
public class Preorder {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     * 例如，给定一个 3叉树 :
     * 1
     * // \
     * 3 2  4
     * / \
     * 5 6
     * 返回其前序遍历: [1,3,5,6,2,4]。
     * <p>
     * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
     */
    public List<Integer> preorder(Node root) {
        preDfs(root);
        return result;
    }

    //记录结果
    private List<Integer> result = new ArrayList<>();

    //递归方法
    private void preDfs(Node node) {
        if (node == null) return;
        //添加数值
        result.add(node.val);
        //遍历
        for (Node child : node.children) {
            preDfs(child);
        }
    }
}
