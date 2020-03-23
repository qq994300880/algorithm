package com.youngdream.algorithm.simple.tree;

/**
 * @Author YoungDream
 * @Date 2019/9/22 12:54
 */
public class Intersect {
    /**
     * 四叉树是一种树数据，其中每个结点恰好有四个子结点：topLeft、topRight、bottomLeft 和 bottomRight。四叉树通常被用来划分一个二维空间，递归地将其细分为四个象限或区域。
     * 我们希望在四叉树中存储 True/False 信息。四叉树用来表示 N * N 的布尔网格。对于每个结点, 它将被等分成四个孩子结点直到这个区域内的值都是相同的。每个节点都有另外两个布尔属性：isLeaf 和 val。当这个节点是一个叶子结点时 isLeaf 为真。val 变量储存叶子结点所代表的区域的值。
     * <p>
     * 例如，下面是两个四叉树 A 和 B：
     * <p>
     * A:
     * +-------+-------+   T: true
     * |       |       |   F: false
     * |   T   |   T   |
     * |       |       |
     * +-------+-------+
     * |       |       |
     * |   F   |   F   |
     * |       |       |
     * +-------+-------+
     * topLeft: T
     * topRight: T
     * bottomLeft: F
     * bottomRight: F
     * <p>
     * B:
     * +-------+---+---+
     * |       | F | F |
     * |   T   +---+---+
     * |       | T | T |
     * +-------+---+---+
     * |       |       |
     * |   T   |   F   |
     * |       |       |
     * +-------+-------+
     * topLeft: T
     * topRight:
     * topLeft: F
     * topRight: F
     * bottomLeft: T
     * bottomRight: T
     * bottomLeft: T
     * bottomRight: F
     * <p>
     * 你的任务是实现一个函数，该函数根据两个四叉树返回表示这两个四叉树的逻辑或(或并)的四叉树。
     * <p>
     * A:                 B:                 C (A or B):
     * +-------+-------+  +-------+---+---+  +-------+-------+
     * |       |       |  |       | F | F |  |       |       |
     * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
     * |       |       |  |       | T | T |  |       |       |
     * +-------+-------+  +-------+---+---+  +-------+-------+
     * |       |       |  |       |       |  |       |       |
     * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
     * |       |       |  |       |       |  |       |       |
     * +-------+-------+  +-------+-------+  +-------+-------+
     *  
     * 提示：
     * A 和 B 都表示大小为 N * N 的网格。
     * N 将确保是 2 的整次幂。
     * 如果你想了解更多关于四叉树的知识，你可以参考这个 wiki 页面。
     * 逻辑或的定义如下：如果 A 为 True ，或者 B 为 True ，或者 A 和 B 都为 True，则 "A 或 B" 为 True。
     */
    public FourNode intersect(FourNode quadTree1, FourNode quadTree2) {
        //如果都为叶子节点
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new FourNode(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        //不都为叶子节点
        //其中一个为叶子节点且值为true，则合并为一个叶子节点
        boolean hasTrue = quadTree1.isLeaf && quadTree1.val || quadTree2.isLeaf && quadTree2.val;
        if (hasTrue) {
            return new FourNode(true, true, null, null, null, null);
        }
        //其中一个为叶子节点且值为false，则返回不是叶子节点的一方
        if (quadTree1.isLeaf || quadTree2.isLeaf) {
            return quadTree1.isLeaf ? quadTree2 : quadTree1;
        }
        //否则包含了复杂的交集运算，使用递归
        FourNode[] nodes = new FourNode[]{
                this.intersect(quadTree1.topLeft, quadTree2.topLeft),
                this.intersect(quadTree1.topRight, quadTree2.topRight),
                this.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft),
                this.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
        };
        //是否都为叶子节点
        boolean all_leaf = true;
        //值是否都相等
        boolean all_equal = true;
        for (int i = 0; i < nodes.length; i++) {
            //不都为，修改标志位跳出
            if (!nodes[i].isLeaf) {
                all_leaf = false;
                break;
            }
            if (i > 0) {
                if (nodes[i].val != nodes[i - 1].val) {
                    all_equal = false;
                }
            }
        }
        //通过标志位得到都为叶子节点，值都相等，合并
        if (all_equal && all_leaf) {
            return new FourNode(nodes[0].val, true, null, null, null, null);
        }
        //否则返回对应的节点
        return new FourNode(false, false, nodes[0], nodes[1], nodes[2], nodes[3]);
    }
}

class FourNode {
    public boolean val;
    public boolean isLeaf;
    public FourNode topLeft;
    public FourNode topRight;
    public FourNode bottomLeft;
    public FourNode bottomRight;

    public FourNode() {
    }

    public FourNode(boolean _val, boolean _isLeaf, FourNode _topLeft, FourNode _topRight, FourNode _bottomLeft, FourNode _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}