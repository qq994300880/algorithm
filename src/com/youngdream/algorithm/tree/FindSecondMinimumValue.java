package com.youngdream.algorithm.tree;

/**
 * @Author YoungDream
 * @Date 2019/10/11 19:16
 */
public class FindSecondMinimumValue {
    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     * <p>
     * 示例 1:
     * 输入:
     * 2
     * / \
     * 2   5
     * / \
     * 5   7
     * 输出: 5
     * 说明: 最小的值是 2 ，第二小的值是 5 。
     * <p>
     * 示例 2:
     * 输入:
     * 2
     * / \
     * 2   2
     * 输出: -1
     * 说明: 最小的值是 2, 但是不存在第二小的值。
     */
    public int findSecondMinimumValue(TreeNode root) {
        //空判断
        if (root == null) return -1;
        //由于题中有说到节点数量只能为2或0，所以可以做如下判断
        if (root.left == null || root.right == null) return -1;
        //获取左节点的值
        int leftVal = root.left.val;
        //获取右节点的值
        int rightVal = root.right.val;
        //如果子节点与父节点的值相等,则继续递归
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        //如果左节点和右节点都有对应第二小的值，则取小值
        if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
        //否则，返回有值的那个
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
