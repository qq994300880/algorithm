package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/5/27 14:52
 */
public class DeleteNode2 {
    public ListNode deleteNode(ListNode head, int val) {
        //  严谨
//        if (head == null) {
////            return null;
////        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode now = pre.next;
        while (now != null) {
            if (now.val == val) {
                pre.next = now.next;
                return head;
            }
            pre = now;
            now = now.next;
        }
        return head;
    }
}
