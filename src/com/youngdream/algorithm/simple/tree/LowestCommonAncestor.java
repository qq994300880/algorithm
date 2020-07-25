package com.youngdream.algorithm.simple.tree;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/24 12:50
 */
public class LowestCommonAncestor {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * <p>
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     * <p>
     * 说明:
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     *
     * @param root 根节点
     * @param p    第一个节点
     * @param q    第二个节点
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p.val < root.val && q.val < root.val) {
//            root = root.left;
//            return lowestCommonAncestor(root, p, q);
//        } else if (p.val > root.val && q.val > root.val) {
//            root = root.right;
//            return lowestCommonAncestor(root, p, q);
//        }
//        return root;
        //忘记这是一个二叉搜索树了(┬＿┬)
        this.p = p.val;
        this.q = q.val;
        dfs(root);
        return parent;
    }

    private int p;

    private int q;

    private boolean b = false;

    private TreeNode parent;

    private boolean dfs(TreeNode node) {
        if (b || node == null) {
            return false;
        }
        boolean left = dfs(node.left);
        if (b) {
            return false;
        }
        boolean now = node.val == p || node.val == q;
        if (b) {
            return false;
        }
        boolean right = dfs(node.right);
        if (b) {
            return false;
        }
        if (left && now || right && now || left && right) {
            parent = node;
            b = true;
        }
        return left || now || right;
    }
}
