package com.youngdream.algorithm.array;

import java.util.PriorityQueue;

/**
 * @Author YoungDream
 * @Date 2019/11/9 14:28
 */
public class KthLargest {
    /*
      设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
      你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
      <p>
      示例:
      int k = 3;
      int[] arr = [4,5,8,2];
      KthLargest kthLargest = new KthLargest(3, arr);
      kthLargest.add(3);   // returns 4
      kthLargest.add(5);   // returns 5
      kthLargest.add(10);  // returns 5
      kthLargest.add(9);   // returns 8
      kthLargest.add(4);   // returns 8
      <p>
      说明:
      你可以假设 nums 的长度≥ k-1 且k ≥ 1。
     */
//    private List<Integer> list = new ArrayList<>();
//    private int k;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        Arrays.sort(nums);
//        for (int num : nums) {
//            list.add(num);
//        }
//    }
//
//    public int add(int val) {
//        if (list.isEmpty()) {
//            list.add(val);
//        } else if (val <= list.get(0)) {
//            list.add(0, val);
//        } else if (val >= list.get(list.size() - 1)) {
//            list.add(val);
//        } else {
//            for (int i = 0; i < list.size() - 1; i++) {
//                if (list.get(i) <= val && val <= list.get(i + 1)) {
//                    list.add(i + 1, val);
//                    break;
//                }
//            }
//        }
//        return list.get(list.size() - this.k);
//    }

    /**
     * PriorityQueue 一个基于优先级的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)。
     * PriorityQueue 队列的头指排序规则最小那哥元素。如果多个元素都是最小值则随机选一个。
     * PriorityQueue 是一个无界队列，但是初始的容量(实际是一个Object[])，随着不断向优先级队列添加元素，其容量会自动扩容，无需指定容量增加策略的细节。
     * 默认情况下PriorityQueue使用自然排序法，最小元素先出列。
     * <p>
     * PriorityQueue优先级规则可以由我们根据具体需求而定制， 方式有2种：
     * 1>添加元素自身实现了Comparable接口，确保元素是可排序的对象
     * 2>如果添加元素没有实现Comparable接口，可以在创建PriorityQueue队列时直接指定比较器。
     * <p>
     * 注意：
     * 1>PriorityQueue是一种无界的，线程不安全的队列
     * 2>PriorityQueue是一种通过数组实现的，并拥有优先级的队列
     * 3>PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器
     */
    private PriorityQueue<Integer> priorityQueue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}
