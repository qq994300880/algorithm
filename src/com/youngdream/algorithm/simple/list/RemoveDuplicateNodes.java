package com.youngdream.algorithm.simple.list;

/**
 * @author YangDuan
 * @date 2020/4/3 21:40
 */
public class RemoveDuplicateNodes {
    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * <p>
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * <p>
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     * <p>
     * 提示：
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     * <p>
     * 进阶：
     * 如果不得使用临时缓冲区，该怎么解决？
     *
     * @param head 链表头结点
     * @return 移除后的链表
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        //  空间0(1),时间0(n^2)
        ListNode temp1 = head;
        ListNode temp2;
        ListNode temp3;
        while (temp1 != null) {
            temp2 = temp1;
            temp3 = temp1.next;
            while (temp3 != null) {
                if (temp1.val == temp3.val) {
                    temp2.next = temp3.next;
                } else {
                    temp2 = temp2.next;
                }
                temp3 = temp3.next;
            }
            temp1 = temp1.next;
        }
        return head;
    }
}
