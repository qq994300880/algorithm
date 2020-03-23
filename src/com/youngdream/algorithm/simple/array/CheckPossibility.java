package com.youngdream.algorithm.simple.array;

/**
 * @Author YoungDream
 * @Date 2019/10/8 15:51
 */
public class CheckPossibility {
    /**
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
     * <p>
     * 示例 1:
     * 输入: [4,2,3]
     * 输出: True
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * <p>
     * 示例 2:
     * 输入: [4,2,1]
     * 输出: False
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     * 说明:  n 的范围为 [1, 10,000]。
     */
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) return true;
        int count = 0;
        for (int i = nums.length - 2; i >= 1; i--) {
            //前
            int pre = nums[i - 1];
            //中
            int now = nums[i];
            //后
            int suf = nums[i + 1];
            //五种情况
            //1.继续前进
            if (pre <= now && now <= suf) continue;
            //2.三连递减，无药可治
            if (pre > now && now > suf) return false;
            //3.改前
            if (pre > now && pre > suf) {
                count++;
                nums[i - 1] = now;
            } else if (pre > suf) {//4.改后
                count++;
                nums[i + 1] = now;
            } else {//5.改中间
                count++;
                nums[i] = suf;
            }
            if (count > 1) return false;
        }
        return true;
    }
}
