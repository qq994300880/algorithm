package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/4/4 21:36
 */
public class KthToLast {
    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例：
     * 输入： 1->2->3->4->5 和 k = 2
     * 输出： 4
     * <p>
     * 说明：
     * 给定的 k 保证是有效的。
     *
     * @param head 链表头结点
     * @param k    倒数第K个
     * @return 节点的值
     */
    public int kthToLast(ListNode head, int k) {
        //  借助额外空间,时间O(n),空间0(n)
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        return list.get(list.size() - k);

        // 时间0(n),空间0(1)
        ListNode node = head;
        while (head != null) {
            if (k == 0) {
                node = node.next;
            } else {
                k--;
            }
            head = head.next;
        }
        return node.val;
    }
}
