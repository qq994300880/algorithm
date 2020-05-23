package com.youngdream.algorithm.simple.stack;

/**
 * @author YangDuan
 * @date 2020/5/23 14:32
 */
public class CQueue2 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     * <p>
     * 示例 1：
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * <p>
     * 示例 2：
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * <p>
     * 提示：
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     */
    private int[] stack;
    private int start;
    private int end;

    public CQueue2() {
        stack = new int[10000];
        start = 0;
        end = 0;
    }

    public void appendTail(int value) {
        stack[end++] = value;
    }

    public int deleteHead() {
        if (start == end) {
            return -1;
        }
        return stack[start++];
    }
}
