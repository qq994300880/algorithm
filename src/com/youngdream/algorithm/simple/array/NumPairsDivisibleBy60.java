package com.youngdream.algorithm.simple.array;

/**
 * @author YangDuan
 * @date 2020/2/3 20:10
 */
public class NumPairsDivisibleBy60 {
    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
     * <p>
     * 示例 1：
     * 输入：[30,20,150,100,40]
     * 输出：3
     * 解释：这三对的总持续时间可被 60 整数：
     * (time[0] = 30, time[2] = 150): 总持续时间 180
     * (time[1] = 20, time[3] = 100): 总持续时间 120
     * (time[1] = 20, time[4] = 40): 总持续时间 60
     * <p>
     * 示例 2：
     * 输入：[60,60,60]
     * 输出：3
     * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
     * <p>
     * 提示：
     * 1 <= time.length <= 60000
     * 1 <= time[i] <= 500
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int result = 0;
        for (int i : time) {
            count[i % 60]++;
        }
        for (int i = 1; i < 30; i++) {
            result += count[i] * count[60 - i];
        }
        result += count[0] * (count[0] - 1) / 2;
        result += count[30] * (count[30] - 1) / 2;
        return result;
    }
}
