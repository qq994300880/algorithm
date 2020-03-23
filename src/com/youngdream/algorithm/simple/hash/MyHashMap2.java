package com.youngdream.algorithm.simple.hash;

/**
 * @Author YoungDream
 * @Date 2019/11/11 18:34
 */
public class MyHashMap2 {
    /**
     * 基于两个数组
     */
    private int[] keys;
    private int[] values;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap2() {
        keys = new int[1000000];
        values = new int[1000000];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        values[key] = value;
        keys[key] = 1;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (keys[key] == 1) return values[key];
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        keys[key] = 0;
        values[key] = 0;
    }
}
