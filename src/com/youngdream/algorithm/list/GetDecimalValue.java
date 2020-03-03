package com.youngdream.algorithm.list;

/**
 * @author YangDuan
 * @date 2020/3/3 21:58
 */
public class GetDecimalValue {
    /**
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     * 请你返回该链表所表示数字的 十进制值 。
     * <p>
     * 示例 1：
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * <p>
     * 示例 2：
     * 输入：head = [0]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：head = [1]
     * 输出：1
     * <p>
     * 示例 4：
     * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * 输出：18880
     * <p>
     * 示例 5：
     * 输入：head = [0,0]
     * 输出：0
     * <p>
     * 提示：
     * 链表不为空。
     * 链表的结点总数不超过 30。
     * 每个结点的值不是 0 就是 1。
     */
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
