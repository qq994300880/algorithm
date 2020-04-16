package com.youngdream.algorithm.simple.tree;

/**
 * @author YangDuan
 * @date 2020/4/15 21:23
 */
public class SortedArrayToBST {
    /**
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
     * <p>
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * <p>
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param nums 升序数组
     * @return 高度最小的二叉搜索树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        temps = nums;
        int len = nums.length;
        TreeNode head = new TreeNode(nums[len / 2]);
        addNode(0, len - 1, head);
        return head;
    }

    private int[] temps;

    private void addNode(int start, int end, TreeNode node) {
        //  防止溢出
        int middle = start + (end + 1 - start) / 2;
        //  左
        int leftDistance = middle - start;
        if (leftDistance > 3) {
            int leftMiddle = start + leftDistance / 2;
            node.left = new TreeNode(temps[leftMiddle]);
            addNode(start, middle - 1, node.left);
        } else if (leftDistance == 3) {
            node.left = new TreeNode(temps[start + 1]);
            node.left.left = new TreeNode(temps[start]);
            node.left.right = new TreeNode(temps[start + 2]);
        } else if (leftDistance == 2) {
            node.left = new TreeNode(temps[start + 1]);
            node.left.left = new TreeNode(temps[start]);
        } else if (leftDistance == 1) {
            node.left = new TreeNode(temps[start]);
        }
        //  右
        int rightDistance = end - middle;
        if (rightDistance > 3) {
//            int rigthMiddle = (middle + 1) + (end + 1 - (middle + 1)) / 2;
            int rigthMiddle = (middle + 1) + (end - middle) / 2;
            node.right = new TreeNode(temps[rigthMiddle]);
            addNode(middle + 1, end, node.right);
        } else if (rightDistance == 3) {
            node.right = new TreeNode(temps[middle + 2]);
            node.right.left = new TreeNode(temps[middle + 1]);
            node.right.right = new TreeNode(temps[middle + 3]);
        } else if (rightDistance == 2) {
            node.right = new TreeNode(temps[middle + 2]);
            node.right.left = new TreeNode(temps[middle + 1]);
        } else if (rightDistance == 1) {
            node.right = new TreeNode(temps[middle + 1]);
        }
    }
}
