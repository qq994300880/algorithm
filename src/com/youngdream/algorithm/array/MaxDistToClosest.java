package com.youngdream.algorithm.array;

/**
 * @Author YoungDream
 * @Date 2019/12/10 23:37
 */
public class MaxDistToClosest {
    /**
     * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
     * 至少有一个空座位，且至少有一人坐在座位上。
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * 返回他到离他最近的人的最大距离。
     * <p>
     * 示例 1：
     * 输入：[1,0,0,0,1,0,1]
     * 输出：2
     * 解释：
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     * <p>
     * 示例 2：
     * 输入：[1,0,0,0]
     * 输出：3
     * 解释：
     * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
     * 这是可能的最大距离，所以答案是 3 。
     * <p>
     * 提示：
     * 1 <= seats.length <= 20000
     * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
     */
    public int maxDistToClosest1(int[] seats) {
        int result = 0;
        int start = 0;
        int end = 0;
        int count = 1;
        int[] counts = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                start = i;
                break;
            }
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                end = i;
                break;
            }
        }
        for (int i = 0; i < start; i++) {
            counts[i] = start - i;
        }
        for (int i = seats.length - 1; i > end; i--) {
            counts[i] = i - end;
        }
        for (int i = start + 1; i <= end; i++) {
            if (seats[i] != 1) {
                counts[i] = count++;
            } else {
                count = 1;
            }
        }
        for (int i = end - 1; i > start; i--) {
            if (seats[i] != 1) {
                counts[i] = Math.min(counts[i], count++);
            } else {
                count = 1;
            }
        }
        for (int i : counts) {
            result = Math.max(result, i);
        }
        return result;
    }

    public int maxDistToClosest2(int[] seats) {
        int result = 0;
        int start = 0;
        int end = 0;
        int count = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                start = i;
                break;
            }
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                end = i;
                break;
            }
        }
        result = Math.max(start, seats.length - 1 - end);
        for (int i = start + 1; i <= end; i++) {
            if (seats[i] == 1) {
                result = Math.max(result, count / 2);
                count = 1;
            } else {
                count++;
            }
        }
        return result;
    }

    //  最优解
    public int maxDistToClosest(int[] seats) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int start = 0;
        int end = seats.length - 1;
        while (seats[start] == 0) {
            count1++;
            start++;
        }
        while (seats[end] == 0) {
            count2++;
            end--;
        }
        // countmax记录从第一个1到最后一个1之间，连续0的最大值
        int countmax = 0;
        for (int k = start + 1; k <= end; k++) {
            if (seats[k] == 0) {
                count3++;
            } else {
                if (count3 > countmax) {
                    countmax = count3;
                }
                count3 = 0;
            }
        }
        // 返回count1, count2, (countmax+1)/2三者中最大值
        return Math.max(Math.max(count1, count2), (countmax + 1) / 2);
    }
}
