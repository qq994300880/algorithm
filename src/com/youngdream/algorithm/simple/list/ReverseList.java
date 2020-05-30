package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/5/30 22:08
 */
public class ReverseList {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * <p>
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * <p>
     * 限制：
     * 0 <= 节点个数 <= 5000
     *
     * @param head 头节点
     * @return 反转后的头节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
