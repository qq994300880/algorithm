package com.youngdream.algorithm.hash;

/**
 * @Author YoungDream
 * @Date 2019/11/10 15:12
 */
public class MyHashSet {
    /**
     * 不使用任何内建的哈希表库设计一个哈希集合
     * 具体地说，你的设计应该包含以下的功能
     * <p>
     * add(value)：向哈希集合中插入一个值。
     * contains(value) ：返回哈希集合中是否存在这个值。
     * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
     * <p>
     * 示例:
     * MyHashSet hashSet = new MyHashSet();
     * hashSet.add(1);        
     * hashSet.add(2);        
     * hashSet.contains(1);    // 返回 true
     * hashSet.contains(3);    // 返回 false (未找到)
     * hashSet.add(2);          
     * hashSet.contains(2);    // 返回 true
     * hashSet.remove(2);          
     * hashSet.contains(2);    // 返回  false (已经被删除)
     * <p>
     * 注意：
     * 所有的值都在 [1, 1000000]的范围内。
     * 操作的总数目在[1, 10000]范围内。
     * 不要使用内建的哈希集合库。
     */
//    private int[] hash;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public MyHashSet() {
//        hash = new int[100001];
//    }
//
//    public void add(int key) {
//        hash[key] = 1;
//    }
//
//    public void remove(int key) {
//        hash[key] = 0;
//    }
//
//    /**
//     * Returns true if this set contains the specified element
//     */
//    public boolean contains(int key) {
//        return hash[key] == 1;
//    }
    //静态内部类
    private static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private int length;//不带扩容的固定长度数组
    private Node[] data;//Node数组

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        length = 100;
        data = new Node[length];
    }

    public void add(int key) {
        int index = key % length;//计算哈希值
        Node curr = data[index];//获取链表
        if (curr == null) {//如果当前链表中没有数据，创建新节点，保存到数组中
            Node node = new Node(key);
            data[index] = node;
            return;
        }
        while (true) {
            if (curr.val == key) return;//如果当前链表中有这个数据，不操作
            if (curr.next == null) {//如果当前链表中没有该值，且链表已遍历完
                Node node = new Node(key);//创建一个新节点
                node.prev = curr;//使新节点变为链表的最后一个节点，并与上一个节点关联起来
                curr.next = node;
                return;
            } else {
                curr = curr.next;//
            }
        }
    }

    public void remove(int key) {
        int index = key % length;
        Node curr = data[index];
        if (curr != null && curr.val == key) {//如果链表中第一个节点等于key
            Node next = curr.next;//获取第二个节点
            if (next != null) next.prev = null;//如果第二个节点不为null，则与第一个节点断开关联
            data[index] = next;//将第二个节点变为链表的第一个节点
            return;
        }
        while (curr != null) {//遍历链表找到key，删除该节点
            if (curr.val == key) {//找到key，断开关联
                Node next = curr.next;
                Node prev = curr.prev;
                if (next != null) next.prev = prev;
                if (prev != null) prev.next = next;
                return;
            }
            curr = curr.next;
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = key % length;//计算哈希值
        Node curr = data[index];//获取链表
        while (curr != null) {//遍历链表
            if (curr.val == key) return true;//如果该链表中有这个值，返回true
            curr = curr.next;//当前节点移到下一个
        }
        return false;
    }
}
