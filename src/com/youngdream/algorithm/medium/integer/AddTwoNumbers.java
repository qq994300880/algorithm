package com.youngdream.algorithm.medium.integer;

/**
 * @author YD
 * @email 994300880@qq.com
 * @date 2020/7/26 10:14
 */
public class AddTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1 第一个数的逆序链表
     * @param l2 第二个数的逆序链表
     * @return 和的逆序链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode temp = root;
        boolean carry = false;
        int num1;
        int num2;
        int sum;
        while (l1 != null || l2 != null || carry) {
            num1 = (l1 == null) ? 0 : l1.val;
            num2 = (l2 == null) ? 0 : l2.val;
            sum = num1 + num2;
            if (carry) {
                sum++;
                carry = false;
            }
            if (sum > 9) {
                carry = true;
                sum -= 10;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }

//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(2);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);
//
//        ListNode node2 = new ListNode(5);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);
//
//        ListNode result = new AddTwoNumbers().addTwoNumbers(node1, node2);
//        while (result != null) {
//            System.out.print(result.val + "=>");
//            result = result.next;
//        }
//    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
