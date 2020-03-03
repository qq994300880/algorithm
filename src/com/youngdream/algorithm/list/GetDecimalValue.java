package com.youngdream.algorithm.list;

/**
 * @author YangDuan
 * @date 2020/3/3 21:58
 */
public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
        int result = head.val;
        while (head.next != null) {
            head = head.next;
            result <<= 1;
            result |= head.val;
        }
        return result;
    }
}
