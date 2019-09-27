package com.youngdream.algorithm.tree;

/**
 * @Author YoungDream
 * @Date 2019/9/26 14:41
 */
public class IsSubtree {
    /**
     * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
     * <p>
     * 示例 1:
     * 给定的树 s:
     * <p>
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * 给定的树 t：
     * 4
     * / \
     * 1   2
     * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
     * <p>
     * 示例 2:
     * 给定的树 s：
     * 3
     * / \
     * 4   5
     * / \
     * 1   2
     * /
     * 0
     * 给定的树 t：
     * 4
     * / \
     * 1   2
     * 返回 false。
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        result = false;
        //自身判断
        if (s == t) return true;
        //调用方法
        dfs(s, t);
        return result;
    }

    //记录是否包含
    private boolean result;

    /**
     * 中序遍历s树
     *
     * @param node 当前节点
     * @param t    t根节点
     */
    private void dfs(TreeNode node, TreeNode t) {
        if (node == null) return;
        dfs(node.left, t);
        //找到t根节点相同值的节点,同时判断结构是否一致
        if (node.val == t.val && compare(node, t)) result = true;
        dfs(node.right, t);
    }

    /**
     * 判断结构是否一致
     *
     * @param a s节点
     * @param b t节点
     * @return 是否结构一致
     */
    private boolean compare(TreeNode a, TreeNode b) {
        //二者都为null
        if (a == null && b == null) return true;
        //其中之一为null
        if (a != null && b == null) return false;
        if (a == null) return false;
        //都不为null
        if (a.val != b.val) return false;
        return compare(a.left, b.left) && compare(a.right, b.right);
    }
}
