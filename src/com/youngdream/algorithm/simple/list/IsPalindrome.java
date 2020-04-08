package com.youngdream.algorithm.simple.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangDuan
 * @date 2020/4/8 22:58
 */
public class IsPalindrome {
    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     * <p>
     * 示例 1：
     * 输入： 1->2
     * 输出： false
     * <p>
     * 示例 2：
     * 输入： 1->2->2->1
     * 输出： true
     * <p>
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * @param head 链表头结点
     * @return 链表是否为回文链表
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int end = list.size() - 1;
        int start = 0;
        while (start < end) {
            if (!list.get(start++).equals(list.get(end--))) {
                return false;
            }
        }
        return true;
    }

    //  进阶
    public boolean isPalindrome(ListNode head) {
        //进阶
        //思路：把链表分为两部分，反转后半部分的链表，然后一一比较值是否相等
        //如果链表中没有元素 || 只有一个元素，那么返回True
        if (head == null || head.next == null) {
            return true;
        }

        //找到中间节点，slow，注意pre.next=null是将链表截断成两部分
        ListNode pre = head;
        ListNode slow = pre.next;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        //反转后半部分链表
        pre = null;
        while (slow != null) {
            ListNode tempNode = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tempNode;
        }
        //注意这个条件 pre != null && head != null
        //设想一个情况，链表节点有奇数个，那么肯定有一部分的链表比另一部分的链表多一个节点
        //但是其实我们不必关注多出的这个节点。
        //eg:1->2->5->2->1。前半部分链表：1->2。后半部分(未反转)：5->2->1;后半部分(反转后)：1->2->5。
        //可以看到，最后的一个节点其实是不用去比较的，因为这个节点刚好是原链表最中间的那个节点。
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
}
