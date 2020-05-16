package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/5/16 22:06
 */
public class Massage {
    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * 注意：本题相对原题稍作改动
     * <p>
     * 示例 1：
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * <p>
     * 示例 2：
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * <p>
     * 示例 3：
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     *
     * @param nums 预约时长数组
     * @return 最长的分钟数
     */
    public int massage(int[] nums) {
        int pre = 0;
        int curr = 0;
        for (int num : nums) {
            int c = Math.max(curr, pre + num);
            pre = curr;
            curr = c;
        }
        return curr;
    }
}
