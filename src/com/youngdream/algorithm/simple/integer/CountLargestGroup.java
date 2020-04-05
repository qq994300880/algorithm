package com.youngdream.algorithm.simple.integer;

/**
 * @author YangDuan
 * @date 2020/4/5 21:33
 */
public class CountLargestGroup {
    /**
     * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
     * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
     * <p>
     * 示例 1：
     * 输入：n = 13
     * 输出：4
     * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
     * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
     * <p>
     * 示例 2：
     * 输入：n = 2
     * 输出：2
     * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
     * <p>
     * 示例 3：
     * 输入：n = 15
     * 输出：6
     * <p>
     * 示例 4：
     * 输入：n = 24
     * 输出：5
     * <p>
     * 提示：
     * 1 <= n <= 10^4
     *
     * @param n 给定整数
     * @return 数字数目
     */
    public int countLargestGroup(int n) {
        // 最大9999，和为36
        int[] counts = new int[37];
        // 记录最大数组的数目
        int max = 0;
        // 记录结果
        int result = 0;
        //  统计组的数目
        for (int i = 1; i <= n; i++) {
            counts[sum(i)]++;
        }
        for (int count : counts) {
            //  获取最大数目，同时记录结果
            if (count > max) {
                result = 1;
                max = count;
            } else if (count == max) {
                result++;
            }
        }
        return result;
    }

    //  抽取计算数位和
    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
