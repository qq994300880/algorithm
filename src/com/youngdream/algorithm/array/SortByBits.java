package com.youngdream.algorithm.array;

import java.util.Arrays;

/**
 * @author YangDuan
 * @date 2020/3/17 22:43
 */
public class SortByBits {
    /**
     * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
     * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
     * 请你返回排序后的数组。
     * <p>
     * 示例 1：
     * 输入：arr = [0,1,2,3,4,5,6,7,8]
     * 输出：[0,1,2,4,8,3,5,6,7]
     * 解释：[0] 是唯一一个有 0 个 1 的数。
     * [1,2,4,8] 都有 1 个 1 。
     * [3,5,6] 有 2 个 1 。
     * [7] 有 3 个 1 。
     * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
     * <p>
     * 示例 2：
     * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
     * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
     * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
     * <p>
     * 示例 3：
     * 输入：arr = [10000,10000]
     * 输出：[10000,10000]
     * <p>
     * 示例 4：
     * 输入：arr = [2,3,5,7,11,13,17,19]
     * 输出：[2,3,5,17,7,11,13,19]
     * <p>
     * 示例 5：
     * 输入：arr = [10,100,1000,10000]
     * 输出：[10,100,10000,1000]
     * <p>
     * 提示：
     * 1 <= arr.length <= 500
     * 0 <= arr[i] <= 10^4
     *
     * @param arr 数组
     * @return 排序后的数组
     */
    public int[] sortByBits1(int[] arr) {
        //  利用Node静态内部类
        int[] result = new int[arr.length];
        Node[] nodes = new Node[arr.length];
        int count;
        for (int i = 0; i < arr.length; i++) {
            count = Integer.bitCount(arr[i]);
            nodes[i] = new Node(arr[i], count);
        }
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.value - o2.value;
            }
            return o1.count - o2.count;
        });
        for (int i = 0; i < result.length; i++) {
            result[i] = nodes[i].value;
        }
        return result;
    }

    private static class Node {
        int value;
        int count;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public int[] sortByBits(int[] arr) {
        //  利用两个数组通过排序1的个数来改变原数组顺序
        Arrays.sort(arr);
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            counts[i] = Integer.bitCount(arr[i]);
        }
        //  这里需要一种稳定的排序算法
        for (int i = 0; i < counts.length; i++) {
            //冒泡
        }
        return arr;
    }
}
