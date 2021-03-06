package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/4/29 21:45
 */
public class FindMagicIndex {
    /**
     * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     * <p>
     * 示例1:
     * 输入：nums = [0, 2, 3, 4, 5]
     * 输出：0
     * 说明: 0下标的元素为0
     * <p>
     * 示例2:
     * 输入：nums = [1, 1, 1]
     * 输出：1
     * <p>
     * 提示:
     * nums长度在[1, 1000000]之间
     *
     * @param nums 给定有序整数数组
     * @return 找出魔术索引
     */
    public int findMagicIndex(int[] nums) {
        if (nums[0] > (nums.length - 1) || nums[nums.length - 1] < 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
