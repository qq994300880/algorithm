package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/6/2 21:59
 */
public class MergeTwoLists {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * <p>
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 限制：
     * 0 <= 链表长度 <= 1000
     *
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //  旁观者清模式...
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            }
            if (l2 == null) {
                temp.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}
