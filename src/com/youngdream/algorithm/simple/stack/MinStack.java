package com.youngdream.algorithm.simple.stack;

/**
 * @author YangDuan
 * @date 2020/4/11 22:19
 */
public class MinStack {
    // 暴力法 × 时间复杂度高
    // 其他：
    // 1.单栈法 √
    // 2.双栈法
    // 3.自创单链表

    private int[] stack;
    private int index;
    private int min = Integer.MAX_VALUE;

    /**
     * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
     * <p>
     * 示例：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    public MinStack() {
        stack = new int[7500];
        index = -1;
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stack[++index] = x;
    }

    public void pop() {
        if (stack[index] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; i++) {
                if (stack[i] < min) {
                    min = stack[i];
                }
            }
        }
        index--;
    }

    public int top() {
        return stack[index];
    }

    public int getMin() {
        return min;
    }
    // 单栈
//    private int min;
//    private Stack<Integer> stack = new Stack<Integer>();
//    public MinStack() {
//        min=Integer.MAX_VALUE;
//        stack = new Stack<Integer>();
//    }
//    public void push(int x) {
//        //当前值更小
//        if(x <= min){
//            //将之前的最小值保存
//            stack.push(min);
//            //更新最小值
//            min=x;
//        }
//        stack.push(x);
//    }
//
//    public void pop() {
//        //如果弹出的值是最小值，那么将下一个元素更新为最小值
//        if(stack.pop() == min) {
//            min=stack.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }
}
