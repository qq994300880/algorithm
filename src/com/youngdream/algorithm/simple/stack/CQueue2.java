package com.youngdream.algorithm.simple.stack;

/**
 * @author YangDuan
 * @date 2020/5/23 14:32
 */
public class CQueue2 {
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
