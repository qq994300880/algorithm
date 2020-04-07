package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/4/7 21:29
 */
public class DeleteNode {
    /**
     * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
     * <p>
     * 示例：
     * 输入：单向链表a->b->c->d->e->f中的节点c
     * 结果：不返回任何数据，但该链表变为a->b->d->e->f
     *
     * @param node 单向链表
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
