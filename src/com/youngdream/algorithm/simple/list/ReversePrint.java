package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/5/22 21:43
 */
public class ReversePrint {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p>
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * 限制：
     * 0 <= 链表长度 <= 10000
     *
     * @param head 头节点
     * @return 反向节点数组
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] result = new int[size];
        temp = head;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = temp.val;
            temp = temp.next;
        }
        return result;
    }
}
