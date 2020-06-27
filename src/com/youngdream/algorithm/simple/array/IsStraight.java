package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/6/27 21:20
 */
public class IsStraight {
    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,4,5]
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: [0,0,1,2,5]
     * 输出: True
     * <p>
     * 限制：
     * 数组长度为 5 
     * 数组的数取值为 [0, 13] .
     *
     * @param nums 给定数字数组
     * @return 是否为顺子
     */
    public boolean isStraight(int[] nums) {
        int[] counts = new int[14];
        int min = 14;
        int max = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            //关键1：记录非0出现次数
            if (++counts[num] > 1) {
                return false;
            }
        }
        //关键2：最大值与最小值的范围
        return max - min <= 4;
    }
}
