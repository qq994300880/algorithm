package com.youngdream.algorithm.tree;

/**
 * @Author YoungDream
 * @Date 2019/11/8 23:02
 */
public class SearchBST {
    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     * 例如，
     * 给定二叉搜索树:
     * 4
     * / \
     * 2   7
     * / \
     * 1   3
     * 和值: 2
     * 你应该返回如下子树:
     * 2
     * / \
     * 1   3
     * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        //赋值给实例变量
        value = val;
        //调用方法获得结果节点
        search(root);
        return result;
    }

    //保存结果节点
    private TreeNode result = null;
    //保存定值
    private int value;

    //查找结果节点
    private void search(TreeNode node) {
        //1.如果当前节点为空，直接结束方法
        if (node == null) return;
        //2.获取当前节点的值
        int val = node.val;
        //3.根据二叉搜索树判断
        if (val == value) {//(1)当前节点值等于定值，将结果引用到该节点，方法结束
            result = node;
        } else if (val > value) {//(2)当前节点值大于定值，说明需要到左子树中继续查找
            search(node.left);
        } else {//(3)当前节点值小于定值，说明需要到柚子树中继续查找
            search(node.right);
        }
    }
}
