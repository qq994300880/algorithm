package com.youngdream.algorithm.simple.stack;

import java.util.Stack;

/**
 * @author YangDuan
 * @date 2020/5/23 14:18
 */
public class CQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        peek();
        if (outStack.isEmpty()) {
            return -1;
        }
        return outStack.pop();
    }

    private void peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
