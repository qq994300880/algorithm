package com.youngdream.algorithm.simple.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/12/18 22:59
 */
public class MiddleNode {
    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * <p>
     * 示例 2：
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * 提示：
     * 给定链表的结点数介于 1 和 100 之间。
     */
    //  超时
    public ListNode middleNode1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        ListNode next = head.next;
        while (next != null) {
            list.add(next);
            next = head.next;
        }
        return list.get(list.size() / 2);
    }

    public ListNode middleNode(ListNode head) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
