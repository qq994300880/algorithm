package com.youngdream.algorithm.simple.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangDuan
 * @date 2020/5/14 21:59
 */
public class MajorityElement {
    /**
     * 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     * <p>
     * 示例 1：
     * 输入：[1,2,5,9,5,9,5,5,5]
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：[3,2]
     * 输出：-1
     * <p>
     * 示例 3：
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * 说明：
     * 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
     *
     * @param nums 给定数组
     * @return 主要元素
     */
    public int majorityElement2(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if ((map.get(num) << 1) > len) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        //  摩尔投票
        int cnt = 0;
        int major = -1;
        for (int n : nums) {
            if (cnt == 0) {
                major = n;
                cnt++;
            } else {
                if (major == n) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return major;
    }
}
