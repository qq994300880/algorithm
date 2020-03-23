package com.youngdream.algorithm.simple.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author YangDuan
 * @date 2020/3/11 17:44
 */
public class ArrayRankTransform {
    /**
     * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
     * 序号代表了一个元素有多大。序号编号的规则如下：
     * 序号从 1 开始编号。
     * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
     * 每个数字的序号都应该尽可能地小。
     * <p>
     * 示例 1：
     * 输入：arr = [40,10,20,30]
     * 输出：[4,1,2,3]
     * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
     * <p>
     * 示例 2：
     * 输入：arr = [100,100,100]
     * 输出：[1,1,1]
     * 解释：所有元素有相同的序号。
     * <p>
     * 示例 3：
     * 输入：arr = [37,12,28,9,100,56,80,5,12]
     * 输出：[5,3,4,2,8,6,7,1,3]
     * <p>
     * 提示：
     * 0 <= arr.length <= 105
     * -109 <= arr[i] <= 109
     *
     * @param arr 给定数组
     * @return 序号数组
     */
    public int[] arrayRankTransform1(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer, int[]> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            if (ints == null) {
                ints = new int[]{i};
                map.put(arr[i], ints);
            } else {
                int[] newInts = new int[ints.length + 1];
                System.arraycopy(ints, 0, newInts, 0, ints.length);
                newInts[newInts.length - 1] = i;
                map.put(arr[i], newInts);
            }
        }
        int index = 1;
        for (int[] value : map.values()) {
            for (int i : value) {
                result[i] = index;
            }
            index++;
        }
        return result;
    }

    //  最优解
    public int[] arrayRankTransform(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int j = 1;
        //  找到最大最小值
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        //  标记有的数值
        int[] bucket = new int[max - min + 1];
        for (int i : arr) {
            bucket[i - min]++;
        }
        //  对标记的数值记录排名
        for (int i = 0; i < bucket.length; i++) {
            //  对标记的数值记录排名
            if (bucket[i] != 0) {
                bucket[i] = j++;
            }
        }
        int[] res = new int[arr.length];
        int index = 0;
        for (int i : arr) {
            res[index++] = bucket[i - min];
        }
        return res;
    }
}
