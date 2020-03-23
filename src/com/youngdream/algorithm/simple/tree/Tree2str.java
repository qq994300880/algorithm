package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/10/1 20:03
 */
public class Tree2str {
    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * <p>
     * 示例 1:
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * 输出: "1(2(4))(3)"
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     * <p>
     * 示例 2:
     * 输入: 二叉树: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * 输出: "1(2()(4))(3)"
     * 解释: 和第一个示例相似，
     * <p>
     * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
     */
    public String tree2str(TreeNode t) {
        dfs(t);
        return sb.toString();
    }

    //中序遍历
    private void dfs(TreeNode node) {
        if (node == null) return;
        sb.append(node.val);
        //添加括号的条件
        if (node.left == null) {//左子树为空
            if (node.right == null) ;//两树都为空,不做处理
            else {//左子树为空，柚子树不为空
                sb.append('(');
                sb.append(')');
                sb.append('(');
                dfs(node.right);
                sb.append(')');
            }
        } else {//左子树不为空
            if (node.right == null) {//左子树不为空，柚子树为空
                sb.append('(');
                dfs(node.left);
                sb.append(')');
            } else {//左子树不为空，柚子树不为空
                sb.append('(');
                dfs(node.left);
                sb.append(')');
                sb.append('(');
                dfs(node.right);
                sb.append(')');
            }
        }
    }

    private StringBuilder sb = new StringBuilder();
}
