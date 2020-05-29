package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/5/29 21:54
 */
public class GetKthFromEnd {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     *
     * @param head 链表头结点
     * @param k    倒数第k个
     * @return 倒数第k个节点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        //时间O(n)，空间O(1)
        ListNode temp = head;
        while (temp != null) {
            if (k == 0) {
                head = head.next;
            } else {
                k--;
            }
            temp = temp.next;
        }
        return head;
    }
}
