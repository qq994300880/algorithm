package com.youngdream.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/9/5 18:17
 */
public class FindMode {
    private List<Integer> list = new ArrayList<>();
    private int preTimes = 1;
    private int curTimes = 1;
    private TreeNode preNode = null;

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * <p>
     * 假定 BST 有如下定义：
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * <p>
     * 例如：
     * 给定 BST [1,null,2,2],
     * 1
     * \
     * 2
     * /
     * 2
     * 返回[2].
     * <p>
     * 提示：如果众数超过1个，不需考虑输出顺序
     * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        Integer[] integers = list.toArray(new Integer[0]);
        return result;
    }

    //执行的顺序就是从x开始找，一直找到最左侧节点，a->y->b->x->z->c->d
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);

        if (preNode != null) {
            curTimes = node.val == preNode.val ? curTimes + 1 : 1;
        }
        if (curTimes == preTimes) {
            list.add(node.val);
        } else if (curTimes > preTimes) {
            preTimes = curTimes;
            list.clear();
            list.add(node.val);
        }
        preNode = node;
        dfs(node.right);
    }
}

/**
 * x
 * / \
 * y   z
 * / \  / \
 * a   b  c  d
 * a<=y<=b<=x<=c<=z<=d
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
