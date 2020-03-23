package com.youngdream.algorithm.simple.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author YoungDream
 * @Date 2019/10/1 19:23
 */
public class FindRestaurant {
    /**
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     * <p>
     * 示例 1:
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * 输出: ["Shogun"]
     * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
     * <p>
     * 示例 2:
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * 输出: ["Shogun"]
     * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
     * <p>
     * 提示:
     * 两个列表的长度范围都在 [1, 1000]内。
     * 两个列表中的字符串的长度将在[1，30]的范围内。
     * 下标从0开始，到列表的长度减1。
     * 两个列表都没有重复的元素。
     */
    //暴力法
    public String[] findRestaurant(String[] list1, String[] list2) {
        //记录最小索引和
        int min = Integer.MAX_VALUE;
        //创建结果字符串List
        List<String> list = new ArrayList<>();
        one:
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                //判断餐厅名称是否相等
                if (list1[i].equals(list2[j])) {
                    //提前结束
                    if (i > min) break one;
                    //提前结束
                    if (j > min) break;
                    //判断是否是最小索引值
                    if (i + j <= min) {
                        //记录最小索引和
                        min = i + j;
                        //添加到结果集
                        list.add(list1[i]);
                    }
                }
            }
        }
        return list.toArray(new String[0]);
    }

    //使用哈希表(官方题解)
    public String[] findRestaurant2(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        //将list1中字符串存入HashMap中
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        //记录索引和最小值
        int min_sum = Integer.MAX_VALUE;
        //计算索引
        int sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            //如果map中包含字符串键
            if (map.containsKey(list2[j])) {
                //计算索引和
                sum = j + map.get(list2[j]);
                //如果计算索引和小于索引和最小值
                if (sum < min_sum) {
                    //清空结果
                    res.clear();
                    //添加字符串
                    res.add(list2[j]);
                    //记录最小索引和
                    min_sum = sum;
                } else if (sum == min_sum) res.add(list2[j]);
            }
        }
        return res.toArray(new String[0]);
    }
}
