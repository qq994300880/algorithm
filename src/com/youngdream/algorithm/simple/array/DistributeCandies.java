package com.youngdream.algorithm.simple.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author YoungDream
 * @Date 2019/9/27 11:53
 */
public class DistributeCandies {
    /**
     * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     * <p>
     * 示例 1:
     * 输入: candies = [1,1,2,2,3,3]
     * 输出: 3
     * 解析: 一共有三种种类的糖果，每一种都有两个。
     * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
     * <p>
     * 示例 2 :
     * 输入: candies = [1,1,2,3]
     * 输出: 2
     * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
     * <p>
     * 注意:
     * 数组的长度为[2, 10,000]，并且确定为偶数。
     * 数组中数字的大小在范围[-100,000, 100,000]内。
     */
    public int distributeCandies(int[] candies) {
        //糖果总数
        int total = candies.length;
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) set.add(candy);
        //糖果种类总数
        int count = set.size();
        return Math.min(count, total >> 1);
    }

    //sort=>O(nlogn)耗时比forEach=>O(n)长
    public int distributeCandies2(int[] candies) {
        int length = candies.length;
        Arrays.sort(candies);
        //糖果种类总数
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (candies[i] != candies[i - 1]) count++;
        }
        return Math.min(count, length >> 1);
    }
}
