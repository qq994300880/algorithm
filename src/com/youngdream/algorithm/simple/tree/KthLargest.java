package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/6/16 21:45
 */
public class KthLargest {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     * <p>
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     * 3
     * / \
     * 1   4
     * \
     *    2
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * 输出: 4
     * <p>
     * 限制：
     * 1 ≤ k ≤ 二叉搜索树元素个数
     *
     * @param root 根节点
     * @param k    第k个
     * @return 第k个大的数
     */
    public int kthLargest(TreeNode root, int k) {
        this.result = -1;
        this.count = 0;
        this.k = k;
        dfs(root);
        return result;
    }

    //记录结果
    private int result;

    //计数器
    private int count;

    //成员变量记录k
    private int k;

    //深度优先
    private void dfs(TreeNode node) {
        //计数达到k则不用遍历了
        if (count == k) {
            return;
        }
        if (node != null) {
            dfs(node.right);
            //计数器没达到k则记录结果
            if (count != k) {
                count++;
                result = node.val;
            }
            dfs(node.left);
        }
    }
}
