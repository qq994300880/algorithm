package com.youngdream.algorithm.simple.stack;

/**
 * @author YangDuan
 * @date 2020/4/10 22:29
 */
public class TripleInOne {
    /**
     * 想复杂了
     */
    private int[] stack;
    private int size;
    private int index;
    private int count;

    /**
     * 三合一。描述如何只用一个数组来实现三个栈。
     * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
     * 构造函数会传入一个stackSize参数，代表每个栈的大小。
     * <p>
     * 示例1:
     * 输入：
     * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
     * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
     * 输出：
     * [null, null, null, 1, -1, -1, true]
     * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
     * <p>
     * 示例2:
     * 输入：
     * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
     * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
     * 输出：
     * [null, null, null, null, 2, 1, -1, -1]
     *
     * @param stackSize 栈的大小
     */
    public TripleInOne(int stackSize) {
        size = stackSize + 1;
        // 多一个标志位
        stack = new int[(size - 1) * size];
    }

    /**
     * 入栈
     *
     * @param stackNum 栈下标
     * @param value    栈值
     */
    public void push(int stackNum, int value) {
        if (stackNum >= size - 1) {
            return;
        }
        index = stackNum * size;
        count = stack[index];
        if (count != size - 1) {
            stack[index + count + 1] = value;
            stack[index]++;
        }
    }

    /**
     * 出栈
     *
     * @param stackNum 栈下标
     * @return 栈值
     */
    public int pop(int stackNum) {
        if (stackNum >= size - 1) {
            return -1;
        }
        index = stackNum * size;
        count = stack[index];
        if (count == 0) {
            return -1;
        }
        stack[index]--;
        return stack[index + count];
    }

    /**
     * 查询
     *
     * @param stackNum 栈下标
     * @return 栈值
     */
    public int peek(int stackNum) {
        if (stackNum >= size - 1) {
            return -1;
        }
        index = stackNum * size;
        count = stack[index];
        if (count == 0) {
            return -1;
        }
        return stack[index + count];
    }

    /**
     * 判断是否为空
     *
     * @param stackNum 栈下标
     * @return 是否为空
     */
    public boolean isEmpty(int stackNum) {
        if (stackNum >= size - 1) {
            return true;
        }
        index = stackNum * size;
        return stack[index] == 0;
    }
}
