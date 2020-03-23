package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/9/30 3:13
 */
public class CanPlaceFlowers {
    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     * <p>
     * 示例 1:
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * <p>
     * 示例 2:
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     * <p>
     * 注意:
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        //记录0的连续区间,开头和结尾需要额外加1
        int length = flowerbed.length;
        int lianxu = 1;
        for (int value : flowerbed) {
            if (value == 1) {
                //3=>1  5=>2  7=>3  9=>4  11=>5 ...... n=>(n-1)/2
                //计算区间可种花数
                int count = (lianxu - 1) / 2;
                //需种花数-可种花数
                n -= count;
                //判断是否种完
                if (n < 1) return true;
                //长度清零
                lianxu = 0;
            } else lianxu++;
        }
        //对结尾为0单独处理
        if (flowerbed[length - 1] == 0) lianxu++;
        //计算区间可种花数
        int count = (lianxu - 1) / 2;
        //需种花数-可种花数
        n -= count;
        //判断是否种完
        return n < 1;
    }
}
